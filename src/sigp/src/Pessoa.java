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
//import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.caelum.vraptor.Resource;

@Entity
@Resource
@Table(name = "PESSOA")
public class Pessoa {
	private Long idPessoa;
	private String nusp;
	private String nome;
	private List<Publicacao> publicacoes = new ArrayList<Publicacao>();

	public Pessoa(String nusp, String nome) {
		this.nusp = nusp;
		this.nome = nome;
	}
	
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "PESSOA_ID")
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable( name = "PESSOA_PUBLICACAO",
	joinColumns = @JoinColumn( name = "PESSOA_ID"), 
	inverseJoinColumns = @JoinColumn (name = "PUBLICACAO_ID"))
	public List<Publicacao> getPublicacoes() {
		return publicacoes;
	}
	public void setPublicacoes(List<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
	}
	
	@Id @GeneratedValue @Column(name = "PESSOA_ID")
	public Long getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	@Column(name = "PESSOA_NUSP", nullable = false, length = 50)
	public String getNusp() {
		return nusp;
	}
	public void setNusp(String nusp) {
		this.nusp = nusp;
	}
	
	@Column(name = "PESSOA_NOME", nullable = false, length = 255)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


}
