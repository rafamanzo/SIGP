package sigp.src.dao;

import sigp.src.Disciplina;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class DisciplinaDao {
	private final Session session;

	public DisciplinaDao(Session session) {
		this.session = session;
	}

	public Disciplina getDisciplina(Long id) {
		return (Disciplina) session.get(Disciplina.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Disciplina> list() {
		return this.session.createCriteria(Disciplina.class).list();
	}
	
	public void save(Disciplina disciplina) {
		Transaction tx = session.beginTransaction();
		session.save(disciplina);
		tx.commit();
	}

	public void update(Disciplina disciplina) {
		Transaction tx = session.beginTransaction();
		session.update(disciplina);
		tx.commit();
	}

	public void delete(Disciplina disciplina) {
		Transaction tx = session.beginTransaction();
		session.delete(disciplina);
		tx.commit();
	}
}
