$(function() {
	$("#btnAddBook").click(function() {
		$("#modalAddLibro").modal();
	});
});


$(function() {
	$("#sectionTable").hide();
	$('#tableLibros').DataTable();
});

function showCovers() {
	$("#sectionTable").hide();
	$("#sectionCovers").show();
}

function showTabla() {
	$("#sectionCovers").hide();
	$("#sectionTable").show();
}

function removeLibro(id) {
	var $figure = $('#libro_' + id);
	var $fila = $('#fila_' + id);
	var $libroId = $('#id_' + id).text();

	$.ajax({
		url : '/wanshitong/biblioteca/removeLibro/' + $libroId,
		method : "POST",

		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},

		success : function(respuesta) {
			$figure.css("background-color", "#000000");
			$figure.fadeIn(1000).fadeOut(200, function() {
				$figure.remove();
			})
			$fila.css("background-color", "#000000");
			$fila.fadeIn(1000).fadeOut(200, function() {
				$fila.remove();
			})
		},
		error : function() {
		}
	});
	event.preventDefault();
}
