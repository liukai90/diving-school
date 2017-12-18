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
			<form>
				<div class="search_add">
					<div class="d_left"></div>
					<div class="d_left2">
						<a href="${pageContext.request.contextPath }/goAddTime.action">
							<img src="img/addStudent.png" />
						</a>
					</div>
				</div>
				<div>
					<table class="datalist">
						<thead>
						<tr>
								<th>ID</th>
								<th>起始</th>
								<th>结束</th>
								<th class="width200">操作</th>
							</tr>
						</thead>
						<tbody id="times">
							
						</tbody>
					</table>
				</div>
				<div class="page">
					<!--<a href="#">上一页</a>
					<a href="#">1</a>
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
					<a href="#">5</a>
					<a href="#">下一页</a>-->
				</div>
			</form>
		</div>
		<jsp:include page="adminFoot.jsp" />
	</body>
	
	<script >
	
	function goModifyTime(btn){
		var id=$(btn).parent().parent().children().eq(0).text();
		location.href="${pageContext.request.contextPath }/goModifyTime.action?id="+id;
	}
	function deleteTime(btn){
		var id=$(btn).parent().parent().children().eq(0).text();
		location.href="${pageContext.request.contextPath }/deleteTime.action?id="+id;
		
	}
		$(function(){
			
			 $.ajax({  
	                url: '${pageContext.request.contextPath }/findAllTime.action',  
	                type: 'GET',  
	                dataType:'json', 
	                contentType:'application/json;charset=utf-8',
	                cache: false,  
	                error: erryFunction,  //错误执行方法    
	                success: allTimeFunction //成功执行方法    
	            }) ;
		});
		function erryFunction() {  
            alert("error");  
        }  
		function allTimeFunction(times){
			
			var timeList="";
			for(var i in times){
				
				timeList+=timeInfo(times[i].id, times[i].startTime, times[i].endTime);
			}
			$("#times").html(timeList);
		}
		var timeInfo=function(id,startTime,endTime){
			
			var time='<tr>';
			time+='<td>'+id+'</td>';
			time+='<td>'+startTime+'</td>';
			time+='<td>'+endTime+'</td>';
			time+='<td class="width200">';
			time+='<a onclick="goModifyTime(this);">';
			time+='<img class="f_data" src="img/modify1.png">';
			time+='</a>';
			time+='<a onclick="deleteTime(this);">';
			time+='<img class="f_data" src="img/delete1.png" />';
			time+='</a>';
			time+='</td>';
		    time+='</tr>';
		    
		    return time;
		}
	</script>


</html>