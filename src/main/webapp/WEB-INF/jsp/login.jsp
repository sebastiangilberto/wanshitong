<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<!-- Header -->
<jsp:include page="fragments/header.jsp" />

<!-- Javascript & Css Login -->
<link rel="stylesheet" href="resources/css/login.css" type="text/css"
	media="all">
<script src="resources/js/login.js"></script>

<!-- Body -->
<body>
	<h1>WANSHITONG</h1>
	<h2>Log in to your Account</h2>
	<div class="container-agile">
		<c:if test="${not empty errorMessage}">
			<div class="alert alert-danger" role="alert">
				<c:out value="${errorMessage}" />
			</div>
		</c:if>
		<form:form id="loginForm" method="POST"
			action="${pageContext.request.contextPath}/login"
			commandName="UsuarioDto">
			<form:input id="usernameLogin" path="username" placeholder="Username"
				required="required" />
			<form:password id="passwordLogin" path="password"
				placeholder="Password" required="required" />
			<ul class="agileinfotickwthree">
				<li><input type="checkbox" id="brand1" value=""> <label
					for="brand1"><span></span>Remember me</label></li>
			</ul>
			<div class="submit-button">
				<input type="submit" value="LOGIN">
				<p>
					<a href="#">REGISTER NEW ACCOUNT</a>
				</p>
				<div class="clear"></div>
			</div>
		</form:form>
	</div>

	<jsp:include page="fragments/footer.jsp" />
</body>

</html>