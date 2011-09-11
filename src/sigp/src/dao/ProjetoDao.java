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

	public void save(Projeto p) {
		Transaction t = this.session.beginTransaction();
		this.session.save(p);
		t.commit();
	}

	public Projeto getProjeto(Long id) {
		return (Projeto) this.session.load(Projeto.class, id);
	}

	public List<Projeto> list() {
		return this.session.createCriteria(Projeto.class).list();
	}

	public void update(Projeto proj) {
		Projeto p = getProjeto(proj.getIdProjeto());
		p.copy(proj);

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
