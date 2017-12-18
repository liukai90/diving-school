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
			<form action="${pageContext.request.contextPath }/addTime.action" method="post">
				
				<div class="text_info clearfix">
					<span>起始时间：</span>
				</div>
				<div class="input_info">
					<input type="text" name="startTime"/>
				</div>
				<div class="text_info clearfix">
					<span>结束时间：</span>
				</div>
				<div class="input_info">
					<input type="text" name="endTime" />
				</div>
				<div class="clearfix text_info"></div>
				<div class="input_info">
					<input class="button_size" type="submit" value="提交"/>
					<input class="button_size" type="button" value="取消" onclick=" window.history.back();" />
				</div>
			</form>
		</div>
		<jsp:include page="adminFoot.jsp" />
	</body>
</html>
