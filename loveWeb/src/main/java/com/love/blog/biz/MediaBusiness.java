package com.love.blog.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.love.blog.vo.MediaGroup;
import com.love.blog.vo.MediaGroupList;
import com.love.blog.vo.MediaType;
import com.love.util.PropertiesUtil;

@Service
public class MediaBusiness {
	
	RestTemplate restTemplate = new RestTemplate();

	public List<MediaGroup> queryMediaGroupsByDisplay(Map<String, Object> urlMap, String display) {
		List<MediaGroup> mediaGroups = new ArrayList<MediaGroup>();
		String rootUrl = MapUtils.getString(urlMap, "msUrl");
		MediaType type = new MediaType();
		type.setDisplay(Integer.parseInt(display));
		MediaGroupList mediaGroupList = restTemplate.postForObject(PropertiesUtil.getProperty("adminUrl")+"/services/media/queryGroupByDisplay.rest", type, MediaGroupList.class);
		for(MediaGroup mediaGroup : mediaGroupList.getMediaGroupList()){
			mediaGroup.setUrl(rootUrl+"/media/queryMedias/"+mediaGroup.getId()+".s");
			mediaGroups.add(mediaGroup);
		}
		return mediaGroups;
	}

}
