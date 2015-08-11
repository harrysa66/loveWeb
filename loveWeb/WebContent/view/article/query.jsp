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
		<pg:pager url="${msUrl}/article/queryArticles/${display}.s" index="center" maxPageItems = "15" maxIndexPages="10"   
		isOffset = "false"  export = "pageOffset,currentPageNumber=pageNumber"  scope = "request">  
 <table style="width: 100%;">    
    <c:forEach items="${articleList}" var="item">  
    <pg:item>  
     <tr>  
      <td class="articltItem"><span><a href="${item.url}">${item.title}</a></span></td>  
      <td class="articltDate"><span><fmt:formatDate value="${item.createTime}" type="date" dateStyle="full"/></span></td>  
     </tr>   
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
