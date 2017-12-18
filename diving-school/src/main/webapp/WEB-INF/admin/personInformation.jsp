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

	<body >
		<jsp:include page="adminHead.jsp" />
		<div class="main">
			<div class="v"></div>
			<form action="${pageContext.request.contextPath }/submitInformation.action" method="post">
			
				<div class="text_info clearfix">
					<span>ID：</span>
				</div>
				<div class="input_info">
					<input type="text" name="name" value="${administrator.id }" readonly="readonly" />
				</div>

				<div class="text_info clearfix">
					<span>姓名：</span>
				</div>
				<div class="input_info">
					<input type="text" name="name" value="${administrator.name }" />
				</div>
				<div class="text_info clearfix">
					<span>性别：</span>
				</div>
				<div class="input_info">
				<input class="cen" name="sex" type="radio" <c:if test="${administrator.sex=='男'}">checked="checked" </c:if>  value="男" /><span class="cen">男</span>
				<input class="cen" name="sex" type="radio" <c:if test="${administrator.sex=='女'}">checked="checked" </c:if> value="女" /><span class="cen">女</span>
				</div>
				<div class="clearfix text_info">
					<span>身份证号：</span>
				</div>
				<div class="input_info">
					<input  class="width200" type="text" name="idcard" value="${administrator.idcard }" />
				</div>
				<div class="text_info clearfix">
					<span>手机号：</span>
				</div>
				<div class="input_info">
					<input type="text" name="phone" value="${administrator.phone }" />
				</div>
				<div class="text_info clearfix">
					<span>生日：</span>
				</div>
				<div class="input_info">
					<select id="se" name="birth" >
					<option id="admin">${administrator.birth}</option>
					</select>
				</div>
				<div class="text_info clearfix">
					<span>创建时间：</span>
				</div>
				<div class="input_info">
					<input type="datetime" readonly="readonly" value="<fmt:formatDate value="${administrator.createTime}" pattern="yyyy/MM/dd HH:mm:ss"/>" />
				</div>
				<div class="clearfix text_info"></div>
				<div class="input_info">
					<input class="button_size" type="submit" value="保存" />
					<input class="button_size" type="button" value="取消" onclick=" window.history.back();" />
				</div>
			</form>
		</div>
		<jsp:include page="adminFoot.jsp" />
	</body>
	<script type="text/javascript">
	$(
	function birth(){
		var sle = document.getElementById("se");
		var birth=document.getElementById("admin").value;
		for(var year = new Date().getFullYear(); year >= 1900; year--) {
			var opt = new Option();
			if(year == birth) {
				opt.selected = true;
			}
			opt.value = year;
			opt.text = year;
			sle.add(opt);

		}
	});
	
	</script>

</html>