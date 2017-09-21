package com.weeds.rest;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Maps;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.weeds.common.Response;
import com.weeds.entity.Page;
import com.weeds.entity.pojo.QrGenerator;
import com.weeds.entity.pojo.quotations.Quotations;
import com.weeds.entity.pojo.quotations.QuotationsComment;
import com.weeds.entity.pojo.quotations.QuotationsLaud;
import com.weeds.service.QrGeneratorService;
import com.weeds.service.QuotationsService;
import com.weeds.utils.DateUtils;
import com.weeds.utils.GlobalKeys;
import com.weeds.utils.ResponseUtil;
import com.weeds.utils.StringUtil;


/**
 * 语录接口
 * 
 * @author xuanxy
 */
@Controller
@RequestMapping(value = "/api/generator")
public class ApiQrGeneratorController extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(ApiQrGeneratorController.class);
	
	@Autowired
	private QrGeneratorService qrGeneratorService;
	
	/**
	 * 语录列表接口 
	 * @param response
	 * @param pageIndex
	 * 		  pageSize
	 * @throws IOException
	 */
	@RequestMapping (value = "getUserQr.json")
	public void getUserQr(HttpServletResponse response,String userId)  throws IOException {
		
		try {
			if(StringUtil.isEmpty(userId)){
				ResponseUtil.printFailError(response, Response.PARAMETERS + "", "缺少参数");
				return;
			}
			
			QrGenerator qr = qrGeneratorService.getQrGeneratorObjectByUserId(userId);
			
			ResponseUtil.printNonEmptyJson(response, "data" , qr);
		} catch (Exception e) {
			
			ResponseUtil.printFail(response, 505, "系统升级");
		}
		
	}
	/**
	 * 语录列表接口 http://localhost/api/quotations/quotationsList.json?pageIndex=1&pageSize=10
	 * @param response
	 * @param pageIndex
	 * 		  pageSize
	 * @throws IOException
	 */
	@RequestMapping (value = "generator.json")
	public void generator(HttpServletResponse response,QrGenerator qrGenerator)  throws IOException {
		
		try {
			if(StringUtil.isEmpty(qrGenerator.getName())){
				ResponseUtil.printFailError(response, Response.PARAMETERS + "", "缺少参数");
				return;
			}
			
			//生成二维码图片
			String qrStr = getQrStr(qrGenerator);
			
			if(StringUtil.isEmpty(qrStr)){
				ResponseUtil.printFailError(response, Response.PARAMETERS + "", "参数不全，无法生成");
				return;
			}
			logger.info("二维码封装信息="+qrStr);
			String httpPath = generationQr(qrStr, qrGenerator.getName());
			if(StringUtil.isEmpty(httpPath)){
				ResponseUtil.printFailError(response, Response.PARAMETERS + "", "网络异常");
				return;
			}
			qrGenerator.setQrCode(httpPath);
			qrGeneratorService.saveOrUpdateQrGenerator(qrGenerator);
			Map<String, Object> returnMap = Maps.newHashMap();
			returnMap.put("httpPath", httpPath);
			returnMap.put("generatorId", qrGenerator.getId());
			ResponseUtil.printNonEmptyJson(response, "data" , returnMap);
		} catch (Exception e) {
			
			ResponseUtil.printFailError(response, 505+"", "系统升级");
		}
		
	}
	
	
	/**
     * 获取二维码生成信息
     * @param qrGenerator
     * @return
     */
    private String getQrStr(QrGenerator qrGenerator){
    	StringBuffer sb = new StringBuffer();
    	sb.append("BEGIN:VCARD\r\n");
    	sb.append("VERSION:3.0\r\n");
    	sb.append("N:"+qrGenerator.getName()+"\r\n");
    	sb.append("TEL:"+qrGenerator.getTelPhone()+"\r\n");
    	sb.append("TEL;TYPE=WORK,VOICE:"+qrGenerator.getTelWork()+"\r\n");
    	sb.append("TEL;TYPE=HOME,VOICE:"+qrGenerator.getTelHome()+"\r\n");
    	sb.append("NOTE:"+qrGenerator.getRemark()+"\r\n");
    	sb.append("EMAIL:"+qrGenerator.getEmail()+"\r\n");
    	sb.append("ORG:"+qrGenerator.getCompany()+"\r\n");
    	sb.append("TITLE:"+qrGenerator.getPosition()+"\r\n");
    	sb.append("URL:"+qrGenerator.getUrl()+"\r\n");
    	sb.append("ADR;TYPE=WORK:"+qrGenerator.getAddressWork()+"\r\n");
    	sb.append("ADR;TYPE=HOME:"+qrGenerator.getAddressWork()+"\r\n");
    	sb.append("END:VCARD");
    	return sb.toString();
    }
    
    /**
     * 生成二维码图片  返回互联网访问路径
     * @param qrStr
     * @return
     */
    private String generationQr(String qrStr,String name){
    	String httpPath = "";
    	try {
    		String basePath = GlobalKeys.getConstantsByKeyForProperties("uploadUrl", "d://opt//");
    		String forder = "qr";
    		String dataForder = DateUtils.dateToString(new Date(), "yyyyMMdd");
    		String path = basePath + File.separator + forder + File.separator + dataForder + File.separator;
    		String imgName = DateUtils.dateToString(new Date(), "yyyyMMddHHmmss")+StringUtil.getRandomVal(2, 6, null)+".png";
    		File file = new File(path,imgName);
			if (!file.exists()) {
				file.mkdirs();
			}
            int qrcodeWidth = 300;
            int qrcodeHeight = 300;
            String qrcodeFormat = "png";
            HashMap<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(qrStr, BarcodeFormat.QR_CODE, qrcodeWidth, qrcodeHeight, hints);
            MatrixToImageConfig config = new MatrixToImageConfig();
            MatrixToImageWriter.writeToFile(bitMatrix, qrcodeFormat, file, config);
            
            httpPath =  GlobalKeys.getConstantsByKeyForProperties("httpUrl", "http://demo.dayiinfo.com:8080/images/")
					+ forder + "/" + dataForder + "/" + imgName;
            logger.info(name + "二维码名片互联网访问地址="+httpPath);
        } catch (Exception e) {
        	logger.error("二维码图片生成异常"+e.getMessage(),e);
        }
    	
    	return httpPath;
    }
    
}
