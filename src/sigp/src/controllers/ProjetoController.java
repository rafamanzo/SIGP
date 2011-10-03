package sigp.src.controllers;

import sigp.src.Projeto;
import sigp.src.dao.ProjetoDao;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class ProjetoController {
	private static String editSaveTitle = "Salva Mudancas";
	private static String editDelTitle = "Remove Projeto";
	
	private final Result result;
	private ProjetoDao dao;
	
	public ProjetoController(Result result, ProjetoDao dao) {
		this.result = result;
		this.dao = dao;
	}
	
	@Path("/projeto/")
	public void main() {
		result.include("projetos", dao.list());
	}

	@Path("/projeto/novoProjeto")
	public void novoProjeto(final Projeto projeto) {
	    result.include("projetos", dao.list());
	}

	@Path("/projeto/salva")
	public void salva(final Projeto projeto) {
		String errormsg = checkProjeto(projeto);
		if (!errormsg.equals("")) {
			result.redirectTo(ProjetoController.class).msg(errormsg);
		} else {
			dao.save(projeto);
			result.redirectTo(ProjetoController.class).main();
		}
	}

	@Path("/projeto/msg")
	public void msg(String msg) {
		result.include("mensagem", msg);
	}

	@Path("/projeto/infoProjeto")
	public void infoProjeto(Long id) {
		Projeto projeto = dao.getProjeto(id);
		result.include("projeto", projeto);
	}
	
	@Path("/projeto/editProjeto")
	public void editProjeto(Long id) {
		Projeto projeto = dao.getProjeto(id);
		result.include("projeto", projeto);
		result.include("editSaveTitle", editSaveTitle);
		result.include("editDelTitle", editDelTitle);
	}

	@Path("/projeto/updateProjeto")
	public void updateProjeto(final Projeto projeto, String oQueFazer) {
		String errormsg = checkProjeto(projeto);
		if (!errormsg.equals("")) {
			result.redirectTo(ProjetoController.class).msg(errormsg);
		} else if (oQueFazer.equals(editSaveTitle)) {
			dao.update(projeto);
			result.redirectTo(ProjetoController.class).infoProjeto(projeto.getIdProjeto());
		} else if (oQueFazer.equals(editDelTitle)) {
			dao.delete(projeto);
			result.redirectTo(ProjetoController.class).main();
		} else {
			result.redirectTo(ProjetoController.class).infoProjeto(projeto.getIdProjeto());
		}
	}

	public String checkProjeto(Projeto projeto) {
		/*Checar se o Membro esta valido. Em caso negativo, retornar
		 * uma string nao nula ( != "" ) dizendo o erro. 
		 * Se estiver valido, retornar "" */
		return "";
	}

}
