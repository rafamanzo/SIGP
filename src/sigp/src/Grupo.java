package sigp.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

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
import javax.persistence.Transient;

import br.com.caelum.vraptor.Resource;

@Entity
@Resource
@Table(name = "GRUPO")
public class Grupo {
	private Long idGrupo;
	private String nome;
	private Grupo responsavel;
	private List<LinhaPesquisa> pesquisas = new ArrayList<LinhaPesquisa>();
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	private List<Filiacao> filiacoes = new ArrayList<Filiacao>();

	public Grupo() {
	}

	public Grupo(String name, List<LinhaPesquisa> pesquisas) {
		this.nome = name;
		this.pesquisas = pesquisas;
	}

	public Grupo(String name) {
		this.nome = name;
	}

	@OneToMany(mappedBy = "grupo")
	public List<Filiacao> getFiliacoes() {
		return filiacoes;
	}

	public void setFiliacoes(List<Filiacao> filiacoes) {
		this.filiacoes = filiacoes;
	}

	@ManyToOne
	@JoinColumn(name = "RESPONSAVEL_ID")
	public Grupo getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Grupo responsavel) {
		this.responsavel = responsavel;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "GRUPO_LINHAP", joinColumns = { @JoinColumn(name = "GRUPO_ID") }, inverseJoinColumns = { @JoinColumn(name = "LINHAP_ID") })
	public List<LinhaPesquisa> getPesquisas() {
		return pesquisas;
	}

	public void setPesquisas(List<LinhaPesquisa> pesquisas) {
		this.pesquisas = pesquisas;
	}

	@OneToMany(mappedBy = "grupo")
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
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
	
	@Transient
	public List<Projeto> getProjetos() {
		LinhaPesquisa pesquisa;
		List<Projeto> projetos = new ArrayList<Projeto>();
		Iterator<LinhaPesquisa> pesquisasit = pesquisas.iterator();
		
		while(pesquisasit.hasNext()){
			pesquisa = pesquisasit.next();
			projetos.addAll(pesquisa.getProjetos());
		}
		
		return projetos;
	}
	
	@Transient
	public List<Publicacao> getPublicacoes() {
		Projeto projeto;
		List<Publicacao> publicacoes = new ArrayList<Publicacao>();
		Iterator<Projeto> projetos = this.getProjetos().iterator();
		
		while(projetos.hasNext()){
			projeto = projetos.next();
			publicacoes.addAll(projeto.getPublicacoes());
		}
		
		return publicacoes;
	}

	@Override
	public String toString() {
		return "Grupo [idGrupo=" + idGrupo + ", nome=" + nome
				+ ", responsavel=" + responsavel + ", pesquisas=" + pesquisas
				+ "]";
	}

}
