package ar.com.sgilberto.enumerator;

public enum TrxStatus {

	SUCCESS("SUCESS", "Success"),

	ERROR("ERROR", "Error");

	private String codigo;

	private String descripcion;

	private TrxStatus(String codigo, String descripcion) {
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