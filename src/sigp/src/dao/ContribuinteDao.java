package sigp.src.dao;

import sigp.src.Contribuinte;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class ContribuinteDao {
	private final Session session;

	public ContribuinteDao(Session session) {
		this.session = session;
	}

	public Contribuinte getContribuinte(Long id) {
		return (Contribuinte) session.get(Contribuinte.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Contribuinte> list() {
		return this.session.createCriteria(Contribuinte.class).list();
	}
	
	public void save(Contribuinte contrib) {
		Transaction tx = session.beginTransaction();
		session.save(contrib);
		tx.commit();
	}

	public void update(Contribuinte contrib) {
		Transaction tx = session.beginTransaction();
		session.update(contrib);
		tx.commit();
	}

	public void delete(Contribuinte contrib) {
		Transaction tx = session.beginTransaction();
		session.delete(contrib);
		tx.commit();
	}
}
