package com.love.blog.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="mediaTypeList")
public class MediaTypeList {
	
	private List<MediaType> mediaTypeList;

	public List<MediaType> getMediaTypeList() {
		return mediaTypeList;
	}

	public void setMediaTypeList(List<MediaType> mediaTypeList) {
		this.mediaTypeList = mediaTypeList;
	}

}
