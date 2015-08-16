package com.love.blog.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.love.blog.vo.Days;
import com.love.blog.vo.DaysIndex;
import com.love.blog.vo.DaysList;
import com.love.framework.common.Constants;
import com.love.util.PropertiesUtil;

@Service
public class DaysBusiness {
	
	RestTemplate restTemplate = new RestTemplate();
	
	public DaysIndex queryDaysIndex(){
		DaysIndex param = new DaysIndex();
		param.setId(null);
		DaysIndex daysIndex = restTemplate.postForObject(PropertiesUtil.getProperty("adminUrl")+"/services/daysIndex/queryDaysIndex.rest", param, DaysIndex.class);
		return daysIndex;
	}
	
	public List<Days> queryDays(){
		List<Days> dayss = new ArrayList<Days>();
		Days days = new Days();
		days.setStatus(Constants.STATUS_DEFAULT);
		DaysList daysList = restTemplate.postForObject(PropertiesUtil.getProperty("adminUrl")+"/services/days/queryDays.rest", days, DaysList.class);
		if(daysList != null && daysList.getDaysList() != null){
			dayss.addAll(daysList.getDaysList());
		}
		return dayss;
	}

}
