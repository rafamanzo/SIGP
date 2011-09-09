package sigp.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sigp.src.LinhaPesquisa;
import sigp.src.Projeto;

public class LinhaPesquisaTest {
    
    private LinhaPesquisa linhapesquisa;
    private List<Projeto> projetos;


    @Before
    public void setUp() throws Exception {
	linhapesquisa = criarLinhaPesquisa();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deveriaDevolverProjetosDaLinhaDePesquisa() {
	assertSame("Deveria devolver o nome do primeiro projeto da linha de pesquisa",
		"Métodos de Otimização", linhapesquisa.getProjetos().get(0).getDescricao());	
	
	assertSame("Deveria devolver o nome do segundo projeto da linha de pesquisa",
		"Uso eficaz de Métricas", linhapesquisa.getProjetos().get(1).getDescricao());	
	
	assertArrayEquals(projetos.toArray(), linhapesquisa.getProjetos().toArray());
    }
    
    
    LinhaPesquisa criarLinhaPesquisa(){
	Projeto projeto1 = mock(Projeto.class);
	Projeto projeto2 = mock(Projeto.class);	
	
	when(projeto1.getDescricao()).thenReturn("Métodos de Otimização");
	when(projeto2.getDescricao()).thenReturn("Uso eficaz de Métricas");	

	projetos = new ArrayList<Projeto>(2);	
	projetos.add(projeto1);
	projetos.add(projeto2);
	
	linhapesquisa = new LinhaPesquisa();
	linhapesquisa.setProjetos(projetos);	
	
	return linhapesquisa;
	
    }

}
