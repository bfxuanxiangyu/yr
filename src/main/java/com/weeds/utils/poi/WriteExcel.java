package com.weeds.utils.poi;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.weeds.utils.StringUtil;
import com.weeds.utils.poi.testvo.Category;

/**
 * @author
 * @version 创建时间：Dec 2, 2008 10:23:24 AM 写入Excel
 */
public class WriteExcel {
	
	
	/**
	 * 个人详情模板类
	 * @param path
	 * @param cateList
	 * @throws IOException
	 */
	public static void writeExcelForFamily(String path) throws IOException{ 
		//创建一个Excel(or new XSSFWorkbook())  
		XSSFWorkbook wb = new XSSFWorkbook(); 
		//创建表格  
		Sheet sheet = wb.createSheet("详情"); 
		sheet.setColumnWidth(0, 12 * 256); //第一列宽度 12
		sheet.setColumnWidth(1, 12 * 256); //第二列宽度 12
		sheet.setColumnWidth(2, 10 * 256); //第三列宽度 12
		sheet.setColumnWidth(3, 12 * 256); //第四列宽度 12
		sheet.setColumnWidth(4, 12 * 256); //第五列宽度 12
		sheet.setColumnWidth(5, 20 * 256); 
		sheet.setColumnWidth(6, 12 * 256); 
		sheet.setColumnWidth(7, 12 * 256); 
		//创建行  
		Row row = sheet.createRow(0); 
		//设置行高  
		row.setHeightInPoints(30); 
		//创建样式  
		CellStyle cs = wb.createCellStyle(); 
		cs.setAlignment(CellStyle.ALIGN_CENTER); 
		cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER); 
		cs.setBorderBottom(CellStyle.BORDER_THIN);  
		cs.setBorderLeft(CellStyle.BORDER_THIN);  
		cs.setBorderRight(CellStyle.BORDER_THIN); 
		cs.setBorderTop(CellStyle.BORDER_THIN);
		XSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗
		cs.setFont(font);
		
		CellStyle cskey = wb.createCellStyle(); //内容值样式
		cskey.setBorderBottom(CellStyle.BORDER_THIN);  
		cskey.setBorderLeft(CellStyle.BORDER_THIN);  
		cskey.setBorderRight(CellStyle.BORDER_THIN); 
		cskey.setBorderTop(CellStyle.BORDER_THIN);
		CellStyle csValue = wb.createCellStyle(); //内容值样式
		csValue.setAlignment(CellStyle.ALIGN_CENTER);
		csValue.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		csValue.setBorderBottom(CellStyle.BORDER_THIN);  
		csValue.setBorderLeft(CellStyle.BORDER_THIN);  
		csValue.setBorderRight(CellStyle.BORDER_THIN); 
		csValue.setBorderTop(CellStyle.BORDER_THIN);
		//创建单元格  
		Cell cell = row.createCell(0); 
		//设置单元格样式  
		cell.setCellStyle(cs); 
		//设置单元格的值
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
		cell.setCellValue("个人信息"); 
		cell = row.createCell(1);
        cell.setCellStyle(cskey); 
        cell = row.createCell(2);
        cell.setCellStyle(cskey); 
        cell = row.createCell(3);
        cell.setCellStyle(cskey); 
        cell = row.createCell(4);
        cell.setCellStyle(cskey); 
        cell = row.createCell(5);
        cell.setCellStyle(cskey); 
        cell = row.createCell(6);
        cell.setCellStyle(cskey); 
        cell = row.createCell(7);
        cell.setCellStyle(cskey);
		
		
		//第二行
		row = sheet.createRow(1); 
		row.setHeightInPoints(30);
		
