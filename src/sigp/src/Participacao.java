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
@Table(name = "PARTICIPACAO")
public class Participacao {
    private Long idParticipacao;
    private Contribuinte contribuinte;
    private Projeto projeto;
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
    @Column(name = "PARTICIPACAO_ID", nullable = false)
    public Long getIdParticipacao() {
		return idParticipacao;
    }

    public void setIdParticipacao(Long idParticipacao) {
    	this.idParticipacao = idParticipacao;
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
    @JoinColumn(name = "PROJETO_ID", nullable = false)
    public Projeto getProjeto() {
    	return projeto;
    }

    public void setProjeto(Projeto projeto) {
    	this.projeto = projeto;
    }



    @Override
    public String toString() {
	return "Participacao [idParticipacao=" + idParticipacao + ", contribuinte="
		+ contribuinte.getNome() + ", projeto=" + projeto.getNome() + "]";
    }

}
