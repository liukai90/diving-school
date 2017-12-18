<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="headr">
			<div class="left">
				<img src="img/adm.png" /><span>${phone}</span>
			</div>
			<div class="right">
				<a class="fn" href="${pageContext.request.contextPath }/exit.action">退出</a>
			</div>
		</div>
		<div class="navi">
			<ul class="menu" id="me">
				<li class="f">
					<a href="${pageContext.request.contextPath }/adminMainPage.action">
						<img src="img/mainPage.png" />
					</a>
				</li>
				<li class="f">
					<a href="${pageContext.request.contextPath }/findAllStudent.action">
						<img src="img/studentManage.png" />
					</a>
				</li>
				<li class="f">
					<a href="${pageContext.request.contextPath }/findAllCarPage.action">
						<img src="img/carManage.png" />
					</a>
				</li>
				<li class="f">
					<a href="${pageContext.request.contextPath }/findAllTimePage.action">
						<img src="img/timeManage.png" />
					</a>
				</li>
				<li class="f">
					<a href="${pageContext.request.contextPath }/bookingManagement.action">
						<img src="img/orderManage.png" />
					</a>
				</li>
				<li class="f">
					<a href="${pageContext.request.contextPath }/getPersonInformation.action">
						<img src="img/personInformation.png" />
					</a>
				</li>
				<li class="f">
					<a href="${pageContext.request.contextPath }/goModifyPassword.action">
						<img src="img/modifyPassword.png" />
					</a>
				</li>
			</ul>

		</div>