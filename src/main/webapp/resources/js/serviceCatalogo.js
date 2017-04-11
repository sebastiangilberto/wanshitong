var catalogo = catalogo || {};

catalogo.service = (function() {

	function agregarLibro() {

		$.ajax({
			url : '/catalogo/agregarLibro',
			data : $('#formAgregarLibro').serialize(),
			dataType : "json",
			method : "POST"
		}).done(function(data) {
			$('#modalAgregarLibro').modal("toggle");
			catalogo.vista.mostrarMensajes(data.response, data.status);
			setTimeout(function() {
				location.reload()
			}, 5000);
		});

		event.preventDefault();

	}

	function eliminarLibro(id) {

		var data = {
			id : id
		}

		var requestContextPath = this.getContextPath();

		$.ajax({
			url : requestContextPath + "/catalogo/eliminarLibro",
			data : data,
			dataType : "json",
			method : "POST"
		}).done(function(data) {
			$('#modalConfirmacion').modal("toggle");
			catalogo.vista.mostrarMensajes(data.response, data.status);
			setTimeout(function() {
				location.reload()
			}, 5000);
		});

		event.preventDefault();

	}

	function getContextPath() {
		return window.location.pathname.substring(0, window.location.pathname
				.indexOf("/", 2));
	}

	return {
		agregarLibro : agregarLibro,
		eliminarLibro : eliminarLibro,
		getContextPath : getContextPath
	};
})();