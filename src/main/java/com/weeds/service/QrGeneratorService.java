package com.weeds.service;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.weeds.dao.quotations.QrGeneratorJpaDao;
import com.weeds.entity.pojo.QrGenerator;
import com.weeds.utils.DateUtils;
import com.weeds.utils.GlobalKeys;

/**
 * Created by admin on 2016/4/20.
 */
@Service
public class QrGeneratorService {

	@Autowired
	private QrGeneratorJpaDao qrGeneratorJpaDao;
    
    /**
     * 保存
     * @param question
     * @return
     */
    public String saveOrUpdateQrGenerator(QrGenerator qrGenerator){
    	String id = qrGenerator.getId();
    	if(StringUtils.isBlank(id)){
    		qrGenerator.setCreateTime(new Date());
    		qrGenerator.setDeleteFlag(0);
    	}else{
    		QrGenerator old = qrGeneratorJpaDao.findOne(id);
    		if(old != null){
    			qrGenerator.setCreateTime(old.getCreateTime());
    			qrGenerator.setDeleteFlag(old.getDeleteFlag());
    		}
    		qrGenerator.setUpdateTime(new Date());
    	}
    	
    	qrGenerator = qrGeneratorJpaDao.save(qrGenerator);
    	return qrGenerator.getId();
    }
    
    
    /**
     * 获取单条
     * @param question
     * @return
     */
    public QrGenerator getQrGeneratorObject(String id){
    	return qrGeneratorJpaDao.findOne(id);
    }
    
    /**
     * 获取单条
     * @param question
     * @return
     */
    public QrGenerator getQrGeneratorObjectByUserId(String userId){
    	return qrGeneratorJpaDao.findByUserId(userId);
    }
    
    
    
    public static void main(String[] args) {
    	StringBuffer sb = new StringBuffer();
    	sb.append("BEGIN:VCARD\r\n");
    	sb.append("VERSION:3.0\r\n");
    	sb.append("N:qwe\r\n");
    	sb.append("TEL:13213213\r\n");
    	sb.append("END:VCARD");
    	System.out.println(sb.toString());
    	try {
    		String basePath = GlobalKeys.getConstantsByKeyForProperties("uploadUrl", "d://opt//")+File.separator+"qr"+File.separator;
    		String forder = "qr";
    		String dataForder = DateUtils.dateToString(new Date(), "yyyyMMdd");
    		String path = basePath + File.separator + forder + File.separator + dataForder + File.separator;
    		String imgName = DateUtils.dateToString(new Date(), "yyyyMMddHHmmss")+".png";
    		File file = new File(path,imgName);
			if (!file.exists()) {
				file.mkdirs();
			}
            int qrcodeWidth = 300;
            int qrcodeHeight = 300;
            String qrcodeFormat = "png";
            HashMap<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(sb.toString(), BarcodeFormat.QR_CODE, qrcodeWidth, qrcodeHeight, hints);
            MatrixToImageConfig config = new MatrixToImageConfig();
            MatrixToImageWriter.writeToFile(bitMatrix, qrcodeFormat, file, config);
            
            String httpPath =  GlobalKeys.getConstantsByKeyForProperties("httpUrl", "http://demo.dayiinfo.com:8080/images/")
					+ forder + "/" + dataForder + "/" + imgName;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
    
}
