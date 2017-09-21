package com.weeds.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLHandshakeException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.weeds.exception.NetServiceException;
import com.weeds.utils.poi.WriteExcel;
import com.weeds.utils.poi.testvo.Category;

/**
 * Apache Httpclient 4.0 工具包装类
 * 
 * @author xuanxy
 */
public class HttpClientUtil {
	private static final String CHARSET = "UTF-8";// UTF-8 GBK GB2312
	private static final String SSL_DEFAULT_SCHEME = "https";
	private static final int SSL_DEFAULT_PORT = 443;

	// 异常自动恢复处理, 使用HttpRequestRetryHandler接口实现请求的异常恢复
	private static HttpRequestRetryHandler requestRetryHandler = new HttpRequestRetryHandler() {
		// 自定义的恢复策略
		public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
			// 设置恢复策略，在发生异常时候将自动重试3次
			if (executionCount >= 3) {
				// Do not retry if over max retry count
				return false;
			}
			if (exception instanceof NoHttpResponseException) {
				// Retry if the server dropped connection on us
				return true;
			}
			if (exception instanceof SSLHandshakeException) {
				// Do not retry on SSL handshake exception
				return false;
			}
			HttpRequest request = (HttpRequest) context.getAttribute(ExecutionContext.HTTP_REQUEST);
			boolean idempotent = (request instanceof HttpEntityEnclosingRequest);
			if (!idempotent) {
				// Retry if the request is considered idempotent
				return true;
			}
			return false;
		}
	};
	// 使用ResponseHandler接口处理响应，HttpClient使用ResponseHandler会自动管理连接的释放，解决了对连接的释放管理
	private static ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
		// 自定义响应处理
		public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String charset = EntityUtils.getContentCharSet(entity) == null ? CHARSET
						: EntityUtils.getContentCharSet(entity);
				return new String(EntityUtils.toByteArray(entity), charset);
			} else {
				return null;
			}
		}
	};

	/**
	 * Get方式提交,URL中包含查询参数, 格式：http://www.g.cn?search=p&name=s.....
	 *
	 * @param url
	 *            提交地址
	 * @return 响应消息
	 * @throws NetServiceException
	 */
	public static String get(String url) throws NetServiceException {
		return get(url, null, null);
	}

	/**
	 * Get方式提交,URL中不包含查询参数, 格式：http://www.g.cn
	 *
	 * @param url
	 *            提交地址
	 * @param params
	 *            查询参数集, 键/值对
	 * @return 响应消息
	 * @throws NetServiceException
	 */
	public static String get(String url, Map<String, String> params) throws NetServiceException {
		return get(url, params, null);
	}

	/**
	 * Get方式提交,URL中不包含查询参数, 格式：http://www.g.cn
	 *
	 * @param url
	 *            提交地址
	 * @param params
	 *            查询参数集, 键/值对
	 * @param charset
	 *            参数提交编码集
	 * @return 响应消息
	 * @throws NetServiceException
	 */
	public static String get(String url, Map<String, String> params, String charset) throws NetServiceException {
		if (url == null || StringUtil.isEmpty(url)) {
			return null;
		}
		List<NameValuePair> qparams = getParamsList(params);
		if (qparams != null && qparams.size() > 0) {
			charset = (charset == null ? CHARSET : charset);
			String formatParams = URLEncodedUtils.format(qparams, charset);
			url = (url.indexOf("?")) < 0 ? (url + "?" + formatParams)
					: (url.substring(0, url.indexOf("?") + 1) + formatParams);
		}
		DefaultHttpClient httpclient = getDefaultHttpClient(charset);
		HttpGet hg = new HttpGet(url);
		// 发送请求，得到响应
		String responseStr = null;
		try {
			responseStr = httpclient.execute(hg, responseHandler);
		} catch (ClientProtocolException e) {
			throw new NetServiceException("客户端连接协议错误", e);
		} catch (IOException e) {
			throw new NetServiceException("IO操作异常", e);
		} finally {
			abortConnection(hg, httpclient);
		}
		return responseStr;
	}

	/**
	 * Post方式提交,URL中不包含提交参数, 格式：http://www.g.cn
	 *
	 * @param url
	 *            提交地址
	 * @param params
	 *            提交参数集, 键/值对
	 * @return 响应消息
	 * @throws NetServiceException
	 */
	public static String post(String url, Map<String, String> params) throws NetServiceException {
		return post(url, params, null);
	}

	/**
	 * Post方式提交,URL中不包含提交参数, 格式：http://www.g.cn
	 *
	 * @param url
	 *            提交地址
	 * @param params
	 *            提交参数集, 键/值对
	 * @param charset
	 *            参数提交编码集
	 * @return 响应消息
	 * @throws NetServiceException
	 */
	public static String post(String url, Map<String, String> params, String charset) throws NetServiceException {
		if (url == null || StringUtil.isEmpty(url)) {
			return null;
		}
		// 创建HttpClient实例
		DefaultHttpClient httpclient = getDefaultHttpClient(charset);
		UrlEncodedFormEntity formEntity = null;
		try {
			if (charset == null || StringUtil.isEmpty(charset)) {
				formEntity = new UrlEncodedFormEntity(getParamsList(params));
			} else {
				formEntity = new UrlEncodedFormEntity(getParamsList(params), charset);
			}
		} catch (UnsupportedEncodingException e) {
			throw new NetServiceException("不支持的编码集", e);
		}
		HttpPost hp = new HttpPost(url);
		hp.setEntity(formEntity);
		// 发送请求，得到响应
		String responseStr = null;
		try {
			responseStr = httpclient.execute(hp, responseHandler);
		} catch (ClientProtocolException e) {
			throw new NetServiceException("客户端连接协议错误", e);
		} catch (IOException e) {
			throw new NetServiceException("IO操作异常", e);
		} finally {
			abortConnection(hp, httpclient);
		}
		return responseStr;
	}

	/**
	 * Post方式提交,忽略URL中包含的参数,解决SSL双向数字证书认证
	 *
	 * @param url
	 *            提交地址
	 * @param params
	 *            提交参数集, 键/值对
	 * @param charset
	 *            参数编码集
	 * @param keystoreUrl
	 *            密钥存储库路径
	 * @param keystorePassword
	 *            密钥存储库访问密码
	 * @param truststoreUrl
	 *            信任存储库绝路径
	 * @param truststorePassword
	 *            信任存储库访问密码, 可为null
	 * @return 响应消息
	 * @throws NetServiceException
	 */
	public static String post(String url, Map<String, String> params, String charset, final URL keystoreUrl,
			final String keystorePassword, final URL truststoreUrl, final String truststorePassword)
					throws NetServiceException {
		if (url == null || StringUtil.isEmpty(url)) {
			return null;
		}
		DefaultHttpClient httpclient = getDefaultHttpClient(charset);
		UrlEncodedFormEntity formEntity = null;
		try {
			if (charset == null || StringUtil.isEmpty(charset)) {
				formEntity = new UrlEncodedFormEntity(getParamsList(params));
			} else {
				formEntity = new UrlEncodedFormEntity(getParamsList(params), charset);
			}
		} catch (UnsupportedEncodingException e) {
			throw new NetServiceException("不支持的编码集", e);
		}
		HttpPost hp = null;
		String responseStr = null;
		try {
			KeyStore keyStore = createKeyStore(keystoreUrl, keystorePassword);
			KeyStore trustStore = createKeyStore(truststoreUrl, keystorePassword);
			SSLSocketFactory socketFactory = new SSLSocketFactory(keyStore, keystorePassword, trustStore);
			Scheme scheme = new Scheme(SSL_DEFAULT_SCHEME, socketFactory, SSL_DEFAULT_PORT);
			httpclient.getConnectionManager().getSchemeRegistry().register(scheme);
			hp = new HttpPost(url);
			hp.setEntity(formEntity);
			responseStr = httpclient.execute(hp, responseHandler);
		} catch (NoSuchAlgorithmException e) {
			throw new NetServiceException("指定的加密算法不可用", e);
		} catch (KeyStoreException e) {
			throw new NetServiceException("keytore解析异常", e);
		} catch (CertificateException e) {
			throw new NetServiceException("信任证书过期或解析异常", e);
		} catch (FileNotFoundException e) {
			throw new NetServiceException("keystore文件不存在", e);
		} catch (IOException e) {
			throw new NetServiceException("I/O操作失败或中断 ", e);
		} catch (UnrecoverableKeyException e) {
			throw new NetServiceException("keystore中的密钥无法恢复异常", e);
		} catch (KeyManagementException e) {
			throw new NetServiceException("处理密钥管理的操作异常", e);
		} finally {
			abortConnection(hp, httpclient);
		}
		return responseStr;
	}

	/**
	 * 获取DefaultHttpClient实例
	 *
	 * @param charset
	 *            参数编码集, 可空
	 * @return DefaultHttpClient 对象
	 */
	private static DefaultHttpClient getDefaultHttpClient(final String charset) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		// 模拟浏览器，解决一些服务器程序只允许浏览器访问的问题
		httpclient.getParams().setParameter(CoreProtocolPNames.USER_AGENT,
				"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
		httpclient.getParams().setParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, Boolean.FALSE);
		httpclient.getParams().setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET,
				charset == null ? CHARSET : charset);
		httpclient.setHttpRequestRetryHandler(requestRetryHandler);
		return httpclient;
	}

	/**
	 * 释放HttpClient连接
	 *
	 * @param hrb
	 *            请求对象
	 * @param httpclient
	 *            client对象
	 */
	private static void abortConnection(final HttpRequestBase hrb, final HttpClient httpclient) {
		if (hrb != null) {
			hrb.abort();
		}
		if (httpclient != null) {
			httpclient.getConnectionManager().shutdown();
		}
	}

	/**
	 * 从给定的路径中加载此 KeyStore
	 *
	 * @param url
	 *            keystore URL路径
	 * @param password
	 *            keystore访问密钥
	 * @return keystore 对象
	 */
	private static KeyStore createKeyStore(final URL url, final String password)
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		if (url == null) {
			throw new IllegalArgumentException("Keystore url may not be null");
		}
		KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
		InputStream is = null;
		try {
			is = url.openStream();
			keystore.load(is, password != null ? password.toCharArray() : null);
		} finally {
			if (is != null) {
				is.close();
				is = null;
			}
		}
		return keystore;
	}

	/**
	 * 将传入的键/值对参数转换为NameValuePair参数集
	 *
	 * @param paramsMap
	 *            参数集, 键/值对
	 * @return NameValuePair参数集
	 */
	private static List<NameValuePair> getParamsList(Map<String, String> paramsMap) {
		if (paramsMap == null || paramsMap.size() == 0) {
			return null;
		}
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> map : paramsMap.entrySet()) {
			params.add(new BasicNameValuePair(map.getKey(), map.getValue()));
		}
		return params;
	}

	public static void main(String[] args) {
		try {
			//catch51Cat();
			catchZBJCat();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 抓取猪八戒网分类数据
	 * 
	 */
	public static void catchZBJCat(){
		try {
			String strzhubajie = "http://www.zbj.com/?pmcode=149720&fromcode=11726814&utm_source=bdpz&utm_medium=SEM";
			//String s = get(strzhubajie);
			//FileUtils.saveFile("d:\\11\\file\\","zhubajiecat.txt", s);
			File input = new File("d:\\11\\file\\zhubajiecat.txt");
			//Document doc = Jsoup.parse(input, "UTF-8");
			Document doc = Jsoup.parse(new URL(strzhubajie), 1000);
			Element content = doc.getElementById("menu-item");
			Elements links = content.getElementsByTag("a");
			 List<Category> cgList = new ArrayList<>();
			 Category cg = new Category();
			 String fatherStr = "";
			 List<String> ls = new ArrayList<>();
			 int count = 0;
			 int oldCount =0;
			 for (Element link : links) {
				 String linkAtt = link.attr("class");
				 String linkText = link.text();
				 
				 if(StringUtil.isNotEmpty(linkAtt)&& linkAtt.equals("menu-list-link")){
					 continue;
				 }
				 
				 
				 
				 if(StringUtil.isNotEmpty(linkAtt)&& linkAtt.equals("menu-subtitle")){
					 System.out.println(linkText);
					 if(StringUtil.isNotEmpty(fatherStr)){
						cg.setSonStrList(ls);
						cgList.add(cg);
					}
					count ++;
					oldCount = count;
					cg = new Category();
					fatherStr = linkText;
					ls = new ArrayList<>();
					System.out.println("第"+count+"次进入");
					cg.setFatherStr(linkText);
				 }else{
					 System.out.println("     "+linkText);
					 if(oldCount<=count){
						if(StringUtil.isNotEmpty(linkText)){
							ls.add(linkText);
						}
					 }
					 if("自建房设计".equals(linkText)){
						System.out.println("这是最后一个----"+linkText);
						cg.setSonStrList(ls);
						cgList.add(cg);
					}
				 }
				 
			 }
			 //WriteExcel.writeExcel("d://11//猪八戒分类.xlsx", cgList);
			// System.out.println(cgList.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 抓取51分类数据
	 * 
	 */
	public static void catch51Cat(){
		try {
			String str51 = "http://search.51job.com/jobsearch/advance_search.php?stype=2";
			String strzhubajie = "http://www.zbj.com/?pmcode=149720&fromcode=11726814&utm_source=bdpz&utm_medium=SEM";
			// String s = get(strzhubajie);
			// FileUtils.saveFile("d:\\11\\file\\","zhubajiecat.txt", s);
			File input = new File("d:\\11\\file\\51cat.txt");
			Document doc = Jsoup.parse(input, "UTF-8", str51);
			Element content = doc.getElementById("kuai1");
			/*
			 * Elements links = content.getElementsByTag("a"); for (Element link
			 * : links) { String linkHref = link.attr("href"); String linkText =
			 * link.text(); System.out.println(linkText); }
			 */ Elements links = content.getElementsByTag("td");
			 List<Category> cgList = new ArrayList<>();
			 Category cg = new Category();
			 String fatherStr = "";
			 List<String> ls = new ArrayList<>();
			 int count = 0;
			 int oldCount =0;
			for (Element link : links) {
				String linkText = link.text();
				String linkHref = link.attr("class");
				if (StringUtil.isNotEmpty(linkHref) && linkHref.equals("tableTh_tSeach_list")) {
					//System.out.println(linkText);
					if(StringUtil.isNotEmpty(fatherStr)){
						cg.setSonStrList(ls);
						cgList.add(cg);
					}
					count ++;
					oldCount = count;
					cg = new Category();
					fatherStr = linkText;
					ls = new ArrayList<>();
					//System.out.println("第"+count+"次进入");
					cg.setFatherStr(linkText);
				} else {
					if(oldCount<=count){
						if(StringUtil.isNotEmpty(linkText)){
							ls.add(linkText);
						}
					}
					Element ee = links.last();
					if(ee.text().equals(linkText)){
						System.out.println("这是最后一个----"+linkText);
						cg.setSonStrList(ls);
						cgList.add(cg);
					}
					//如果是最后一次进入   直接添加到集合
					//System.out.println("                          " + linkText);
				}
				
			}
			WriteExcel.writeExcel("d://11//51分类.xlsx", cgList);
			System.out.println(cgList.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
