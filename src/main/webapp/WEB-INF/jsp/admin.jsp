<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<!-- Header -->
<jsp:include page="fragments/header.jsp" />

<!-- Javascript && Css Admin -->
<link rel="stylesheet" href="${path}/resources/css/admin.css" type="text/css"
	media="all">
<script src="https://api.filestackapi.com/filestack.js"></script>
<script src="${path}/resources/js/alertUtils.js"></script>
<script src="${path}/resources/js/catalogo.js"></script>
<script src="${path}/resources/js/serviceCatalogo.js"></script>
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

	<jsp:include page="fragments/menu.jsp"></jsp:include>

	<div class="container-fluid main">

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