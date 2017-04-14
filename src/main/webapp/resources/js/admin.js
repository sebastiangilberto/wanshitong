var admin = admin || {};

admin.vista = (function() {

})();

$(function() {
	$('#tablaLibros').DataTable();
});

$(function() {
	$('#btnModalAgregarLibro').on('click', function(e) {
		$('#modalAgregarLibro').modal('show');
	});
	
	$('#btnAgregarLibro').click(function() {
		admin.service.agregarLibro()
	});

	$('.btnEliminarLibro').on('click', function(e) {
		e.preventDefault();
		var id = $(this).closest('tr').data('id');
		$('#modalConfirmacion').data('id', id).modal('show');
	});

	$('#btnEliminarLibro').click(function() {
		var id = $('#modalConfirmacion').data('id');
		admin.service.eliminarLibro(id);
	});
});
