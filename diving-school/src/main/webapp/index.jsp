<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="css/findAllStudent.css"/>
		<link rel="stylesheet" href="css/login.css"/>
	</head>
	<body>
		<div class="headr">
				<h1>欢迎来到预约系统</h1>
		</div>
		<div class="d">
			<div class="between"></div>
			<div class="loginsize">
				<h2>手机号登录</h2>
				<div class="login">
					<form  action="${pageContext.request.contextPath }/login.action" method="post">
						<img src="img/username.png">
						<input class="in" type="text" name="phone" value="手机号"/><br><br>
					<img src="img/password.png" />
					<input class="in" type="password" name="password" value=""/><br /><br>
					<p align="center">登录类型</p>
					<input class="ri location" type="radio" name="loginType" value="1"/>
					<img  src="img/student.png"/>
					<input  class="ri" type="radio" name="loginType" value="0"/>
					<img  src="img/admin.png"/>
					<br /><br />
					<input class="b" type="submit" value="登录"/>
					</form>
					<p class="error">${error}</p>
					<span>${success}</span>
				</div>
				
			</div>
		</div>
		<div class="footer1">
			<p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
			<p>版权所有(C)加拿大达内IT培训集团公司 </p>
		</div>
		
	</body>
</html>
