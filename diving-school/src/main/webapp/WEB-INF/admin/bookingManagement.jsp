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
		<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	</head>

	<body>
		<jsp:include page="adminHead.jsp"/>
		<div class="main">
			<form>
				<div class="search_add">
					<div class="d_left">
						<span>日期：</span><input id="orderTime" type="date" onchange="findOrder(this);" />
						<span>科目：</span>
						<span>车辆：</span>
						<select id="mark" onchange="findOrderByCar(this);" ></select>
					</div>
				</div>
				<div>
					<table class="datalist">
					<thead>
						<tr>
								<th>ID</th>
								<th>日期</th>
								<th>科目</th>
								<th>项目</th>
								<th>车辆</th>
								<th>时间段</th>
								<th>姓名</th>
								<th>手机号</th>
						</tr>
					</thead>
						<tbody id="orderShow">
						</tbody>
					</table>
				</div>
			</form>
		</div>
		<jsp:include page="adminFoot.jsp"/>
	</body>
	
	<script type="text/javascript">
	
	function findOrderByCar(opt){
		var carId=opt.value;
		var submitDate=document.getElementById("orderTime").value;
		$.ajax({  
            url: '${pageContext.request.contextPath }/findOrderByCar.action?submitDate='+submitDate+'&carId='+carId,  
            type: 'GET',  
            dataType:'json', 
            contentType:'application/json;charset=utf-8',
            cache: false,  
            error: erryFunction,  //错误执行方法    
            success: orderFunction //成功执行方法    
        }) ;
	}
	function findOrder(date){
		
		var submitDate=date.value;
		$.ajax({  
            url: '${pageContext.request.contextPath }/findOrderBySubmitDate.action?submitDate='+submitDate,  
            type: 'GET',  
            dataType:'json', 
            contentType:'application/json;charset=utf-8',
            cache: false,  
            error: erryFunction,  //错误执行方法    
            success: orderFunction //成功执行方法    
        }) ;
	}
	
	function orderFunction(orderQueryVo){
		var ids=orderQueryVo.ids;
		var students=orderQueryVo.students;
		var cars=orderQueryVo.cars;
		var times=orderQueryVo.times;
		var submitDates=orderQueryVo.submitDates;
		var orders="";
		for(var i in ids){
			orders+=orderInfo(ids[i], submitDates[i],cars[i].subject, cars[i].item, cars[i].mark, times[i].startTime, 
					times[i].endTime, students[i].name, students[i].phone);
		}
		
		$("#orderShow").html(orders);
		 var select=document.getElementById("mark");
		 select.disabled=false;
		
	}
	var orderInfo=function(id,submitDate,subject,item,mark,startTime,endTime,name,phone){
		var order='<tr>';
		order+='<td>'+id+'</td>';
		order+='<td>'+new Date(submitDate).toLocaleDateString()+'</td>';
		order+='<td>'+subject+'</td>';
		order+='<td>'+item+'</td>';
		order+='<td>'+mark+'</td>';
		order+='<td>'+startTime+'~'+endTime+'</td>';
		order+='<td>'+name+'</td>';
		order+='<td>'+phone+'</td>';
		order+='</tr>';
		return order;
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
	 function erryFunction() {  
         alert("error");  
     }  
	$(function(){
		selectMark();
		 var select=document.getElementById("mark");
		 select.disabled=true;
		 var time=document.getElementById("time");
		 	 time.disabled=true;
		 	 
	 });
	</script>

</html>