package sigp.src;

public enum Veiculo {
	JOURNAL("Journal"), CONFERENCIA("Conferencia"), PUBLICACAO("Publicacao");
	private String tipoVeiculo;
	
	private Veiculo(String tipoVeiculo) {		
		this.tipoVeiculo = tipoVeiculo;
	}

	public String getTipoVeiculo(){
		return tipoVeiculo;
	}
}
