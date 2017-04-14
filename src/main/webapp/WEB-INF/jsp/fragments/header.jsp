<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<head>
<title>Wanshitong</title>

<!-- Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- Icons -->
<link rel="shortcut icon" href="/resources/ico/favicon.ico"
	type="image/x-icon" />

<!-- Css -->
<spring:url value="/resources/css/wanshitong.css"
	var="wanshitongCss" />
<spring:url value="/resources/css/bootstrap.min.css"
	var="bootstrapCss" />

<link href="${wanshitongCss}" rel="stylesheet" />
<link href="${bootstrapCss}" rel="stylesheet" />

<!-- Javascript -->
<spring:url value="/resources/js/jquery-3.1.1.min.js"
	var="jqueryJs" />
<spring:url value="/resources/js/bootstrap.min.js"
	var="bootstrapJs" />
<spring:url value="/resources/js/wanshitong.js"
	var="wanshitongJs" />

<script src="${jqueryJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="${wanshitongJs}"></script>


<!-- Fonts -->
<link rel="stylesheet"
	href="//fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900"
	type="text/css" media="all">
<link rel="stylesheet"
	href="//fonts.googleapis.com/css?family=Montserrat:400,700"
	type="text/css" media="all">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"
	type="text/css" media="all">
</head>