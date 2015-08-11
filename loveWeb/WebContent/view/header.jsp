<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<header>
	<h1>
		<a href="${msUrl}">${indexPage.title }</a>
	</h1>
	<p>${indexPage.subtitle }</p>
	</header>
	<!--nav begin-->
	<div class="navswf">
		<object id="customMenu" data="${msUrl}/images/nav.swf" width="528" height="70"
			type="application/x-shockwave-flash">
			<param name="allowScriptAccess" value="always">
			<param name="allownetworking" value="all">
			<param name="allowFullScreen" value="true">
			<param name="wmode" value="transparent">
			<param name="menu" value="false">
			<param name="scale" value="noScale">
			<param name="salign" value="1">
		</object>
		<div id="nav">
			<ul>
				<c:forEach var="item" items="${topMenuList}">
					<li><a href="${item.url}" title="${item.name}">${item.name}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<!--nav end-->
	<div class="blank"></div>