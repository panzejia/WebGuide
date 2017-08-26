<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<ol class="breadcrumb">
		<li><a href="index.jsp">主页</a></li>
		<li><a href="english">英文词频</a></li>
		<li class="active">词频排序</li>
	</ol>
	<div class="row">
		<div class="col-md-12">
			<div class="table-responsive">
				<h4 class="margin-bottom-15">该文章总共有 ${total}个关键词</h4>
				<table class="table table-striped table-hover table-bordered">
					<thead>
						<tr>
							<th>关键词</th>
							<th>出现次数</th>
						</tr>
					</thead>
					<tbody>
						<!-- 循環開始 -->
						<c:forEach items="${wordList}" var="word">
							<tr>
								<td>${word.getWord()}</td>
								<td>${word.getWordFrequency()}</td>
							</tr>
						</c:forEach>
						<!-- 循環結束 -->
					</tbody>
				</table>
			</div>
		</div>
	</div>