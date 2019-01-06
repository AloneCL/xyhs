<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="order by dede58.com" />
<title>个人中心</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<!-- start header -->

	<jsp:include page="/backer/login_header.jsp"></jsp:include>
	<!--end header -->
	<!-- end banner_x -->
	<!-- self_info -->
	<div class="grzxbj">
		<div class="selfinfo center">
			<div class="lfnav fl">
				<div class="ddzx">订单中心</div>
				<div class="subddzx">
					<ul>
						<li><a href="./dingdanzhongxin.html">我的订单</a></li>
						<li><a href="">意外保</a></li>
						<li><a href="">团购订单</a></li>
						<li><a href="">评价晒单</a></li>
					</ul>
				</div>
				<div class="ddzx">个人中心</div>
				<div class="subddzx">
					<ul>
						<li><a href="${pageContext.request.contextPath}/userInfo.action"
							style="color: #ff6700; font-weight: bold;">我的个人中心</a></li>
						<li><a href="">消息通知</a></li>
						<li><a href="${pageContext.request.contextPath}/updatePassWord.action">修改密码</a></li>
						<li><a href="">收货地址</a></li>
					</ul>
				</div>
			</div>
			<div class="rtcont fr">
				<div class="grzlbt ml40">我的资料</div>
				<div class="subgrzl ml40">
					<span>昵称</span><span>${user_message.userName }</span>
				</div>
				<div class="subgrzl ml40">
					<span>账号</span><span>${user_message.userAccount }</span>
				</div>
				<div class="subgrzl ml40">
					<span>手机号</span><span>${user_message.userTel }</span>
				</div>
				<div class="subgrzl ml40">
					<span>个性签名</span><span>一支穿云箭，千军万马来相见！</span>
				</div>
				<div class="subgrzl ml40">
					<span>我的爱好</span><span>游戏，音乐，旅游，健身</span><span>
				</div>
				<div class="subgrzl ml40">
					<span>收货地址</span><span>${user_message.userPostAddress }</span>
				</div>

			</div>
			<div class="clear"></div>
		</div>
	</div>
	<!-- self_info -->
	<jsp:include page="/backer/footer.jsp"></jsp:include>
</body>

</html>