		cell = row.createCell(0); 
		cell.setCellStyle(csValue);
		cell.setCellValue("姓名"); 
		cell = row.createCell(1);
		cell.setCellStyle(csValue);
		cell.setCellValue("轩翔宇"); 
		cell = row.createCell(2);
		cell.setCellStyle(csValue);
		cell.setCellValue("英文名称"); 
		cell = row.createCell(3);
		cell.setCellStyle(csValue);
		cell.setCellValue("simon"); 
		cell = row.createCell(4);
		cell.setCellStyle(csValue);
		cell.setCellValue("性别"); 
		cell = row.createCell(5);
		cell.setCellStyle(csValue);
		cell.setCellValue("男"); 
		//插入图片
		cell = row.createCell(6);
		cell.setCellStyle(cskey);
		sheet.addMergedRegion(new CellRangeAddress(1, 5, 6, 7));
		String fileName = "d://11//11.png";  
		ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();     
		BufferedImage  bufferImg = ImageIO.read(new File(fileName));     
        ImageIO.write(bufferImg, "png", byteArrayOut);
        //画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）  
        XSSFDrawing patriarch = (XSSFDrawing) sheet.createDrawingPatriarch();     
        //anchor主要用于设置图片的属性  
        XSSFClientAnchor anchor = new XSSFClientAnchor(0, 0, 255, 255,(short) 6, 1, (short) 8, 6);     
        anchor.setAnchorType(3);     
        //插入图片    
        patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), XSSFWorkbook.PICTURE_TYPE_JPEG)); 
        
        //第三行
        row = sheet.createRow(2); 
        row.setHeightInPoints(30);
        
        cell = row.createCell(0); 
        cell.setCellStyle(csValue);
        cell.setCellValue("手机"); 
        cell = row.createCell(1);
        cell.setCellStyle(csValue);
        cell.setCellValue("15601605036"); 
        cell = row.createCell(2);
        cell.setCellStyle(csValue);
        cell.setCellValue("QQ"); 
        cell = row.createCell(3);
        cell.setCellStyle(csValue);
        cell.setCellValue("61611853"); 
        cell = row.createCell(4);
        cell.setCellStyle(csValue);
        cell.setCellValue("微信"); 
        cell = row.createCell(5);
        cell.setCellStyle(csValue);
        cell.setCellValue("guangtouXuan"); 
        
        //第四行
        row = sheet.createRow(3); 
        row.setHeightInPoints(30);
        
        cell = row.createCell(0); 
        cell.setCellStyle(csValue);
        cell.setCellValue("民族"); 
        cell = row.createCell(1);
        cell.setCellStyle(csValue);
        cell.setCellValue("汉族"); 
        cell = row.createCell(2);
        cell.setCellStyle(csValue);
        cell.setCellValue("住址"); 
        cell = row.createCell(3);
        sheet.addMergedRegion(new CellRangeAddress(3, 3, 3, 5));
        cell.setCellStyle(csValue);
        cell.setCellValue("上海市普陀区怒江路600弄");
        cell = row.createCell(4);
        cell.setCellStyle(cskey); 
        cell = row.createCell(5);
        cell.setCellStyle(cskey);
        
        //第五行
  		row = sheet.createRow(4); 
  		row.setHeightInPoints(30);
  		
  		cell = row.createCell(0);
  		cell.setCellStyle(csValue);
  		cell.setCellValue("邮编"); 
  		cell = row.createCell(1);
  		cell.setCellStyle(csValue);
  		cell.setCellValue("200033"); 
  		cell = row.createCell(2);
  		cell.setCellStyle(csValue);
  		cell.setCellValue("邮寄地址"); 
  		cell = row.createCell(3);
  		sheet.addMergedRegion(new CellRangeAddress(4, 4, 3, 5));
  		cell.setCellStyle(csValue);
  		cell.setCellValue("上海市普陀区中江路879弄"); 
  		cell = row.createCell(4);
        cell.setCellStyle(cskey); 
        cell = row.createCell(5);
        cell.setCellStyle(cskey);

        //第六行
        row = sheet.createRow(5); 
        row.setHeightInPoints(30);
        
        cell = row.createCell(0); 
        cell.setCellStyle(csValue);
        cell.setCellValue("出生日期"); 
        cell = row.createCell(1);
        cell.setCellStyle(csValue);
        cell.setCellValue("1989-9-6"); 
        cell = row.createCell(2);
        cell.setCellStyle(csValue);
        cell.setCellValue("教育"); 
        cell = row.createCell(3);
        cell.setCellStyle(csValue);
        cell.setCellValue("大专"); 
        cell = row.createCell(4);
        cell.setCellStyle(csValue);
        cell.setCellValue("邮箱"); 
        cell = row.createCell(5);
        cell.setCellStyle(csValue);
        cell.setCellValue("61611853@qq.com"); 
        
        //第七行
        row = sheet.createRow(6); 
        row.setHeightInPoints(30);
        
        cell = row.createCell(0); 
		cell.setCellStyle(cs); 
		sheet.addMergedRegion(new CellRangeAddress(6, 6, 0, 7));
		cell.setCellValue("银行卡信息"); 
		cell = row.createCell(7);
		cell.setCellStyle(cskey);
		
		//第八行
        row = sheet.createRow(7); 
        row.setHeightInPoints(30);
        
        cell = row.createCell(0);
        cell.setCellStyle(csValue);
        cell.setCellValue("卡号"); 
        cell = row.createCell(1);
        cell.setCellStyle(csValue);
        cell.setCellValue("xxxxxxxxx"); 
        cell = row.createCell(2);
        cell.setCellStyle(csValue);
        cell.setCellValue("开户行"); 
        cell = row.createCell(3);
        cell.setCellStyle(csValue);
        cell.setCellValue("中国银行"); 
        cell = row.createCell(4);
        cell.setCellStyle(csValue);
        cell.setCellValue("开户人姓名"); 
        cell = row.createCell(5);
        cell.setCellStyle(csValue);
        cell.setCellValue("轩翔宇"); 
        cell = row.createCell(6);
        cell.setCellStyle(csValue);
        cell.setCellValue("开户人电话"); 
        cell = row.createCell(7);
        cell.setCellStyle(csValue);
        cell.setCellValue("15601605036"); 
        
        //第九行
        row = sheet.createRow(8); 
        row.setHeightInPoints(30);
        
        cell = row.createCell(0);
        cell.setCellStyle(csValue);
        cell.setCellValue("开户支行地址"); 
        cell = row.createCell(1);
        sheet.addMergedRegion(new CellRangeAddress(8, 8, 1, 7));
        cell.setCellStyle(csValue);
        cell.setCellValue("上海市青浦支行");
        cell = row.createCell(7);
        cell.setCellStyle(cskey);
        
        //第十行
        row = sheet.createRow(9); 
        row.setHeightInPoints(30);
		//设置单元格样式 
        cell = row.createCell(0);
		cell.setCellStyle(cs); 
		//设置单元格的值
		sheet.addMergedRegion(new CellRangeAddress(9, 9, 0, 7));
		cell.setCellValue("个人信息");
		cell = row.createCell(1);
        cell.setCellStyle(cskey); 
        cell = row.createCell(2);
        cell.setCellStyle(cskey); 
        cell = row.createCell(3);
        cell.setCellStyle(cskey); 
        cell = row.createCell(4);
        cell.setCellStyle(cskey); 
        cell = row.createCell(5);
        cell.setCellStyle(cskey); 
        cell = row.createCell(6);
        cell.setCellStyle(cskey); 
        cell = row.createCell(7);
        cell.setCellStyle(cskey);
        
        //第十一行
		row = sheet.createRow(10); 
        row.setHeightInPoints(30);
        
        cell = row.createCell(0); 
        sheet.addMergedRegion(new CellRangeAddress(10, 11, 0, 7));
        cell.setCellStyle(csValue);
        cell.setCellValue("好人");
        cell = row.createCell(1);
        cell.setCellStyle(cskey); 
        cell = row.createCell(2);
        cell.setCellStyle(cskey); 
        cell = row.createCell(3);
        cell.setCellStyle(cskey); 
        cell = row.createCell(4);
        cell.setCellStyle(cskey); 
        cell = row.createCell(5);
        cell.setCellStyle(cskey); 
        cell = row.createCell(6);
        cell.setCellStyle(cskey); 
        cell = row.createCell(7);
        cell.setCellStyle(cskey);
        row = sheet.createRow(11);
		cell = row.createCell(7);
		cell.setCellStyle(cskey);
        
        //第十三行
        row = sheet.createRow(12); 
        row.setHeightInPoints(30);
        
        cell = row.createCell(0);
        cell.setCellStyle(cs); 
        cell.setCellValue("备注信息"); 
        sheet.addMergedRegion(new CellRangeAddress(12,12, 0, 7));
        cell = row.createCell(1);
        cell.setCellStyle(cskey); 
        cell = row.createCell(2);
        cell.setCellStyle(cskey); 
        cell = row.createCell(3);
        cell.setCellStyle(cskey); 
        cell = row.createCell(4);
        cell.setCellStyle(cskey); 
        cell = row.createCell(5);
        cell.setCellStyle(cskey); 
        cell = row.createCell(6);
        cell.setCellStyle(cskey); 
        cell = row.createCell(7);
        cell.setCellStyle(cskey); 
        
        //第十三行
        row = sheet.createRow(13); 
        row.setHeightInPoints(30);
        
        cell = row.createCell(0);
		sheet.addMergedRegion(new CellRangeAddress(13, 14, 0, 7));
		cell.setCellStyle(csValue);
		cell.setCellValue("大好人"); 
		cell = row.createCell(7);
        cell.setCellStyle(cskey);
		row = sheet.createRow(14);
		cell = row.createCell(0);
		cell.setCellStyle(cskey); 
		cell = row.createCell(1);
        cell.setCellStyle(cskey); 
        cell = row.createCell(2);
        cell.setCellStyle(cskey); 
        cell = row.createCell(3);
        cell.setCellStyle(cskey); 
        cell = row.createCell(4);
        cell.setCellStyle(cskey); 
        cell = row.createCell(5);
        cell.setCellStyle(cskey); 
        cell = row.createCell(6);
        cell.setCellStyle(cskey); 
        cell = row.createCell(7);
        cell.setCellStyle(cskey);
		
		FileOutputStream fos = new FileOutputStream(path); 
		wb.write(fos); 
		if(null != fos){ 
			fos.close(); 
		} 
		System.out.println("写入成功，路径="+path);
	} 	
	
	/**
	 * 写入类别
	 * @param path
	 * @param cateList
	 * @throws IOException
	 */
	public static void writeExcel(String path,List<Category> cateList) throws IOException{ 
        //创建一个Excel(or new XSSFWorkbook())  
		XSSFWorkbook wb = new XSSFWorkbook(); 
        //创建表格  
        Sheet sheet = wb.createSheet("51job"); 
        //创建行  
        Row row = sheet.createRow(0); 
        //设置行高  
        row.setHeightInPoints(30); 
        //创建样式  
        CellStyle cs = wb.createCellStyle(); 
        cs.setAlignment(CellStyle.ALIGN_CENTER); 
        cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER); 
        cs.setBorderBottom(CellStyle.BORDER_DOTTED);  
        cs.setBorderLeft(CellStyle.BORDER_THIN);  
        cs.setBorderRight(CellStyle.BORDER_THIN); 
        cs.setBorderTop(CellStyle.BORDER_THIN); 
        //创建单元格  
        Cell cell = row.createCell(0); 
        //设置单元格样式  
        cell.setCellStyle(cs); 
        //设置单元格的值
        cell.setCellValue("一级分类"); 
        cell = row.createCell(1); 
        cell.setCellStyle(cs); 
        cell.setCellValue("二级分类");
        int nowRow = 1;
        for (int i = 0; i < cateList.size(); i++) {
			Category category = cateList.get(i);
			String fstr = category.getFatherStr();
			if(StringUtil.isEmpty(fstr)){
				continue;
			}
			row = sheet.createRow(nowRow++); 
			cell = row.createCell(0);//创建第一个单元格
			cell.setCellValue(fstr); 
			cell = row.createCell(1);//创建第二个单元格
			cell.setCellValue(""); 
			List<String> sList = category.getSonStrList();
			for (String s : sList) {
				fstr = "";
				row = sheet.createRow(nowRow++); 
				cell = row.createCell(0);//创建第一个单元格
				cell.setCellValue(fstr); 
				cell = row.createCell(1);//创建第二个单元格
				cell.setCellValue(s); 
			}
		}
        FileOutputStream fos = new FileOutputStream(path); 
        wb.write(fos); 
        if(null != fos){ 
            fos.close(); 
        } 
        System.out.println("写入成功，路径="+path);
    } 	
	
	
	/**
	 * 写入事例
	 * @param path
	 * @throws IOException
	 */
	public static void writeExcel(String path) throws IOException{ 
        //创建一个Excel(or new XSSFWorkbook())  
		XSSFWorkbook wb = new XSSFWorkbook(); 
        //创建表格  
        Sheet sheet = wb.createSheet("51job"); 
        //创建行  
        Row row = sheet.createRow(0); 
        //设置行高  
        row.setHeightInPoints(30); 
        //创建样式  
        CellStyle cs = wb.createCellStyle(); 
        cs.setAlignment(CellStyle.ALIGN_CENTER); 
        cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER); 
        cs.setBorderBottom(CellStyle.BORDER_DOTTED);  
        cs.setBorderLeft(CellStyle.BORDER_THIN);  
        cs.setBorderRight(CellStyle.BORDER_THIN); 
        cs.setBorderTop(CellStyle.BORDER_THIN); 
        //创建单元格  
        Cell cell = row.createCell(0); 
        //设置单元格样式  
        cell.setCellStyle(cs); 
        //设置单元格的值  
        cell.setCellValue("序号"); 
        cell = row.createCell(1); 
        cell.setCellStyle(cs); 
        cell.setCellValue("用户"); 
        row = sheet.createRow(1); 
        cell = row.createCell(0); 
        cell.setCellValue("1"); 
        cell = row.createCell(1); 
        cell.setCellValue("张起灵"); 
        FileOutputStream fos = new FileOutputStream(path); 
        wb.write(fos); 
        if(null != fos){ 
            fos.close(); 
        } 
        System.out.println("写入成功，路径="+path);
    } 	
	
	
	
	public static void main(String[] args) throws IOException {
		List<String> sl = new ArrayList<String>();
		sl.add("高级工程师");
		sl.add("UI");
		sl.add("美工");
		List<String> sl2 = new ArrayList<String>();
		sl2.add("高级工程师1");
		sl2.add("UI1");
		sl2.add("美工1");
		Category cg = new Category();
		cg.setFatherStr("软件");
		cg.setSonStrList(sl);
		Category cg2 = new Category();
		cg2.setFatherStr("ruanjin2");
		cg2.setSonStrList(sl2);
		
		List<Category> clist = new ArrayList<>();
		clist.add(cg);
		clist.add(cg2);
		
		//writeExcel("D:/11/11.xlsx",clist);
		writeExcelForFamily("D:/11/11.xlsx");
	}
}
