<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<!-- Head -->
<head>

<!-- Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- Javascript -->
<link rel="stylesheet" href="resources/css/login.css" type="text/css"
	media="all">
<script src="resources/js/login.js"></script>

</head>

<jsp:include page="fragments/header.jsp" />
<!-- Body -->
<body>

	<h1>Bienvenidos a Wanshitong</h1>

	<div class="container w3layouts agileits">

		<div class="login w3layouts agileits">
			<h2>Sign In</h2>
			<form:form id="loginForm" method="POST"
				action="${pageContext.request.contextPath}/login"
				commandName="UsuarioDto">
				<form:input path="username" placeholder="Username" />
				<form:password path="password" placeholder="Password" />
				<ul class="tick w3layouts agileits">
					<li><input type="checkbox" id="brand1"> <label
						for="brand1"><span></span>Remember me</label></li>
				</ul>
				<div class="send-button w3layouts agileits">
					<input type="submit" value="Sign In">
				</div>
				<a href="#">Forgot Password?</a>
				<div class="clear"></div>
			</form:form>
			<c:if test="${not empty errorMessage}">
				<p class="error">
					<c:out value="${errorMessage}" />
				</p>
			</c:if>
		</div>

		<div class="register w3layouts agileits">
			<h2>Sign Up</h2>
			<form:form id="registerForm" method="POST"
				action="${pageContext.request.contextPath}/register"
				commandName="UsuarioDto">
				<form:input path="username" placeholder="Username" />
				<form:password path="password" placeholder="Password" />
				<form:input path="email" placeholder="Email" />
			</form:form>
			<div class="send-button w3layouts agileits">
				<form>
					<input type="submit" value="Sign Up">
				</form>
			</div>
			<p>
				By creating an account, you agree to our <a
					class="underline w3layouts agileits" href="#">Terms</a>
			</p>
			<div class="clear"></div>
		</div>

	</div>

</body>

<jsp:include page="fragments/footer.jsp" />

</html>