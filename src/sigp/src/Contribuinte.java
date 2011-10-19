package sigp.src;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;



import br.com.caelum.vraptor.Resource;

@Entity
@Resource
@Table(name = "CONTRIBUINTE")
public class Contribuinte {
	private Long idContribuinte;
	private String nome;
	private List<Publicacao> publicacoes = new ArrayList<Publicacao>();
	private List<Filiacao> filiacoes = new ArrayList<Filiacao>();
	private List<Projeto> projetos = new ArrayList<Projeto>();
	private List<LinhaPesquisa> linhasDePesquisa = new ArrayList<LinhaPesquisa>();
	private Date participacaoDataInicio;
	private Date participacaoDataFim;
	private Date pesquisaDataInicio;
	private Date pesquisaDataFim;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "PESQUISA_DATA_INICIO", nullable = false, insertable = false, updatable = false)
	public Date getPesquisaDataInicio() {
		return pesquisaDataInicio;
	}
	public void setPesquisaDataInicio(Date pesquisaDataInicio) {
		this.pesquisaDataInicio = pesquisaDataInicio;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "PESQUISA_DATA_INICIO", nullable = false)
	public Date getPesquisaDataFim() {
		return pesquisaDataFim;
	}
	public void setPesquisaDataFim(Date pesquisaDataFim) {
		this.pesquisaDataFim = pesquisaDataFim;
	}	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CONTRIBUINTE_LINHAP", 
				joinColumns = { @JoinColumn(name = "CONTRIBUINTE_ID") }, 
				inverseJoinColumns = { @JoinColumn(name = "LINHAP_ID") })
	public List<LinhaPesquisa> getLinhasDePesquisa() {
		return linhasDePesquisa;
	}
	public void setLinhasDePesquisa(List<LinhaPesquisa> linhasDePesquisa) {
		this.linhasDePesquisa = linhasDePesquisa;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PARTICIPACAO_DATA_INICIO", nullable = false)
	public Date getParticipacaoDataInicio() {
		return participacaoDataInicio;
	}
	public void setParticipacaoDataInicio(Date participacaoDataInicio) {
		this.participacaoDataInicio = participacaoDataInicio;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "PARTICIPACAO_DATA_FIM", nullable = false)
	public Date getParticipacaoDataFim() {
		return participacaoDataFim;
	}
	public void setParticipacaoDataFim(Date participacaoDataFim) {
		this.participacaoDataFim = participacaoDataFim;
	}

	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CONTRIBUINTE_PROJETO", 
				joinColumns = { @JoinColumn(name = "CONTRIBUINTE_ID") }, 
				inverseJoinColumns = { @JoinColumn(name = "PROJETO_ID") })
	public List<Projeto> getProjetos() {
		return projetos;
	}
	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	
	
	private Usuario usuario;
	
	@OneToOne(cascade = CascadeType.ALL)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@OneToMany(mappedBy = "contribuinte")
	public List<Filiacao> getFiliacoes() {
		return filiacoes;
	}
	public void setFiliacoes(List<Filiacao> filiacoes) {
		this.filiacoes = filiacoes;
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
