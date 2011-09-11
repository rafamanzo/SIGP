package sigp.src.dao;

import br.com.caelum.vraptor.ioc.Component;
import org.hibernate.Session;
import org.hibernate.Transaction;

import sigp.src.Membro;

import java.util.List;

@Component
public class MembroDao {
	private final Session session;

	public MembroDao(Session session) {
		this.session = session;
	}

	public void save(Membro m) {
		Transaction t = this.session.beginTransaction();
		this.session.save(m);
		t.commit();
	}

	public Membro getMembro(Long id) {
		return (Membro) this.session.load(Membro.class, id);
	}

	public List<Membro> list() {
		return this.session.createCriteria(Membro.class).list();
	}

	public void update(Membro mem) {
		Membro m = getMembro(mem.getIdMembro());
		m.copy(mem);

		Transaction t = this.session.beginTransaction();
		this.session.update(m);
		t.commit();
	}

	public void delete(Membro m) {
		Transaction t = this.session.beginTransaction();
		this.session.delete(m);
		t.commit();
	}
}
