package sigp.src;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.caelum.vraptor.Resource;

@Entity
@Resource
@Table(name = "FILIACAO")
public class Filiacao {
	private Long idFiliacao;
	private List<Contribuinte> contribuintes = new ArrayList<Contribuinte>();
	private List<Grupo> grupos = new ArrayList<Grupo>();

	@OneToMany
	@JoinTable(name = "FILIACAO_GRUPO",
				joinColumns = @JoinColumn(name = "FILIACAO_ID"),
				inverseJoinColumns = @JoinColumn(name = "GRUPO_ID"))
	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	@OneToMany
	@JoinTable(name = "FILIACAO_CONTRIBUINTE",
				joinColumns = @JoinColumn(name = "FILIACAO_ID"),
				inverseJoinColumns = @JoinColumn(name = "CONTRIBUINTE_ID"))
	public List<Contribuinte> getContribuintes() {
		return contribuintes;
	}

	public void setContribuintes(List<Contribuinte> contribuintes) {
		this.contribuintes = contribuintes;
	}

	@Id
	@GeneratedValue 
	@Column(name = "FILIACAO_ID")
	public Long getIdFiliacao() {
		return idFiliacao;
	}

	public void setIdFiliacao(Long idFiliacao) {
		this.idFiliacao = idFiliacao;
	}
	
}
