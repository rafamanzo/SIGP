package sigp.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sigp.src.Grupo;
import sigp.src.LinhaPesquisa;

public class GrupoTest {
    
    private Grupo grupo;
    private List<LinhaPesquisa> pesquisas;

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
	assertSame("Deveria devolver a primeira linha de pesquisa", "Sistemas",
		grupo.getPesquisas().get(0).getName());
	assertSame("Deveria devolver a segunda linha de pesquisa",
		"Bancos de Dados", grupo.getPesquisas().get(1)
			.getName());
	assertArrayEquals(pesquisas.toArray(), grupo.getPesquisas().toArray());
    }
    
    private Grupo criarGrupo(){
	grupo = new Grupo();
	grupo.setNome("Grupo de Sistemas de Software");
	
	pesquisas = new ArrayList<LinhaPesquisa>(2);
	pesquisas.add(new LinhaPesquisa("Sistemas"));
	pesquisas.add(new LinhaPesquisa("Bancos de Dados"));
	
	grupo.setPesquisas(pesquisas);	
	return grupo;	
    }
}
