<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>个人商品</title>
</head>
<body>
	<jsp:include page="/backer/login_header.jsp"></jsp:include>
	<div class="grzxbj">
		<div class="selfinfo center">
			<div class="lfnav fl">
				<div class="ddzx">订单中心</div>
				<div class="subddzx">
					<ul>
						<li><a href="" style="color: #ff6700; font-weight: bold;">我的订单</a></li>
						<li><a href="">意外保</a></li>
						<li><a href="">团购订单</a></li>
						<li><a href="">评价晒单</a></li>
					</ul>
				</div>
				<div class="ddzx">个人中心</div>
				<div class="subddzx">
					<ul>
						<li><a href="./self_info.html">我的个人中心</a></li>
						<li><a href="">消息通知</a></li>
						<li><a href="">优惠券</a></li>
						<li><a href="">收货地址</a></li>
					</ul>
				</div>
			</div>
			<div class="rtcont fr">
				<div class="ddzxbt">交易订单</div>
				<div class="ddxq">
					<div class="ddspt fl">
						<img src="./image/gwc_xiaomi6.jpg" alt="">
					</div>
					<div class="ddbh fl">订单号:1705205643098724</div>
					<div class="ztxx fr">
						<ul>
							<li>已发货</li>
							<li>￥2499.00</li>
							<li>2017/05/20 13:30</li>
							<li><a href="">订单详情></a></li>
							<div class="clear"></div>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<div class="ddxq">
					<div class="ddspt fl">
						<img src="./image/liebiao_hongmin4_dd.jpg" alt="">
					</div>
					<div class="ddbh fl">订单号:170526435444865</div>
					<div class="ztxx fr">
						<ul>
							<li>已发货</li>
							<li>￥1999.00</li>
							<li>2017/05/26 14:02</li>
							<li><a href="">订单详情></a></li>
							<div class="clear"></div>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	
	<jsp:include page="/backer/footer.jsp"></jsp:include>
</body>
</html>