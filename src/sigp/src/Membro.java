package sigp.src;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.caelum.vraptor.Resource;

@Entity
@Table(name = "MEMBRO")
public class Membro {
	private Long idMembro;
	private String avatar;
	private int nusp;
	private String senha;
	private String login;
	private String tipo;
	private List<Grupo> grupos = new ArrayList<Grupo>();
	
	public Membro() {
	}

//	@OneToOne(mappedBy = "PESSOA_ID")
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable( name = "MEMBRO_GRUPO",
	joinColumns = @JoinColumn( name = "MEMBRO_ID"), 
	inverseJoinColumns = @JoinColumn (name = "GRUPO_ID"))
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	@Id @GeneratedValue @Column(name = "MEMBRO_ID")
	public Long getIdMembro() {
		return idMembro;
	}
	public void setIdMembro(Long idMembro) {
		this.idMembro = idMembro;
	}
	
	@Lob
	@Basic(optional = true, fetch = FetchType.EAGER )
	@Column(name = "MEMBRO_AVATAR", nullable = true)
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	@Column(name = "MEMBRO_NUSP", nullable = false)
	public int getNusp() {
		return nusp;
	}
	public void setNusp(int nusp) {
		this.nusp = nusp;
	}
	
	@Column(name = "MEMBRO_LOGIN", nullable = false)
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	@Column(name = "MEMBRO_SENHA", nullable = false)
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name = "MEMBRO_TIPO", nullable = false)
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void copy(Membro m) {
		this.setAvatar(m.getAvatar());
		this.setGrupos(m.getGrupos());
	}
		
}
