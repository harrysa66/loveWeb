package com.love.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestUtils;

public class PageMapUtil {
	public PageMapUtil() {}
    
	/**
	 * 获得页面中的页号信息，放到pagemap对象中
	 * @param <T>
	 * @param request
	 * @return
	 */
	public static Map<String, Object> getPageObj(HttpServletRequest request) {
		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("rows", ServletRequestUtils.getStringParameter(request, "rows", "20"));
		pageMap.put("page", ServletRequestUtils.getStringParameter(request, "page", "1"));
		pageMap.put("totalCount", ServletRequestUtils.getStringParameter(request, "totalCount", "0"));
		return pageMap;
    }
	
}