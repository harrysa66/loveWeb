package com.love.blog.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.love.blog.vo.Media;
import com.love.blog.vo.MediaGroup;
import com.love.blog.vo.MediaGroupList;
import com.love.blog.vo.MediaList;
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
		if(mediaGroupList != null && mediaGroupList.getMediaGroupList() != null){
			for(MediaGroup mediaGroup : mediaGroupList.getMediaGroupList()){
				MediaGroup tempGroup = new MediaGroup();
				tempGroup.setId(mediaGroup.getId());
				MediaList mediaList = restTemplate.postForObject(PropertiesUtil.getProperty("adminUrl")+"/services/media/queryMediasByGroup.rest", tempGroup, MediaList.class);
				if(mediaList.getMediaList() != null){
					mediaGroup.setName(mediaGroup.getName()+"（"+mediaList.getMediaList().size()+"）");
				}else{
					mediaGroup.setName(mediaGroup.getName()+"（0）");
				}
				mediaGroup.setUrl(rootUrl+"/media/queryMedias/"+mediaGroup.getTypes()+"/"+mediaGroup.getId()+".s");
				mediaGroups.add(mediaGroup);
			}
		}
		return mediaGroups;
	}

	public List<Media> queryMediasByGroup(String groupId) {
		List<Media> medias = new ArrayList<Media>();
		MediaGroup group = new MediaGroup();
		group.setId(groupId);
		MediaList mediaList = restTemplate.postForObject(PropertiesUtil.getProperty("adminUrl")+"/services/media/queryMediasByGroup.rest", group, MediaList.class);
		if(mediaList != null && mediaList.getMediaList() != null){
			medias.addAll(mediaList.getMediaList());
		}
		return medias;
	}

}
