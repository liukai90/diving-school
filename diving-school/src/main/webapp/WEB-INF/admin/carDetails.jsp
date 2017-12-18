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
		<script type="text/javascript" src="js/dynamic.js" ></script>
	</head>

	<body>
		<jsp:include page="adminHead.jsp" />
		<div class="main">
			<div class="v"></div>
			<form action method="post" enctype="multipart/form-data">
				<div class="f_div1">
					<div class="new_text_info clearfix">
						<span>牌号：</span>
					</div>
					<div class="new_input_info">
						<span>${car.mark}</span>
					</div>
					<div class="new_text_info clearfix">
						<span>品牌：</span>
					</div>
					<div class="new_input_info">
						<span>${car.brand}</span>
					</div>
					<div class="new_text_info clearfix">
						<span>科目：</span>
					</div>
					<div class="new_input_info">
						<span>${car.subject}</span>
					</div>
					<div class="new_text_info clearfix">
						<span>项目：</span>
					</div>
					<div class="new_input_info">
						<span>${car.item}</span>
					</div>
					<div class="new_text_info clearfix">
						<span>创建时间：</span>
					</div>
					<div class="new_input_info">
						<span><fmt:formatDate value="${car.createTime}" pattern="yyyy/MM/dd HH:mm:ss"/></span>
					</div>

				</div>
				<div class="f_div2">
						<img id="imgs" class="im" src=${car.carPicture } />
				</div>
			</form>
		</div>
		<jsp:include page="adminFoot.jsp" />
	</body>

</html>