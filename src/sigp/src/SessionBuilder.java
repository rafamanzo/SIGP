package sigp.src;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SessionBuilder implements ComponentFactory<Session> {

	private final SessionFactory factory;
	private Session session;

	public SessionBuilder(SessionFactory factory) {
		this.factory = factory;
	}

	@PostConstruct
	public void inicializa() {
		this.session = this.factory.openSession();
	}

	@PreDestroy
	public void finaliza() {
		this.session.close();
	}

	public Session getInstance() {
		return this.session;
	}
}
