<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!doctype html>
<html>
<head>
<title>LOVE博客</title>
<%@include file="/view/resource.jsp"%>
<style type="text/css">
.ui_btn {
    background: #398bfc none repeat scroll 0 0;
    border-bottom-color: #3782f0;
    color: #fff;
    cursor: pointer;
    border-radius: 2px;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    height: 28px;
    line-height: 28px;
    overflow: hidden;
    padding: 0 15px;
    text-align: center;
}
</style>
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
      <th class="boardItem"><span>网友：${item.ip}<br>（来自：${item.ipAddress}）</span></th>  
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
 <table style="width: 100%;margin-bottom: 10px;">  
 	<tr><td>
 		<div style="width:100%;">
 			<script id="myEditor" type="text/plain" style="width:710px;height:400px;"></script>
 			<script type="text/javascript">
 				var um = UM.getEditor('myEditor',{
 					toolbar:[
 				            'source | undo redo | bold italic underline strikethrough | superscript subscript | forecolor backcolor | removeformat |',
 				            'insertorderedlist insertunorderedlist | selectall cleardoc paragraph | fontfamily fontsize' ,
 				            '| justifyleft justifycenter justifyright justifyjustify |',
 				            'link unlink | emotion ',
 				            '| horizontal print preview fullscreen', 'drafts', 'formula'
 				        ]
 				});
			</script>
 		</div>
 	</td></tr>
 </table>
 <table style="width: 100%;margin-bottom: 20px;">  
 	<tr><td>
 	<a title="留言" class="ui_btn" href="javascript:writeBoard()"><span><em>留 言</em></span></a>
 	<form id="boardForm">
 		<input id="content" name="content" type="hidden">
 	</form>
 	</td></tr>
 </table>
  <%@include file="/view/pagination.jsp"%>
  </pg:pager>
	</div>
	<%@include file="/view/right.jsp"%>
		</article>
		<%@include file="/view/footer.jsp"%>
<script type="text/javascript">
function writeBoard(){
	$("#content").val(UM.getEditor('myEditor').getContent());
	$.ajax({
        type: "POST",
        url:"writeBoard.s",
        data:$('#boardForm').serialize(),
		success: function(data) {
			if(data.success){
				UM.getEditor('myEditor').setContent("");
				showTip(data.msg,3,'succ');
			}else{
				showTip(data.msg,3,'error');
			}
        },
        error: function(request) {
        	showTip('留言失败',3,'error');
        }
        
    });
}
</script>
</body>
</html>
