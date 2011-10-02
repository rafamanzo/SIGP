package sigp.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sigp.src.Contribuinte;
import sigp.src.Filiacao;
import sigp.src.Grupo;
import sigp.src.Projeto;

public class FiliacaoTest {

    private Filiacao filiacao;
    private Contribuinte contribuinte;
    private Grupo grupo;
    private List<Projeto> projetos;

    @Before
    public void setUp() throws Exception {
	filiacao = criarFiliacao();
    }

    @After
    public void tearDown() throws Exception {
	filiacao = null;
	contribuinte = null;
	grupo = null;
	projetos = null;
    }

    @Test
    public void deveriaDevolverRespectivoContribuinte() {
	assertNotNull(filiacao.getContribuinte());
	assertNotNull(filiacao.getGrupo());
	assertSame(filiacao.getProjetos(), this.projetos);
    }

    @Test
    public void deveriaDevolverNomesDosProjetosDoFiliado() {
	assertEquals(
		"Deveria devolver o Nome do projeto 1 em que o Filiado participa",
		"Projeto Gamma", filiacao.getProjetos().get(0).getNome());
	assertEquals(
		"Deveria devolver o Nome do projeto 2 em que o Filiado participa",
		"Projeto Beta", filiacao.getProjetos().get(1).getNome());
    }

    @Test
    public void deveriaDevolverFinanciamentosDosProjetosDoFiliado() {
	assertEquals("Deveria devolver a Agencia Financiadora do projeto 1",
		"Fapesp", filiacao.getProjetos().get(0).getFinanciamento());
	assertEquals("Deveria devolver a Agencia Financiadora do projeto 2",
		"CNPq", filiacao.getProjetos().get(1).getFinanciamento());
    }

    @Test
    public void deveriaDevolverDescricaoDosProjetosDoFiliado() {
	assertEquals(
		"Deveria devolver a Descricao do projeto 1 em que o Filiado participa",
		"Metodos de Otimizacao", filiacao.getProjetos().get(0)
			.getDescricao());
	assertEquals(
		"Deveria devolver a Descricao do projeto 2 em que o Filiado participa",
		"Metodos de Criptografia", filiacao.getProjetos().get(1)
			.getDescricao());
    }

    @Test
    public void deveriaDevolverFinanciamentoDoProjetoDoFiliado() {
	assertEquals("Deveria devolver a Agencia Financiadora do projeto 1",
		"Fapesp", filiacao.getProjetos().get(0).getFinanciamento());
	assertEquals("Deveria devolver a Agencia Financiadora do projeto 2",
		"CNPq", filiacao.getProjetos().get(1).getFinanciamento());
    }

    @Test
    public void deveriaDevolverNomeDoRespectivoContribuinte() {
	assertEquals(filiacao.getContribuinte().getNome(),
		"Marco Aurelio Gerosa");
    }

    private Filiacao criarFiliacao() {

	filiacao = new Filiacao();
	contribuinte = mock(Contribuinte.class);
	grupo = mock(Grupo.class);

	when(contribuinte.getNome()).thenReturn("Marco Aurelio Gerosa");
	when(grupo.getNome()).thenReturn("Grupo de Sistemas");

	Projeto projeto1 = new Projeto();
	Projeto projeto2 = new Projeto();

	projeto1.setNome("Projeto Gamma");
	projeto1.setDescricao("Metodos de Otimizacao");
	projeto1.setFinanciamento("Fapesp");

	projeto2.setNome("Projeto Beta");
	projeto2.setDescricao("Metodos de Criptografia");
	projeto2.setFinanciamento("CNPq");

	projetos = new ArrayList<Projeto>(2);
	projetos.add(projeto1);
	projetos.add(projeto2);

	filiacao.setProjetos(projetos);
	filiacao.setContribuinte(contribuinte);
	filiacao.setGrupo(grupo);

	return filiacao;
    }

}
