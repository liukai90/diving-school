<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/studentMenu.css" />
		<link rel="stylesheet" href="css/studentInformation.css">
		<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	</head>

	<body>
		<jsp:include page="studentHead.jsp"/>
		<div class="main">
			<div class="v"></div>
			<form action="${pageContext.request.contextPath }/stuSubmitPassword.action" method="post">

				<div class="text_info clearfix">
					<span>旧密码：</span>
				</div>
				<div class="input_info">
					<input name="password" type="password" oninput="checkPassword(this);" /><span id="original"></span>
				</div>
				<div class="text_info clearfix">
					<span>新密码：</span>
				</div>
				<div class="input_info">
					<input id="new" name="onePassword" type="password" oninput="checkPasswordLength(this);" /><span id="newPassword"></span>
				</div>
				<div class="text_info clearfix">
					<span>重复新密码：</span>
				</div>
				<div class="input_info">
					<input id="repeatNew" name="doublePassword" type="password" oninput="twoTimePasswordSame(this);"/><span id="repeatNewPassword"></span>
				</div>
				<div class="clearfix text_info"></div>
				<div class="input_info">
					<input class="button_size" type="submit" value="提交" />
					<input class="button_size" type="button" value="取消" onclick="window.history.back();" />
				</div>
				<div class="text_info clearfix">
				</div>
				<div class="input_info">
					<span>${defeat }</span>
				</div>
			</form>
		</div>
		<jsp:include page="studentFoot.jsp"/>
	</body>
	<script type="text/javascript">
	function checkPasswordLength(ipt){
		var newPassword=ipt.value;
		if(newPassword.length>=6&&newPassword.length<=18){
			$("#newPassword").text("正确").css("color","green");
		}else{
			$("#newPassword").text("密码应为6~18位字符").css("color","red");
		}
		var repeatNewPassword=document.getElementById("repeatNew").value;
		if(repeatNewPassword==newPassword){
			$("#repeatNewPassword").text("正确").css("color","green");
		}else{
			$("#repeatNewPassword").text("两次密码不一致").css("color","red");
		}
		
	}
	function twoTimePasswordSame(ipt){
		
		var repeatNewPassword=ipt.value;
		var newPassword=document.getElementById("new").value;
		if(repeatNewPassword==newPassword){
			$("#repeatNewPassword").text("正确").css("color","green");
		}else{
			$("#repeatNewPassword").text("两次密码不一致").css("color","red");
		}
		
	}
	function checkPassword(ipt){
		
		var password=ipt.value;
		
		$.ajax({  
            url: '${pageContext.request.contextPath }/stuCheckPassword.action',  
            type: 'POST',  
            dataType:'json', 
            data:'password='+password,
            cache: false,  
            error: erryFunction,  //错误执行方法    
            success: stateFunction //成功执行方法    
        }) ;
	}
	 function erryFunction() {  
         alert("error");  
     } 
	 function stateFunction(state){
		 
		 if(state){
			 $("#original").text("正确").css("color","green");
		 }else{
			 $("#original").text("错误").css("color","red");
		 }
	 }
	</script>

</html>