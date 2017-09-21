package com.weeds.utils;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

/**
 * Estarapp通用工具类：存放一些不好归类的工具方法
 * @author xuanxy
 *
 */
public class EstarappUtil {
	 /**
	 * 获得系统访问根路径
     * Convenience method to get the application's URL based on request
     * variables.
     * 
     * @param request the current request
     * @return URL to application
     */
    public static String getAppURL(HttpServletRequest request) {
        if (request == null) return "";
        
        StringBuffer url = new StringBuffer();
        int port = request.getServerPort();
        if (port < 0) {
            port = 80; // Work around java.net.URL bug
        }
        String scheme = request.getScheme();
        url.append(scheme);
        url.append("://");
        String serverName = request.getServerName();
        if(serverName!=null && serverName.equals("localhost")){
        	url.append(getLocalIP());
        }else{
        	 url.append(serverName);
        }
        if ((scheme.equals("http") && (port != 80)) || (scheme.equals("https") && (port != 443))) {
            url.append(':');
            url.append(port);
        }
        url.append(request.getContextPath());
        return url.toString();
    }
    /**
     * 获得服务器ip
     * @return
     */
	public static String getLocalIP() {
		InetAddress addr = null;
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		byte[] ipAddr = addr.getAddress();
		String ipAddrStr = "";
		for (int i = 0; i < ipAddr.length; i++) {
			if (i > 0) {
				ipAddrStr += ".";
			}
			ipAddrStr += ipAddr[i] & 0xFF;
		}
		return ipAddrStr;
	}
    
    
    
    private static final double EARTH_RADIUS = 6378137; 
    private static double rad(double d) 
    { 
       return d * Math.PI / 180.0; 
    } 
    /**
     * 计算两个经纬度之间的距离：单位米
     * @param lng1
     * @param lat1
     * @param lng2
     * @param lat2
     * @return
     */
    public static double getDistance( double lng1,double lat1,double lng2, double lat2 ) 
    { 
       double radLat1 = rad(lat1); 
       double radLat2 = rad(lat2); 
       double a = radLat1 - radLat2; 
       double b = rad(lng1) - rad(lng2); 
       double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +  
        Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2))); 
       s = s * EARTH_RADIUS ; 
       s = Math.round(s * 10000) / 10000; 
       return s; 
    } 
    
    
    /**
	 * MD5加密
	 * 
	 * @param secret_key
	 * @return
	 */
	public static String encryptMd5(String secret_key) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(secret_key.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getLocalIP());
	}
}
