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
		<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	</head>

	<body>
		<jsp:include page="adminHead.jsp" />
		<div class="main">
			<div class="v"></div>
			<form action="${pageContext.request.contextPath }/addStudent.action" method="post">

				<div class="text_info clearfix">
					<span>姓名：</span>
				</div>
				<div class="input_info">
					<input type="text" name="name" value="" />
				</div>
				<div class="text_info clearfix">
					<span>性别：</span>
				</div>
				<div class="input_info">
					<input class="cen" name="sex" type="radio" value="1" /><span class="cen">男</span>
					<input class="cen" name="sex" type="radio" value="0" /><span class="cen">女</span>
				</div>
				<div class="text_info clearfix">
					<span>生日：</span>
				</div>
				<div class="input_info">
					<select id="se" name="birth" >
						<!--<option></option>-->
					</select>
				</div>
				<div class="clearfix text_info">
					<span>身份证号：</span>
				</div>
				<div class="input_info">
					<input style="width: ;" class="width200" type="text" name="idcard" value="" />
				</div>
				<div class="text_info clearfix">
					<span>手机号：</span>
				</div>
				<div class="input_info">
					<input type="text" name="phone" value="" />
				</div>
				<div class="text_info clearfix">
					<span>报名金额：</span>
				</div>
				<div class="input_info">
					<input type="number" name="entryFee" />
				</div>
				<div class="clearfix text_info"></div>
				<div class="input_info">
					<input class="button_size" type="submit" value="提交" />
					<input class="button_size" type="button" value="取消" onclick=" window.history.back();" />
				</div>
			</form>
		</div>
		<jsp:include page="adminFoot.jsp" />
	</body>
	
	<script type="text/javascript">
	$(function birth(){
		var sle = document.getElementById("se");
		for(var year = new Date().getFullYear(); year >= 1900; year--) {
			var opt = new Option();
			if(year == 1996) {
				opt.selected = true;
			}
			opt.value = year;
			opt.text = year;
			sle.add(opt);

		}
	});

	</script>

</html>