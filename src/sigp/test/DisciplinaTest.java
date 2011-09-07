package sigp.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sigp.src.Grupo;
import sigp.src.Disciplina;
import sigp.src.LinhaPesquisa;

public class DisciplinaTest {

    private Disciplina disciplina;
    private List<Grupo> grupos;

    @Before
    public void setUp() throws Exception {
	disciplina = criarDisciplina();
    }

    @Test
    public void deveriaDevolverSigla() {
	assertSame("Deveria devolver a Sigla inserida", "MAC0332",
		disciplina.getSigla());
    }

    @Test
    public void deveriaDevolverNome() {
	assertSame("Deveria devolver o nome da disciplina",
		"Engenharia de Software", disciplina.getNome());
    }

    @Test
    public void deveriaDevolverEmenta() {
	assertSame(
		"Deveria devolver a Ementa inserida",
		"Gerenciamento de projeto. Análise e especificação de requisitos.",
		disciplina.getEmenta());
    }

    @Test
    public void deveriaDevolverGrupos() {
	assertSame("Deveria devolver o primeiro grupo", "Grupo de Sistemas",
		disciplina.getGrupos().get(0).getNome());
	assertSame("Deveria devolver o segundo grupo",
		"Grupo de Bancos de Dados", disciplina.getGrupos().get(1)
			.getNome());
	assertArrayEquals(grupos.toArray(), disciplina.getGrupos().toArray());
    }

    @After
    public void tearDown() throws Exception {
	
    }

    private Disciplina criarDisciplina() {
	disciplina = new Disciplina();
	disciplina.setSigla("MAC0332");
	disciplina.setNome("Engenharia de Software");
	disciplina
		.setEmenta("Gerenciamento de projeto. Análise e especificação de requisitos.");

	List<LinhaPesquisa> pesquisas = new ArrayList<LinhaPesquisa>(2);
	pesquisas.add(new LinhaPesquisa("Sistemas"));
	pesquisas.add(new LinhaPesquisa("Bancos de Dados"));

	// final List<Grupo> grupos = new ArrayList<Grupo>(2);
	grupos = new ArrayList<Grupo>(2);
	grupos.add(new Grupo("Grupo de Sistemas", pesquisas));
	grupos.add(new Grupo("Grupo de Bancos de Dados", pesquisas));

	disciplina.setGrupos(grupos);

	return disciplina;
    };

}
