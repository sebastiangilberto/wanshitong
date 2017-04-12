var wanshitong = wanshitong || {};

wanshitong.service = (function() {

	function getContextPath() {
		return window.location.pathname.substring(0, window.location.pathname
				.indexOf("/", 2));
	}

	return {
		getContextPath : getContextPath
	}

})();