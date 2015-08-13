<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!doctype html>
<html>
<head>
<title>LOVE博客</title>
<%@include file="/view/resource.jsp"%>
<script type="text/javascript">
$(function(){
	var obj=null;
	var As=$("#nav a");//document.getElementById('nav').getElementsByTagName('a');
	obj = As[0];
	for(i=1;i<As.length;i++){
		if(window.location.href.indexOf(As[i].href)>=0)
		obj=As[i];
	}
	obj.id='nav_current'
})
</script>
</head>
<body>
<%@include file="/view/header.jsp"%>
	<article>
	<div class="blog">
		<!-- blog list begin-->
		<c:forEach var="item" items="${articles}" begin="0" end="2">
			<h2><a href="${item.url}">${item.title}</a></h2>
			<p class="datetime"><fmt:formatDate value="${item.createTime}" type="date" dateStyle="full"/></p>
			<ul class="topimg">
				<c:if test="${not empty item.imgUrl}">
					<img src="${item.imgUrl}">
				</c:if>
				<c:if test="${empty item.imgUrl}">
					<img src="${msUrl}/images/article.png">
				</c:if>
			</ul>
			<ul class="content">
				<div>${item.content}</div>
			</ul>
			<p class="read">
				<a href="${item.url}">阅读>></a>
			</p>
		</c:forEach>
		<!-- blog list end-->
	</div>
	<%@include file="/view/right.jsp"%>
		</article>
		<%@include file="/view/footer.jsp"%>
</body>
</html>
