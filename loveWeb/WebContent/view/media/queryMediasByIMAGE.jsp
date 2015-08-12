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
		<pg:pager url="${msUrl}/media/queryMedias/${types }/${groupId}.s" index="center" maxPageItems = "9" maxIndexPages="10"   
		isOffset = "false"  export = "pageOffset,currentPageNumber=pageNumber"  scope = "request">  
 <table style="width: 100%;"> 
 <tr>   <td>
 <div class="box">
    <div id="imgs" class="imgs">
    	<c:forEach items="${mediaList}" var="item">  
    <pg:item> 
        <img src="
        <c:if test="${not empty item.imgUrl}">
					${item.imgUrl}
				</c:if>
				<c:if test="${empty item.imgUrl}">
					${msUrl}/images/default.jpg
				</c:if>
        " layer-pname="
        <c:if test="${not empty item.name}">
					${item.name }
				</c:if>
				<c:if test="${empty item.name}">
					图片
				</c:if>
        ">
        </pg:item>  
</c:forEach>
    </div>
	<div style="text-align:center;clear:both;">
<!-- <script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="/follow.js" type="text/javascript"></script> -->
</div>
</div>
 
 </td></tr>   
</table>    
<div class="blank" style="padding-top: 60px;"></div>
  <%@include file="/view/pagination.jsp"%>
  </pg:pager>
	</div>
	<%@include file="/view/right.jsp"%>
		</article>
		<%@include file="/view/footer.jsp"%>
		
<script>
;!function(){
layer.use('extend/layer.ext.js', function(){
    //初始加载即调用，所以需放在ext回调里
    layer.ext = function(){
        layer.photosPage({
            //html:'<div style="padding:20px;">这里传入自定义的html<p>相册支持左右方向键，支持Esc关闭</p><p>另外还可以通过异步返回json实现相册。更多用法详见官网。</p><p>'+ unescape("%u7D20%u6750%u5BB6%u56ED%20-%20sc.chinaz.com") +'</p><p id="change"></p></div>',
            //title: '快捷模式-获取页面元素包含的所有图片',
            id: 100, //相册id，可选
            parent:'#imgs'
        });
    };
});
}();
</script>
</body>
</html>
