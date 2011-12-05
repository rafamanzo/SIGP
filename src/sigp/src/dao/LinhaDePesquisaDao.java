package sigp.src.dao;

import sigp.src.LinhaPesquisa;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class LinhaDePesquisaDao {
	private final Session session;

	public LinhaDePesquisaDao(Session session) {
		this.session = session;
	}

	public LinhaPesquisa getLinhaPesquisa(Long id) {
		return (LinhaPesquisa) session.get(LinhaPesquisa.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<LinhaPesquisa> list() {
		return this.session.createCriteria(LinhaPesquisa.class).list();
	}
	
	public void save(LinhaPesquisa linhapesquisa) {
		Transaction tx = session.beginTransaction();
		session.save(linhapesquisa);
		tx.commit();
	}

	public void update(LinhaPesquisa linhapesquisa) {
		Transaction tx = session.beginTransaction();
		session.update(linhapesquisa);
		tx.commit();
	}
	
	public void delete(LinhaPesquisa linhapesquisa) {
		Transaction tx = session.beginTransaction();
		session.delete(linhapesquisa);
		tx.commit();
	}
}
