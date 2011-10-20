package sigp.src;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.caelum.vraptor.Resource;

@Entity
@Resource
@Table(name = "DISCIPLINA")
public class Disciplina {
	private String sigla;
	private String nome;
	private String ementa;
	private Long idDisciplina;
    private Grupo grupo;

	
    @ManyToOne
    @JoinColumn(name = "GRUPO_ID", nullable = false)
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Column(name = "DISCIPLINA_SIGLA", nullable = false, length = 15)
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Column(name = "DISICPLINA_NOME", nullable = false, length = 255)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "DISCIPLINA_EMENTA", nullable = false, length = 510)
	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	@Id
	@GeneratedValue
	@Column(name = "DISCIPLINA_ID")
	public Long getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	@Override
	public String toString() {
		return "Disciplina [sigla=" + sigla + ", nome=" + nome + ", ementa="
				+ ementa + ", idDisciplina=" + idDisciplina + ", grupos=" + "]";
	}

}
