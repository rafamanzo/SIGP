package sigp.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import sigp.src.Filiacao;
import sigp.src.Projeto;
import sigp.src.Publicacao;

public class ProjetoTest {

    private Projeto projeto;
    List<Publicacao> publicacoes;
    List<Filiacao> filiados;
    Filiacao filiacao11, filiacao12, filiacao21, filiacao22;

    @Before
    public void setUp() throws Exception {
	projeto = criarProjeto();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deveriaDevolverDescricao() {
	assertSame("Deveria devolver a Descricao do projeto",
		"Metodos de Otimizacao", projeto.getDescricao());
    }

    @Test
    public void deveriaDevolverFinanciamento() {
	assertSame("Deveria devolver a Agencia Financiadora do projeto",
		"Fapesp", projeto.getFinanciamento());
    }

   

    @Test
    public void deveriaDevolverAListaDePublicacoesComOTamanhoCerto() {
	assertEquals(2, publicacoes.size());
	assertEquals(publicacoes.get(0).getTitulo(), "publicacao um");
	assertEquals(publicacoes.get(1).getTitulo(), "publicacao dois");
    }

    public Projeto criarProjeto() {
	projeto = new Projeto();

	projeto.setNome("Projeto Gamma3");
	projeto.setDescricao("Metodos de Otimizacao");
	projeto.setFinanciamento("Fapesp");

	publicacoes = new ArrayList<Publicacao>(2);
	Publicacao publicacao1 = mock(Publicacao.class);
	Publicacao publicacao2 = mock(Publicacao.class);

	publicacao1.setTitulo("publicacao um");
	publicacao2.setTitulo("publicacao dois");

	publicacoes.add(publicacao1);
	publicacoes.add(publicacao2);

	when(publicacao1.getTitulo()).thenReturn("publicacao um");
	when(publicacao2.getTitulo()).thenReturn("publicacao dois");

	filiados = new ArrayList<Filiacao>(2);
	filiacao11 = mock(Filiacao.class);
	filiacao12 = mock(Filiacao.class);
	filiacao21 = mock(Filiacao.class);
	filiacao22 = mock(Filiacao.class);

	when(filiacao11.getIdFiliacao()).thenReturn((long) 11);
	when(filiacao12.getIdFiliacao()).thenReturn((long) 12);
	when(filiacao21.getIdFiliacao()).thenReturn((long) 21);
	when(filiacao22.getIdFiliacao()).thenReturn((long) 22);

	filiados.add(filiacao11);
	filiados.add(filiacao12);
	filiados.add(filiacao21);
	filiados.add(filiacao22);

	return projeto;

    }

}
