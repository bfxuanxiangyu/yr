package com.weeds.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @author xuanxy
 *
 */
public class FileUtils {
	
	/**
	 * 上传本地方法
	 * @param request
	 * @param file    上传文件对象
	 * @param folder  上传文件夹名称
	 * @return
	 */
	public static String  uploadlocal(HttpServletRequest request ,CommonsMultipartFile file,String folder){
		String url =null;//上传后的路径
		if(file!=null){
			String fileLastName = file.getOriginalFilename();
			if(fileLastName != null && fileLastName !="" ){
				//截取后缀名
				String lastName = fileLastName.substring(fileLastName.indexOf("."));
				String path = request.getSession().getServletContext().getRealPath("resource");
				String fileName =  getFileName()+lastName;
				File targetFile = new File(path+"/"+folder+"/", fileName);
				if(!targetFile.exists()){
					targetFile.mkdirs();
				}
				//保存
				try {
					file.transferTo(targetFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//设置图片路径
				url = getAppURL(request)+"/resource/"+folder+"/"+fileName;
			}
		}
		return url;
	}
	
	
	/**
	 * 获得文件名称
	 * @return
	 */
	public static String getFileName(){
		DateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf2.format(new Date());
	}
	
	 /**
	  * 获取url
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
        url.append(request.getServerName());
        if ((scheme.equals("http") && (port != 80)) || (scheme.equals("https") && (port != 443))) {
            url.append(':');
            url.append(port);
        }
        url.append(request.getContextPath());
        return url.toString();
    }
    
    
    /**
     * 读取文件路径 
     * @param filePath
     * @return
     */
    public static String readFile(String filePath){
    	String res = "";
		String s ="";
    	try {
    		File in = new File(filePath);
			BufferedReader input = new BufferedReader(new FileReader(in));//普通文件读取
			while((s = input.readLine())!=null){
				System.out.println(s);
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return res;
    }
    
    
    /**
     * 保存文件
     * @param filePath
     * @param s
     */
    public static void saveFile(String saveFilePath,String fileName,String s){
    	try {
    		String paths[] = saveFilePath.split("\\\\");
            String dir = paths[0];
            for (int i = 0; i < paths.length-1; i++) {
                try {
                    dir = dir + "/" + paths[i + 1];
                    File dirFile = new File(dir);
                    if (!dirFile.exists()) {
                        dirFile.mkdir();
                        System.out.println("创建目录为：" + dir);
                    }
                } catch (Exception err) {
                    System.err.println("ELS - Chart : 文件夹创建发生异常");
                }
            }
    		
    		String pathName = saveFilePath+fileName;
			File out = new File(pathName);
			BufferedWriter output = new BufferedWriter( new FileWriter(out));//在这又把.Txt文件都清空了
			output.write("\n"+s);
			System.out.println("写入成功 ，全路径="+pathName);
			output.flush();
			output.newLine();
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
    
    
    /**
     * inputstream 流转字节数组
     * @param inStream
     * @return
     * @throws IOException
     */
    public static final byte[] input2byte(InputStream inStream)  
            throws IOException {  
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();  
        byte[] buff = new byte[100];  
        int rc = 0;  
        while ((rc = inStream.read(buff, 0, 100)) > 0) {  
            swapStream.write(buff, 0, rc);  
        }  
        byte[] in2b = swapStream.toByteArray();  
        return in2b;  
    } 
    
    
    /**
     * 得到图片X轴坐标
     * @param px
     * @param colWidth
     * @return
     */
    public static int getAnchorX(int px, int colWidth){  
        return (int) Math.round(( (double)701*16000.0/301)*((double)1/colWidth)*px);  
    }  
    /**
     * 得到图片Y轴坐标
     * @param px
     * @param colWidth
     * @return
     */
    public static int getAnchorY(int px, int rowHeight){  
        return (int) Math.round(( (double)144 * 8000/301)*((double)1/rowHeight)*px);  
    }  
    /**
     * 得到图片高度
     * @param px
     * @param colWidth
     * @return
     */
    public static int getRowHeight(int px){  
        return (int) Math.round(((double)4480/300) * px);  
    }  
    /**
     * 得到图片宽度
     * @param px
     * @param colWidth
     * @return
     */ 
    public static int getColWidth(int px){  
        return (int) Math.round(((double)10971/300) * px);  
    }  

}
