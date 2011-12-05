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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.caelum.vraptor.Resource;

@Entity
@Resource
@Table(name = "LINHAP")
public class LinhaPesquisa {
    
	private Long idPesquisa;
	
	@NotEmpty(message = "Linha de pesquisa precisa ter nome.")
	private String nome;
	
	private List<Projeto> projetos = new ArrayList<Projeto>();
	private List<Grupo> grupos = new ArrayList<Grupo>();
	private LinhaPesquisa subLinha;
	private List<RelacaoPesquisa> relacoes = new ArrayList<RelacaoPesquisa>();
	
	/*@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CONTRIBUINTE_LINHAP", 
				joinColumns = { @JoinColumn(name = "LINHAP_ID") }, 
				inverseJoinColumns = { @JoinColumn(name = "CONTRIBUINTE_ID") })
	public List<Contribuinte> getContribuintes() {
		return contribuintes;
	}
	public void setContribuintes(List<Contribuinte> contribuintes) {
		this.contribuintes = contribuintes;
	}*/
	@OneToMany(mappedBy = "linha")
	public List<RelacaoPesquisa> getRelacoes() {
		return relacoes;
	}
	public void setRelacoes(List<RelacaoPesquisa> relacoes) {
		this.relacoes = relacoes;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "SUB_LINHA_ID")
	public LinhaPesquisa getSubLinha() {
		return subLinha;
	}
	public void setSubLinha(LinhaPesquisa subLinha) {
		this.subLinha = subLinha;
	}
	
	
	public LinhaPesquisa() {
	}
	public LinhaPesquisa(String name){
		this.nome = name;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable( name = "LINHAP_PROJETO",
	joinColumns = @JoinColumn( name = "LINHAP_ID"), 
	inverseJoinColumns = @JoinColumn (name = "PROJETO_ID"))
	public List<Projeto> getProjetos() {
		return projetos;
	}
	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "pesquisas")
	public List<Grupo> getGrupos(){
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos){
		this.grupos = grupos;
	}
	
	
	@Id
	@GeneratedValue 
	@Column(name = "LINHAP_ID")
	public Long getIdPesquisa() {
		return idPesquisa;
	}
	public void setIdPesquisa(Long idPesquisa) {
		this.idPesquisa = idPesquisa;
	}
	
	
	@Column(name = "LINHAP_NOME", nullable = false)
	public String getNome() {
		return nome;
	}
	public void setNome(String name) {
		this.nome = name;
	}
	
	
	
	
	
}
