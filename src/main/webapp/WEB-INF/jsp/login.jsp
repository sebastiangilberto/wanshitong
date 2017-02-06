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

	<h1>Bienvenidos a Wanshitong</h1>

	<div class="container w3layouts agileits">

		<div class="login w3layouts agileits">
			<h2>Sign In</h2>
			<form:form id="loginForm" method="POST"
				action="${pageContext.request.contextPath}/login"
				commandName="UsuarioDto">
				<form:input id="usernameLogin" path="username"
					placeholder="Username" required="required"/>
				<form:password id="passwordLogin" path="password"
					placeholder="Password" required="required"/>
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
			<div class="error">
				<c:if test="${not empty errorMessage}">
					<c:out value="${errorMessage}" />
				</c:if>
			</div>
			<div class="alert alert-success hidden" role="alert">Login
				Successfully</div>
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

<!-- Footer -->
<jsp:include page="fragments/footer.jsp" />

</html>