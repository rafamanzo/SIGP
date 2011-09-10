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
@Table(name = "PROJETO")
public class Projeto {
	private String descricao;
	private Long idProjeto;
	private String financiamento;
	private List<Grupo> grupos = new ArrayList<Grupo>();
	private List<Membro> membros = new ArrayList<Membro>();
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable( name = "PROJETO_MEMBRO",
	joinColumns = @JoinColumn( name = "PROJETO_ID"), 
	inverseJoinColumns = @JoinColumn (name = "MEMBRO_ID"))
	public List<Membro> getMembros() {
		return membros;
	}
	public void setMembros(List<Membro> membros) {
		this.membros = membros;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable( name = "PROJETO_GRUPO",
	joinColumns = @JoinColumn( name = "PROJETO_ID"), 
	inverseJoinColumns = @JoinColumn (name = "GRUPO_ID"))
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
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
	public void setFinanciamento(String finaciamento) {
		this.financiamento = finaciamento;
	}
	
}
