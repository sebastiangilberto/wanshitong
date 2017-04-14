var wanshitong = wanshitong || {};

wanshitong.service = (function() {

	function getContextPath() {
		var path = window.location.pathname.substring(0, window.location.pathname
				.indexOf("/", 2));
		
		if(path == '/wanshitong'){
			return path;
		} else {
			return '';
		}
	}

	function logout() {
		document.getElementById("logoutForm").submit();
	}

	return {
		getContextPath : getContextPath,
		logout : logout
	}

})();