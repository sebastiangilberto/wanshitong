package ar.com.sgilberto.model;

public class UsuarioDto {

	private String username;

	private String password;
	
	private String email;

	public UsuarioDto() {

	}

	public UsuarioDto(String usuario, String password) {
		this.username = usuario;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
