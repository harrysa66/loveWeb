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
		<pg:pager   
url="/PageAction.do"   
index="half-full"  
maxPageItems = "1"   
    maxIndexPages="5"   
isOffset = "<%=false%>"   
    export = "pageOffset,currentPageNumber=pageNumber"   
    scope = "request">  
      
 <table>    
    <c:forEach items="${articleList}" var="article">  
    <pg:item>  
     <tr>  
      <td height="39">${article.title}</td>  
     </tr>       
    </pg:item>  
</c:forEach>  
</table>    
  <pg:index>  
    <center>  
    <table border=0 cellpadding=0 width=10% cellspacing=0>  
    <tr align=center valign=top>  
    <td valign=bottom><font face=arial,sans-serif  
      size=-1>Result Page: </font></td>  
    <pg:prev ifnull="true">  
      <% if (pageUrl != null) { %>  
        <td align=right><A HREF="<%= pageUrl %>"><IMG  
          SRC=http://www.google.com/nav_previous.gif alt="" border=0><br>  
        <b>Previous</b></A></td>  
      <% } else { %>  
        <td><IMG SRC=http://www.google.com/nav_first.gif alt="" border=0></td>  
      <% } %>  
    </pg:prev>  
    <pg:pages>  
      <% if (pageNumber == currentPageNumber) { %>  
        <td><IMG SRC=http://www.google.com/nav_current.gif alt=""><br>  
        <font color=#A90A08><%=pageNumber%></font></td>  
      <% } else { %>  
        <td><A HREF="<%=pageUrl%>"><IMG  
          SRC=http://www.google.com/nav_page.gif alt="" border=0><br>  
        <%= pageNumber %></A></td>  
      <% } %>  
    </pg:pages>  
    <pg:next ifnull="true">  
      <% if (pageUrl != null) { %>  
        <td><A HREF="<%=pageUrl%>"><IMG  
          SRC=http://www.google.com/nav_next.gif alt="" border=0><br>  
        <b>Next</b></A></td>  
      <% } else { %>  
        <td><IMG SRC=http://www.google.com/nav_last.gif alt="" border=0></td>  
      <% } %>  
    </pg:next>  
    </tr>  
    </table>  
    </center>  
  </pg:index>  
  </pg:pager>
	</div>
	<%@include file="/view/right.jsp"%>
		</article>
		<%@include file="/view/footer.jsp"%>
</body>
</html>
