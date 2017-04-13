<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<!-- Menu -->
<div class="menu">
	<div class="container-fluid">
		<div class="navbar-header">
			<a href="${pageContext.request.contextPath}">Wanshitong</a>
		</div>
		<div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="${pageContext.request.contextPath}/login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<li><a href="wanshitong.service.logout()"><span
							class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</div>
<!-- Form Logout -->
<div style="display: none">
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</div>