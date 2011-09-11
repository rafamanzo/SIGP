package sigp.src;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
	public static void main(String[] args) { /*
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Date data = new Date();
		data.setTime(200);
		try {
			transaction = session.beginTransaction();
			//
			// List<LinhaPesquisa> pesquisas = new ArrayList<LinhaPesquisa>();
			// pesquisas.add(new LinhaPesquisa("Math"));
			// pesquisas.add(new LinhaPesquisa("Computer Science"));

			// Grupo student1 = new Grupo("Eswar", pesquisas);
			// Grupo student2 = new Grupo("Joe", pesquisas);
			// session.save(student1);
			// session.save(student2);

			// List<Grupo> grupo = new ArrayList<Grupo>();
			// grupo.add(new Grupo("Math", pesquisas));
			// grupo.add(new Grupo("Computer Science", pesquisas));
			//
			// Publicacao student1 = new Publicacao("O homem 2",
			// Veiculo.JOURNAL, "Bezerra da Silva", data, grupo);
			// Publicacao student2 = new Publicacao("O homem",
			// Veiculo.CONFERENCIA, "Bezerra da Silva", data, grupo);
			// session.save(student1);
			// session.save(student2);

			transaction = session.beginTransaction();
			Pessoa address1 = new Pessoa("6920251", "Lucas Colucci");
			Pessoa address2 = new Pessoa("9999999", "Chuck Norris");
			Membro student1 = new Membro();
			Membro student2 = new Membro();
			session.save(student1);
			session.save(student2);

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();

		} */
	} 
}
