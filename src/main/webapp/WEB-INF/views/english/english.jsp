<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/header.jsp" flush="true"/>
  <!-- text banner section -->
 <div id="contentArea">
	<!-- portfolio section -->
	<section id="works" class="works section self-padding">
	<div class="row" style="margin-right: -15px;margin:0 auto;">
		<h4 class="margin-bottom-15">查询一篇英文文章或真题中含有多少核心词汇</h4>
		<form id="WordCloudByUser">
			<textarea autocomplete="off" style="width: 100%;height: 100px;margin: 0px;color:#000" name="WordCloudContent" id="WordCloudContent" type="text" placeholder="输入要查询的内容"></textarea>
			<div style="margin:0 auto;padding: 5px;font-size:16px;float:right">
				<button type="button" class="button blue center" href="#result" onclick="doEnglishWords(WordCloudContent,'kaoyan')">查询考研核心词汇</button>
			</div>
			<div style="margin:0 auto;padding: 5px;font-size:16px;float:right">
				<button type="button" class="button blue center" href="#result" onclick="doEnglishWords(WordCloudContent,'cet4')">查询四级核心词汇</button>
			</div>
			<div style="margin:0 auto;padding: 5px;font-size:16px;float:right">
				<button type="button" class="button blue center" href="#result" onclick="doEnglishWords(WordCloudContent,'noLevel')">查询无过滤条件词汇</button>
			</div>
			<div style="text-align:center;margin-top: 150px;">
				<p>考研核心词汇系统收录  950  个核心词汇 <a href="english/kaoyan" target="_blank">  点击查看</a></p>
				<p>四级核心词汇系统收录 1111 个核心词汇<a href="english/cet4" target="_blank">  点击查看</a></p>
			</div>
		</form>
	</div>
	</section>
	<!-- portfolio section --> 
</div>
<jsp:include page="/footer.jsp" flush="true"/>
