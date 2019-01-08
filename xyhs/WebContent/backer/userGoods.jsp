<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
			<div class="lfnav myfl">
				<div class="ddzx">订单中心</div>
				<div class="subddzx">
					<ul>
						<li><a href="">我的订单</a></li>
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
						<li><a href="" style="color: #ff6700; font-weight: bold;">我的商品</a></li>
						<li><a
							href="${pageContext.request.contextPath}/updatePassWord.action">修改密码</a></li>
						<li><a href="">收货地址</a></li>
					</ul>
				</div>
			</div>
			
			<div class="rtcont fr">

				<div class="ddzxbt">商品列表</div>
				<table>
					<c:forEach items="${goodsList }" var="goods">
						<div class="myddxq">
							<div class="myddspt myfl">
								<img style="width: 80px; height: 80px;" src="${goods.goodsImg }" alt="">
							</div>
							<div class="ddbh myfl">商品名称: ${goods.goodsName}</div>
							<div class="ztxx fr">
								<ul>
									<li>${goods.goodsType }</li>
									<li>${goods.price }</li>
									<li><fmt:formatDate value="${goods.upTime }"
											pattern="yyyy-MM-dd　HH：mm" /></li>
									<li><a href="${pageContext.request.contextPath}/userShowGoods.action?goodsId=${goods.goodsId}">商品详情></a></li>
									<div class="clear"></div>
								</ul>
							</div>
							<div class="clear"></div>
						</div>
					</c:forEach>
					<tr align="center" valign="top">
						<td colspan="11">共${totalPage}页&nbsp;共${total}有条记录&nbsp;当前是第${currentPage}页&nbsp;
							<c:choose>
								<c:when test="${currentPage != 1 }">
									<a style="color:#00F;" onmouseout="this.style.color='#00F'"
					onmousemove="this.style.color='#F00'" href="${pageContext.request.contextPath}/searchUserGoods.action?id=${cookie.userId.value }&page=${currentPage-1}">上一页</a>
								</c:when>
								<c:otherwise>
						            上一页
						        </c:otherwise>
							</c:choose> &nbsp; <c:choose>
								<c:when test="${currentPage != totalPage }">
									<a style="color:#00F;" onmouseout="this.style.color='#00F'"
					onmousemove="this.style.color='#F00'" href="${pageContext.request.contextPath}/searchUserGoods.action?id=${cookie.userId.value }&page=${currentPage+1}">下一页</a>
								</c:when>
								<c:otherwise>
							   下一页 
							</c:otherwise>
							</c:choose>&nbsp;
						</td>
					</tr>
				</table>
			</div>
			<div class="clear"></div>
		</div>
	</div>

	<jsp:include page="/backer/footer.jsp"></jsp:include>
</body>
</html>