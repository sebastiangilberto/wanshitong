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
<jsp:include page="header.jsp" />

<!-- Javascript && Css Admin -->
<link rel="stylesheet" href="${servletContextPath}/resources/css/admin.css" type="text/css"
	media="all">
<script src="https://api.filestackapi.com/filestack.js"></script>
<script src="${servletContextPath}/resources/js/alertUtils.js"></script>
<script src="${servletContextPath}/resources/js/catalogo.js"></script>
<script src="${servletContextPath}/resources/js/serviceCatalogo.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/material-design-lite/1.1.0/material.min.css"
	type="text/css" media="all">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.13/css/dataTables.material.min.css"
	type="text/css" media="all">
<script
	src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.13/js/dataTables.material.min.js"></script>

<body>

	<jsp:include page="menu.jsp"></jsp:include>

	<div class="container-fluid main">

	<p>PATH: <c:out value="${path}"></c:out></p>
	<p>URL: <c:out value="${url}"></c:out></p>
	<p>SERVER:<c:out value="${server}"></c:out></p>
	<p>LOCALNAME: <c:out value="${localName}"></c:out></p>
	<p>SCHEME: <c:out value="${scheme}"></c:out></p>
	<p>SERVLETCONTEXTPATH: <c:out value="${servletContextPath}"></c:out></p>
	<p>SERVLETCONTEXTNAME: <c:out value="${servletContextName}"></c:out></p>
	<p>URI: <c:out value="${uri}"></c:out></p>
	<p>PAGE: <c:out value="${page}"></c:out></p>
		
		<h1>Title : ${title}</h1>
		<h1>Message : ${message}</h1>

		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				Welcome : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>
	</div>
</body>
</html>