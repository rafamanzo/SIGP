package sigp.src;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CriaTabela {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Disciplina.class);
		configuration.addAnnotatedClass(Grupo.class);
		configuration.addAnnotatedClass(Membro.class);
		configuration.addAnnotatedClass(Publicacao.class);
		configuration.addAnnotatedClass(Projeto.class);
		configuration.addAnnotatedClass(Veiculo.class);

		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		new SchemaExport(configuration).create(true, true);
		tx.commit();
	}
}
