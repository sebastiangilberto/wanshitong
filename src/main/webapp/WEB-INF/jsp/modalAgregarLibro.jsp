<!-- Modal -->
<div class="modal fade" id="modalAgregarLibro" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header" style="padding: 35px 50px;">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4>
					<span class="glyphicons glyphicons-book-open"></span> Nuevo Libro
				</h4>
			</div>
			<div class="modal-body" style="padding: 40px 50px;">
				<form id="formAgregarLibro">
					<div class="form-group">
						<input name="titulo" placeholder="Titulo" required="required" />
					</div>
					<div class="form-group">
						<input name="autor" placeholder="Autor" required="required" />
					</div>
					<div class="form-group">
						<input name="genero" placeholder="Genero" required="required" />
					</div>
					<div class="form-group">
						<input type="filepicker" name="tapa"
							data-fp-button-text="Agregar Imagen"
							data-fp-apikey="A3Lel4pTUQ0uP92Q4qpHSz"
							data-fp-mimetypes="image/*" data-fp-container="window"
							data-fp-services="IMAGE_SEARCH,COMPUTER,URL"
							onchange="console.log(event.fpfile.url)" />
					</div>
					<button type="submit" class="btn btn-success btn-block"
						onclick="catalogo.service.agregarLibro()">
						<span class="glyphicons glyphicons-ok"></span> Confirmar
					</button>
				</form>
			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-danger btn-default pull-right"
					data-dismiss="modal">
					<span class="glyphicon glyphicon-remove"></span> Cancel
				</button>
			</div>
		</div>

	</div>
</div>