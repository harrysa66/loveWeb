package com.love.blog.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="days")
public class Days {
	
	private String id;
	private Date memorialDate;
	private String fmtDate;
	private String memorialTitle;
	private String memorialContent;
	private String status;
	private String isvalid;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getMemorialDate() {
		return memorialDate;
	}
	public void setMemorialDate(Date memorialDate) {
		this.memorialDate = memorialDate;
	}
	public String getFmtDate() {
		return fmtDate;
	}
	public void setFmtDate(String fmtDate) {
		this.fmtDate = fmtDate;
	}
	public String getMemorialTitle() {
		return memorialTitle;
	}
	public void setMemorialTitle(String memorialTitle) {
		this.memorialTitle = memorialTitle;
	}
	public String getMemorialContent() {
		return memorialContent;
	}
	public void setMemorialContent(String memorialContent) {
		this.memorialContent = memorialContent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIsvalid() {
		return isvalid;
	}
	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}

}
