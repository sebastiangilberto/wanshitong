var catalogo = catalogo || {};

catalogo.service = (function() {

	function agregarLibro() {

		$.ajax({
			url : '/wanshitong/catalogo/agregarLibro/',
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

		$.ajax({
			url : '/wanshitong/catalogo/eliminarLibro/' + id,
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

	return {
		agregarLibro : agregarLibro,
		eliminarLibro : eliminarLibro
	};
})();