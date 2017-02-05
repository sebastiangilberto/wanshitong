$(function() {
	if (document.formLogin.username.value == ""
			&& document.formLogin.password.value == "") {
		alert("Username and password are required");
		document.formLogin.username.focus();
		return false;
	}
	if (document.formLogin.username.value == "") {
		alert("Username is required");
		document.formLogin.username.focus();
		return false;
	}
	if (document.formLogin.password.value == "") {
		alert("Password is required");
		document.formLogin.password.focus();
		return false;
	}
});