package sigp.src;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LINHAP")
public class LinhaPesquisa {
	private Long idPesquisa;
	private String name;
	
	public LinhaPesquisa() {
	}
	
	public LinhaPesquisa(String name){
		this.name = name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
