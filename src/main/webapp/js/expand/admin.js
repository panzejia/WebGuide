/** 自定义内容从此开始 */
var XMLHttpReq = false;
// 创建XMLHttpRequest对象
function createXMLHttpRequest() {
	if (window.XMLHttpRequest) { // Mozilla 浏览器
		XMLHttpReq = new XMLHttpRequest();
	} else if (window.ActiveXObject) { // IE浏览器
		try {
			XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}
}
// 发送请求函数
function sendRequest(url) {
	createXMLHttpRequest();
	XMLHttpReq.open("GET", url, true);
	XMLHttpReq.onreadystatechange = processResponse;// 指定响应函数
	XMLHttpReq.send(null); // 发送请求
}
// 处理返回信息函数
function processResponse() {
	if (XMLHttpReq.readyState == 4) { // 判断对象状态
		if (XMLHttpReq.status == 200) { // 信息已经成功返回，开始处理信息
			var result = XMLHttpReq.responseText;
			document.getElementById("content").innerHTML = result;
		} else { // 页面不正常
			window.alert("您所请求的页面有异常。");
		}
	}
}

//输入英文文章计算词频
function doEnglishWords(content,englishClass){
	$.ajax({
		type : "POST",
		dataType : "html",
		url : "english/doResult",
		data : {
			"content":$(content).val(),
			"englishClass" : englishClass,
		},
		success : function(data) {
			var strresult = data;
			document.getElementById("works").innerHTML = strresult;
		},
		error : function(data) {
			alert("保存失败");
		}
	});
}

// 获取词云
function doWordCloudByArticle(articleId) {
	var url = "getWordFre?articleId=" + articleId;
	sendRequest(url);
}
// 自定义文章词云$('#WordCloudByUser').serialize(),
function doWordCloudTemp(content) {
	$.ajax({
		type : "POST",
		dataType : "html",
		url : "wordcloud/doResult",
		data : {
			"content":$(content).val(),
		},
		success : function(data) {
			var strresult = data;
			document.getElementById("works").innerHTML = strresult;
		},
		error : function(data) {
			alert("保存失败");
		}
	});
}