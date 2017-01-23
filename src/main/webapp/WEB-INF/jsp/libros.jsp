<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<c:forEach items="${libros}" var="item">
			<div class="row">
				<ul>
					<li><c:out value="${item.titulo}" /></li>
					<li><c:out value="${item.autor}" /></li>
					<li><c:out value="${item.genero}" /></li>
				</ul>
			</div>
		</c:forEach>
	</div>
</body>
</html>