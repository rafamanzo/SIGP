package sigp.src;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.caelum.vraptor.Resource;

@Entity
@Resource
@Table(name = "MEMBRO")
public class Membro {
	private Long idMembro;
	private char[] avatar;
	private List<Grupo> grupos = new ArrayList<Grupo>();
	
	public Membro() {
	}

//	@OneToOne(mappedBy = "PESSOA_ID")
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable( name = "MEMBRO_GRUPO",
	joinColumns = @JoinColumn( name = "MEMBRO_ID"), 
	inverseJoinColumns = @JoinColumn (name = "GRUPO_ID"))
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	@Id @GeneratedValue @Column(name = "MEMBRO_ID")
	public Long getIdMembro() {
		return idMembro;
	}
	public void setIdMembro(Long idMembro) {
		this.idMembro = idMembro;
	}
	
	@Lob
	@Basic(optional = true, fetch = FetchType.EAGER )
	@Column(name = "MEMBRO_AVATAR", nullable = true)
	public char[] getAvatar() {
		return avatar;
	}
	public void setAvatar(char[] avatar) {
		this.avatar = avatar;
	}

	
		
}
