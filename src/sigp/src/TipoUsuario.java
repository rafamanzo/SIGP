package sigp.src;

public enum TipoUsuario {
	USUARIO("Usuario"), ADMINISTRADOR("Administrador");
	private String tipoUsuario;
	
	private TipoUsuario(String tipoUsuario) {		
		this.tipoUsuario = tipoUsuario;
	}

	public String getTipoUsuario(){
		return tipoUsuario;
	}
}
