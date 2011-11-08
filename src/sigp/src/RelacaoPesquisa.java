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
@Table(name = "RELACAOP")
public class RelacaoPesquisa {
    private Long idRelacao;
    private Contribuinte contribuinte;
    private LinhaPesquisa linha;
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
    @Column(name = "RELACAOP_ID", nullable = false)
    public Long getIdRelacao() {
		return idRelacao;
    }
    public void setIdRelacao(Long idRelacao) {
    	this.idRelacao = idRelacao;
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
    @JoinColumn(name = "LINHAP_ID", nullable = false)
    public LinhaPesquisa getLinha() {
    	return linha;
    }
    public void setLinha(LinhaPesquisa linha) {
    	this.linha = linha;
    }



    @Override
    public String toString() {
	return "RelacaoPesquisa [idRelacaoPesquisa=" + idRelacao + ", contribuinte="
		+ contribuinte.getNome() + ", linhaPesquisa=" + linha.getNome() + "]";
    }

}
