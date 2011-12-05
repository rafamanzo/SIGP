package sigp.test.controllers;

//import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sigp.src.Contribuinte;
import sigp.src.TipoUsuario;
import sigp.src.Usuario;
import sigp.src.controllers.UsuarioController;
import sigp.src.dao.UsuarioDao;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

public class UsuarioControllerTest {

    UsuarioController controller;
    Result result;
    private Validator validator;
    private UsuarioController controlmock;
    UsuarioDao dao;

    File avatar;
    TipoUsuario tipoUsuario;
    String senha;
    String login;
    Contribuinte contribuinte;

    List<Usuario> usuarios;

    @Before
    public void setUp() throws Exception {
        result = mock(Result.class);
        dao = mock(UsuarioDao.class);
        validator = mock(Validator.class);
        controller = new UsuarioController(result, validator, dao);

        controlmock = mock(UsuarioController.class);
        when(result.redirectTo(UsuarioController.class))
                .thenReturn(controlmock);
        when(validator.onErrorForwardTo(controller)).thenReturn(controlmock);
        setUpDao();
    }

    private void setUpDao() {
        usuarios = new ArrayList<Usuario>();
        {
            Usuario usuario = new Usuario();
            Contribuinte contribuinte = mock(Contribuinte.class);
            usuario.setContribuinte(contribuinte);

            usuario.setLogin("mgerosa");
            usuario.setSenha("engsoft");

            usuarios.add(usuario);
        }

        {
            Usuario usuario = new Usuario();
            Contribuinte contribuinte = mock(Contribuinte.class);
            usuario.setContribuinte(contribuinte);

            usuario.setLogin("jleandro");
            usuario.setSenha("vision");

            usuarios.add(usuario);
        }

        when(dao.list()).thenReturn(usuarios);
        when(dao.pegaUsuarioPorLogin("mgerosa")).thenReturn(usuarios.get(0));
        when(dao.pegaUsuarioPorLogin("jleandro")).thenReturn(usuarios.get(1));
    }

    @After
    public void tearDown() throws Exception {
        controller = null;
        result = null;
        dao = null;
        usuarios = null;
    }

    @Test
    public void testVerifica() {
        controller.verifica("ninguem", "nada");
        verify(controlmock).index();
    }

    @Test
    public void testSalva() {
        // Testar tentativa de persistencia de usuario ja existente
        Usuario u = usuarios.get(0);
        controller.salva(u, "engsoft");
        verify(result).include("usuarioJaExistente", "Login nao disponivel.");

        // Testar insercao persistencia de novo usuario
        Usuario unovo = new Usuario();
        unovo.setLogin("newnuser");
        unovo.setSenha("newpssd");
        controller.salva(unovo, "newpssd");
        verify(dao).save(unovo);
    }

}
