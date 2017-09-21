package com.weeds.quartz;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.weeds.entity.pojo.Family;
import com.weeds.service.FamilyService;
import com.weeds.utils.DateUtils;
import com.weeds.utils.LunarCalendar;
import com.weeds.utils.StringUtil;

@Component
public class BithdayAnalysisJob {
	private static Logger logger = LoggerFactory.getLogger(BithdayAnalysisJob.class);
	
	@Autowired
	private FamilyService familyService;

	/**
	 * 定时
	 */
	public void execute() {
		logger.info("当前生日分析定时任务执行时间:"+DateUtils.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		
		try {
			Map<String, Object> parameters = Maps.newHashMap();
			parameters.put("status", 0);
			List<Family> familyList = familyService.getFamilyList(parameters);
			List<Family> dbFamilyList = Lists.newArrayList(); 
			String birthDay = "";
			String noticeBirthday = "";
			int gregorian = 0;
			String nowYear = Calendar.getInstance().get(Calendar.YEAR)+"";
			
			if(familyList != null && !familyList.isEmpty()){
				for (Family family : familyList) {
					birthDay = family.getBirthday();
					gregorian = family.getGregorian();
					if(StringUtil.isNotEmpty(birthDay)){
						if(gregorian==0){//过阴历   需要转换
							birthDay = nowYear + birthDay.substring(4);
							String tmpDate []  =  birthDay.split("-");
							int year = Integer.valueOf(tmpDate[0]);
							int month = Integer.valueOf(tmpDate[1]);
							int monthDay = Integer.valueOf(tmpDate[2]);
							int birStrArry []  = LunarCalendar.lunarToSolar(year, month, monthDay, false);
							noticeBirthday = birStrArry[0] + "-" + birStrArry[1] + "-" + birStrArry[2];
							if(StringUtil.isNotEmpty(family.getNoticeBirthday()) && noticeBirthday.equals(family.getNoticeBirthday())){
								logger.info(family.getChName()+"生日"+noticeBirthday+"无需校对，过滤");
								continue;
							}
							logger.info("分析农历,农历转换为公历="+noticeBirthday);
						}else{
							noticeBirthday = birthDay;
						}
					}
					family.setNoticeBirthday(noticeBirthday);
					dbFamilyList.add(family);
				}
				//批处理分析数据
				if(dbFamilyList != null && !dbFamilyList.isEmpty()){
					familyService.batchPersistentFamily(dbFamilyList);
				}
				logger.info("分析处理完成，共分析"+dbFamilyList.size()+"条数据");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
