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
@Table(name = "RELACAO_PESQUISA")
public class RelacaoPesquisa {
    private Long idRelacaoPesquisa;
    private Contribuinte contribuinte;
    private LinhaPesquisa linhaPesquisa;
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
    @Column(name = "RELACAO_PESQUISA_ID", nullable = false)
    public Long getIdRelacaoPesquisa() {
		return idRelacaoPesquisa;
    }

    public void setIdRelacaoPesquisa(Long idRelacaoPesquisa) {
    	this.idRelacaoPesquisa = idRelacaoPesquisa;
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
    @JoinColumn(name = "LINHA_PESQUISA_ID", nullable = false)
    public LinhaPesquisa getLinhaPesquisa() {
    	return linhaPesquisa;
    }

    public void setLinhaPesquisa(LinhaPesquisa linhaPesquisa) {
    	this.linhaPesquisa = linhaPesquisa;
    }



    @Override
    public String toString() {
	return "RelacaoPesquisa [idRelacaoPesquisa=" + idRelacaoPesquisa + ", contribuinte="
		+ contribuinte.getNome() + ", linhaPesquisa=" + linhaPesquisa.getNome() + "]";
    }

}
