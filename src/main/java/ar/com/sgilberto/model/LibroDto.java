package ar.com.sgilberto.model;

public class LibroDto {

	private Integer id;

	private String titulo;

	private String autor;

	private String genero;

	private String tapa;

	public LibroDto() {

	}

	public LibroDto(String titulo, String autor, String genero, String tapa) {
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.tapa = tapa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTapa() {
		return tapa;
	}

	public void setTapa(String tapa) {
		this.tapa = tapa;
	}

}
