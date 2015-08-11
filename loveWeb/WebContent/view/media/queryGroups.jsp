<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!doctype html>
<html>
<head>
<title>LOVE博客</title>
<%@include file="/view/resource.jsp"%>
</head>
<body>
<%@include file="/view/header.jsp"%>
	<article>
	<div class="blog">
		<pg:pager url="${msUrl}/media/queryMediaGroups/${display}.s" index="center" maxPageItems = "12" maxIndexPages="10"   
		isOffset = "false"  export = "pageOffset,currentPageNumber=pageNumber"  scope = "request">  
 <table style="width: 100%;"> 
 <tr>   <td>
 	<ul class="box01">
    <c:forEach items="${mediaGroupList}" var="item">  
    <pg:item> 
    <li>
		<div class="in">
			<a href="${item.url }"><img src="${item.imgUrl}" /></a>
			<p><b class="bsc"></b><a href="${item.url }">${item.name }</a></p>
		</div>
	</li> 
    </pg:item>  
</c:forEach>
</ul>
 </td></tr>   
</table>    
<div class="blank" style="padding-top: 60px;"></div>
  <%@include file="/view/pagination.jsp"%>
  </pg:pager>
	</div>
	<%@include file="/view/right.jsp"%>
		</article>
		<%@include file="/view/footer.jsp"%>
</body>
</html>
