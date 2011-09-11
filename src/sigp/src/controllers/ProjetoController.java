package sigp.src.controllers;

import sigp.src.Membro;
import sigp.src.dao.MembroDao;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class ProjetoController {
	private static String editSaveTitle = "Salva Mudancas";
	private static String editDelTitle = "Remove Membro";
	
	private final Result result;
	private MembroDao membroDao;
	
	public ProjetoController(Result result, MembroDao membroDao) {
		this.result = result;
		this.membroDao = membroDao;
	}
	
	@Path("/membros")
	public void main() {
		result.include("membros", membroDao.list());
	}

	@Path("/membros/novoMembro")
	public void novoMembro() {
	}

	@Path("/membros/salva")
	public void salva(final Membro membro) {
		String errormsg = checkMembro(membro);
		if (!errormsg.equals("")) {
			result.redirectTo(ProjetoController.class).msg(errormsg);
		} else {
			membroDao.save(membro);
			result.redirectTo(ProjetoController.class).main();
		}
	}

	@Path("/membros/msg")
	public void msg(String msg) {
		result.include("mensagem", msg);
	}

	@Path("/membros/infoMembro")
	public void infoMembro(Long id) {
		Membro membro = membroDao.getMembro(id);
		result.include("membro", membro);
		result.include("editSaveTitle", editSaveTitle);
		result.include("editDelTitle", editDelTitle);
	}

	@Path("/membros/updateMembro")
	public void updateMembro(final Membro membro, String oQueFazer) {
		String errormsg = checkMembro(membro);
		if (!errormsg.equals("")) {
			result.redirectTo(ProjetoController.class).msg(errormsg);
		} else if (oQueFazer.equals(editSaveTitle)) {
			membroDao.update(membro);
			result.redirectTo(ProjetoController.class).main();
		} else if (oQueFazer.equals(editDelTitle)) {
			membroDao.delete(membro);
			result.redirectTo(ProjetoController.class).main();
		} else {
			result.redirectTo(ProjetoController.class).main();
		}
	}

	public String checkMembro(Membro membro) {
		/*Checar se o Membro esta valido. Em caso negativo, retornar
		 * uma string nao nula ( != "" ) dizendo o erro. 
		 * Se estiver valido, retornar "" */
		return "";
	}

}
