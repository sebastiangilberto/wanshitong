<!DOCTYPE html>
<html lang="en">

<!-- Head -->
<head>

<!-- Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- Custom-Style-Sheet -->
<link rel="stylesheet" href="resources/css/bootstrap.css"
	type="text/css" media="all">
<link rel="stylesheet" href="resources/css/validify.css" type="text/css"
	media="all">
<link rel="stylesheet" href="resources/css/style.css" type="text/css"
	media="all">

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

<!-- Javascript -->
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script src="resources/js/validify.js"></script>
<script src="resources/js/login.js"></script>

</head>

<jsp:include page="fragments/header.jsp" />

<!-- Body -->
<body>

	<div class="containerw3layouts-agileits">

		<form action="#" method="post" id="loginForm" novalidate>
			<div class="form-group agileits-w3layouts">
				<input type="email" class="form-control agileinfo textbox"
					name="email" required placeholder="Email">
			</div>
			<div class="form-group w3-agile password">
				<input type="password" class="form-control w3-agileits textbox"
					required placeholder="Password">
			</div>
			<div class="form-group w3-agile submit">
				<button class="btn btn-default btn-osx w3-agileits btn-lg" disabled
					type="submit">
					<i class="fa agileinfo fa-arrow-circle-right"></i>
				</button>
			</div>
			<div class="alert agileits-w3layouts alert-success hidden"
				role="alert">Login Successful!</div>
		</form>

	</div>

</body>

<jsp:include page="fragments/footer.jsp" />

</html>