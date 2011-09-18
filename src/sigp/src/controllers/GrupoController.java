package sigp.src.controllers;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import sigp.src.Grupo;
import sigp.src.dao.GrupoDao;

@Resource
public class GrupoController {
	private final Result result;
	private final GrupoDao dao;

	public GrupoController(Result result, GrupoDao dao) {
		this.result = result;
		this.dao = dao;
	}

	@Path("/grupo/")
	public void index() {
		result.include("grupos", dao.list());
	}

	@Path("/grupo/novo")
	public void novo_form() {
		result.include("grupos", dao.list());
	}

	@Path("/grupo/cria")
	public void cria(final Grupo grupo, final Long responsavel) {
		if (responsavel != 0)
			grupo.setResponsavel(dao.getGrupo(responsavel));
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
