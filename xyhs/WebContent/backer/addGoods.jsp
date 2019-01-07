<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>商品上传</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
<style type="text/css">
body {
	font-family: Tahoma, Verdana, Arial, Helvetica, sans-serif;
	font-size: 15px;
}

p, h1, form, button {
	border: 0;
	margin: 0;
	padding: 0;
}

.spacer {
	clear: both;
	height: 1px;
}
/* ———– My Form ———– */
.myform {
	margin: 0 auto;
	width: 400px;
	padding: 14px;
}
/* ———– stylized ———– */
#stylized {
	border: solid 2px #b7ddf2;
	background: #ebf4fb;
}

#stylized h1 {
	font-size: 16px;
	font-weight: bold;
	margin-bottom: 8px;
}

#stylized p {
	font-size: 12px;
	color: #666666;
	margin-bottom: 20px;
	border-bottom: solid 1px #b7ddf2;
	padding-bottom: 10px;
}

#stylized label {
	display: block;
	font-weight: bold;
	text-align: right;
	width: 140px;
	float: left;
}

#stylized .small {
	color: #666666;
	display: block;
	font-size: 11px;
	font-weight: normal;
	text-align: right;
	width: 140px;
}

#stylized input {
	float: left;
	font-size: 15px;
	padding: 4px 2px;
	border: solid 1px #aacfe4;
	width: 200px;
	margin: 2px 0 20px 10px;
}

#stylized .sub {
	clear: both;
	margin-left: 150px;
	width: 120px;
	height: 32px;
	line-height: 20px;
	border: 1px solid #8b9c56;
	background: url("../images/bt_bg.gif") 0px -64px;
	text-align: center;
	color: #336600;
	font-size: 15px;
	font-weight: bold;
	cursor: pointer;
}

.red {
	color: #ff0000;
}

.blue {
	color: #0000FF;
}

.tableImg {
	display: none;
	position: absolute;
}
</style>
</head>
<body>
	<div id="stylized" class="myform">
		<form id="form" name="form" method="post" action="${pageContext.request.contextPath}/addGoods.action">
			<h1>上传商品</h1>
			<p>
				<span class="red">请按照规范填写商品信息 </span> <span class="blue"> </span>
			</p>
			<label>商品名称 <span class="small"></span>
			</label> <input type="text" name="goodsName" id="name" value="" /> 
			<label>商品类型
				<span class="small"></span>
			</label> 
			<input type="text" name="goodsType" id="num" value="" /> 
			<label>商品价格
				<span class="small"></span>
			</label> 
			<input type="text" name="price" id="num" value="" /> 
			<label>商品介绍
				<span class="small"></span>
			</label> 
			<input type="text" name="introduce" id="num" value="" /> 
			<input type="text" name="userId" value="${cookie.userId.value}" hidden/>
			<label>商品图片
				<span class="small"></span>
			</label> 
			<input type="button" value="封面图" class="tableButton"
				id="uploadButton1"> <img src="" alt="" name="flag1"
				class="tableImg" width="200" height="130"> <input type="text" name="goodsImg" id="imgurl1" value="" hidden>
			<input class="sub" type="submit" value="提交" />
						<div class="spacer">
			</div>
		</form>
	</div>
	<script type="text/javascript">
	$('.tableButton').mouseover(function() {
		$(this).next().show(100);
	}).mouseout(function() {
		$(this).next().hide(100);
	});
	
	</script>
</body>
</html>