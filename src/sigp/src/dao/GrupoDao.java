package sigp.src.dao;

import sigp.src.Grupo;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class GrupoDao {
	private final Session session;

	public GrupoDao(Session session) {
		this.session = session;
	}

	public Grupo getGrupo(Long id) {
		return (Grupo) session.get(Grupo.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Grupo> list() {
		return this.session.createCriteria(Grupo.class).list();
	}
	
	public void save(Grupo grupo) {
		Transaction tx = session.beginTransaction();
		session.save(grupo);
		tx.commit();
	}

	public void update(Grupo grupo) {
		Transaction tx = session.beginTransaction();
		session.update(grupo);
		tx.commit();
	}
	
	public void delete(Grupo grupo) {
		Transaction tx = session.beginTransaction();
		session.delete(grupo);
		tx.commit();
	}
}
