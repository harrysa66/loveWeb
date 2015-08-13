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
		<pg:pager url="${msUrl}/board/query.s" index="center" maxPageItems = "10" maxIndexPages="10"   
		isOffset = "false"  export = "pageOffset,currentPageNumber=pageNumber"  scope = "request">  
 <table style="width: 100%;" class="bordered">    
    <c:forEach items="${boardList}" var="item">  
    <pg:item>  
     <tr>  
      <th class="boardItem"><span>网友：${item.ip}（来自：${item.ipAddress}）</span></th>  
      <th class="boardDate"><span>留言时间：<fmt:formatDate value="${item.createTime}" type="date" dateStyle="full"/></span></th>  
     </tr>   
     <tr>  
      <td class="boardItem" colspan="2"><span>留言：${item.content}</span></td>  
     </tr>
     <c:if test="${not empty item.replyContent}">
     <tr>  
      <td class="boardItem" colspan="2"><span style="color: red;">回复：</span><span>${item.replyContent}</span></td>  
     </tr>
     </c:if>
    </pg:item>  
</c:forEach>  
</table>    
  <%@include file="/view/pagination.jsp"%>
  </pg:pager>
	</div>
	<%@include file="/view/right.jsp"%>
		</article>
		<%@include file="/view/footer.jsp"%>
</body>
</html>
