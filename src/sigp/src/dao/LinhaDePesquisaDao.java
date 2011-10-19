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
	
	public void save(LinhaPesquisa grupo) {
		Transaction tx = session.beginTransaction();
		session.save(grupo);
		tx.commit();
	}

	public void update(LinhaPesquisa grupo) {
		Transaction tx = session.beginTransaction();
		session.update(grupo);
		tx.commit();
	}
	
	public void delete(LinhaPesquisa grupo) {
		Transaction tx = session.beginTransaction();
		session.delete(grupo);
		tx.commit();
	}
}
