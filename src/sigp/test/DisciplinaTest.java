package sigp.test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.util.ArrayList;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sigp.src.Grupo;
import sigp.src.Disciplina;
import sigp.src.LinhaPesquisa;

public class DisciplinaTest {

    private Disciplina disciplina;    
    private ArrayList<Grupo> grupos;

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
		"Gerenciamento de projeto. An�lise e especifica��o de requisitos.",
		disciplina.getEmenta());
    }

    @Test
    public void deveriaDevolverGrupos() {
	assertSame("Deveria devolver o primeiro grupo", "Grupo de Engenharia de Software",
		disciplina.getGrupos().get(0).getNome());
	assertSame("Deveria devolver o segundo grupo",
		"Grupo de Computação Gráfica", disciplina.getGrupos().get(1)
			.getNome());	
    }
    
    @Test
    public void deveriaDevolverLinhaPesquisaDeGrupos() {
	assertSame("Deveria devolver a primeira Linha de Pesquisa do Grupo 1", "Métodos Ágeis",
		disciplina.getGrupos().get(0).getPesquisas().get(0).getNome());
	assertSame("Deveria devolver a segunda Linha de Pesquisa do Grupto 1",
		"Software Livre", disciplina.getGrupos().get(0).getPesquisas().get(1).getNome());
	assertSame("Deveria devolver a primeira Linha de Pesquisa do Grupo 2","High Quality Image Rendering",disciplina.getGrupos().get(1).getPesquisas().get(0).getNome());
	assertSame("Deveria devolver a primeira Linha de Pesquisa do Grupo 2","Applied Discrete Geometry",disciplina.getGrupos().get(1).getPesquisas().get(1).getNome());
    }

    @After
    public void tearDown() throws Exception {
	disciplina = null;
	grupos = null;	
    }

  private Disciplina criarDisciplina() {
	disciplina = new Disciplina();
	disciplina.setSigla("MAC0332");
	disciplina.setNome("Engenharia de Software");
	disciplina.setEmenta("Gerenciamento de projeto. Análise e especificação de requisitos.");
	
	grupos = new ArrayList<Grupo>(2);	
	Grupo grupo1 = mock(Grupo.class);
	Grupo grupo2 = mock(Grupo.class);		
	
	LinhaPesquisa linha11 = mock(LinhaPesquisa.class);
	LinhaPesquisa linha12 = mock(LinhaPesquisa.class);
	LinhaPesquisa linha21 = mock(LinhaPesquisa.class);
	LinhaPesquisa linha22 = mock(LinhaPesquisa.class);
	
	ArrayList<LinhaPesquisa> linhas1 = new ArrayList<LinhaPesquisa>(2);
	ArrayList<LinhaPesquisa> linhas2 = new ArrayList<LinhaPesquisa>(2);
	linhas1.add(linha11);
	linhas1.add(linha12);
	linhas2.add(linha21);
	linhas2.add(linha22);	

	when(grupo1.getNome()).thenReturn("Grupo de Engenharia de Software");
	when(grupo1.getPesquisas()).thenReturn(linhas1);
	when(linha11.getNome()).thenReturn("Métodos Ágeis");
	when(linha12.getNome()).thenReturn("Software Livre");
	
	when(grupo2.getNome()).thenReturn("Grupo de Computação Gráfica");
	when(grupo2.getPesquisas()).thenReturn(linhas2);
	when(linha21.getNome()).thenReturn("High Quality Image Rendering");
	when(linha22.getNome()).thenReturn("Applied Discrete Geometry");		
	
	grupos.add(grupo1);
	grupos.add(grupo2);	
	disciplina.setGrupos(grupos);

	return disciplina;
    };

}
