<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>小米手机列表</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.loginUser !=null}">
			<jsp:include page="/backer/login_header.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="backer/register_header.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>
	<!-- start banner_x -->
	<!-- end banner_x -->

	<!-- start banner_y -->
	<!-- end banner -->

	<!-- start danpin -->
	<div class="danpin center">

		<div class="biaoti center">小米手机</div>
		<div class="main center">
			<div class="mingxing fl mb20"
				style="border: 2px solid #fff; width: 230px; cursor: pointer;"
				onmouseout="this.style.border='2px solid #fff'"
				onmousemove="this.style.border='2px solid red'">
				<div class="sub_mingxing">
					<a href="./xiangqing.html" target="_blank"><img
						src="./image/liebiao_xiaomi6.jpg" alt=""></a>
				</div>
				<div class="pinpai">
					<a href="./xiangqing.html" target="_blank">小米6</a>
				</div>
				<div class="youhui">5.16早10点开售</div>
				<div class="jiage">2499.00元</div>
			</div>
			<div class="mingxing fl mb20"
				style="border: 2px solid #fff; width: 230px; cursor: pointer;"
				onmouseout="this.style.border='2px solid #fff'"
				onmousemove="this.style.border='2px solid red'">
				<div class="sub_mingxing">
					<a href=""><img src="./image/liebiao_xiaomi5c.jpg" alt=""></a>
				</div>
				<div class="pinpai">
					<a href="">小米手机5c</a>
				</div>
				<div class="youhui">搭载澎湃S1 八核高性能处理器</div>
				<div class="jiage">1499.00元</div>
			</div>
			<div class="mingxing fl mb20"
				style="border: 2px solid #fff; width: 230px; cursor: pointer;"
				onmouseout="this.style.border='2px solid #fff'"
				onmousemove="this.style.border='2px solid red'">
				<div class="sub_mingxing">
					<a href=""><img src="./image/liebiao_xiaomint2.jpg" alt=""></a>
				</div>
				<div class="pinpai">
					<a href="">小米Note 2</a>
				</div>
				<div class="youhui">5月9日-20日 小米Note 2 享花呗12期分期免息</div>
				<div class="jiage">2799.00元</div>
			</div>
			<div class="mingxing fl mb20"
				style="border: 2px solid #fff; width: 230px; cursor: pointer;"
				onmouseout="this.style.border='2px solid #fff'"
				onmousemove="this.style.border='2px solid red'">
				<div class="sub_mingxing">
					<a href=""><img src="./image/liebiao_xiaomimix.jpg" alt=""></a>
				</div>
				<div class="pinpai">
					<a href="">小米MIX</a>
				</div>
				<div class="youhui">5月9日-20日小米MIX 享花呗12期分期免息</div>
				<div class="jiage">3499.00元</div>
			</div>
			<div class="mingxing fl mb20"
				style="border: 2px solid #fff; width: 230px; cursor: pointer;"
				onmouseout="this.style.border='2px solid #fff'"
				onmousemove="this.style.border='2px solid red'">
				<div class="sub_mingxing">
					<a href=""><img src="./image/liebiao_xiaomi5s.jpg" alt=""></a>
				</div>
				<div class="pinpai">
					<a href="">小米5s</a>
				</div>
				<div class="youhui">“暗夜之眼”超感光相机 / 无孔式超声波</div>
				<div class="jiage">1999.00元</div>
			</div>

			<div class="clear"></div>
		</div>
		<div class="main center mb20">
			<div class="mingxing fl mb20"
				style="border: 2px solid #fff; width: 230px; cursor: pointer;"
				onmouseout="this.style.border='2px solid #fff'"
				onmousemove="this.style.border='2px solid red'">
				<div class="sub_mingxing">
					<a href=""><img src="./image/liebiao_xiaomi5.jpg" alt=""></a>
				</div>
				<div class="pinpai">
					<a href="">小米手机5</a>
				</div>
				<div class="youhui">骁龙820处理器 / UFS 2.0 闪存</div>
				<div class="jiage">1799.00元</div>
			</div>
			<div class="mingxing fl mb20"
				style="border: 2px solid #fff; width: 230px; cursor: pointer;"
				onmouseout="this.style.border='2px solid #fff'"
				onmousemove="this.style.border='2px solid red'">
				<div class="sub_mingxing">
					<a href=""><img src="./image/liebiao_hongmin4.jpg" alt=""></a>
				</div>
				<div class="pinpai">
					<a href="">红米Note 4</a>
				</div>
				<div class="youhui">十核旗舰处理器 / 全金属一体化机身</div>
				<div class="jiage">1399.00元</div>
			</div>
			<div class="mingxing fl mb20"
				style="border: 2px solid #fff; width: 230px; cursor: pointer;"
				onmouseout="this.style.border='2px solid #fff'"
				onmousemove="this.style.border='2px solid red'">
				<div class="sub_mingxing">
					<a href=""><img src="./image/pinpai3.png" alt=""></a>
				</div>
				<div class="pinpai">
					<a href="">小米手机5 64GB</a>
				</div>
				<div class="youhui">5月9日-10日，下单立减100元</div>
				<div class="jiage">1799元</div>
			</div>
			<div class="mingxing fl mb20"
				style="border: 2px solid #fff; width: 230px; cursor: pointer;"
				onmouseout="this.style.border='2px solid #fff'"
				onmousemove="this.style.border='2px solid red'">
				<div class="sub_mingxing">
					<a href=""><img src="./image/liebiao_hongmin42.jpg" alt=""></a>
				</div>
				<div class="pinpai">
					<a href="">红米4</a>
				</div>
				<div class="youhui">2.5D 玻璃，金属一体化机身</div>
				<div class="jiage">999.00元</div>
			</div>
			<div class="mingxing fl mb20"
				style="border: 2px solid #fff; width: 230px; cursor: pointer;"
				onmouseout="this.style.border='2px solid #fff'"
				onmousemove="this.style.border='2px solid red'">
				<div class="sub_mingxing">
					<a href=""><img src="./image/liebiao_hongmin4x.jpg" alt=""></a>
				</div>
				<div class="pinpai">
					<a href="">红米Note 4X 全网通版</a>
				</div>
				<div class="youhui">多彩金属 / 4100mAh 超长续航</div>
				<div class="jiage">1299.00元</div>
			</div>

			<div class="clear"></div>
		</div>
	</div>


	<footer class="mt20 center">
		<div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select
			Region</div>
		<div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号
			京网文[2014]0059-0009号</div>
		<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>

	</footer>

	<!-- end danpin -->


</body>
</html>