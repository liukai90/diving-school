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
			<jsp:include page="adminHead.jsp" />
			<div class="main">
					<div class="search_add">
						<div class="d_left">
							<img class="cen" src="img/student1.png" />
							<input class="cen" type="text" id="search"/>
							<input class="cen" type="button" value="搜索" onclick="search();" />
						</div>
						<div class="d_left2">
							<a href="${pageContext.request.contextPath }/goAddCar.action">
								<img src="img/addStudent.png" />
							</a>
						</div>
					</div>
					<div>
						<table class="datalist">
						<thead>
							<tr>
								<th>ID</th>
								<th>牌号</th>
								<th>品牌</th>
								<th>科目</th>
								<th>项目</th>
								<th>创建时间</th>
								<th>详情</th>
								<th class="width200">操作</th>
							</tr>
						</thead>
							<tbody id="cars">
								
							</tbody>
						</table>
					</div>
					<div class="page">
					</div>
			</div>
			<jsp:include page="adminFoot.jsp" />
		</body>
		<script >
			function search(){
				
				var mark=document.getElementById("search").value;
				mark=encodeURI(mark);
				alert(mark);

				$.ajax({  
	                url: '${pageContext.request.contextPath }/findCarByMark.action?mark='+mark,  
	                type: 'GET',  
	                dataType:'json', 
	                cache: false,  
	                error: erryFunction,  //错误执行方法    
	                success: carFunction //成功执行方法    
	            }) ;
			}
			function carFunction(car){
				
				car=carInfo(car.id, car.mark, car.brand, car.subject, car.item, car.createTime);
				$("#cars").html(car);
				
			}
			$( function () {
				
			$.ajax({  
                url: '${pageContext.request.contextPath }/findAllCar.action',  
                type: 'GET',  
                dataType:'json', 
                //contentType:'application/json;charset=utf-8',
                cache: false,  
                error: erryFunction,  //错误执行方法    
                success: allCarFunction //成功执行方法    
            }) ;
			});
			
			 function erryFunction() {  
	                alert("error");  
	            }  
			 function allCarFunction(cars){
				 
				 var carList="";
				 for(var i in cars){
					 carList+=carInfo(cars[i].id,cars[i].mark, cars[i].brand, cars[i].subject, cars[i].item,cars[i].createTime);
				 }
				 
				 $("#cars").html(carList);
			 }
			 var carInfo=function(id,mark,brand,subject,item,createTime){
					var car='<tr>';
					car+='<td>'+id+'</td>';
					car+='<td>'+mark+'</td>';
					car+='<td>'+brand+'</td>';
					car+='<td>'+subject+'</td>';
					car+='<td>'+item+'</td>';
					car+='<td>'+new Date(createTime).toLocaleString()+'</td>';
					car+='<td>';
					car+='<a onclick="carDetails(this);">';
					car+='<img class="f_data" src="img/details.png" />';
					car+='</a>';
					car+='</td>';
					car+='<td class="width200">';
					car+='<a onclick="modifyCar(this);">';
					car+='<img class="f_data" src="img/modify1.png">';
					car+='</a>';
					car+='<a onclick="deleteCar(this);">';
					car+='<img class="f_data" src="img/delete1.png" />';
					car+='</a>';
					car+='</td>';
				    car+='</tr>';					
					 return car;
				}
			 function carDetails(btn){
				 
				 var id=$(btn).parent().parent().children().eq(0).text();
					location.href="${pageContext.request.contextPath }/getCarDetails.action?id="+id;
					
			 }
			 function deleteCar(btn){
				 var id=$(btn).parent().parent().children().eq(0).text();
					location.href="${pageContext.request.contextPath }/deleteCar.action?id="+id;
			 }
			 function modifyCar(btn){
				 
				 var id=$(btn).parent().parent().children().eq(0).text();
					location.href="${pageContext.request.contextPath }/goModifyCar.action?id="+id;
					
			 }
		</script>

</html>