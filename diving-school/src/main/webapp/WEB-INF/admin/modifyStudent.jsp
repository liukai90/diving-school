<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/findAllStudent.css" />
		<link rel="stylesheet" href="css/modify.css" />
		<script></script>
	</head>
	<body>
		<jsp:include page="adminHead.jsp" />
		<div class="main">
			<div class="v"></div>
			<form action="${pageContext.request.contextPath }/updateStudent.action" method="post">
				<div class="text_info clearfix">
					<span>ID：</span>
				</div>
				<div class="input_info">
					<input type="text" name="id" value="${student.id}" readonly="true"/>
				</div>
				
				<div class="text_info clearfix">
					<span>姓名：</span>
				</div>
				<div class="input_info">
					<input type="text" name="name" value="${student.name}"/>
				</div>
				<div class="text_info clearfix">
					<span>性别：</span>
				</div>
				<div class="input_info">
				<input class="cen" name="sex" type="radio" <c:if test="${student.sex=='男'}">checked="checked" </c:if>  value="男" /><span class="cen">男</span>
				<input class="cen" name="sex" type="radio" <c:if test="${student.sex=='女'}">checked="checked" </c:if> value="女" /><span class="cen">女</span>
				</div>
				<div class="clearfix text_info">
					<span>身份证号：</span>
				</div>
				<div class="input_info">
					<input class="width200" name="idcard" type="text" value="${student.idcard}"/>
				</div>
				<div class="text_info clearfix">
					<span>手机号：</span>
				</div>
				<div class="input_info">
					<input name="phone" type="text" value="${student.phone}"/>
				</div>
				<div class="text_info clearfix">
					<span>报名金额：</span>
				</div>
				<div class="input_info">
					<input name="entryFee" type="text" value="${student.entryFee}"/>
				</div>
				<div class="text_info clearfix">
					<span>密码：</span>
				</div>
				<div class="input_info">
					<input name="password" type="password" value="${student.password}"/>
				</div>
				<div class="clearfix text_info"></div>
				<div class="input_info">
					<input class="button_size" type="submit" value="保存"/>
					<input class="button_size" type="button" value="取消" onclick=" window.history.back();" />
				</div>
			</form>
		</div>
		<jsp:include page="adminFoot.jsp" />
	</body>
</html>
