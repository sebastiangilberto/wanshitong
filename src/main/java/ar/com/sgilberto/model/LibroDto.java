package ar.com.sgilberto.model;

public class LibroDto {

	private String titulo;

	private String autor;

	private String genero;

	public LibroDto() {

	}

	public LibroDto(String titulo, String autor, String genero) {
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
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

}
