package sigp.src;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.caelum.vraptor.Resource;

@Entity
@Resource
@Table(name = "FILIACAO")
public class Filiacao {
	private Long idFiliacao;
	private Contribuinte contribuinte;
	private Grupo grupo;
	private Date dataInicio;
	private Date dataFim;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_INICIO", nullable = false)
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_FIM", nullable = false)
	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@Id
	@GeneratedValue
	@Column(name = "FILIACAO_ID", nullable = false)
	public Long getIdFiliacao() {
		return idFiliacao;
	}

	public void setIdFiliacao(Long idFiliacao) {
		this.idFiliacao = idFiliacao;
	}

	@ManyToOne
	@JoinColumn(name = "CONTRIBUINTE_ID", nullable = false)
	public Contribuinte getContribuinte() {
		return contribuinte;
	}

	public void setContribuinte(Contribuinte contribuinte) {
		this.contribuinte = contribuinte;
	}

	@ManyToOne
	@JoinColumn(name = "GRUPO_ID", nullable = false)
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "Filiacao [idFiliacao=" + idFiliacao + ", contribuinte="
				+ contribuinte.getNome() + ", grupo=" + grupo.getNome() + "]";
	}

}
