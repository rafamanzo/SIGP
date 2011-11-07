package sigp.src.controllers;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.view.Results;
import sigp.src.Grupo;
import sigp.src.dao.GrupoDao;

@Resource
public class GrupoController {
    private final Result result;
    private final GrupoDao dao;
    private Validator validator;

    public GrupoController(Result result, Validator validator, GrupoDao dao) {
        this.result = result;
        this.validator = validator;
        this.dao = dao;
    }

    @Path("/grupo/")
    public void index() {
        result.include("grupos", dao.list());
    }

    @Path("/grupo/procura/{query}")
    public void procura(String query) {
        result.use(Results.json()).from(dao.search(query)).serialize();
    }

    @Path("/grupo/novo")
    public void novo_form() {
        result.include("grupos", dao.list());
    }

    @Path("/grupo/cria")
    public void cria(final Grupo grupo, final String responsavel) {
        validator.validate(grupo);
        Grupo respon = dao.find(responsavel);
        if (respon == null && !responsavel.equals("")) {
            // TODO: adicionar um erro! Tentei e falhei usar o validator...
            validator.add(new ValidationMessage("nome do responsável",
                    "não existe"));
            //result.redirectTo(GrupoController.class).novo_form();
            //return;
        }
        validator.onErrorForwardTo(this).novo_form();
        grupo.setResponsavel(respon);
        dao.save(grupo);
        result.redirectTo(GrupoController.class).index();
    }

    @Path("/grupo/ver/{idGrupo}")
    public void visualiza(Long idGrupo) {
        Grupo grupo = dao.getGrupo(idGrupo);
        if (grupo == null)
            result.redirectTo(GrupoController.class).index();
        else
            result.include("grupo", grupo);
    }

    @Path("/grupo/alterar/{idGrupo}")
    public void altera_form(Long idGrupo) {
        Grupo grupo = dao.getGrupo(idGrupo);
        if (grupo == null)
            result.redirectTo(GrupoController.class).index();
        else
            result.include("grupo", grupo);
        result.include("grupos", dao.list());
    }

    @Path("/grupo/altera")
    public void altera(final Grupo grupo, final Long responsavel) {
        validator.validate(grupo);
        validator.onErrorForwardTo(this).altera_form(grupo.getIdGrupo());
        grupo.setResponsavel(dao.getGrupo(responsavel));
        dao.update(grupo);
        result.redirectTo(GrupoController.class).index();
    }

    @Path("/grupo/apagar/{idGrupo}")
    public void remove(Long idGrupo) {
        Grupo grupo = dao.getGrupo(idGrupo);
        if (grupo != null)
            dao.delete(grupo);
        result.redirectTo(GrupoController.class).index();
    }

}
