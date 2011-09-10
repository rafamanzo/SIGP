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
@Table(name = "GRUPO")
public class Grupo {
	private Long idGrupo;
	private String nome;
	private List<LinhaPesquisa> pesquisas = new ArrayList<LinhaPesquisa>();

	public Grupo() {
	}

	public Grupo(String name, List<LinhaPesquisa> pesquisas) {
		this.nome = name;
		this.pesquisas = pesquisas;
	}

	public Grupo(String name) {
		this.nome = name;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "GRUPO_LINHAP", joinColumns = { @JoinColumn(name = "GRUPO_ID") }, inverseJoinColumns = { @JoinColumn(name = "LINHAP_ID") })
	public List<LinhaPesquisa> getPesquisas() {
		return pesquisas;
	}

	public void setPesquisas(List<LinhaPesquisa> pesquisas) {
		this.pesquisas = pesquisas;
	}

	@Id
	@GeneratedValue
	@Column(name = "GRUPO_ID")
	public Long getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}

	@Column(name = "GRUPO_NOME", nullable = false, length = 255)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Grupo [idGrupo=" + idGrupo + ", nome=" + nome + ", pesquisas="
				+ pesquisas + "]";
	}

	
}