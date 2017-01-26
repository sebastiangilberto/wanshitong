document.addEventListener("load", function() {
	setTimeout(hideURLbar, 0);
}, false);
function hideURLbar() {
	window.scrollTo(0, 1);
}

$("#loginForm").validify({
	onSubmit : function(e, $this) {
		$this.find('.alert').removeClass('hidden')
	},
	onFormSuccess : function(form) {
		console.log("Form is valid now!")
	},
	onFormFail : function(form) {
		console.log("Form is not valid :(")
	}
});