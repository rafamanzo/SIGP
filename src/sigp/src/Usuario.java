package sigp.src;



import javax.persistence.Entity;

import javax.persistence.Table;

import br.com.caelum.vraptor.Resource;

@Entity
@Resource
@Table(name = "USUARIO")
public class Usuario {
	private Long idUsuario;
	private String cpf;
	private String tipo;
	private String senha;
	private String login;
	
	public Long getIdPessoa() {
		return idUsuario;
	}
	public void setIdPessoa(Long idPessoa) {
		this.idUsuario = idPessoa;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	
	
}
