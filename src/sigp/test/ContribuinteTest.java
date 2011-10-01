package sigp.test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sigp.src.Contribuinte;
import sigp.src.Publicacao;
import sigp.src.TipoUsuario;
import sigp.src.Usuario;

public class ContribuinteTest {

    private Contribuinte contribuinte;
    private List<Publicacao> publicacoes;
    private Publicacao publicacao1, publicacao2;
    private Usuario usuario;

    @Before
    public void setUp() throws Exception {
	contribuinte = criarContribuinte();
    }

    @After
    public void tearDown() throws Exception {
	contribuinte = null;
    }

    @Test
    public void deviaDevolverNomeDoContribuinte() {
	assertEquals(contribuinte.getNome(), "Marco Aurelio Gerosa");
    }

    @Test
    public void deviaDevolverListaDePublicacoesDoContribuinte() {
	assertArrayEquals(contribuinte.getPublicacoes().toArray(),
		publicacoes.toArray());
    }

    @Test
    public void deviaDevolverTipoDeUsuarioDoContribuinte() {
	assertEquals(contribuinte.getUsuario().getTipoUsuario(),
		TipoUsuario.USUARIO);
    }

    private Contribuinte criarContribuinte() {

	contribuinte = new Contribuinte();
	publicacoes = new ArrayList<Publicacao>(2);

	publicacao1 = mock(Publicacao.class);
	publicacao2 = mock(Publicacao.class);

	publicacoes.add(publicacao1);
	publicacoes.add(publicacao2);

	usuario = mock(Usuario.class);
	when(usuario.getTipoUsuario()).thenReturn(TipoUsuario.USUARIO);

	contribuinte.setNome("Marco Aurelio Gerosa");
	contribuinte.setPublicacoes(publicacoes);
	contribuinte.setUsuario(usuario);

	return contribuinte;
    }

}
