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

    @Path("/linhadepesquisa/novo")
    public void novalinhadepesquisa() {
	result.include("linhasdepesquisa", dao.list());
    }

    @Path("/linhadepesquisa/inserir")
    public void inserir(final LinhaPesquisa linhapesquisa) {
	dao.save(linhapesquisa);
	result.redirectTo(this).index();
    }

    @Path("/linhadepesquisa/alterar/{idPesquisa}")
    public void editar(Long idPesquisa) {
	LinhaPesquisa linhapesquisa = dao.getLinhaPesquisa(idPesquisa);
	if (linhapesquisa == null)
	    result.redirectTo(this).index();
	else
	    result.include("linhapesquisa", linhapesquisa);
	result.include("linhasdepesquisa", dao.list());
    }

    @Path("/linhadepesquisa/altera")
    public void altera(final LinhaPesquisa linhapesquisa,
	    final Long subLinha) {
	linhapesquisa.setSubLinha(dao.getLinhaPesquisa(subLinha));
	dao.update(linhapesquisa);
	result.redirectTo(this).index();
    }

    @Path("/linhadepesquisa/apagar/{idPesquisa}")
    public void remove(Long idPesquisa) {
	LinhaPesquisa linhapesquisa = dao.getLinhaPesquisa(idPesquisa);
	if (linhapesquisa != null)
	    dao.delete(linhapesquisa);
	result.redirectTo(this).index();
    }

    @Path("/linhadepesquisa/ver/{idPesquisa}")
    public void visualiza(Long idPesquisa) {
	LinhaPesquisa linhapesquisa = dao.getLinhaPesquisa(idPesquisa);
	if (linhapesquisa == null)
	    result.redirectTo(this).index();
	else
	    result.include("linhapesquisa", linhapesquisa);
    }
}
