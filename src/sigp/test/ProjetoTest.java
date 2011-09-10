package sigp.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import sigp.src.LinhaPesquisa;
import sigp.src.Projeto;
import sigp.src.Grupo;
import sigp.src.Membro;

public class ProjetoTest {
    
    private Projeto projeto;
    List<Grupo> grupos;
    List<Membro> membros;
    Membro membro11, membro12, membro21, membro22;    
    

    @Before
    public void setUp() throws Exception {
	projeto = criarProjeto();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deveriaDevolverDescricao() {
	assertSame("Deveria devolver a Descricao do projeto", "Métodos de Otimização",
		projeto.getDescricao());
    }
    
    @Test
    public void deveriaDevolverFinanciamento() {
	assertSame("Deveria devolver a Agencia Financiadora do projeto", "Fapesp",
		projeto.getFinanciamento());
    }
    
    @Test
    public void deveriaDevolverGruposEnvolvidosNoProjeto(){
	assertSame("Deveria devolver o primeiro grupo da lista de Grupos envolvidos no projeto", grupos.get(0).getNome(), 
		projeto.getGrupos().get(0).getNome());
	assertSame("Deveria devolver o segundo grupo da lista de Grupos envolvidos no projeto", grupos.get(1).getNome(), 
		projeto.getGrupos().get(1).getNome());	
	assertArrayEquals(grupos.toArray(), projeto.getGrupos().toArray());
    }
    
    @Test
    //Trocar depois para Pessoas envolvidas no projeto
    public void deveriaDevolverMembrosEnvolvidosNoProjeto(){
	assertSame("Deveria devolver o id do primeiro membro de envolvidos no projeto", membro11.getIdMembro(), 
		projeto.getMembros().get(0).getIdMembro());
	assertSame("Deveria devolver o id do primeiro membro de envolvidos no projeto", membro12.getIdMembro(), 
		projeto.getMembros().get(1).getIdMembro());
	assertSame("Deveria devolver o id do primeiro membro de envolvidos no projeto", membro21.getIdMembro(), 
		projeto.getMembros().get(2).getIdMembro());
	assertSame("Deveria devolver o id do primeiro membro de envolvidos no projeto", membro22.getIdMembro(), 
		projeto.getMembros().get(3).getIdMembro());
	
	assertArrayEquals(membros.toArray(), projeto.getMembros().toArray());
    }
    
    
    
    public Projeto criarProjeto(){
	projeto = new Projeto();
	
	projeto.setDescricao("Métodos de Otimização");
	projeto.setFinanciamento("Fapesp");	
	
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
	when(linha11.getName()).thenReturn("Métodos Ágeis");
	when(linha12.getName()).thenReturn("Software Livre");
	
	when(grupo2.getNome()).thenReturn("Grupo de Computação Gráfica");
	when(grupo2.getPesquisas()).thenReturn(linhas2);
	when(linha21.getName()).thenReturn("High Quality Image Rendering");
	when(linha22.getName()).thenReturn("Applied Discrete Geometry");	
	
	grupos.add(grupo1);
	grupos.add(grupo2);	
	
	projeto.setGrupos(grupos);	
	
	membros = new ArrayList<Membro>(2);	
	membro11 = mock(Membro.class);
	membro12 = mock(Membro.class);	
	membro21 = mock(Membro.class);
	membro22 = mock(Membro.class);	
	
	when(membro11.getIdMembro()).thenReturn((long) 11);
	when(membro12.getIdMembro()).thenReturn((long) 12);
	when(membro21.getIdMembro()).thenReturn((long) 21);
	when(membro22.getIdMembro()).thenReturn((long) 22);
	
	membros.add(membro11);
	membros.add(membro12);
	membros.add(membro21);
	membros.add(membro22);
	
	projeto.setGrupos(grupos);
	projeto.setMembros(membros);
	return projeto;
	
    }
    

}
