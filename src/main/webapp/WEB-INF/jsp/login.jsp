<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page session="true"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="url" value="${pageContext.request.requestURL}"/>
<c:set var="server" value="${pageContext.request.serverName}" />
<c:set var="localName" value="${pageContext.request.localName}" />
<c:set var="scheme" value="${pageContext.request.scheme}" />
<c:set var="servletContextPath" value="${pageContext.servletContext.contextPath}" />
<c:set var="servletContextName" value="${pageContext.servletContext.servletContextName}" />
<c:set var="uri" value="${pageContext.request.requestURI}" />
<c:set var="page" value="${pageContext.page}" />

<!DOCTYPE html>
<html lang="en">

<!-- Header -->
<jsp:include page="fragments/header.jsp" />

<!-- Javascript & Css Login -->
<link rel="stylesheet" href="resources/css/login.css"
	type="text/css" media="all">
<script src="resources/js/login.js"></script>

<!-- Body -->
<body>
	
	<p>PATH: <c:out value="${path}"></c:out></p>
	<p>URL: <c:out value="${url}"></c:out></p>
	<p>SERVER:<c:out value="${server}"></c:out></p>
	<p>LOCALNAME: <c:out value="${localName}"></c:out></p>
	<p>SCHEME: <c:out value="${scheme}"></c:out></p>
	<p>SERVLETCONTEXTPATH: <c:out value="${servletContextPath}"></c:out></p>
	<p>SERVLETCONTEXTNAME: <c:out value="${servletContextName}"></c:out></p>
	<p>URI: <c:out value="${uri}"></c:out></p>
	<p>PAGE: <c:out value="${page}"></c:out></p>
	
	<h1>WANSHITONG</h1>
	<h2>Log in to your Account</h2>
	<div class="container-agile">
		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="alert alert-info">${msg}</div>
		</c:if>
		<form name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method='POST'>
			<input type="text" id="username" name="username"
				placeholder="Username" required="required" /> <input
				type="password" id="password" name="password" placeholder="Password"
				required="required" />
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
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</div>

	<jsp:include page="fragments/footer.jsp" />
</body>

</html>