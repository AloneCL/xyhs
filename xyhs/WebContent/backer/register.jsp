<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
	<form method="post" action="submitRegister.action"
		onsubmit="return checkForm()">
		<div class="regist">
			<div class="regist_center">
				<div class="regist_top">
					<div class="left fl">会员注册</div>
					<div class="right fr">
						<a href="mainGoods.action" target="_self">哇呜校园</a>
					</div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="regist_main center">
					<div class="username">
						用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;<input class="shurukuang"
							id="name" onblur="if(this.value!=''){checkName()}" type="text"
							name="userName" placeholder="请输入你的用户名" /><span id="nameSpan">请输入用户名</span>
					</div>
					<div class="username">
						密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;<input
							class="shurukuang" id="npass1" type="password" name="userPass"
							onblur="if(this.value!=''){checkPassWord()}"
							placeholder="请输入你的密码" /><span id="passWordSpan">请输入6位以上字符</span>
					</div>

					<div class="username">
						确认密码:&nbsp;&nbsp;<input class="shurukuang" type="password"
							onblur="if(this.value!=''){checkeInput()}" id="npass2"
							name="userPass1" placeholder="请确认你的密码" /><span
							id="passWordSpan1">两次密码要输入一致哦</span>
					</div>
					<div class="username">
						手&nbsp;&nbsp;机&nbsp;&nbsp;号:&nbsp;&nbsp;<input class="shurukuang"
							id="userTel" onblur="if(this.value!=''){checkTel()}" type="text"
							name="userAccount" placeholder="请填写正确的手机号" /><span id="telSpan">填写下手机号吧，方便我们联系您！</span>
					</div>
					<div class="username">
						<div class="left fl">
							验&nbsp;&nbsp;证&nbsp;&nbsp;码:&nbsp;&nbsp;<input class="yanzhengma"
								type="text" name="verifyCode" placeholder="请输入验证码" />
						</div>
						<div class="right fl">
							<input type="button" id="btnSendCode" value="免费获取验证码"
								onclick="sendPhoneCode()" />
						</div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="regist_submit">
					<input class="submit" type="submit" name="submit" value="立即注册">
				</div>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	function checkAccount(count) {
		var result = false;
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/checkUserAccount.action",
			data : {
				account : count
			},
			dataType : "text",
			async : false,
			success : function(data) {
				if (data == "error") {
					$('#telSpan').html(
							"<font size='2' color='red'>该手机号已注册</font>");
					result = false;
				} else if (data == "ok") {
					$('#telSpan').html(
							"<font size='2' color='green'>账号可用</font>");
					result = true;
				}
			}
		});
		return result;
	}

	function checkeInput() {
		var p1 = $("#npass1").val();
		var p2 = $("#npass2").val();

		if (p1 != '' && p2 != '' && p1 != p2) {
			//alert("新密码不一致");
			//p1 = $("#npass1").val("");
			p2 = $("#npass2").val("");
			$("#passWordSpan1").html("两次密码不一致");
			$("#passWordSpan1").css('color', 'red');
			p2.focus();
			return false;
		} else {
			$("#passWordSpan1").html("符合要求");
			$("#passWordSpan1").css('color', 'green');
			return true;
		}

	}

	function checkName() {
		var name = document.getElementById("name").value;
		var nameSpan = document.getElementById("nameSpan");
		var reg = /^\w+$/;
		if (name.length < 1) {
			nameSpan.innerHTML = "<font size='2' color='red'>用户名不能为空</font>"
		} else if (name.length < 6) {
			nameSpan.innerHTML = "<font size='2' color='red'>用户名要至少六位</font>"
		} else if (!reg.test(name)) {
			nameSpan.innerHTML = "<font size='2' color='red'>只能由字母数字下划线组成</font>"
		} else {
			nameSpan.innerHTML = "<font size='2' color='green'>符合要求</font>"
			return true;
		}
	}

	function checkTel() {
		var tel = $("#userTel").val();
		var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
		if (!reg.test(tel)) {
			telSpan.innerHTML = "<font size='2' color='red'>请输入正确的手机号格式</font>"
		} else {
			telSpan.innerHTML = "<font size='2' color='green'>符合要求</font>"
			return checkAccount(tel);
		}
	}

	function checkPassWord() {
		var pass = document.getElementById("npass1").value;
		var passWordSpan = document.getElementById("passWordSpan");
		if (pass.length < 1) {
			passWordSpan.innerHTML = "<font size='2' color='red'>密码不能为空</font>"
		} else if (pass.length < 6) {
			passWordSpan.innerHTML = "<font size='2' color='red'>密码至少6位</font>"
		} else if (pass.length > 16) {
			passWordSpan.innerHTML = "<font size='2' color='red'>密码最长为16位</font>"
		} else {
			passWordSpan.innerHTML = "<font size='2' color='green'>符合要求</font>"
			return true;
		}
	}

	function checkForm() {
		if (checkPassWord() && checkeInput() && checkTel()) {
			return true;
		} else {
			alert("输入格式不规范");
			return false;
		}
	}

	var InterValObj;
	var countdown = 60;
	var curCount;
	function sendPhoneCode() {
		var tel =$("#userTel").val();
		curCount = countdown;
		if (!checkTel())
			return;
		$("#btnSendCode").val(curCount + "秒后重新发送");
		$("#btnSendCode").attr('disabled', true);
		InterValObj = window.setInterval(SetRemainTime, 1000);
			 $.ajax({
				url:"${pageContext.request.contextPath}/SendMessage/sendMessage.action",
			    type:"post",
				dataType:"text",
				data:{
					phone: tel
				},
				success:function(data){
				     alert("成功发送");
				}
							
			})
	}

	function SetRemainTime() { //发送验证码倒计时
		if (curCount == 1) {
			window.clearInterval(InterValObj);
			$("#btnSendCode").attr('disabled', false);
			$("#btnSendCode").val("免费获取");
		} else {
			curCount--;
			$("#btnSendCode").val(curCount + "秒后重新发送");
		}
	}
</script>
<c:if test="${not empty error }">
	<script type="text/javascript">
		alert('${error}')
	</script>
</c:if>
</html>