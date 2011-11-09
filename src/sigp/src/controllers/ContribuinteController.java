package sigp.src.controllers;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import sigp.src.Contribuinte;
import sigp.src.Grupo;
import sigp.src.dao.ContribuinteDao;
import sigp.src.dao.UsuarioDao;
import sigp.src.Usuario;

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
    public void cria(final Contribuinte contribuinte, final Long idUsuario) {
        validator.validate(contribuinte);
        Usuario user = udao.getUsuario(idUsuario);
        if (user == null) {
            validator.add(new ValidationMessage("usuário",
                    "não existe"));
        }
        
        validator.onErrorForwardTo(this).novo_form();
        contribuinte.setUsuario(user);
        user.setContribuinte(contribuinte);
        dao.save(contribuinte);
        udao.save(user);
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
        else {
            result.include("contribuinte", contribuinte);
            result.include("usuarios", udao.list());
        }
    }

    @Path("/contribuinte/altera")
    public void altera(final Contribuinte contribuinte, final Long idUsuario) {
        validator.validate(contribuinte);
        Usuario user = udao.getUsuario(idUsuario);
        if (user == null) {
            validator.add(new ValidationMessage("usuário",
                    "não existe"));
        }
        
        validator.onErrorForwardTo(this).altera_form(contribuinte.getIdContribuinte());
        contribuinte.setUsuario(user);
        user.setContribuinte(contribuinte);
        dao.update(contribuinte);
        udao.update(user);
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
