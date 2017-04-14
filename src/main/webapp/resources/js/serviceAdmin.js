var admin = admin || {};

admin.service = (function() {

	function agregarLibro() {

		$.ajax({
			url : wanshitong.service.getContextPath() + '/admin/agregarLibro',
			data : $('#formAgregarLibro').serialize(),
			dataType : "json",
			method : "POST"
		}).done(function(data) {
			$('#modalAgregarLibro').modal("toggle");
			alert.utils.mostrarMensajes(data.response, data.status);
			setTimeout(function() {
				location.reload()
			}, 5000);
		});

		event.preventDefault();

	}

	function eliminarLibro(id) {
		
		var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
		var csrfToken = $("meta[name='_csrf']").attr("content");
		
	    var data = {};
	    
	    data[csrfParameter] = csrfToken;
	    data["id"] = id;
		
		$.ajax({
			url : wanshitong.service.getContextPath() + "/admin/eliminarLibro",
			data : data,
			dataType : "json",
			method : "POST"
		}).done(function(data) {
			$('#modalConfirmacion').modal("toggle");
			alert.utils.mostrarMensajes(data.response, data.status);
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