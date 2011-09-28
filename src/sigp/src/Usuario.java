package sigp.src;



import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import javax.persistence.Table;

import sigp.src.hash.PasswordCodificator;

import br.com.caelum.vraptor.Resource;

@Entity
@Resource
@Table(name = "USUARIO")
public class Usuario {
	private Long idUsuario;
	private byte[] avatar;
	private TipoUsuario tipoUsuario;
	private String senha;
	private String login;
	private Contribuinte contribuinte;
	
	@OneToOne
	@JoinColumn(name = "ID_CONTRIBUINTE")
	public Contribuinte getContribuinte() {
		return contribuinte;
	}
	public void setContribuinte(Contribuinte contribuinte) {
		this.contribuinte = contribuinte;
	}
	
	@Id @GeneratedValue @Column(name = "USUARIO_ID")
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	@Lob
	@Basic(optional = true, fetch = FetchType.EAGER )
	@Column(name = "USUARIO_AVATAR", nullable = true)
	public byte[] getAvatar() {
		return avatar;
	}
	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	@Enumerated (EnumType.STRING)
	@Column(name = "USUARIO_TIPO", nullable = false, length = 50)
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	@Column(name = "USUARIO_SENHA", nullable = false, length = 255)
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		PasswordCodificator p = new PasswordCodificator(senha);
		this.senha = p.codificado();
	}
	
	@Column(name = "USUARIO_LOGIN", nullable = false, length = 50)
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	
	
}
