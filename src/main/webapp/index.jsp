﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="baidu-site-verification" content="E0gMgKgxPb" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>iFlin导航</title>
    <link rel="stylesheet" type="text/css" href="https://ktbl.iflin.cn/css/style.css"/>
	<script src="https://ktbl.iflin.cn/spider/js/admin/jquery.min.js"></script>
    <link href="/favicon.ico" rel="icon" type="image/x-icon" />
<script src="http://s1.bdstatic.com/r/www/cache/global/js/BaiduHttps_20150714_zhanzhang.js"></script>
<script>
//获取每日一句
	$.getJSON("https://open.iciba.com/dsapi?callback=?",
		function(json) {
			document.getElementById("dailyEnglish").innerHTML = "<p>"+json.content+"</p><p>"+json.note+"</p><p>"+json.translation+"</p>";
		});　
　

    function checkHttps () {
        BaiduHttps.useHttps();    
    };
    function baiduWithHttps (formname) {
        var data = BaiduHttps.useHttps();
        if (data.s === 0) {
            return true;
        }
        else {
            formname.action = 'https://www.baidu.com/baidu' + '?ssl_s=1&ssl_c' + data.ssl_code;
            return true;
        }
    };
	 
</script>
</head>
<body>
	<div class="menu">
		 <nav>
		  <ul>
			<li>
			  <a href="index.html">主页</a>
			</li>
			<li>
			  <a href="https://ktbl.iflin.cn/rs2" target="_blank">课题部落</a>
			</li>
			<li>
			  <a href="https://ktbl.iflin.cn/spider" target="_blank">爬虫控制端</a>
			</li>
			<li>
			  <a href="#">博客</a>
			</li>
		  </ul>
		</nav>
	</div>
	<div class="container">
		<div class="pic">
			<a href="index.html">
			<img src="image/logo.png" width="270" height="129"></a>
		</div>
		<div class="search">
		<form onsubmit="return baiduWithHttps(this)" action="http://www.baidu.com/baidu">
			<input name="tn" type="hidden" value="SE_zzsearchcode_shhzc78w">
			<input name="ie" type="hidden" value="utf-8">
			<input class="searchinput" type="text"  onfocus="checkHttps" name="word"  size="30">
			<input class="button blue center"  type="submit"value="百度搜索">
		</form>
		 </div>
	</div>
	<div class="navigation">
		<div class="navigationarea"><a class="href" href="http://www.cbnweek.com/" target="_blank">第一财经</a></div>
		<div class="navigationarea"><a class="href" href="http://mole.61.com/" target="_blank">摩尔庄园</a></div>
		<div class="navigationarea"><a class="href" href="https://www.taobao.com/" target="_blank">淘宝天猫</a></div>
		<div class="navigationarea"><a class="href" href="http://www.zgtuku.com/" target="_blank">中国图库</a></div>
		<div class="navigationarea"><a class="href" href="http://blog.csdn.net/" target="_blank">CSDN博客</a></div>
		<div class="navigationarea"><a class="href" href="http://github.com/panzejia" target="_blank">Github</a></div>
		<div class="navigationarea"><a class="href" href="http://www.iqshw.com/" target="_blank">爱Q生活</a></div>
		<div class="navigationarea"><a class="href" href="http://weibo.com" target="_blank">新浪微博</a></div>
		<div class="navigationarea"><a class="href" href="http://som.bnuz.edu.cn" target="_blank">管理学院</a></div>
		<div class="navigationarea"><a class="href" href="http://www.bnuz.edu.cn" target="_blank">北师大珠</a></div>
		<div class="navigationarea"><a class="href" href="http://www.win7china.com/" target="_blank">Win7之家</a></div>
		<div class="navigationarea"><a class="href" href="" target="_blank">信杰团队</a></div>
	</div>
	<div class="dailyEnglish" id="dailyEnglish"></div>
	<div class="footer">
		<a>©2017 iflin.cn 沉记本</a>
	</div>
</body>
<script charset="gbk" src="http://www.baidu.com/js/opensug.js"></script>
</html>

