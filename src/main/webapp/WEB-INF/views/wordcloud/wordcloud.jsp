<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/header.jsp" flush="true"/>
  <!-- text banner section -->
 <div id="contentArea">
	<!-- portfolio section -->
	<section id="works" class="works section self-padding">
	<div class="row" style="margin-right: -15px;margin:0 auto;">
		<h4 class="margin-bottom-15">自定义查询词频 -- 中文词云及词频</h4>
		<form id="WordCloudByUser">
			<textarea autocomplete="off" style="width: 100%;height: 100px;margin: 0px;color:#000" name="WordCloudContent" id="WordCloudContent" type="text" placeholder="输入要查询的内容"></textarea>
			<div style="margin:0 auto;width:20%;font-size:16px;">
				<button type="button" class="btn-download" class="button blue center" href="#result" onclick="doWordCloudTemp(WordCloudContent)">点击查询</button>
			</div>
		</form>
	</div>
	</section>
	<!-- portfolio section --> 
</div>
<jsp:include page="/footer.jsp" flush="true"/>
