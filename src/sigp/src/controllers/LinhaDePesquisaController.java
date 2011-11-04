package sigp.src.controllers;

import java.util.List;

import sigp.src.LinhaPesquisa;
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

    @Path("/linhadepesquisa/")
    public void index() {
	result.include("linhasdepesquisa", dao.list());	
    }

    public List<LinhaPesquisa> lista() {
	return dao.list();
    }

    @Path("/linhadepesquisa/novalinhadesquisa/")
    public void inserir(final LinhaPesquisa linhapesquisa) {
	dao.save(linhapesquisa);	
    }

    @Path("/linhadepesquisa/{idlinhapesquisa}/editar")
    public LinhaPesquisa editar(Long idlinhapesquisa) {
	return dao.getLinhaPesquisa(idlinhapesquisa);
    }

    @Path("/linhadepesquisa/{idlinhapesquisa}/alterar")
    public void alterar(LinhaPesquisa linhapesquisa) {
	dao.update(linhapesquisa);
	result.redirectTo(this).lista();
    }

    @Path("/linhadepesquisa/{idlinhapesquisa}/remover")
    public boolean remover(Long idlinhapesquisa) {
	LinhaPesquisa linhapesquisa = dao.getLinhaPesquisa(idlinhapesquisa);
	dao.delete(linhapesquisa);
	result.redirectTo(this).lista();
	return true;
    }
}
