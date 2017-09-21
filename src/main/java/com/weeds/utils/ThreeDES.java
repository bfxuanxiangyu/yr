package com.weeds.utils;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.binary.Base64;

/**
 * 加密方法DESede表示是3des加密方式<p>
 * 运算模式CBC,ECB。在CBC模式下使用key,向量iv;在ECB模式下仅使用key。<p>
 * 填充模式NoPadding、PKCS5Padding、SSL3Padding。<p>
 * 语言之间的兼容：<br>
 * 一个是C#采用CBC Mode，PKCS7 Padding,Java采用CBC Mode，PKCS5Padding Padding,<br>
 * 另一个是C#采用ECB Mode，PKCS7 Padding,Java采用ECB Mode，PKCS5Padding Padding,
 * <p>
 * 此段代码使用的CBC模式NoPadding填充方式、用字节零填充，目的是匹配C#语言中CBC模式，zeros填充方式。
 */
/**
 * @author xuanxy
 *
 */
public class ThreeDES {

	/**
	 * 加密BASE64编码的KEY
	 */
	private static final String BASE64_key = "dbat@hsty324&njwi#kns!we";
	/**
	 * 向量IV
	 */
	private static final String _IV = "12345678";
	private final static String Algorithm = "DESede/CBC/NoPadding";//加密方法／运算模式／填充模式
	/* 加密方法DESede表示是3des加密方式
	 * 运算模式CBC,ECB。在CBC模式下使用key,向量iv;在ECB模式下仅使用key。
	 * 填充模式NoPadding、PKCS5Padding、SSL3Padding。
	 * 语言之间的兼容：
	 * 一个是C#采用CBC Mode，PKCS7 Padding,Java采用CBC Mode，PKCS5Padding Padding,
	 * 另一个是C#采用ECB Mode，PKCS7 Padding,Java采用ECB Mode，PKCS5Padding Padding,
	 */
	private static SecureRandom sr = new SecureRandom();
	private static SecretKeyFactory keyFactory;
	private static DESedeKeySpec dks;
	private static SecretKey securekey;
	private static IvParameterSpec ips;

	static {
		
		//添加jce支持(sun有其默认实现)
		//Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		try {
			dks = new DESedeKeySpec(BASE64_key.getBytes());
			keyFactory = SecretKeyFactory.getInstance("DESede");
			securekey = keyFactory.generateSecret(dks);
			ips = new IvParameterSpec(_IV.getBytes("UTF-8"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 3des加密
	 * @param password 密码
	 * @return 加密后密文
	 */
	public static String encrypt(String password){
		
		Cipher cipher;
		String result = null;
		try {
			cipher = Cipher.getInstance(Algorithm);
			cipher.init(Cipher.ENCRYPT_MODE, securekey, ips, sr);
			byte [] arry = cipher.doFinal(FormateData(password));
			result = new String(Base64.encodeBase64(arry),"UTF-8");
			System.out.println(bytesToHexString(arry));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 3des解密
	 *  @param password 密文
	 *  @return 解密后密码
	 */
	public static String decrypt(String password){
		
		Cipher cipher;
		String result = null;
		try {

			cipher = Cipher.getInstance(Algorithm);
			cipher.init(Cipher.DECRYPT_MODE, securekey, ips, sr);
			byte [] arry = cipher.doFinal(Base64.decodeBase64(password.getBytes("UTF-8")));
			result = new String(FormateByte(arry));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 密码加密时，填充字符串为8的倍数。<p>
	 * （此方法在模式是CBC模式，填充方式为NoPadding方式的情况下，用字节零填充.）
	 *	
	 * @param str
	 * 			密码
	 * @return 加密后的密文
	 */
	public static byte [] FormateData(String str) throws UnsupportedEncodingException{
		
		int yu = str.length() % 8;
		if(yu != 0){
			int size = 8 - yu;
			byte [] arr = new byte [str.length() + size];
			byte [] data = str.getBytes("UTF-8");
			int i = 0;
			for (; i < data.length; i++) {
				arr[i] = data[i];
			}
			for (int j = 0; j < size; j++,i++) {
				arr[i] = new byte [] {0}[0];
			}
			return arr;
		}
		return str.getBytes("UTF-8");
	}
	
	/**
	 * 密码解密时，将填充的字节零去掉！<p>
	 * (此方法只在模式是CBC模式，填充方式为NoPadding方式，用字节零填充 的情况下使用。)
	 * @param arr
	 * 			密文字节组
	 * 
	 * @return 密码字节组
	 */
	public static byte [] FormateByte(byte [] arr){
		
		int i = 0;
		for (; i < arr.length; i++) {
			if(arr[i] == 0){
				break;
			}
		}
		byte [] result = new byte [i];
		for (int j = 0; j < i; j++) {
			result[j] = arr[j];
		}
		return result;
	}
	
	
	/**
	  * 把字节数组转换成16进制字符串
	  * @param bArray
	  * @return
	  */
	public static final String bytesToHexString(byte[] bArray) {
	  StringBuffer sb = new StringBuffer(bArray.length);
	  String sTemp;
	  for (int i = 0; i < bArray.length; i++) {
	   sTemp = Integer.toHexString(0xFF & bArray[i]);
	   if (sTemp.length() < 2)
	    sb.append(0);
	    sb.append(sTemp.toUpperCase());
	  }
	  return sb.toString();
	}


	
	 /**
	 * 把sting转成 byte[]
    * @param hexString the hex string
    * @return byte[]
    */
   public static byte[] hexStringToBytes(String hexString) {
       if (hexString == null || hexString.equals("")) {
           return null;
       }
       hexString = hexString.toUpperCase();
       int length = hexString.length() / 2;
       char[] hexChars = hexString.toCharArray();
       byte[] d = new byte[length];
       for (int i = 0; i < length; i++) {
           int pos = i * 2;
           d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
       }
       return d;
   }
   /**
    * Convert char to byte
    * @param c char
    * @return byte
    */
    public static byte charToByte(char c) {
       return (byte) "0123456789ABCDEF".indexOf(c);
   }
	
	public static void main(String[] args) {
		String a = encrypt("1");
		System.out.println(a);
		System.out.println(decrypt(a));
	}
}
