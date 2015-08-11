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
		<h1 align="center" style="padding-top: 10px;">${article.title }</h1>
		<h3 align="center" style="font-size: 16px;padding-top: 10px;">${article.subtitle }</h3>
		<h3 align="center" style="font-size: 14px;padding-top: 10px;color: gray;"><fmt:formatDate value="${article.createTime}" type="date" dateStyle="full"/></h3>
		<p style="padding-top: 20px;">${article.content }</p>
		<div class="blank" style="padding-top: 20px;"></div>
	</div>
	<%@include file="/view/right.jsp"%>
		</article>
		<%@include file="/view/footer.jsp"%>
</body>
</html>
