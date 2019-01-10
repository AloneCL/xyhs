<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品分类</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>

	<jsp:include page="/backer/login_header.jsp"></jsp:include>

	<div class="danpin center">

		<div class="biaoti center">小电器</div>
		<div class="main center">
			<c:forEach items="${elList}" var="eletric">
				<div class="mingxing fl mb20"
					style="border: 2px solid #fff; width: 230px; cursor: pointer;"
					onmouseout="this.style.border='2px solid #fff'"
					onmousemove="this.style.border='2px solid red'">
					<div class="sub_mingxing">
						<a href="${pageContext.request.contextPath}/goodsData.action?goodsdId=${eletric.goodsId}" target="_blank"><img
							style="height: 100; width: 100;" src="${eletric.goodsImg }"
							alt=""></a>
					</div>
					<div class="pinpai">
						<a href="${pageContext.request.contextPath}/goodsData.action?goodsdId=${eletric.goodsId}" target="_blank">${eletric.goodsName }</a>
					</div>
					<div class="youhui">${eletric.introduce }</div>
					<div class="jiage">${eletric.price}/元</div>
				</div>
			</c:forEach>
		</div>


		<div class="biaoti center">书籍</div>
		<div class="main center mb20">
			<c:forEach items="${bookList}" var="book">
				<div class="mingxing fl mb20"
					style="border: 2px solid #fff; width: 230px; cursor: pointer;"
					onmouseout="this.style.border='2px solid #fff'"
					onmousemove="this.style.border='2px solid red'">
					<div class="sub_mingxing">
						<a href="${pageContext.request.contextPath}/goodsData.action?goodsdId=${book.goodsId}" target="_blank"><img
							style="height: 100; width: 100;" src="${book.goodsImg }" alt=""></a>
					</div>
					<div class="pinpai">
						<a href="${pageContext.request.contextPath}/goodsData.action?goodsdId=${book.goodsId}" target="_blank">${book.goodsName }</a>
					</div>
					<div class="youhui">${book.introduce }</div>
					<div class="jiage">${book.price}/元</div>
				</div>
			</c:forEach>
		</div>

		<div class="biaoti center">小书桌</div>
		<div class="main center mb20">
			<c:forEach items="${deskList}" var="desk">
				<div class="mingxing fl mb20"
					style="border: 2px solid #fff; width: 230px; cursor: pointer;"
					onmouseout="this.style.border='2px solid #fff'"
					onmousemove="this.style.border='2px solid red'">
					<div class="sub_mingxing">
						<a href="${pageContext.request.contextPath}/goodsData.action?goodsdId=${desk.goodsId}" target="_blank"><img
							style="height: 100; width: 100;" src="${desk.goodsImg }" alt=""></a>
					</div>
					<div class="pinpai">
						<a href="${pageContext.request.contextPath}/goodsData.action?goodsdId=${desk.goodsId}" target="_blank">${desk.goodsName }</a>
					</div>
					<div class="youhui">${desk.introduce }</div>
					<div class="jiage">${desk.price}/元</div>
				</div>
			</c:forEach>
		</div>
		
		<div class="biaoti center">实用小工具</div>
		<div class="main center mb20">
			<c:forEach items="${toolList}" var="tool">
				<div class="mingxing fl mb20"
					style="border: 2px solid #fff; width: 230px; cursor: pointer;"
					onmouseout="this.style.border='2px solid #fff'"
					onmousemove="this.style.border='2px solid red'">
					<div class="sub_mingxing">
						<a href="${pageContext.request.contextPath}/goodsData.action?goodsdId=${tool.goodsId}" target="_blank"><img
							style="height: 100; width: 100;" src="${tool.goodsImg }" alt=""></a>
					</div>
					<div class="pinpai">
						<a href="${pageContext.request.contextPath}/goodsData.action?goodsdId=${tool.goodsId}" target="_blank">${tool.goodsName }</a>
					</div>
					<div class="youhui">${tool.introduce }</div>
					<div class="jiage">${tool.price}/元</div>
				</div>
			</c:forEach>
		</div>
	</div>


	<jsp:include page="/backer/footer.jsp"></jsp:include>

	<!-- end danpin -->


</body>
</html>