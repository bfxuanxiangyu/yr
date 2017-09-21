package com.weeds.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class ApachHttpClient {

	public static String post(String url, Map<String, String> params) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String body = null;

		HttpPost post = postForm(url, params);

		HttpResponse response = sendRequest(httpclient, post);
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			body = paseResponse(response);
			System.out.println("fanhui:"+body);
			httpclient.getConnectionManager().shutdown();
		}
		return body;
	}

	public static String get(String url) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String body = null;

		HttpGet get = new HttpGet(url);
		HttpResponse response = sendRequest(httpclient, get);
		body = paseResponse(response);
		//System.out.println(body);
		httpclient.getConnectionManager().shutdown();

		return body;
	}

	private static String paseResponse(HttpResponse response) {
		HttpEntity entity = response.getEntity();

		String charset = EntityUtils.getContentCharSet(entity);

		String body = null;
		try {
			body = EntityUtils.toString(entity,"GBK");
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return body;
	}

	private static HttpResponse sendRequest(DefaultHttpClient httpclient, HttpUriRequest httpost) {
		HttpResponse response = null;

		try {
			response = httpclient.execute(httpost);
			CookieStore cookieStore = httpclient.getCookieStore();
            StringBuffer sb = new StringBuffer();
            System.out.println(cookieStore.getCookies());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	private static HttpPost postForm(String url, Map<String, String> params) {

		HttpPost httpost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();

		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new BasicNameValuePair(key, params.get(key)));
		}

		try {
			httpost.setEntity(new UrlEncodedFormEntity(nvps, "gbk"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return httpost;
	}
	
	public static void main(String[] args) {
		
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("operate", "clickLike");
		maps.put("videoId", "4273");
		maps.put("CID", "4444");
		String url = "https://jinshuju.net/f/58oGBH/success?e_token=LS0tIDFyZXJiMmZpCi4uLgo%3D--966a72ef8a567b4ff227a20eec";
		maps.put("Cookie", "ecco_clientid=6cbebf71-5577-d0e6-037b-0174a7d6e536; _ga=GA1.4.911690438.1456292353");
		for (int i = 0; i < 100; i++) {
			maps.put("UA", "SCH-F"+(i++)+" Infraware/5.30.CU (GUI)/WAP2.0 Profile/MIDP-2.0 Configuration/CLDC-1.1");
			url += StringUtil.getRandomVal(2, 6, null);
			//post(url,maps);
			get(url);
			System.out.println("第"+i+"次请求");
		}	
	}

}
