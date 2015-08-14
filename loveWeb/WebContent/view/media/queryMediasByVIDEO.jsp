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
    videojs.options.flash.swf = "${msUrl}/js/video-js/video-js.swf";
  </script>
  <script type="text/javascript">
  var vodeojs = null;
  function playVideo(url){
	  if(vodeojs != null){
		  vodeojs.dispose();
			var html = "<video id='video' class='video-js vjs-default-skin vjs-big-play-centered' controls preload='none' width='700' height='350' poster='${msUrl}/images/video.jpg'> <source id='videoSource' src='' type='video/mp4' /> </video>";
			$("#videoDiv").append(html);
	  }
	  $("#videoSource").attr('src',url);
	  vodeojs = videojs('video', {"autoplay": false}, function() {
		  //this.play(); // if you don't trust autoplay for some reason
		});
  }
  </script>
</head>
<body>
<%@include file="/view/header.jsp"%>
	<article>
	<div class="blog">
		<pg:pager url="${msUrl}/media/queryMedias/${types }/${groupId}.s" index="center" maxPageItems = "5" maxIndexPages="10"   
		isOffset = "false"  export = "pageOffset,currentPageNumber=pageNumber"  scope = "request">  
 <table style="width: 100%;"> 
 <tr><td colspan="2">
 <div id="videoDiv" style="padding-top: 20px;padding-bottom: 20px;">
 <video id="video" class="video-js vjs-default-skin vjs-big-play-centered" controls preload="none" width="700" height="350"
      poster="${msUrl}/images/video.jpg">
    <source id="videoSource" src="" type="video/mp4" />
  </video>
 </div>
 </td></tr>
 <c:forEach items="${mediaList}" var="item">  
    <pg:item>  
     <tr>  
      <td class="articltItem"><span><a href="javascript:playVideo('${item.imgUrl}')">
      <c:if test="${not empty item.name}">
					${item.name }
				</c:if>
				<c:if test="${empty item.name}">
					视频
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
