<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/header.jsp" flush="true" />
<!-- text banner section -->
<div id="contentArea">
	<section id="banner" class="banner no-padding">
		<div class="container-fluid">
			<div class="row no-gutter">
				<div class="flexslider">
					<ul class="slides">
						<li>
							<div class="col-md-12">
								<blockquote>
									<h1>你好,我是 iFlin。</h1>
									<p>欢迎来到这里！</p>
								</blockquote>
							</div>
						</li>
						<li>
							<div class="col-md-12">
								<blockquote>
									<h1>Hello! I'm iFlin.</h1>
									<p>Welcome Here!</p>
								</blockquote>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	<!-- Text banner section -->
	<!-- portfolio section -->
	<section id="works" class="works section self-padding">
		<div class="container-fluid">
			<div class="row no-gutter">
				<div class="col-lg-3 col-md-6 col-sm-6 work">
					<a href="https://www.iflin.cn" class="work-box"> <img
						src="images/guide.png" alt="" target="_blank">
						<div class="overlay"></div> <!-- overlay -->
					</a>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-6 work">
					<a href="https://ktbl.iflin.cn/spider" class="work-box"> <img
						src="images/spidercontroller.png" alt="" target="_blank">
						<div class="overlay"></div> <!-- overlay -->
					</a>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-6 work">
					<a href="https://ktbl.iflin.cn/rs2" class="work-box"> <img
						src="images/ktbl.png" alt="" target="_blank">
						<div class="overlay"></div> <!-- overlay -->
					</a>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-6 work">
					<a href="english" class="work-box"> <img
						src="images/english.png" alt="">
						<div class="overlay"></div> <!-- overlay -->
					</a>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-6 work">
					<a href="wordcloud" class="work-box"> <img
						src="images/chinesecloud.png" alt="">
						<div class="overlay"></div> <!-- overlay -->
					</a>
				</div>
			</div>
		</div>
	</section>
	<!-- portfolio section -->
</div>
<jsp:include page="/footer.jsp" flush="true" />