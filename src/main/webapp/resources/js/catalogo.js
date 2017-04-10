var catalogo = catalogo || {};

catalogo.vista = (function() {

	function mostrarMensajes(mensaje, status) {

		$('.messages-list').children().remove();
		createGenericMessages($('.messages-list'), mensaje, status);
		$('html, body').animate({
			scrollTop : 0
		}, 1500);
	}

	return {
		mostrarMensajes : mostrarMensajes
	}

})();

$(function() {
	$('#tablaLibros').DataTable();
});

$(function() {
	$('#btnAgregarLibro').on('click', function(e) {
		$('#modalAgregarLibro').modal('show');
	});

	$('.btnEliminarLibro').on('click', function(e) {
		e.preventDefault();
		var id = $(this).closest('tr').data('id');
		$('#modalConfirmacion').data('id', id).modal('show');
	});

	$('#btnEliminarLibro').click(function() {
		var id = $('#modalConfirmacion').data('id');
		catalogo.service.eliminarLibro(id);
	});
});
