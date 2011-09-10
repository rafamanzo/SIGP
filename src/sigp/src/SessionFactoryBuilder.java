package sigp.src;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@ApplicationScoped
public class SessionFactoryBuilder implements ComponentFactory<SessionFactory> {
	private SessionFactory factory;

	@PostConstruct
	public void inicializa() {
		Configuration conf = new Configuration();
		conf.configure();
		this.factory = conf.buildSessionFactory();
	}

	@PreDestroy
	public void finaliza() {
		this.factory.close();
	}

	public SessionFactory getInstance() {
		return this.factory;
	}
}
