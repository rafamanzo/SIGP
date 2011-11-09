package sigp.src.controllers;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import sigp.src.Projeto;
import sigp.src.dao.ProjetoDao;

@Resource
public class ProjetoController {
    private final Result result;
    private final ProjetoDao dao;
    private Validator validator;

    public ProjetoController(Result result, Validator validator,
            ProjetoDao dao) {
        this.result = result;
        this.validator = validator;
        this.dao = dao;
    }

    @Path("/projeto/")
    public void index() {
        result.include("projetos", dao.list());
    }

    @Path("/projeto/novo")
    public void novo_form() {
        result.include("projetos", dao.list());
    }

    @Path("/projeto/cria")
    public void cria(final Projeto projeto) {
        validator.validate(projeto);
        validator.onErrorForwardTo(this).novo_form();
        dao.save(projeto);
        result.redirectTo(ProjetoController.class).index();
    }

    @Path("/projeto/ver/{id}")
    public void visualiza(Long id) {
        Projeto projeto = dao.getProjeto(id);
        if (projeto == null)
            result.redirectTo(ProjetoController.class).index();
        else
            result.include("projeto", projeto);
    }

    @Path("/projeto/alterar/{id}")
    public void altera_form(Long id) {
        Projeto projeto = dao.getProjeto(id);
        if (projeto == null)
            result.redirectTo(ProjetoController.class).index();
        else
            result.include("projeto", projeto);
    }

    @Path("/projeto/altera")
    public void altera(final Projeto projeto) {
        validator.validate(projeto);
        validator.onErrorForwardTo(this).altera_form(projeto.getIdProjeto());
        dao.update(projeto);
        result.redirectTo(ProjetoController.class).index();
    }

    @Path("/projeto/apagar/{id}")
    public void remove(Long id) {
        Projeto projeto = dao.getProjeto(id);
        if (projeto != null)
            dao.delete(projeto);
        result.redirectTo(DisciplinaController.class).index();
    }
}
