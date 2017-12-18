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
			<form action="${pageContext.request.contextPath }/modifyCar.action" method="post" enctype="multipart/form-data">
				<div class="f_div1">
					<div class="new_text_info clearfix">
						<span>ID：</span>
					</div>
					<div class="new_input_info">
						<input type="text" name="id" value="${car.id}" readonly="readonly" />
					</div>
					<div class="new_text_info clearfix">
						<span>牌号：</span>
					</div>
					<div class="new_input_info">
						<input type="text" name="mark" value="${car.mark}" />
					</div>
					<div class="new_text_info clearfix">
						<span>品牌：</span>
					</div>
					<div class="new_input_info">
						<input type="text" name="brand" value="${car.brand }" />
					</div>
					<div class="new_text_info clearfix">
						<span>科目：</span>
					</div>
					<div class="new_input_info">
						<input type="radio" name="subject" <c:if test="${car.subject=='科目二'}">checked="checked" </c:if> value="科目二" /><span>科目二</span>
						<input type="radio" name="subject" <c:if test="${car.subject=='科目三'}">checked="checked" </c:if> value="科目三" /><span>科目三</span>
					</div>
					<div class="new_text_info clearfix">
						<span>项目：</span>
					</div>
					<div class="new_input_info">
						<input type="text" name="item" value="${car.item }" />
					</div>
					<div class="new_text_info clearfix">
						<span>更改图片：</span>
					</div>
					<div class="new_input_info">
						<input id="file" type="file" name="car_picture" onchange="preview();" />
						<input type="button" onclick="call();" value="取消上传" />
					</div>
					<div class="new_text_info clearfix">
						<span>上传说明：</span>
					</div>
					<div class="new_input_info">
						<span>图片大小不超过3M,且一律为350*350</span>
					</div>
					<div class="clearfix new_text_info"></div>
					<div class="new_input_info">
						<input class="button_size" type="submit" value="保存" />
						<input class="button_size" type="button" value="取消" onclick=" window.history.back();" />
					</div>

				</div>
				<div class="f_div2">
						<img id="imgs" class="im" src="${car.carPicture }" />
				</div>
			</form>
		</div>
		<jsp:include page="adminFoot.jsp" />
	</body>

</html>