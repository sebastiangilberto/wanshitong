<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="container">
	<hr>
	<footer>
		<p id="copyright">&copy; Sebastian Gilberto</p>
		<a id="sgilbertoLink" href="https://github.com/sgilberto">https://github.com/sgilberto</a>
	</footer>
</div>

<spring:url value="/resources/js/jquery-3.1.1.min.js" var="jqueryJs" />
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/resources/js/wanshitong.js" var="wanshitongJs" />

<script src="${jqueryJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="${wanshitongJs}"></script>