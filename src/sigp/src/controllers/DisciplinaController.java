package sigp.src.controllers;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import sigp.src.Disciplina;
import sigp.src.dao.DisciplinaDao;
import sigp.src.dao.GrupoDao;

@Resource
public class DisciplinaController {
    private final Result result;
    private final DisciplinaDao dao;
    private final GrupoDao gdao;
    private Validator validator;

    public DisciplinaController(Result result, Validator validator,
            DisciplinaDao dao, GrupoDao gdao) {
        this.result = result;
        this.validator = validator;
        this.dao = dao;
        this.gdao = gdao;
    }

    @Path("/disciplina/")
    public void index() {
        result.include("disciplinas", dao.list());
    }

    @Path("/disciplina/novo")
    public void novo_form() {
        result.include("disciplinas", dao.list());
        result.include("grupos", gdao.list());
    }

    @Path("/disciplina/cria")
    public void cria(final Disciplina disciplina) {
        validator.validate(disciplina);
        validator.onErrorForwardTo(this).novo_form();
        dao.save(disciplina);
        result.redirectTo(DisciplinaController.class).index();
    }

    @Path("/disciplina/ver/{id}")
    public void visualiza(Long id) {
        Disciplina disciplina = dao.getDisciplina(id);
        if (disciplina == null)
            result.redirectTo(DisciplinaController.class).index();
        else
            result.include("disciplina", disciplina);
    }

    @Path("/disciplina/alterar/{id}")
    public void altera_form(Long id) {
        Disciplina disciplina = dao.getDisciplina(id);
        if (disciplina == null)
            result.redirectTo(DisciplinaController.class).index();
        else
            result.include("disciplina", disciplina);
    }

    @Path("/disciplina/altera")
    public void altera(final Disciplina disciplina) {
        validator.validate(disciplina);
        validator.onErrorForwardTo(this).altera_form(disciplina.getIdDisciplina());
        dao.update(disciplina);
        result.redirectTo(DisciplinaController.class).index();
    }

    @Path("/disciplina/apagar/{id}")
    public void remove(Long id) {
        Disciplina disciplina = dao.getDisciplina(id);
        if (disciplina != null)
            dao.delete(disciplina);
        result.redirectTo(DisciplinaController.class).index();
    }
}
