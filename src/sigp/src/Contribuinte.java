package sigp.src;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;



import br.com.caelum.vraptor.Resource;

@Entity
@Resource
@Table(name = "CONTRIBUINTE")
public class Contribuinte {
	private Long idContribuinte;
	private String nome;
	private List<Publicacao> publicacoes = new ArrayList<Publicacao>();
	private Usuario usuario;
	
	@OneToOne(mappedBy = "usuario")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CONTRIBUINTE_PUBLICACAO", 
				joinColumns = { @JoinColumn(name = "CONTRIBUINTE_ID") }, 
				inverseJoinColumns = { @JoinColumn(name = "PUBLICACAO_ID") })
	public List<Publicacao> getPublicacoes() {
		return publicacoes;
	}
	public void setPublicacoes(List<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
	}
	
	@Id @GeneratedValue @Column(name = "CONTRIBUINTE_ID")
	public Long getIdContribuinte() {
		return idContribuinte;
	}
	public void setIdContribuinte(Long idContribuinte) {
		this.idContribuinte = idContribuinte;
	}
	
	@Column(name = "CONTRIBUINTE_NOME", nullable = false, length = 255)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
