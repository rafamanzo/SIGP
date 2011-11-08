package sigp.test.controllers;

//import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sigp.src.LinhaPesquisa;
import sigp.src.Projeto;
import sigp.src.controllers.LinhaDePesquisaController;
import sigp.src.dao.LinhaDePesquisaDao;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

public class LinhaDePesquisaControllerTest {

    LinhaDePesquisaController controller;
    Result result;
    LinhaDePesquisaDao dao;
    List<LinhaPesquisa> list;
    List<Projeto> projetos;
    private Validator validator;

    @Before
    public void setUp() throws Exception {
        result = mock(Result.class);
        dao = mock(LinhaDePesquisaDao.class);
        validator = mock(Validator.class);
        controller = new LinhaDePesquisaController(result, validator, dao);

        LinhaDePesquisaController controlmock = mock(LinhaDePesquisaController.class);
        when(result.redirectTo(LinhaDePesquisaController.class)).thenReturn(
                controlmock);
        when(validator.onErrorForwardTo(controller)).thenReturn(controlmock);

        setUpDao();
    }

    private void setUpDao() {
        list = new ArrayList<LinhaPesquisa>();
        {
            LinhaPesquisa l = new LinhaPesquisa();
            LinhaPesquisa subl = new LinhaPesquisa();
            l.setIdPesquisa(1L);
            l.setNome("Pesquisa 1");
            l.setProjetos(projetos);
            l.setSubLinha(subl);
            list.add(l);
        }
        when(dao.list()).thenReturn(list);
        when(dao.getLinhaPesquisa(1L)).thenReturn(list.get(0));
    }

    @After
    public void tearDown() throws Exception {
        controller = null;
        result = null;
        dao = null;
    }

    @Test
    public void testIndex() {
        controller.index();
        verify(result).include("linhasdepesquisa", list);
    }

}
