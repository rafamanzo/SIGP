package sigp.src.dao;

import sigp.src.Publicacao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class PublicacaoDao {
	private final Session session;

	public PublicacaoDao(Session session) {
		this.session = session;
	}

	public Publicacao getPublicacao(Long id) {
		return (Publicacao) session.get(Publicacao.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Publicacao> list() {
		return this.session.createCriteria(Publicacao.class).list();
	}
	
	public void save(Publicacao publicacao) {
		Transaction tx = session.beginTransaction();
		session.save(publicacao);
		tx.commit();
	}

	public void update(Publicacao publicacao) {
		Transaction tx = session.beginTransaction();
		session.update(publicacao);
		tx.commit();
	}

	public void delete(Publicacao publicacao) {
		Transaction tx = session.beginTransaction();
		session.delete(publicacao);
		tx.commit();
	}
}
