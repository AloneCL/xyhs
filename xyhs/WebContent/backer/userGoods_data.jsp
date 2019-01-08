<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品信息</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<style type="text/css">
.tableImg {
	display: none;
	position: absolute;
}
</style>
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
						<li><a
							href="${pageContext.request.contextPath}/searchUserGoods.action?id=${cookie.userId.value}"
							style="color: #ff6700; font-weight: bold;">我的商品</a></li>
						<li><a
							href="${pageContext.request.contextPath}/updatePassWord.action">修改密码</a></li>
						<li><a href="">收货地址</a></li>
					</ul>
				</div>
			</div>


			<div class="rtcont fr">
				<form
					action="${pageContext.request.contextPath}/modifyGoods.action"
					id="goodsDataForm" method="post">
					<div class="grzlbt ml40">
						<a
							href="${pageContext.request.contextPath}/searchUserGoods.action?id=${cookie.userId.value}">商品列表</a>
						->> 商品详情
					</div>
					<div class="subgrzl ml40" style="margin-top: 20px;">
						<span id="title">商品名称：</span><input type="text" name="goodsName"
							id="userPass" value="${goods.goodsName }"
							style="font-size: 17px; height: 20px" />
							<input type="text" name="goodsId" value="${goods.goodsId }" hidden>
					</div>
					<div class="subgrzl ml40" style="margin-top: 20px;">
						<span id="title">商品价格：</span><input type="text" name="price"
							id="price" value="${goods.price }"
							style="font-size: 17px; height: 20px" />
					</div>
					<div class="subgrzl ml40" style="margin-top: 20px;">
						<span id="title">商品描述：</span><input type="text" name="introduce"
							id="introduce" value="${goods.introduce }"
							style="font-size: 17px; height: 20px" />
					</div>
					<div class="subgrzl ml40" style="margin-top: 20px;">
						<span id="title">商品状态：</span><select id="type" name="goodsStatus"
							style="font-size: 17px; height: 28px">
							<option value="0"
								<c:if test="${goods.goodsStatus == 0}">selected</c:if>>已下架</option>
							<option value="1"
								<c:if test="${goods.goodsStatus == 1}">selected</c:if>>销售中</option>
							<option value="2"
								<c:if test="${goods.goodsStatus == 2}">selected</c:if>>租赁中</option>
							<option value="3"
								<c:if test="${goods.goodsStatus == 3}">selected</c:if>>审核中</option>
						</select>
					</div>

					<div class="subgrzl ml40" style="margin-top: 20px;">
						<span id="title">封面图：</span><input type="button" name="uploadButton" value="点击修改" id="uploadButton"
							class="tableButton" style="font-size: 17px; height: 28px" /> 
						<img src="${goods.goodsImg }" alt="" name="flag1" class="tableImg"
							width="200" height="130"> <input type="text"
							name="goodsImg" id="goodsImg" value="" hidden>
					</div>
					<div align="center">
						<input type="button" value="确认修改"  onclick="update()"
							style="margin-top: 40px; background-color: #008CBA; /* Green */ border: none; color: white; padding: 12px 22px; text-align: center; text-decoration: none; display: inline-block; font-size: 15px;" />
					</div>
					
				</form>
				<div hidden>
					<input type="file" name="upfile" id="file" accept="image/*"
						onchange="upload()">
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<!-- self_info -->
	<jsp:include page="/backer/footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="lib/layer/3.1.1/layer.js"></script>
<script type="text/javascript">
	var imgTarget;
	var inputTarget;

	$('#uploadButton').click(function() {
		imgTarget = $(this).next();
		inputTarget = $('#goodsImg');
		$('#file').click();
	});

	$('.tableButton').mouseover(function() {
		$(this).next().show(100);
	}).mouseout(function() {
		$(this).next().hide(100);
	});

	function upload() {
		var fd = new FormData();
		fd.append('picture', $('#file')[0].files[0]);
		$.ajax({
			url : '${pageContext.request.contextPath}/uploadImg.action',
			data : fd,
			processData : false,
			contentType : false,
			type : 'POST',
			success : function(data) {
				inputTarget.val("../" + data);
				imgTarget.attr('src', "../" + data);
				layer.msg('修改成功', {icon: 1,time:1000});
			}
		});
	}
	
	function update(){
		$.ajax({
			url : "${pageContext.request.contextPath}/modifyGoods.action",
			type : "post",
			dataType : "text",
			data : $('#goodsDataForm').serialize(),
			 //processData:false,
             //contentType:"text/html; charset=UTF-8",
			success : function(data) {
			   if(data == "success"){
				   layer.msg('修改成功',{icon: 1,time:1000});
			   }else if(data == "fail"){
				   layer.msg('修改失败',{icon:2,time:1000});
			   }
			}
		})
	}
</script>
</html>