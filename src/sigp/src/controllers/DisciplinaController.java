package sigp.src.controllers;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import sigp.src.Disciplina;
import sigp.src.dao.DisciplinaDao;

@Resource
public class DisciplinaController {
	private final Result result;
	private final DisciplinaDao dao;

	public DisciplinaController(Result result, DisciplinaDao dao) {
		this.result = result;
		this.dao = dao;
	}

	@Path("/disciplina/")
	public void index() {
		result.include("disciplinas", dao.list());
	}

	@Path("/disciplina/novo")
	public void novo_form() {
		result.include("disciplinas", dao.list());
	}

	@Path("/disciplina/cria")
	public void cria(final Disciplina disciplina) {
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
