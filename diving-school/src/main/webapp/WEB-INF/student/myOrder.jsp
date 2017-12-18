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
				<link rel="stylesheet" href="css/myOrder.css" />
		<script type="text/javascript" src="js/jquery-1.11.1.js" ></script>
	</head>
	<body>
		<jsp:include page="studentHead.jsp"/>
		<div class="main">
						<div>
					<table class="datalist">
					
						<thead>
							<tr>
								<th>ID</th>
								<th>科目</th>
								<th>车辆</th>
								<th>日期</th>
								<th>时间段</th>
								<th class="width200">操作</th>
							</tr>
						</thead>
						<tbody id="orders">
						</tbody>
					</table>
				</div>
		</div>
	<jsp:include page="studentFoot.jsp"/>
	</body>
	<script type="text/javascript">
	$(function(){
		orderInformation();
	});	
	function orderInformation(){
		$.ajax({  
            url: '${pageContext.request.contextPath }/myOrderInformation.action',
            type: 'GET',  
            dataType:'json', 
            contentType:'application/json;charset=utf-8',
            cache: false,  
            error: erryFunction,  //错误执行方法    
            success: orderFunction //成功执行方法    
        }) ;
	}
	
	function erryFunction(){
		alert("error");
	}
	
	function orderFunction(orderQueryVo){
		var ids=orderQueryVo.ids;
		var cars=orderQueryVo.cars;
		var times=orderQueryVo.times;
		var submitDates=orderQueryVo.submitDates;
		var orders="";
		
		for(var i in ids /*in cars in times in submitDates*/){
			orders+=orderInfo(ids[i], cars[i].subject, cars[i].mark,new Date(submitDates[i]).toLocaleDateString(), times[i].startTime,times[i].endTime);
		}
		$("#orders").html(orders);
		
	}
	
	var orderInfo=function(id,subject,mark,submitDate,startTime,endTime){
		var order='<tr>';
		order+='<td>'+id+'</td>';
		order+='<td>'+subject+'</td>';
		order+='<td>'+mark+'</td>';
		order+='<td>'+submitDate+'</td>';
		order+='<td>'+startTime+'~'+endTime+'</td>';
		order+='<td class="width200">';
		order+='<a  href="${pageContext.request.contextPath }/cancelOrder.action?id='+id+'">';
		order+='<img class="f_data" src="img/cancel.png">';
		order+='</a>';
		order+='</td>';
		order+='</tr>';
		return order;
	}
	</script>
</html>
