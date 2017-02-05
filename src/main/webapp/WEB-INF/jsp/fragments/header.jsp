<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>Wanshitong</title>

<!-- Icons -->
<link rel="shortcut icon" href="resources/ico/favicon.ico"
	type="image/x-icon" />

<!-- Css -->
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/resources/css/wanshitong.css" var="wanshitongCss" />
<spring:url
	value="http://cdnjs.cloudflare.com/ajax/libs/pure/0.6.2/pure-min.css"
	var="pureCss" />

<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${wanshitongCss}" rel="stylesheet" />
<link href="${pureCss}" rel="stylesheet" />

<!-- Javascript -->
<spring:url value="/resources/js/jquery-3.1.1.min.js" var="jqueryJs" />
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/resources/js/wanshitong.js" var="wanshitongJs" />

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