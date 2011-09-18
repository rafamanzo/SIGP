package sigp.src.dao;

import br.com.caelum.vraptor.ioc.Component;
import org.hibernate.Session;
import org.hibernate.Transaction;

import sigp.src.Projeto;

import java.util.List;

@Component
public class ProjetoDao {
	private final Session session;

	public ProjetoDao(Session session) {
		this.session = session;
	}

	public Projeto getProjeto(Long id) {
		return (Projeto) this.session.load(Projeto.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Projeto> list() {
		return this.session.createCriteria(Projeto.class).list();
	}

	public void save(Projeto p) {
		Transaction t = this.session.beginTransaction();
		this.session.save(p);
		t.commit();
	}

	public void update(Projeto p) {
		Transaction t = this.session.beginTransaction();
		this.session.update(p);
		t.commit();
	}

	public void delete(Projeto p) {
		Transaction t = this.session.beginTransaction();
		this.session.delete(p);
		t.commit();
	}
}
