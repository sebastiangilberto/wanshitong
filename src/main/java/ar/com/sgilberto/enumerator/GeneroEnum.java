package ar.com.sgilberto.enumerator;

public enum GeneroEnum {

	AVENTURA("AV", "Aventura"),

	ACCION("AC", "Accion"),

	POLICIACO("PO", "Policiaco"),

	SUSPENSO("SU", "Suspenso");

	private String codigo;

	private String descripcion;

	private GeneroEnum(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}
}