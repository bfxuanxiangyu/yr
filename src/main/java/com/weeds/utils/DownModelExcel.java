package com.weeds.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xuanxy
 *
 */
public class DownModelExcel {
	
	
	public static String modelDownload(HttpServletRequest request,HttpServletResponse response,String fileName) throws Exception
	{
		File f = null;
		String path=request.getSession().getServletContext().getRealPath("/");//得到项目路径
		f = new File(path,File.separator +"excelmodle" + File.separator +fileName);
		
		if(f.exists()){
			response.setContentLength((int)f.length());
			String parameter = "filename=" + fileName;
			response.setHeader("Content-disposition", new String(parameter.getBytes("GB2312"), "ISO8859_1"));
			OutputStream os = response.getOutputStream();
			FileInputStream fis= new FileInputStream(f);
			byte[] b = new byte[512];
			int length;
			while((length = fis.read(b)) > 0){
				os.write(b, 0, length);
			}
			os.flush();
			os.close();
		}else{
			return "nofindfile";
		}
		return null;	
	}

	/**
	 * 
	 * @Title: downErrorExcel 
	 * @param @param filename  //显示给客户看的名称
	 * @param @param errorFileName //通过该名称来下载那个错误的Excel
	 * @return void     
	 * @Description: TODO() 
	 */
	public static void downErrorExcel(HttpServletRequest request,HttpServletResponse response,String filename,String errorFileName){
		try{
			errorFileName="d:\\11";//错误Excel的路径
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");			  
			response.setHeader("Content-Disposition", new String(("attachment;filename="+filename+".xlsx").getBytes("GB2312"), "UTF-8"));
			
			File f = new File(errorFileName);
			FileInputStream in = new FileInputStream(f);
			byte b[] = new byte[1024];
			int i = 0;
			ServletOutputStream out = response.getOutputStream();
			while((i=in.read(b))!=	-1){
				out.write(b, 0, i);
			}
			out.flush();
			out.close();
		    in.close();
		}catch(Exception e){
	        e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Title: downErrorExcel 
	 * @param @param filename  //显示给客户看的名称
	 * @param @param downSaveExcelUrl //通过该路径文件来下载保存在服务器上的的Excel
	 * @return void     
	 * @Description: TODO() 
	 */
	public static void downSaveExcel(HttpServletRequest request,HttpServletResponse response,String filename,String downSaveExcelUrl){
		try{
		    //response.setContentLength((int)f.length());
		    response.setContentType("application/msexcel");
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");			  
			response.setHeader("Content-Disposition", new String(("attachment;filename="+filename+".xlsx").getBytes("GB2312"), "UTF-8"));
			response.setBufferSize(10*1024*1024);
			File f = new File(downSaveExcelUrl);
			FileInputStream in = new FileInputStream(f);
			byte b[] = new byte[1024];
			int i = 0;
			OutputStream out = response.getOutputStream();
			while((i=in.read(b))!=	-1){
				out.write(b, 0, i);
			}
			out.flush();
			out.close();
		    in.close();
		}catch(Exception e){
	        e.printStackTrace();
		}
	}
	
	/**
	 * createExcelXlsxFile:创建导出的excel 文件
	 * @author yingmm
	 * @Date:2015-2-3上午11:03:21
	 * @description
	 */
	public static FileOutputStream createExcelXlsxFile(String savePath,String formatDate){
		FileOutputStream out=null;
		try{
			// 转换为字符串
			formatDate = DateUtils.dateToString(new Date(), "yyyyMMddHHmmss");
			// 随机生成文件编号
			int random = new Random().nextInt(10000);
			String path = "d:\\11";
			String tmpPath = File.separator + "down" + File.separator;
			File targetFolder = new File(path, tmpPath);
			if (!targetFolder.exists()) {
				targetFolder.mkdirs();
			}
			savePath = targetFolder.getPath() + File.separator + formatDate + "_" + random + ".xlsx";
			out = new FileOutputStream(savePath);
			
		}catch(Exception e){
	        e.printStackTrace();
		}
		return out;
	}
	
	
	
}	
