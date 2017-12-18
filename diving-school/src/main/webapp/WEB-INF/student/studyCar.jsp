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
		<link rel="stylesheet" href="css/practiceCar.css" />
		<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	</head>
	<body>
	<jsp:include page="studentHead.jsp"/>
	<div class="main">
		<div class="v"></div>
		<div class="information">
			<form action="${pageContext.request.contextPath}/submitOrder.action" method="post">
				<div class="key clearfix">
					<span>姓名：</span>
				</div>
				<div class="value">
					<span>${student.name }</span>
				</div>
				<div class="key clearfix">
					<span>电话：</span>
				</div>
				<div class="value">
					<span>${student.phone}</span>
				</div>
				<div class="key clearfix">
					<span>日期：</span>
				</div>
				<div class="value">
					<input id="date" name="submitDate" class="calendar" type="date" onchange="checkDate(this);"/>
				</div>
				<div class="key clearfix">
					<span>车辆：</span>
				</div>
				<div class="value">
					<select id="mark" name="carId" onchange="checkCar(this);"></select>
				</div>
				<div class="key clearfix">
					<span>时间段：</span>
				</div>
				<div class="value">
					<select id="time" name="timeId" onchange="checkOrder(this)"></select>
				</div>
				<div class="key clearfix">
					<input class="inp" type="submit" value="提交" />
				</div>
				<div class="value">
					<input class="inp" type="button" value="取消" onclick="window.history.back();"/>
				</div>
			</form>
		</div>
		<div class="show" id="show">
		<span>${orderInformation}</span>
		</div>
	</div>
	<jsp:include page="studentFoot.jsp"/>
	</body>
	<script type="text/javascript">
		function checkDate(date){
			
			var submitDate=date.value;
			$.ajax({  
                url: '${pageContext.request.contextPath }/isHaveOrder.action?submitDate='+submitDate,  
                type: 'GET',  
                dataType:'json', 
                contentType:'application/json;charset=utf-8',
                cache: false,  
                error: erryFunction,  //错误执行方法    
                success: hintFunction //成功执行方法    
            }) ;
		}
		 function erryFunction() {  
             alert("error");  
         }  
		 function hintFunction(orderDateMessage){
			 var select=document.getElementById("mark");
			 select.disabled=false;
			 var messageHtml="<span>"+orderDateMessage.message+"</span>";
			 $("#show").html(messageHtml);
		 }
		 function selectMark(){
			 $.ajax({  
	                url: '${pageContext.request.contextPath }/getAllMark.action',  
	                type: 'GET',  
	                dataType:'json', 
	                //contentType:'application/json;charset=utf-8',
	                cache: false,  
	                error: erryFunction,  //错误执行方法    
	                success: selectFunction //成功执行方法    
	            }) ;
		 }
		 function selectFunction(cars){
			 
			 var select=document.getElementById("mark");
			 
			 for(var i in cars){
				 				 
				 var opt=new Option(cars[i].mark, cars[i].id, false, false);
		
				 select.add(opt);
				 
			 }
		 }
		 function selectTime(){
			 $.ajax({  
	                url: '${pageContext.request.contextPath }/getAllTime.action',  
	                type: 'GET',  
	                dataType:'json', 
	                //contentType:'application/json;charset=utf-8',
	                cache: false,  
	                error: erryFunction,  //错误执行方法    
	                success: timeFunction //成功执行方法    
	            }) ;
		 }
		 function timeFunction(times){
			 
			 var select=document.getElementById("time");
			 
			 for(var i in times){
				 
				 var opt=new Option( times[i].startTime+'~'+times[i].endTime,times[i].id, false, false);
				 
				select .add(opt);
				 
			 }
			 
		 }
		 $(
				 function() {
					 selectMark();
					 selectTime();
				});
		 function checkCar(select){
			 
			 var id=select.value;
			 
			 $.ajax({  
	                url: '${pageContext.request.contextPath }/checkCar.action?id='+id,  
	                type: 'GET',  
	                dataType:'json', 
	                //contentType:'application/json;charset=utf-8',
	                cache: false,  
	                error: erryFunction,  //错误执行方法    
	                success: carFunction //成功执行方法    
	            }) ;
		 }
		 function carFunction(car){
			 var carShow=carInfo(car.mark,car.brand, car.subject, car.item, car.carPicture);
			 
			 $("#show").html(carShow);
			 var time=document.getElementById("time");
		 	 time.disabled=false;
			 
		 }
		 
		 var carInfo=function(mark,brand,subject,item,carPicture){
			 
			 var carShow='<div id="showInformation">';
			 carShow+='<table id="tab">';
			 carShow+='<tr>';
			 carShow+='<td>牌号:</td>';
			 carShow+='<td>'+mark+'</td>';
			 carShow+='</tr>';
			 carShow+='<tr>';
			 carShow+='<td>品牌:</td>';
			 carShow+='<td>'+brand+'</td>';
			 carShow+='</tr>';
			 carShow+='<tr>';
			 carShow+='<td>科目:</td>';
			 carShow+='<td>'+subject+'</td>';
			 carShow+='</tr>';
			 carShow+='<tr>';
			 carShow+='<td>项目:</td>';
			 carShow+='<td>'+item+'</td>';
			 carShow+='</tr>';
			 carShow=='</table>';
			 carShow+='</div>';
			 carShow+='<div id="showPicture">';
			 carShow+='<img id="car" src="'+carPicture+'" />';
			 carShow+='</div>';
			 
			 return carShow;
		 }
		 
		 $(function(){
			 var select=document.getElementById("mark");
			 select.disabled=true;
			 var time=document.getElementById("time");
			 	 time.disabled=true;
			 	 
		 });
		 
		 function checkOrder(timeSelect){
			 var submitDate=document.getElementById("date").value;
			 var carId=document.getElementById("mark").value;
			 var timeId=timeSelect.value;
			 
			 $.ajax({  
	                url: '${pageContext.request.contextPath }/checkOrder.action',  
	                type: 'POST',  
	                dataType:'json', 
	                data:'carId='+carId+'&submitDate='+submitDate+'&timeId='+timeId,
	               // contentType:'application/json;charset=utf-8',
	                cache: false,  
	                error: erryFunction,  //错误执行方法    
	                success: orderFunction //成功执行方法    
	            }) ;
		 }
		 function orderFunction(message){
			 var messageHtml="<span>"+message.message+"<span>";
			 $("#show").html(messageHtml);
		 }
	</script>

</html>