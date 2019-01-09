<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<title>商品详情</title>
</head>
<c:choose>
	<c:when test="${sessionScope.loginUser !=null}">
		<jsp:include page="login_header.jsp" />
	</c:when>
	<c:otherwise>
		<jsp:include page="register_header.jsp" />
	</c:otherwise>
</c:choose>
<body>
	<form action="post" method="">
		<div class="xiangqing">
			<div class="neirong w">
				<div class="xiaomi6 fl">${goods.goodsName }</div>
				<nav class="fr">
					<li><a href="">概述</a></li>
					<li>|</li>
					<li><a href="">变焦双摄</a></li>
					<li>|</li>
					<li><a href="">设计</a></li>
					<li>|</li>
					<li><a href="">参数</a></li>
					<li>|</li>
					<li><a href="">F码通道</a></li>
					<li>|</li>
					<li><a href="">用户评价</a></li>
					<div class="clear"></div>
				</nav>
				<div class="clear"></div>
			</div>
		</div>

		<div class="jieshao mt20 w">
			<div class="left fl">
				<img style="padding-left:40px; width: 450px;height: 550px;"src="${goods.goodsImg }">
			</div>
			<div class="right fr">
				<div class="h3 ml20 mt20">${goods.goodsName }</div>
				<div class="jianjie mr40 ml20 mt10">${goods.introduce }</div>
				<div class="jiage ml20 mt10">${goods.price }元</div>
		<!-- 		<div class="ft20 ml20 mt20">选择版本</div>
				<div class="xzbb ml20 mt10">
					<div class="banben fl">
						<a> <span>全网通版 6GB+64GB </span> <span>2499元</span>
						</a>
					</div>
					<div class="banben fr">
						<a> <span>全网通版 6GB+128GB</span> <span>2899元</span>
						</a>
					</div>
					<div class="clear"></div>
				</div>
				<div class="ft20 ml20 mt20">选择颜色</div>
				<div class="xzbb ml20 mt10">
					<div class="banben">
						<a> <span class="yuandian"></span> <span class="yanse">亮黑色</span>
						</a>
					</div>

				</div> -->
				<div class="xqxq mt20 ml20">
					<div class="top1 mt10">
						<div class="left1 fl"></div>
						<div class="right1 fr">${goods.price }元</div>
						<div style="font-size: 15px; color: #000;">${goods.goodsName }/${goods.introduce }</div>
						<div style="font-size: 15px; color: #000; margin-top: 20px;">库存：x 23 件</div>
					</div>
					<div class="bot mt20 ft20 ftbc" style="margin-top: 40px;">总计：${goods.price }元</div>
				</div>
				<div class="xiadan ml20 mt20" style="margin-top: 50px;">
					<input class="jrgwc" type="button" name="jrgwc" value="立即选购" onclick=""/> <input
						class="jrgwc" type="button" name="jrgwc" value="加入购物车" onclick="addShoppingCar()"/>

				</div>
			</div>
			<div class="clear"></div>
		</div>
	</form>
	<jsp:include page="/backer/footer.jsp" />
	<script type="text/javascript" src="lib/layer/3.1.1/layer.js"></script>
	<script type="text/javascript">
	function addShoppingCar(){
		let userId = ${cookie.userId.value};
		let goodsId = ${goods.goodsId};
		$.ajax({
			url:"${pageContext.request.contextPath}/addGoodsForCar.action",
			data:{
				userId: userId,
				goodsId : goodsId
			},
			success:function(data){
				if(data == "success"){
					  layer.msg('成功添加',{icon:1,time:1000});
				}else if(data == "fail"){
					  layer.msg('出错了',{icon:5});
				}
					
			},
			error:function(){
				layer.msg('程序出错了',{icon:2});
			}
		})
	}
	</script>
</body>
</html>