<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="order by dede58.com" />
<title>个人中心</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
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
						<li><a href="${pageContext.request.contextPath}/searchUserGoods.action?id=${cookie.userId.value }">我的订单</a></li>
						<li><a href="">意外保</a></li>
						<li><a href="">团购订单</a></li>
						<li><a href="">评价晒单</a></li>
					</ul>
				</div>
				<div class="ddzx">个人中心</div>
				<div class="subddzx">
					<ul>
						<li><a
							href="${pageContext.request.contextPath}/userInfo.action">我的个人中心</a></li>
						<li><a href="${pageContext.request.contextPath}/searchUserGoods.action?id=${cookie.userId.value}">我的商品</a></li>
						<li><a
							href="${pageContext.request.contextPath}/updatePassWord.action"
							style="color: #ff6700; font-weight: bold;">修改密码</a></li>
						<li><a href="">收货地址</a></li>
					</ul>
				</div>
			</div>

			<div class="rtcont fr">
				<form
					action="${pageContext.request.contextPath}/submitModifyPass.action"
					id="passForm" method="post">
					<div class="grzlbt ml40">修改密码</div>
					<div class="subgrzl ml40" style="margin-top: 30px;">
						<span id="title">请输入原始密码：</span><input type="password" name="userPass" id="userPass"
							style="font-size: 20px; height: 20px" />
					</div>
					<div class="subgrzl ml40" style="margin-top: 30px;">
						<span id="title">请输入新密码：</span><input type="password" name="userPass1" id="userPass1"
							style="font-size: 20px; height: 20px" />
					</div>
					<div class="subgrzl ml40" style="margin-top: 30px;">
						<span id="title">请确认密码：</span><input type="password" name="userPass2" id="userPass2"
							style="font-size: 20px; height: 20px" />
					</div>
					<div align="center">
						<input type=button value="确认修改" onclick="submitForm()"
							style="margin-top: 40px; background-color: #008CBA; /* Green */ border: none; color: white; padding: 12px 22px; text-align: center; text-decoration: none; display: inline-block; font-size: 15px;" />
					</div>
				</form>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<!-- self_info -->
	<jsp:include page="/backer/footer.jsp"></jsp:include>
</body>

<script type="text/javascript">
	function submitForm() {
 		//var form = new FormData(document.getElementById("passForm"));
		$.ajax({
			url : "${pageContext.request.contextPath}/submitModifyPass.action",
			type : "post",
			dataType : "text",
			data : $('#passForm').serialize(),
			 //processData:false,
             //contentType:"text/html; charset=UTF-8",
			success : function(data) {
				alert(data);
				$('userPass').val('');
				$('userPass1').val('');
				$('userPass2').val('');
			}
		})
	}
</script>
</html>