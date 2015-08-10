<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<aside>
	<h2>博客分类</h2>
	<ul>
		<c:forEach var="item" items="${articleRightMenuList}">
			<li><a href="${item.url}" title="${item.name}">${item.name}</a></li>
		</c:forEach>
		<!-- <li><a href="/">慢生活(3)</a></li>
		<li><a href="/">程序人生(25)</a></li>
		<li><a href="/">经典美文(39)</a></li> -->
	</ul>
	<h2>近期文章</h2>
	<ul>
		<c:forEach var="item" items="${articleTitleList}" begin="0" end="9">
			<li><a href="${item.url}" title="${item.name}">${item.name}</a></li>
		</c:forEach>
		<!-- <li><a href="/">女孩都有浪漫的小情怀</a></li>
		<li><a href="/">也许下个路口就会遇见希望</a></li>
		<li><a href="/">6月毕业季，祝福送给你</a></li>
		<li><a href="/">生活常有缺席的-可搞笑从来不缺席</a></li>
		<li><a href="/">为了一个不存在的梦，执念了那么多年</a></li>
		<li><a href="/">妹妹，明天你就要嫁人啦</a></li> -->
	</ul>
	<h2>娱乐分享</h2>
	<ul>
		<c:forEach var="item" items="${mediaRightMenuList}">
			<li><a href="${item.url}" title="${item.name}">${item.name}</a></li>
		</c:forEach>
		<!-- <li><a href="/">2008 年三月</a></li>
		<li><a href="/">2008 年四月</a></li>
		<li><a href="/">2008 年六月</a></li> -->
	</ul>
	<!-- <h2>友情链接</h2>
	<ul>
		<li><a href="">个人博客</a></li>
		<li><a href="/">百度</a></li>
		<li><a href="/">Google</a></li>
	</ul> -->
	<!-- Baidu Button BEGIN -->
<div id="bdshare" class="bdshare_t bds_tools_32 get-codes-bdshare share">
<a class="bds_tsina"></a>
<a class="bds_qzone"></a>
<a class="bds_tqq"></a>
<a class="bds_renren"></a>
<span class="bds_more"></span>
</div>
<script type="text/javascript" id="bdshare_js" data="type=tools&amp;uid=6574585" ></script>
<script type="text/javascript" id="bdshell_js"></script>
<script type="text/javascript">
document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000)
</script>
<!-- Baidu Button END -->
		</aside> 