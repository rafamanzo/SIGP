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
import javax.persistence.Table;

import br.com.caelum.vraptor.Resource;

@Entity
@Resource
@Table(name = "LINHAP")
public class LinhaPesquisa {
	private Long idPesquisa;
	private String nome;
	private List<Projeto> projetos = new ArrayList<Projeto>();
	
	
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
