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
    <li class="boyimg"><a style="background: url(../images/boy.jpg) no-repeat;" href="javascript:void(0)"><span>关于他</span></a></li>
    <li class="girlimg"><a style="background: url(../images/girl.jpg) no-repeat;" href="javascript:void(0)"><span>关于我</span></a></li>
  </ul>
  <ul class="texts">
    <p>人生，是一场盛大的遇见</p>
    <p>若你懂得，就请珍惜。</p>
    <p>无论下多久的雨，最后都会有彩虹；无论你多么悲伤，要相信幸福在前方等候</p>
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
			<div class="memorial_day">
  <div class="time_axis"></div>
  <ul>
    <li class="n1" style="top: 54px; left: 90px;"><a href="/">相遇</a>
      <div class="dateview">2011-06-27</div>
    </li>
    <li class="n2" style="top: 54px; left: 220px;"><a href="/">相识</a>
      <div class="dateview">2011-12-19</div>
    </li>
    <li class="n3" style="top: 54px; left: 350px;"><a href="/">相知</a>
      <div class="dateview">2012-10-01</div>
    </li>
    <li class="n4" style="top: 54px; left: 480px;"><a href="/">相恋</a>
      <div class="dateview">2013-02-14</div>
    </li>
    <li class="n5" style="top: 54px; left: 610px;"><a href="/">相爱</a>
      <div class="dateview">2014-10-05</div>
    </li>
  </ul>
</div>
	</div>
	<%@include file="/view/right.jsp"%>
		</article>
		<%@include file="/view/footer.jsp"%>
</body>
</html>
