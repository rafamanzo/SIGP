package sigp.src.dao;

import sigp.src.Grupo;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class GrupoDao {
	private Session session;

	public GrupoDao(Session session) {
		this.session = session;
	}

	public void add(Grupo Grupo) {
		Transaction tx = session.beginTransaction();
		session.save(Grupo);
		tx.commit();
	}

	public Grupo getGrupo(Long id) {
		return (Grupo) session.get(Grupo.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Grupo> getList() {
		return this.session.createCriteria(Grupo.class).list();
	}

	public void delete(Grupo grupo) {
		Transaction tx = session.beginTransaction();
		session.delete(grupo);
		tx.commit();
	}

	public void update(Grupo grupo) {
		Transaction tx = session.beginTransaction();
		session.update(grupo);
		tx.commit();
	}
}
