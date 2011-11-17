package sigp.test.integration;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sigp.src.LinhaPesquisa;
import sigp.src.Projeto;

import sigp.src.dao.LinhaDePesquisaDao;
import sigp.src.dao.ProjetoDao;

/* Atencao: eh necessario ter pelo menos dois projetos jah cadastrados no sistema */

public class LinhaPesquisaIntegracao {
    
	public static void main(String[] args) {		
		
		Configuration configuration = new Configuration();
		configuration.configure();
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();		

		ProjetoDao dao = new ProjetoDao(session);
		LinhaDePesquisaDao ldao = new LinhaDePesquisaDao(session);
		
		Projeto projeto1 = dao.getProjeto(1L);		
		Projeto projeto2 = dao.getProjeto(2L);		
		
		System.out.println("projeto1 nome =" + projeto1.getNome());
		System.out.println("projeto2 nome =" + projeto2.getNome());
	
		List<Projeto> projetos = new ArrayList<Projeto>();	
		projetos.add(projeto1);
		projetos.add(projeto2);
		
		LinhaPesquisa linhapesquisa = new LinhaPesquisa();
		linhapesquisa.setNome("linha teste de integracao");
		linhapesquisa.setSubLinha(null);
		//linhapesquisa.setSubLinha(ldao.getLinhaPesquisa(1L));
		linhapesquisa.setProjetos(projetos);
		new LinhaDePesquisaDao(session).save(linhapesquisa);
	}
}