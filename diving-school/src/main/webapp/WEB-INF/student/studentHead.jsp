<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="headr">
			<div class="left">
				<img src="img/adm.png"/><span>${phone}</span>
			</div>
			<div class="right">
			<a class="fn" href="${pageContext.request.contextPath }/exit.action">退出</a>
			</div>
		</div>
		<div class="navi">
			<ul class="menu" id="me">
				<li class="f">
					<a class="" href="${pageContext.request.contextPath }/stuMainPage.action" >
					<img src="img/sMainPage.png" />
					</a>
				</li>
				<li class="f">
					<a class="" href="${pageContext.request.contextPath }/orderStudyCar.action">
						<img src="img/IStudentCar.png" />
					</a>
				</li>
				<li class="f">
					<a class="" href="${pageContext.request.contextPath }/myOrderPage.action">
						<img src="img/myOrder.png" />
					</a>
				</li>
				<li class="f">
					<a class="" href="${pageContext.request.contextPath }/goStuModifyPersonInformation.action">
						<img src="img/sPersonInformation.png" />
					</a>
				</li>
				<li class="f">
					<a class="" href="${pageContext.request.contextPath }/stuModifyPassword.action">
						<img src="img/sModifyPassword.png" />
					</a>
				</li>
			</ul>
			
		</div>