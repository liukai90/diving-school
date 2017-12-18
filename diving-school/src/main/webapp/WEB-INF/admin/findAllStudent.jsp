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
		<script type="text/javascript" charset="utf-8" src="js/jquery-1.11.1.js"></script>

	</head>

	<body>
		<jsp:include page="adminHead.jsp" />
		<div class="main">
			<!--<form>-->
				<div class="search_add">
					<div class="d_left">
						<img class="cen" src="img/student1.png" />
						<input class="cen" type="text" id="search"/>
						<input class="cen" type="button" value="搜索" onclick="search();" />
					</div>
					<div class="d_left2">
						<a href="${pageContext.request.contextPath }/goAddStudent.action">
							<img src="img/addStudent.png" />
						</a>
					</div>
				</div>
				<div>
					<table class="datalist" >
					<thead>
					<tr >
								<th>ID</th>
								<th>姓名</th>
								<th>性别</th>
								<th>身份证号</th>
								<th>生日</th>
								<th>电话</th>
								<th>报名金额</th>
								<th>报名时间</th>
								<th class="width200">操作</th>
							</tr>
							</thead>
						<tbody id="students">							

						</tbody>
					</table>
				</div>
				<div class="page" id="pageNumber">
				<a onclick="json(this.text);" > </a>
					<!--<a href="#">上一页</a>
					<a href="#">1</a>
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
					<a href="#">5</a>
					<a href="#">下一页</a>-->
				</div>
			<!--</form>-->
		</div>
		<jsp:include page="adminFoot.jsp" />
		</body>
		
				<script>
			function goModifyStudent(btn){
				var id=$(btn).parent().parent().children().eq(0).text();
				location.href="${pageContext.request.contextPath }/modifyStudentById.action?id="+id;
			}
			function deleteStudent(btn){
				var id=$(btn).parent().parent().children().eq(0).text();
				location.href="${pageContext.request.contextPath }/deleteStudentById.action?id="+id;
				
			}
			function search(){
				var name=document.getElementById("search").value;
				name=encodeURI(name);				
				$.ajax({  
	                url: '${pageContext.request.contextPath }/findStudentByName.action?name='+name,  
	                type: 'GET',  
	                dataType:'json', 
	                cache: false,  
	                error: erryFunction,  //错误执行方法    
	                success: studentFunction //成功执行方法    
	            }) ;
			}
			function studentFunction(students){
				var studentList="";
				for(var index in students){
					studentList+=studentInfo(students[index].id,students[index].name,students[index].sex,students[index].idcard,students[index].birth,students[index].phone,students[index].entryFee,students[index].createTime);
				}
				$("#students").html(studentList);
			}
			var studentInfo=function(id,name,sex,idcard,birth,phone,entryFee,createTime){
				var student="<tr>";
				student+="<td>"+id+"</td>";
				student+="<td>"+name+"</td>";
				student+="<td>"+sex+"</td>";
				student+="<td>"+idcard+"</td>";
				student+="<td>"+birth+"</td>";
				student+="<td>"+phone+"</td>";
				student+="<td>"+entryFee+"</td>";
				student+="<td>"+new Date(createTime).toLocaleString()+"</td>";
				student+="<td class='width200'><a onclick='goModifyStudent(this);' ><img class='f_data' src='img/modify1.png'></a><a onclick='deleteStudent(this);'><img class='f_data' src='img/delete1.png' /></a></td></tr>";					
				 //$("#students").append(studens);
				 return student;
				 //$("#students").html(student);
				 //document.getElementById("students").appendChild(studens);
			}
			var pageNum=function(total,pageSize,pageIndex){
				var pages=Math.ceil(total/pageSize);
				console.log(pages);
				console.log(Math.ceil(pageSize/2));
				var page="";
				page+="<a onclick='json("+(pageIndex-1)+");'>上一页</a>";
				if(pageIndex>Math.ceil(pageSize/2)){
					for(var index=pageIndex-Math.floor(pageSize/2);index<=pages;index++){
						if(index==pageIndex+Math.ceil(pageSize/2)){
							break;
						}else{
							page+="<a onclick='json("+index+");'>"+index+"</a>";
						}
					}
				}else{
					for(var index=1;index<=pages;index++){
						if(index==6){
							break;
						}
						page+="<a onclick='json("+index+");'>"+index+"</a>";
					}
				}
				page+="<a onclick='json("+(pageIndex+1)+");'>下一页</a>";
				$("#pageNumber").html(page);
			}

			
		function json(pageIndex) {
	            $.ajax({  
	                url: '${pageContext.request.contextPath }/pagingFindStudent.action?page='+pageIndex+'&pageSize=5',  
	                type: 'GET',  
	                dataType:'json', 
	                contentType:'application/json;charset=utf-8',
	                cache: false,  
	                error: erryFunction,  //错误执行方法    
	                success: allStudentFunction //成功执行方法    
	            }) ;
			
		} 
	            function erryFunction() {  
	                alert("error");  
	            }  
	            function allStudentFunction(dataGridResult) { 
	            	console.log(dataGridResult);
	                var total =dataGridResult.total; 
	                var students=dataGridResult.rows;
	                var studentList;
	                for(var i in students){
	                	studentList+=studentInfo(students[i].id,students[i].name,students[i].sex,students[i].idcard,students[i].birth,students[i].phone,students[i].entryFee,students[i].createTime);
	                	
	                }
	                $("#students").html(studentList);
	                var pageIndex=sessionStorage.getItem("pageIndex");
	                pageNum(total,5,pageIndex);
	              
	                
	            }  
	            $(function(){
	            	json(1);
	            });
		</script>

</html>