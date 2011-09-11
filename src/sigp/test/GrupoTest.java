package sigp.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sigp.src.Grupo;
import sigp.src.LinhaPesquisa;
import sigp.src.Projeto;

public class GrupoTest {
    
    private Grupo grupo;
    private List<LinhaPesquisa> pesquisas;
    private List<Projeto> projetos1;
    private List<Projeto> projetos2;

    @Before
    public void setUp() throws Exception {
	grupo = criarGrupo();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deveriaDevolverNome() {
	assertSame("Deveria devolver o nome do Grupo",
		"Grupo de Sistemas de Software", grupo.getNome());
    }
    
    @Test
    public void deveriaDevolverLinhasPesquisa() {
	assertSame("Deveria devolver o nome da primeira linha de pesquisa", "Métodos Ágeis",
		grupo.getPesquisas().get(0).getNome());
	assertSame("Deveria devolver o nome da segunda linha de pesquisa",
		"Software Livre", grupo.getPesquisas().get(1).getNome());
	assertArrayEquals(pesquisas.toArray(), grupo.getPesquisas().toArray());
    }
    
    @Test
    public void deveriaDevolverProjetosDeCadaLinhaDePesquisa() {
	assertSame("Deveria devolver o nome do primeiro projeto da primeira linha de pesquisa", "Métodos de Otimização",
		grupo.getPesquisas().get(0).getProjetos().get(0).getDescricao());
	assertSame("Deveria devolver o nome do segundo projeto da primeira linha de pesquisa", "Uso eficaz de Métricas",
		grupo.getPesquisas().get(0).getProjetos().get(1).getDescricao());
	
	
	assertSame("Deveria devolver o nome do primerio projeto da segunda linha de pesquisa",
		"Achmus", grupo.getPesquisas().get(1).getProjetos().get(0).getDescricao());
	assertSame("Deveria devolver o nome do segundo projeto da segunda linha de pesquisa",
		"Arquimedes", grupo.getPesquisas().get(1).getProjetos().get(1).getDescricao());	
	
	assertArrayEquals(projetos1.toArray(), grupo.getPesquisas().get(0).getProjetos().toArray());
	assertArrayEquals(projetos2.toArray(), grupo.getPesquisas().get(1).getProjetos().toArray());
    }
    
    private Grupo criarGrupo(){
	
	Projeto projeto11 = mock(Projeto.class);
	Projeto projeto12 = mock(Projeto.class);	
	Projeto projeto21 = mock(Projeto.class);
	Projeto projeto22 = mock(Projeto.class);	
	
	when(projeto11.getDescricao()).thenReturn("Métodos de Otimização");
	when(projeto12.getDescricao()).thenReturn("Uso eficaz de Métricas");
	when(projeto21.getDescricao()).thenReturn("Achmus");
	when(projeto22.getDescricao()).thenReturn("Arquimedes");
	
	LinhaPesquisa linha1 = mock(LinhaPesquisa.class);
	LinhaPesquisa linha2 = mock(LinhaPesquisa.class);	
	
	when(linha1.getNome()).thenReturn("Métodos Ágeis");
	when(linha2.getNome()).thenReturn("Software Livre");
	
	projetos1 = new ArrayList<Projeto>(2);
	projetos2 = new ArrayList<Projeto>(2);
	
	projetos1.add(projeto11);
	projetos1.add(projeto12);
	
	projetos2.add(projeto21);
	projetos2.add(projeto22);
	
	when(linha1.getProjetos()).thenReturn(projetos1);
	when(linha2.getProjetos()).thenReturn(projetos2);	
	
	pesquisas = new ArrayList<LinhaPesquisa>(2);
	pesquisas.add(linha1);
	pesquisas.add(linha2);	
	
	grupo = new Grupo();
	grupo.setNome("Grupo de Sistemas de Software");
	grupo.setPesquisas(pesquisas);

	return grupo;	
    }
}
