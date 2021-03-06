<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员登录</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
	<!-- login -->
	<div class="top center">
		<div class="logo center">
			<a href="${pageContext.request.contextPath }/mainGoods.action"><img
				src="image/mistore_logo.png" alt=""></a>
		</div>
	</div>
	<form method="post" action="submitLogin.action" class="form center" onsubmit="return checkForm()">
		<div class="login">
			<div class="login_center">
				<div class="login_top">
					<div class="left fl">会员登录</div>
					<div class="right fr">
						您还不是我们的会员？<a href="userRegister.action" target="_self">立即注册</a>
					</div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="login_main center">
					<div class="username">
						账&nbsp;&nbsp;&nbsp;&nbsp;号:&nbsp;<input class="shurukuang" type="text" name="userAccount" id="name" onblur="checkeName()"
							placeholder="请输入你的用户名" /><br/><span id="nameSpan" style="margin-left: 55px;"></span>
					</div>
					<div class="username">
						密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input class="shurukuang" id="password" onblur="checkePassWord()"
							type="password" name="userPass" placeholder="请输入你的密码" /><br/><span id="passWordSpan" style="margin-left: 55px;"></span>
					</div>
					<div class="username">
						<div class="left fl">
							验证码:&nbsp;<input class="yanzhengma" type="text" id="validateCode" onblur="if(this.value!=''){checkImg(this.value)}" name="validateCode"
								placeholder="请输入验证码" />
						</div>
						<div class="right fl">
							<img id="codeValidateImg"
								onClick="javascript:flushValidateCode();" />
						</div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="login_submit">
					<input class="submit" type="submit" name="submit" value="立即登录">
				</div>

			</div>
		</div>
	</form>
	<footer>
		<div class="copyright">简体 | 繁体 | English | 常见问题</div>
		<div class="copyright">
			小米公司版权所有-京ICP备10046444-<img src="./image/ghs.png" alt="">京公网安备11010802020134号-京ICP证110507号
		</div>

	</footer>
	<script type="text/javascript">
		$(document).ready(function() {
			flushValidateCode();//进入页面就刷新生成验证码
		});

		/* 刷新生成验证码 */
		function flushValidateCode() {
			var validateImgObject = document.getElementById("codeValidateImg");
			validateImgObject.src = "${pageContext.request.contextPath }/getLoginCode.action?time="
					+ new Date();
		}
		/*校验验证码输入是否正确*/
		function checkImg(code) {
			var url = "${pageContext.request.contextPath}/checkimagecode.action";
			$.get(url, {
				"validateCode" : code
			}, function(data) {
				if (data == "ok") {
				} else {
					alert("验证码错误!")
					flushValidateCode();
				}
			})
		}
		
		function checkeName()
		{   
			var  name = document.getElementById("name").value;
			var nameSpan = document.getElementById("nameSpan");
			var reg=/^[1][3,4,5,7,8][0-9]{9}$/;
			/* if(name.length<1){
				nameSpan.innerHTML="<font size='2' color='red'>用户名不能为空</font>"
			}else if(name.length<6){
				nameSpan.innerHTML="<font size='2' color='red'>用户名要至少六位</font>"
			}else  */
			if(!reg.test(name)){
				nameSpan.innerHTML="<font size='2' color='red'>请输入正确的手机号</font>"
			}else{
				nameSpan.innerHTML="<font size='2' color='green'>符合要求</font>"
				return true;
			}
		}

		function checkePassWord(){
			var pass = document.getElementById("password").value;
			var passWordSpan = document.getElementById("passWordSpan");
			if(pass.length<1){
				passWordSpan.innerHTML="<font size='2' color='red'>密码不能为空</font>"
			}else if (pass.length<6) {
				passWordSpan.innerHTML="<font size='2' color='red'>密码至少6位</font>"
			}else if(pass.length>16){
				passWordSpan.innerHTML="<font size='2' color='red'>密码最长为16位</font>"
			}else{
				passWordSpan.innerHTML="<font size='2' color='green'>符合要求</font>"
				return true;
			}
		}
		
		function checkForm(){
	        var  name = document.getElementById("name").value;
			if(checkeName()&&checkePassWord()){
				return true;
			}
			alert("账号密码不符和规范");
			return false;
		}
	</script>
</body>
<c:if test="${not empty error }">
	<script type="text/javascript">
		alert('${error}')
	</script>
</c:if>
</html>