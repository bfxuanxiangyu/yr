package com.weeds.utils;

import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;

import com.weeds.service.profile.ShiroDbRealm.ShiroUser;


/**
 * 字符串处理工具类
 * @author xuanxy
 *
 */
public class StringUtil {
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null || str.equals("") || str.equalsIgnoreCase("null")){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 判断字符串是否不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		boolean flag = isEmpty(str);
		if(!flag){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 比较两个字符串的大小，限于1.1.0   1.1.1类型
	 * @param strComp    比较参数
	 * @param comperStr  待比较参数
	 * @return
	 */
	public static boolean compareStringToNumber(String strComp,String comperStr){
		boolean state = false;
		if(isEmpty(strComp)|| isEmpty(comperStr)){
			state = false;
		}else{
			strComp = strComp.replace(".", "");
			comperStr = comperStr.replace(".", "");
			int sc = new Integer(strComp).intValue();
			int cs = new Integer(comperStr).intValue();
			
			if(sc<=cs){
				state = false;  //第一个小于等于第二个
			}else{
				state = true;   //第一个大于第二个
				System.out.println("第二个较大");
			}
		}
		return state;
	}
	
	
	/**
	 * 转移客户端
	 * @param type
	 * @return
	 */
	public static String parseClient(int key){
		String str = "";
		switch (key) {
		case 0:
			str = "iphone";
			break;
		case 1:
			str = "android";
			break;
		case 2:
			str = "ipad";
			break;

		default:
			str = "";
			break;
		}
		return str;
	}
	
	
	
	/**
	 * 校验版本号    必须为1.1.1或1.1.11格式
	 * @param vers
	 * @return
	 */
	public static boolean checkVersion(String vers){
		boolean state = false;
		
		try {
			String strPattern = "\\d{1}.\\d{1}.\\d{1,2}$";
			//String strPattern = "[0-9]{1}.[0-9]{1}.[0-9]{1,2}$";
			Pattern p = Pattern.compile(strPattern);
			Matcher m = p.matcher(vers);
			return m.matches();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}
	
	
	/**
	 * 只能传入数值型    保留多少位
	 * @param obj
	 * @param stauts
	 * @return
	 */
	public static Object getDataFormat(Object obj , int stauts){
		DecimalFormat df = new DecimalFormat("0.0");
		Random rd=new Random();//随机数生成器
		double j= rd.nextDouble()*10 + 20;
		obj = df.format(j);
		return obj;
	}
	
	/**
	 * 随机生成多少位
	 * @param longVal
	 * @param status  1 获取纯数字(整数)     2获取字符串类型
	 * @param type  intnum(整数)     doublenum获取字符串类型
	 * @return
	 */
	public static String getRandomVal(int status,int longVal,String type){
		String returnVal = "";
		if(status==1){
			Random rd=new Random();//随机数生成器
			if(isNotEmpty(type) && type.equals("doublenum")){
				double j= rd.nextDouble()*10  + longVal;
				returnVal = j+"";
			}else if(isNotEmpty(type) && type.equals("intnum")){
				int j = (int) (rd.nextDouble()*10 + longVal);
				returnVal = j+"";
			}else{
				returnVal = rd.nextInt()*longVal+"";
			}
		}else if(status==2){
			String str = "0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
	        String str2[] = str.split(",");// 将字符串以,分割
	        Random rand = new Random();// 创建Random类的对象rand
	        int index = 0;
	        String randStr = "";// 创建内容为空字符串对象randStr
	        randStr = "";// 清空字符串对象randStr中的值
	        for (int i = 0; i < longVal; ++i) {
	            index = rand.nextInt(str2.length - 1);// 在0到str2.length-1生成一个伪随机数赋值给index
	            randStr += str2[index];// 将对应索引的数组与randStr的变量值相连接
	        }
	        returnVal = (randStr+"").toUpperCase();
		}
		return returnVal;
	}
	
	
	/**
	 * 处理页面提交参数--乱码问题
	 * @param request
	 * @param prefix
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> getParametersStartingWith(ServletRequest request, String prefix) throws Exception{
		//Validate.notNull(request, "Request must not be null");
		Enumeration paramNames = request.getParameterNames();
		Map<String, Object> params = new TreeMap<String, Object>();
		if (prefix == null) {
			prefix = "";
		}
		while (paramNames != null && paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			if ("".equals(prefix) || paramName.startsWith(prefix)) {
				String unprefixed = paramName.substring(prefix.length());
				String[] values = request.getParameterValues(paramName);
				if (values == null || values.length == 0) {
					// Do nothing, no values found at all.
				} else if (values.length > 1) {
					params.put(unprefixed, values);
				} else {
					//String s = new String(values[0].getBytes("iso-8859-1"),"utf-8");
					params.put(unprefixed, values[0]);
				}
			}
		}
		return params;
	}
	
	 /**
     * 去除value为空的map对象
     * @param parameters
     * @return
     */
    public static Map<String, Object> removeVauleNull(Map<String, Object> parameters){
    	Map<String, Object> returnMap = new HashMap<String, Object>();
    	for(Map.Entry entry:parameters.entrySet()){
			if(StringUtil.isNotEmpty(entry.getValue().toString())){
				returnMap.put(entry.getKey()+"", entry.getValue());
			}
		}
    	return returnMap;
    }
    /**
     * _转驼峰（正则）
     *
     * @param param
     * @return
     */
    public static String underlineToCamel2(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        StringBuilder sb = new StringBuilder(param.toLowerCase());
        Matcher mc = Pattern.compile("_").matcher(param);
        int i = 0;
        while (mc.find()) {
            int position = mc.end() - (i++);
            //String.valueOf(Character.toUpperCase(sb.charAt(position)));
            sb.replace(position - 1, position + 1, sb.substring(position, position + 1).toUpperCase());
        }
        return sb.toString();
    }
    
    /**
     * 加密密码
     *
     * @param password
     * @return
     */
    public static String encryptPassword(String password) {
        return DigestUtils.md5Hex(DigestUtils.md5Hex(password).substring(7, 23));
    }
    
    
    /**
	 * 取出Shiro中的当前用户LoginName.
	 */
	public static String getCurrentUserName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.loginName;
	}
	
	
	/**
	 * 获取多少位的唯一值
	 * @param length
	 * @return
	 */
	public static String getUUIDString(int length){
		String uuidStr = UUID.randomUUID().toString().replace("-", "");
		
		return uuidStr.substring(0, length);
	}
	
	
	public static void main(String[] args) {
		System.out.println(getRandomVal(1, 20, "doublenum"));
		System.out.println(getRandomVal(2, 6, null));
	}
}
