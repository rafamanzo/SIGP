package sigp.test;

import static org.junit.Assert.*;

import java.io.File;

import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sigp.src.Contribuinte;
import sigp.src.TipoUsuario;
import sigp.src.Usuario;

public class UsuarioTest {

    Usuario usuario;
    File avatar;
    Contribuinte contribuinte;

    @Before
    public void setUp() throws Exception {
	criarUsuario();
    }

    @After
    public void tearDown() throws Exception {
	usuario = null;
    }

    @Test
    public void deveriaDevolverOLoginDoUsuario() {
	assertEquals("magerosa", usuario.getLogin());
    }

    @Test
    public void deveriaDevolverOPasswordDoUsuario() {
	assertEquals("0ca290254c08590dae516265a68ba950", usuario.getSenha());
    }

    @Test
    public void deveriaVerificarAExistenciaDeAvatar() {
	assertNotNull(usuario.getAvatar());
    }

    @Test
    public void deveriaVerificarAExistenciaDeContribuinte() {
	assertNotNull(usuario.getContribuinte());
	assertEquals(usuario.getContribuinte().getNome(),
		"Marco Aurelio Gerosa");
    }

    private void criarUsuario() {
	usuario = new Usuario();
	avatar = mock(File.class);
	contribuinte = mock(Contribuinte.class);

	when(contribuinte.getNome()).thenReturn("Marco Aurelio Gerosa");

	usuario.setLogin("magerosa");
	usuario.setSenha("pressmanschach");
	usuario.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
	usuario.setAvatar(avatar);
	usuario.setContribuinte(contribuinte);

    }

}
