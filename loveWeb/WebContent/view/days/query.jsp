<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
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
		<div class="banner">
		
  <ul class="boy_girl">
    <li class="boyimg"><a style="background: url(
    <c:if test="${not empty daysIndex.boyUrl}">
    ${daysIndex.boyUrl}
    </c:if>
    <c:if test="${empty daysIndex.boyUrl}">
    ${msUrl}/images/boy.jpg
    </c:if>
    ) no-repeat;" href="javascript:void(0)"><span>${daysIndex.boyTitle}</span></a></li>
    <li class="girlimg"><a style="background: url(
    <c:if test="${not empty daysIndex.girlUrl}">
   ${daysIndex.girlUrl}
    </c:if>
    <c:if test="${empty daysIndex.girlUrl}">
    ${msUrl}/images/girl.jpg
    </c:if>
    ) no-repeat;" href="javascript:void(0)"><span>${daysIndex.girlTitle}</span></a></li>
  </ul>
  <ul class="texts">
    <p>${daysIndex.contentOne}</p>
    <p>${daysIndex.contentTwo}</p>
    <p>${daysIndex.contentThree}</p>
  </ul>
</div>
<div class="blank"></div>
<%-- <ul id="example1" class="timeliner">
				<li title="2011年03月06日" lang="5"></li>
				<li title="Slide two" lang="5">
					This is HTML text. It could also be flash, embedded video 
					etc.<br>
					More examples and technical info below. 
					This is HTML text. It could also be flash, embedded video 
					etc.<br>
					More examples and technical info below.
					This is HTML text. It could also be flash, embedded video 
					etc.<br>
					
				</li>
				<li title="Slide three with a long title<br>and a line-break" lang="5">
					This example will repeat automatically. It can also stop at 
					the last slide if you want it to.
				</li>
			</ul> --%>
<c:if test="${not empty daysList}">
			<div class="memorial_day">
  <div class="time_axis"></div>
  <ul>
  		<c:forEach items="${daysList}" var="item" varStatus="status">
  			<li class="n${status.count}" style="top: 54px; left: ${(status.count * 90)+(status.index * 40)}px;"><a href="javascript:void(0)">${item.memorialTitle}</a>
      			<div class="dateview"><fmt:formatDate value="${item.memorialDate}" type="date" dateStyle="default"/></div>
    		</li>
  		</c:forEach>
  	
  </ul>
</div>
</c:if>
	</div>
	<%@include file="/view/right.jsp"%>
		</article>
		<%@include file="/view/footer.jsp"%>
</body>
</html>
