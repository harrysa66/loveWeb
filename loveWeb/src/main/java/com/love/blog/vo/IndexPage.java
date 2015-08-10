package com.love.blog.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="indexPage")
public class IndexPage {
	
	private String id;
	private String title;
	private String subtitle;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

}
