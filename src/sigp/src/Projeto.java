package sigp.src;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.caelum.vraptor.Resource;

@Entity
@Resource
@Table(name = "PROJETO")
public class Projeto {
    
	private Long idProjeto;
    
    @NotEmpty(message = "Projeto precisa ter um nome.")
	private String nome;
    
    @NotEmpty(message = "Projeto precisa ter uma descrição.")
	private String descricao;
    
	private String financiamento;
	
	private List<Publicacao> publicacoes = new ArrayList<Publicacao>();
	private List<LinhaPesquisa> linhasDePesquisa = new ArrayList<LinhaPesquisa>();
	private List<Participacao> participacoes = new ArrayList<Participacao>();

	/*@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CONTRIBUINTE_PROJETO", 
				joinColumns = { @JoinColumn(name = "PROJETO_ID") }, 
				inverseJoinColumns = { @JoinColumn(name = "CONTRIBUINTE_ID") })
	public List<Contribuinte> getContribuintes() {
		return contribuintes;
	}
	public void setContribuintes(List<Contribuinte> contribuintes) {
		this.contribuintes = contribuintes;
	}*/
	@OneToMany(mappedBy = "projeto")
	public List<Participacao> getParticipacoes() {
		return participacoes;
	}
	public void setParticipacoes(List<Participacao> participacoes) {
		this.participacoes = participacoes;
	}
	

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "projetos")
	public List<LinhaPesquisa> getLinhasDePesquisa() {
		return linhasDePesquisa;
	}
	public void setLinhasDePesquisa(List<LinhaPesquisa> linhasDePesquisa) {
		this.linhasDePesquisa = linhasDePesquisa;
	}
	
	

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "projetos")
	public List<Publicacao> getPublicacoes() {
		return publicacoes;
	}
	public void setPublicacoes(List<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
	}	
	
	@Column(name = "PROJETO_NOME", nullable = false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "PROJETO_DESCRICAO", nullable = false, length = 510)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Id @GeneratedValue @Column(name = "PROJETO_ID")
	public Long getIdProjeto() {
		return idProjeto;
	}
	public void setIdProjeto(Long idProjeto) {
		this.idProjeto = idProjeto;
	}
	
	@Column(name = "PROJETO_FINACIAMENTO", nullable = false)
	public String getFinanciamento() {
		return financiamento;
	}
	public void setFinanciamento(String financiamento) {
		this.financiamento = financiamento;
	}

	
	
	public void copy(Projeto p) {
		this.setNome(p.getNome());
		this.setDescricao(p.getDescricao());
		this.setFinanciamento(p.getFinanciamento());
	}

}
