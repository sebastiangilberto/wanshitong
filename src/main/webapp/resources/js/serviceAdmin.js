var admin = admin || {};

admin.service = (function() {

	function agregarLibro() {

		$.ajax({
			url : wanshitong.service.getContextPath() + '/catalogo/agregarLibro',
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

		$.ajax({
			url : wanshitong.service.getContextPath() + "/catalogo/eliminarLibro",
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

	return {
		agregarLibro : agregarLibro,
		eliminarLibro : eliminarLibro
	};
})();