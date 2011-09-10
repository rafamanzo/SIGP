package sigp.src;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.caelum.vraptor.Resource;

@Entity
@Resource
@Table(name = "PUBLICACAO")
public class Publicacao {
	private Long idPublicacao;
	private String titulo;
	private Veiculo veiculo;
	private String autor;
	private Date data;
	private List<Grupo> grupos = new ArrayList<Grupo>();


	public Publicacao() {
	}
	
	public Publicacao(String titulo, Veiculo veiculo, String autor, Date data, List<Grupo> grupos) {
		this.autor = autor;
		this.data = data;
		this.grupos = grupos;
		this.titulo = titulo;
		this.veiculo = veiculo;
				
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable( name = "PUB_GRUPO",
	joinColumns = @JoinColumn( name = "PUBLICACAO_ID"), 
	inverseJoinColumns = @JoinColumn (name = "GRUPO_ID"))
	public List<Grupo> getGrupos() {
		return grupos;
	}


	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	
	@Id @GeneratedValue @Column(name = "PUBLICACAO_ID")
	public Long getIdPublicacao() {
		return idPublicacao;
	}
	public void setIdPublicacao(Long idPublicacao) {
		this.idPublicacao = idPublicacao;
	}
	
	@Column(name = "PUBLICACAO_TITULO", nullable = false, length = 255)
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Enumerated (EnumType.STRING)
	@Column(name = "PUBLICACAO_VEICULO", nullable = false, length = 20)
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	@Column(name = "PUBLICACAO_AUTOR", nullable = false, length = 255)
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	@Temporal (TemporalType.DATE)
	@Column(name = "PUBLICACAO_DATA", nullable = false)
	public Date getData() {
		return data;
	}
	
	
	public void setData(Date data) {
		this.data = data;
	}
	
	
		
	
}