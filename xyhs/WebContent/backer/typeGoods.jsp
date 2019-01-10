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

	<c:choose>
		<c:when test="${sessionScope.loginUser !=null}">
			<jsp:include page="/backer/login_header.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="/backer/register_header.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>

	<div class="danpin center">

		<div class="main center">
			<c:forEach items="${tgoods1}" var="eletric">
				<div class="mingxing fl mb20"
					style="border: 2px solid #fff; width: 230px; cursor: pointer;"
					onmouseout="this.style.border='2px solid #fff'"
					onmousemove="this.style.border='2px solid red'">
					<div class="sub_mingxing">
						<a
							href="${pageContext.request.contextPath}/goodsData.action?goodsdId=${eletric.goodsId}"
							target="_blank"><img style="height: 100; width: 100;"
							src="${eletric.goodsImg }" alt=""></a>
					</div>
					<div class="pinpai">
						<a
							href="${pageContext.request.contextPath}/goodsData.action?goodsdId=${eletric.goodsId}"
							target="_blank">${eletric.goodsName }</a>
					</div>
					<div class="youhui">${eletric.introduce }</div>
					<div class="jiage">${eletric.price}/元</div>
				</div>
			</c:forEach>
		</div>


		<div class="main center mb20">
			<c:forEach items="${tgoods2}" var="book">
				<div class="mingxing fl mb20"
					style="border: 2px solid #fff; width: 230px; cursor: pointer;"
					onmouseout="this.style.border='2px solid #fff'"
					onmousemove="this.style.border='2px solid red'">
					<div class="sub_mingxing">
						<a
							href="${pageContext.request.contextPath}/goodsData.action?goodsdId=${book.goodsId}"
							target="_blank"><img style="height: 100; width: 100;"
							src="${book.goodsImg }" alt=""></a>
					</div>
					<div class="pinpai">
						<a
							href="${pageContext.request.contextPath}/goodsData.action?goodsdId=${book.goodsId}"
							target="_blank">${book.goodsName }</a>
					</div>
					<div class="youhui">${book.introduce }</div>
					<div class="jiage">${book.price}/元</div>
				</div>
			</c:forEach>
		</div>

		<div class="main center mb20">
			<c:forEach items="${tgoods3}" var="desk">
				<div class="mingxing fl mb20"
					style="border: 2px solid #fff; width: 230px; cursor: pointer;"
					onmouseout="this.style.border='2px solid #fff'"
					onmousemove="this.style.border='2px solid red'">
					<div class="sub_mingxing">
						<a
							href="${pageContext.request.contextPath}/goodsData.action?goodsdId=${desk.goodsId}"
							target="_blank"><img style="height: 100; width: 100;"
							src="${desk.goodsImg }" alt=""></a>
					</div>
					<div class="pinpai">
						<a
							href="${pageContext.request.contextPath}/goodsData.action?goodsdId=${desk.goodsId}"
							target="_blank">${desk.goodsName }</a>
					</div>
					<div class="youhui">${desk.introduce }</div>
					<div class="jiage">${desk.price}/元</div>
				</div>
			</c:forEach>
		</div>

		<div class="main center mb20">
			<c:forEach items="${toolList4}" var="tool">
				<div class="mingxing fl mb20"
					style="border: 2px solid #fff; width: 230px; cursor: pointer;"
					onmouseout="this.style.border='2px solid #fff'"
					onmousemove="this.style.border='2px solid red'">
					<div class="sub_mingxing">
						<a
							href="${pageContext.request.contextPath}/goodsData.action?goodsdId=${tool.goodsId}"
							target="_blank"><img style="height: 100; width: 100;"
							src="${tool.goodsImg }" alt=""></a>
					</div>
					<div class="pinpai">
						<a
							href="${pageContext.request.contextPath}/goodsData.action?goodsdId=${tool.goodsId}"
							target="_blank">${tool.goodsName }</a>
					</div>
					<div class="youhui">${tool.introduce }</div>
					<div class="jiage">${tool.price}/元</div>
				</div>
			</c:forEach>
		</div>
		<div align="center">
			<tr align="center" valign="top" style="font-size: 14px;">
				<td colspan="11">共<span style="color: red;">${totalPage}</span>页&nbsp;共<span style="color: red;">${total}</span>有条记录&nbsp;当前是第<span style="color: red;">${currentPage}</span>页&nbsp;
					<c:choose>
						<c:when test="${currentPage != 1 }">
							<a style="color: #00F;" onmouseout="this.style.color='#00F'"
								onmousemove="this.style.color='#F00'"
								href="${pageContext.request.contextPath}/typeGoods.action?type=${type }&page=${currentPage-1}">上一页</a>
						</c:when>
						<c:otherwise>
						            上一页
						        </c:otherwise>
					</c:choose> &nbsp; <c:choose>
						<c:when test="${currentPage != totalPage }">
							<a style="color: #00F;" onmouseout="this.style.color='#00F'"
								onmousemove="this.style.color='#F00'"
								href="${pageContext.request.contextPath}/typeGoods.action?type=${type }&page=${currentPage+1}">下一页</a>
						</c:when>
						<c:otherwise>
							   下一页 
							</c:otherwise>
					</c:choose>&nbsp;
				</td>
			</tr>
		</div>
	</div>


	<jsp:include page="/backer/footer.jsp"></jsp:include>

	<!-- end danpin -->


</body>
</html>