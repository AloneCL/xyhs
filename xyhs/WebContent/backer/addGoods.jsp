<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加商品</title>
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
<style type="text/css">
.tableImg {
	display: none;
	position: absolute;
}
</style>
</head>
<body>
	<center>
		<div class="rtcont fr">
			<form action="${pageContext.request.contextPath}/modifyGoods.action"
				id="goodsForm" method="post">
				<div class="subgrzl ml40" style="margin-top: 20px;">
					<span id="title">商品名称：</span><input type="text" name="goodsName"
						id="userPass" style="font-size: 17px; height: 20px" /> <input
						type="text" name="userId" value="${cookie.userId.value}" hidden>
				</div>
				<div class="subgrzl ml40" style="margin-top: 20px;">
					<span id="title">商品价格：</span><input type="text" name="price"
						id="price" style="font-size: 17px; height: 20px" />
				</div>
				<div class="subgrzl ml40" style="margin-top: 20px;">
					<span id="title">商品描述：</span><input type="text" name="introduce"
						id="introduce" style="font-size: 17px; height: 20px" />
				</div>
				<div class="subgrzl ml40" style="margin-top: 20px;">
					<span id="title">商品类型：</span><select id="type" name="goodsType"
							style="font-size: 17px; height: 28px; width：50px;">
							<option value="1">小电器</option>
							<option value="2">书籍</option>
							<option value="3">小书桌</option>
							<option value="4">实用小工具</option>
							<option value="5">服装</option>
							<option value="6">复习资料/笔记</option>
							<option value="7">洗漱品</option>
							<option value="8">其他</option>
							</select>
				</div>

				<div class="subgrzl ml40" style="margin-top: 20px;">
					<span id="title">封面图：</span><input type="button"
						name="uploadButton" value="点击修改" id="uploadButton"
						class="tableButton" style="font-size: 17px; height: 28px" /> <img
						src="" alt="" name="flag1" class="tableImg" width="200"
						height="130"> <input type="text" name="goodsImg"
						id="goodsImg" value="" hidden>
				</div>
				<div align="center">
					<input type="button" value="确认上传" onclick="update()"
						style="margin-top: 40px; background-color: #008CBA; /* Green */ border: none; color: white; padding: 12px 22px; text-align: center; text-decoration: none; display: inline-block; font-size: 15px;" />
				</div>

			</form>
			<div hidden>
				<input type="file" name="upfile" id="file" accept="image/*"
					onchange="upload()">
			</div>
		</div>
		<div class="clear"></div>
	</center>
</body>
<script type="text/javascript" src="../lib/layer/3.1.1/layer.js"></script>
<script type="text/javascript">
    
    function test(){
    	layer.msg('heheda',{icon:1,time:1000});
    }
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
				layer.msg('图片上传成功', {
					icon : 1,
					time : 1000
				});
			}
		});
	}
	
	function update(){
		$.ajax({
			url : "${pageContext.request.contextPath}/addGoods.action",
			type : "post",
			dataType : "text",
			data : $('#goodsForm').serialize(),
			 //processData:false,
             //contentType:"text/html; charset=UTF-8",
			success : function(data) {
			   if(data == "success"){
				   layer.msg('添加成功',{icon: 1,time:1000});
				   setTimeout(close,1000);
			   }else if(data == "fail"){
				   layer.msg('添加失败',{icon:2,time:1000});
				   setTimeout(close,1000);
			   }
			}
		})
	}
	
	function close(){    
		var index = parent.layer.getFrameIndex(window.name);
		window.parent.location.reload();
		parent.layer.close(index);
    }
</script>
</html>