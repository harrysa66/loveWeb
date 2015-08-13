<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!doctype html>
<html>
<head>
<title>LOVE博客</title>
<%@include file="/view/resource.jsp"%>
<script>
function playAudio(url){
	$("#audioDiv").empty();
	var html = "<audio src='"+url+"' preload='none' type='audio/mpeg'/>";
	$("#audioDiv").append(html);
	audiojs.events.ready(function() {
	    var as = audiojs.createAll();
	  });
}
  </script>
</head>
<body>
<%@include file="/view/header.jsp"%>
	<article>
	<div class="blog">
		<pg:pager url="${msUrl}/media/queryMedias/${types }/${groupId}.s" index="center" maxPageItems = "15" maxIndexPages="10"   
		isOffset = "false"  export = "pageOffset,currentPageNumber=pageNumber"  scope = "request">  
 <table style="width: 100%;"> 
 <tr><td colspan="2">
 <div id="audioDiv" style="padding-top: 20px;padding-bottom: 20px;">
 </div>
 </td></tr>
 <c:forEach items="${mediaList}" var="item">  
    <pg:item>  
     <tr>  
      <td class="articltItem"><span><a href="javascript:playAudio('${item.imgUrl}')">
      <c:if test="${not empty item.name}">
					${item.name }
				</c:if>
				<c:if test="${empty item.name}">
					音频
				</c:if>
      </a></span></td>  
      <td class="articltDate"><span><fmt:formatDate value="${item.createTime}" type="date" dateStyle="full"/></span></td>  
     </tr>   
    </pg:item>  
</c:forEach>  
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
