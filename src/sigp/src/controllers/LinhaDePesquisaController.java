package sigp.src.controllers;

import java.util.ArrayList;
import java.util.List;

import sigp.src.LinhaPesquisa;
import sigp.src.Projeto;
import sigp.src.dao.LinhaDePesquisaDao;
import sigp.src.dao.ProjetoDao;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

@Resource
public class LinhaDePesquisaController {
    private final Result result;
    private final LinhaDePesquisaDao dao;
    private final ProjetoDao pdao;
    private Validator validator;

    public LinhaDePesquisaController(Result result, Validator validator, LinhaDePesquisaDao dao, ProjetoDao pdao) {
        this.result = result;
        this.validator = validator;
        this.dao = dao;
        this.pdao = pdao;
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
        result.include("todosprojetos", pdao.list());
    }

    @Path("/linhadepesquisa/inserir")   
    public void inserir(final LinhaPesquisa linhapesquisa, final List<Long> idsProjetos){

    	List<Projeto> projetos = new ArrayList<Projeto>();
    	for (int i = 0; i < idsProjetos.size(); i++){
    		projetos.add(pdao.getProjeto(idsProjetos.get(i)));
    	}
    	linhapesquisa.setProjetos(projetos);
    	
        validator.validate(linhapesquisa);
        validator.onErrorForwardTo(this).novalinhadepesquisa();
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
        result.include("todosprojetos", pdao.list());    
    }

    @Path("/linhadepesquisa/altera")
    public void altera(final LinhaPesquisa linhapesquisa, final Long subLinha) {
        validator.validate(linhapesquisa);
        validator.onErrorForwardTo(this).editar(linhapesquisa.getIdPesquisa());
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
