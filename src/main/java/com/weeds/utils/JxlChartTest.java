package com.weeds.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


/**
 * jxl读写excel
 * @author xuanxy
 *
 */
public class JxlChartTest {
	
	public static final String fileName = "d:\\11\\1.xls"; 

	public static void readFile(){
		try {
			File file = new File(fileName);
			InputStream is = new FileInputStream(file);
			Workbook rwb = null;
			rwb = Workbook.getWorkbook(is);
			//Sheet的下标是从0开始的
			//获取第一张Sheet表
			Sheet rs = rwb.getSheet(0);
			//获取Sheet表中所包含的总列数
			int rsColumns = rs.getColumns();
			//获取Sheet表中所包含的总行数
			int rsRows = rs.getRows();
			//获取指这下单元格的对象引用
			for(int i=0;i<rsRows;i++){
				for(int j=0;j<rsColumns;j++){
					Cell cell = rs.getCell(j,i);
					String cellValues = cell.getContents();
					if(cellValues!=null && !cellValues.trim().equals("")){
						System.out.println(cellValues);
					}
					System.out.println("=============");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeFile(){
		
		try {
			OutputStream out = new FileOutputStream(new File(fileName));
			WritableWorkbook book = Workbook.createWorkbook(out);
			WritableSheet sheet = book.createSheet("Sheet1", 0);
			// 居中
			WritableCellFormat format = new WritableCellFormat();
			format.setAlignment(Alignment.CENTRE);
			format.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 边框
			WritableCellFormat formatBorder = new WritableCellFormat();
			formatBorder.setBorder(Border.ALL, BorderLineStyle.THIN);
			sheet.setColumnView(0, 10);
			sheet.setColumnView(1, 15);
			sheet.setColumnView(2, 25);
			sheet.setColumnView(3, 25);
			sheet.addCell(new Label(0, 0, "编号", format));
			sheet.addCell(new Label(1, 0, "网吧名称", format));
			sheet.addCell(new Label(2, 0, "审计查询", format));
			sheet.addCell(new Label(3, 0, "统计时间", format));
			//jxl.write.DateTime labelDT = new jxl.write.DateTime(1,2,new java.util.Date()); 
			//sheet.addCell(labelDT); 
			//sheet.addCell(new Label(1, 2, "选项", formatBorder));
			sheet.addCell(new Label(0, 1, "选项1", formatBorder));
			sheet.addCell(new jxl.write.Number(1, 1, 10, formatBorder));
			sheet.addCell(new jxl.write.Number(2, 1, 3, formatBorder));
			sheet.addCell(new jxl.write.Number(3, 1, 4, formatBorder));
			sheet.addCell(new Label(0, 2, "选项2", formatBorder));
			sheet.addCell(new jxl.write.Number(1, 2, 5, formatBorder));
			sheet.addCell(new jxl.write.Number(2, 2, 7, formatBorder));
			sheet.addCell(new jxl.write.Number(3, 2, 1, formatBorder));
			sheet.addCell(new Label(0, 3, "选项3", formatBorder));
			sheet.addCell(new jxl.write.Number(1, 3, 13, formatBorder));
			sheet.addCell(new jxl.write.Number(2, 3, 3, formatBorder));
			sheet.addCell(new jxl.write.Number(3, 3, 12, formatBorder));
			book.write();
			out.flush();
			book.close();
			out.close();
			System.out.println("写入成功");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		//readFile();
		writeFile();
	}
}
