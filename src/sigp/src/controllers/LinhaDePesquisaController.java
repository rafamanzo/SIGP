package sigp.src.controllers;

import sigp.src.dao.LinhaDePesquisaDao;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class LinhaDePesquisaController {
	private final Result result;
	private final LinhaDePesquisaDao dao;
	
	public LinhaDePesquisaController(Result result, LinhaDePesquisaDao dao) {
		this.result = result;
		this.dao = dao;
	}
	
	@Path("/linhaDePesquisa/")
	public void index() {
		result.include("linhasDePesquisa", dao.list());
	}
	
	
	
	
}
