package sigp.src.controllers;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import sigp.src.Projeto;
import sigp.src.Publicacao;
import sigp.src.Veiculo;
import sigp.src.dao.ProjetoDao;
import sigp.src.dao.PublicacaoDao;

@Resource
public class PublicacaoController {
	private final Result result;
	private final PublicacaoDao dao;
	private final ProjetoDao pdao;
    private Validator validator;

	public PublicacaoController(Result result, Validator validator, PublicacaoDao dao, ProjetoDao pdao) {
		this.result = result;
		this.validator = validator;
		this.dao = dao;
		this.pdao = pdao;
	}

	@Path("/publicacao/")
	public void index() {
		result.include("publicacoes", dao.list());
	}

	@Path("/publicacao/novo")
	public void novo_form() {
		result.include("veiculos", Veiculo.values());
		result.include("todosprojetos", pdao.list());
	}

	@Path("/publicacao/cria")
	public void cria(final Publicacao publicacao,  final List<Long> idsProjetos) {
		List<Projeto> projetos = new ArrayList<Projeto>();
    	for (int i = 0; i < idsProjetos.size(); i++){
    		projetos.add(pdao.getProjeto(idsProjetos.get(i)));
    	}
    	publicacao.setProjetos(projetos);		
		
	    validator.validate(publicacao);
	    validator.onErrorForwardTo(this).novo_form();
		dao.save(publicacao);
		result.redirectTo(PublicacaoController.class).index();
	}

	@Path("/publicacao/ver/{id}")
	public void visualiza(Long id) {
		Publicacao publicacao = dao.getPublicacao(id);
		if (publicacao == null)
			result.redirectTo(PublicacaoController.class).index();
		else
			result.include("publicacao", publicacao);
	}

	@Path("/publicacao/alterar/{id}")
	public void altera_form(Long id) {
		Publicacao publicacao = dao.getPublicacao(id);
		if (publicacao == null)
			result.redirectTo(PublicacaoController.class).index();
		else
			result.include("publicacao", publicacao);
		result.include("veiculos", Veiculo.values());
	}

	@Path("/publicacao/altera")
	public void altera(final Publicacao publicacao) {
        validator.validate(publicacao);
        validator.onErrorForwardTo(this).altera_form(publicacao.getIdPublicacao());
		dao.update(publicacao);
		result.redirectTo(PublicacaoController.class).index();
	}

	@Path("/publicacao/apagar/{id}")
	public void remove(Long id) {
		Publicacao publicacao = dao.getPublicacao(id);
		if (publicacao != null)
			dao.delete(publicacao);
		result.redirectTo(PublicacaoController.class).index();
	}
}
