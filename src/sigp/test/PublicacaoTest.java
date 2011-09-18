package sigp.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import sigp.src.Grupo;
import sigp.src.LinhaPesquisa;
import sigp.src.Publicacao;
import sigp.src.Veiculo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PublicacaoTest {    
  
    private Publicacao publicacao;
    private List<Grupo> grupos;
    private SimpleDateFormat formatador = new SimpleDateFormat("dd/mm/yyyy");
    

    @Before
    public void setUp() throws Exception {
	this.publicacao = criarPublicacao();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deveriaDevolverTitulo() {
	assertEquals("Deveria devolver o Titulo da Publicacao", "Service-oriented middleware for the Future Internet: state of the art and research directions",
		publicacao.getTitulo());
    }
    
    @Test
    public void deveriaDevolverVeiculo() {
	assertEquals("Deveria devolver o Ve�culo da Publicacao", "Journal",
		publicacao.getVeiculo().getTipoVeiculo());
    }
    
    @Test
    public void deveriaDevolverAutor() {
	assertEquals("Deveria devolver o Autor da Publicacao", "Marco Gerosa",
		publicacao.getAutor());
    }
    
    @Test
    public void deveriaDevolverData() throws ParseException {
	assertEquals("Deveria devolver a Data da Publicacao", formatador.parse("25/05/2011"),
		publicacao.getData());
    }
    
    @Test
    public void deveriaDevolverGruposEnvolvidosNaPublicacao(){
	assertEquals("Deveria devolver o primeiro grupo da lista de Grupos envolvidos na publicacao", grupos.get(0).getNome(), 
		publicacao.getGrupos().get(0).getNome());
	assertEquals("Deveria devolver o segundo grupo da lista de Grupos envolvidos na publicacao", grupos.get(1).getNome(), 
		publicacao.getGrupos().get(1).getNome());	
	assertArrayEquals(grupos.toArray(), publicacao.getGrupos().toArray());
    }
    
    public Publicacao criarPublicacao() throws ParseException{
	
	publicacao = new Publicacao();			
	
	publicacao.setVeiculo(Veiculo.JOURNAL);
	publicacao.setTitulo("Service-oriented middleware for the Future Internet: state of the art and research directions");
	publicacao.setAutor("Marco Gerosa");	
	
        publicacao.setData(formatador.parse("25/05/2011"));

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
	
	publicacao.setGrupos(grupos);		
	
	return publicacao;
	
    }

}
