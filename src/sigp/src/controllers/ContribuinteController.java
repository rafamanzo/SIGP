package sigp.src.controllers;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import sigp.src.Contribuinte;
import sigp.src.dao.ContribuinteDao;
import sigp.src.dao.UsuarioDao;

@Resource
public class ContribuinteController {
    private final Result result;
    private final ContribuinteDao dao;
    private final UsuarioDao udao;
    private Validator validator;

    public ContribuinteController(Result result, Validator validator,
            ContribuinteDao dao, UsuarioDao udao) {
        this.result = result;
        this.validator = validator;
        this.dao = dao;
        this.udao = udao;
    }

    @Path("/contribuinte/")
    public void index() {
        result.include("contribuintes", dao.list());
    }

    @Path("/contribuinte/novo")
    public void novo_form() {
        result.include("contribuintes", dao.list());
        result.include("usuarios", udao.list());
    }

    @Path("/contribuinte/cria")
    public void cria(final Contribuinte contribuinte) {
        validator.validate(contribuinte);
        validator.onErrorForwardTo(this).novo_form();
        dao.save(contribuinte);
        result.redirectTo(ContribuinteController.class).index();
    }

    @Path("/contribuinte/ver/{id}")
    public void visualiza(Long id) {
        Contribuinte contribuinte = dao.getContribuinte(id);
        if (contribuinte == null)
            result.redirectTo(ContribuinteController.class).index();
        else
            result.include("contribuinte", contribuinte);
    }

    @Path("/contribuinte/alterar/{id}")
    public void altera_form(Long id) {
        Contribuinte contribuinte = dao.getContribuinte(id);
        if (contribuinte == null)
            result.redirectTo(ContribuinteController.class).index();
        else
            result.include("contribuinte", contribuinte);
    }

    @Path("/contribuinte/altera")
    public void altera(final Contribuinte contribuinte) {
        validator.validate(contribuinte);
        validator.onErrorForwardTo(this).altera_form(contribuinte.getIdContribuinte());
        dao.update(contribuinte);
        result.redirectTo(ContribuinteController.class).index();
    }

    @Path("/contribuinte/apagar/{id}")
    public void remove(Long id) {
        Contribuinte contribuinte = dao.getContribuinte(id);
        if (contribuinte != null)
            dao.delete(contribuinte);
        result.redirectTo(ContribuinteController.class).index();
    }
}
