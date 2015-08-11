<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
   
  <pg:index>  
    <center style="font-size:14px;">  
    <table border=0 cellpadding=0 cellspacing=0>  
    <tr align=center valign=top>  
    <pg:first>  
    	<td class="pagetd"><b>
    	<c:if test="${not empty pageUrl}"><a href="${pageUrl}">首页</a></c:if>
        <c:if test="${empty pageUrl}">首页</c:if>
        </b></td>
    </pg:first>
    <pg:prev ifnull="true"> 
    	<td class="pagetd"><b>
    	<c:if test="${not empty pageUrl}"><a href="${pageUrl}">上一页</a></c:if>
        <c:if test="${empty pageUrl}">上一页</c:if>
        </b></td> 
    </pg:prev>  
    <pg:pages>  
    <td class="pagetd">
    	<c:choose>  
            <c:when test="${currentPageNumber eq pageNumber}">  
                <font color="#A90A08">${pageNumber }</font>  
            </c:when>  
            <c:otherwise>   
                <a href="${pageUrl}">${pageNumber }</a>  
            </c:otherwise>  
        </c:choose>
        </td>
    </pg:pages>  
    <pg:next ifnull="true">  
    <td class="pagetd"><b>
    	<c:if test="${not empty pageUrl}"><a href="${pageUrl}">下一页</a></c:if>
        <c:if test="${empty pageUrl}">下一页</c:if>
        </b></td> 
    </pg:next>  
    <pg:last>  
    	<td class="pagetd"><b>
    	<c:if test="${not empty pageUrl}"><a href="${pageUrl}">尾页</a></c:if>
        <c:if test="${empty pageUrl}">尾页</c:if>
        </b></td>
    </pg:last> 
    </tr>  
    </table>  
    </center>  
  </pg:index>  
 
