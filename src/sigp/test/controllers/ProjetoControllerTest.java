package sigp.test.controllers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

import sigp.src.Filiacao;
import sigp.src.LinhaPesquisa;
import sigp.src.Projeto;
import sigp.src.Publicacao;
import sigp.src.controllers.ProjetoController;

import sigp.src.dao.ProjetoDao;

public class ProjetoControllerTest {

    ProjetoController controller;
    Result result;
    ProjetoDao dao;
    List<Projeto> projetos;
    private Validator validator;

    @Before
    public void setUp() throws Exception {
        result = mock(Result.class);
        dao = mock(ProjetoDao.class);
        validator = mock(Validator.class);
        controller = new ProjetoController(result, validator, dao);

        ProjetoController controlmock = mock(ProjetoController.class);
        when(result.redirectTo(ProjetoController.class))
                .thenReturn(controlmock);
        when(validator.onErrorForwardTo(controller)).thenReturn(controlmock);
        
        setUpDao();
    }

    private void setUpDao() {
        projetos = new ArrayList<Projeto>();
        {
            Projeto p = new Projeto();
            p.setIdProjeto(1L);
            p.setNome("Projeto 1");
            p.setFinanciamento("Fapesp");
            p.setDescricao("Metodos de Otimizacao");

            List<LinhaPesquisa> linhas = new ArrayList<LinhaPesquisa>(2);
            LinhaPesquisa linha1 = mock(LinhaPesquisa.class);
            LinhaPesquisa linha2 = mock(LinhaPesquisa.class);
            linhas.add(linha1);
            linhas.add(linha2);

            List<Publicacao> publicacoes = new ArrayList<Publicacao>(2);
            Publicacao publicacao1 = mock(Publicacao.class);
            Publicacao publicacao2 = mock(Publicacao.class);
            publicacoes.add(publicacao1);
            publicacoes.add(publicacao2);

            List<Filiacao> filiados = new ArrayList<Filiacao>(2);
            Filiacao filiacao1 = mock(Filiacao.class);
            Filiacao filiacao2 = mock(Filiacao.class);
            filiados.add(filiacao1);
            filiados.add(filiacao2);

            p.setLinhasDePesquisa(linhas);
            p.setPublicacoes(publicacoes);
            projetos.add(p);
        }

        {
            Projeto p = new Projeto();
            p.setIdProjeto(1L);
            p.setNome("Projeto 2");
            p.setFinanciamento("CNPq");
            p.setDescricao("Metodos de Criptografia");

            List<LinhaPesquisa> linhas = new ArrayList<LinhaPesquisa>(2);
            LinhaPesquisa linha1 = mock(LinhaPesquisa.class);
            LinhaPesquisa linha2 = mock(LinhaPesquisa.class);
            linhas.add(linha1);
            linhas.add(linha2);

            List<Publicacao> publicacoes = new ArrayList<Publicacao>(2);
            Publicacao publicacao1 = mock(Publicacao.class);
            Publicacao publicacao2 = mock(Publicacao.class);
            publicacoes.add(publicacao1);
            publicacoes.add(publicacao2);

            List<Filiacao> filiados = new ArrayList<Filiacao>(2);
            Filiacao filiacao1 = mock(Filiacao.class);
            Filiacao filiacao2 = mock(Filiacao.class);
            filiados.add(filiacao1);
            filiados.add(filiacao2);

            p.setLinhasDePesquisa(linhas);
            p.setPublicacoes(publicacoes);
            projetos.add(p);
        }
        when(dao.list()).thenReturn(projetos);
        when(dao.getProjeto(1L)).thenReturn(projetos.get(0));
        when(dao.getProjeto(2L)).thenReturn(projetos.get(1));
    }

    @After
    public void tearDown() throws Exception {
        controller = null;
        result = null;
        dao = null;
        projetos = null;
    }

    @Test
    public void testIndex() {
        controller.main();
        verify(result).include("projetos", projetos);
    }

    @Test
    public void testSalva() {
        Projeto p = projetos.get(0);
        controller.salva(p);
        verify(dao).save(p);
    }

    @Test
    public void testMsg() {
        String msg = "message";
        controller.msg(msg);
        verify(result).include("mensagem", msg);
    }

    @Test
    public void testInfoProjeto() {
        Projeto projeto = dao.getProjeto(1L);
        controller.infoProjeto(1L);
        verify(result).include("projeto", projeto);
    }

}
