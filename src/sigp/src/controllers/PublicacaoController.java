package sigp.src.controllers;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import sigp.src.Publicacao;
import sigp.src.Veiculo;
import sigp.src.dao.PublicacaoDao;

@Resource
public class PublicacaoController {
	private final Result result;
	private final PublicacaoDao dao;

	public PublicacaoController(Result result, PublicacaoDao dao) {
		this.result = result;
		this.dao = dao;
	}

	@Path("/publicacao/")
	public void index() {
		result.include("publicacoes", dao.list());
	}

	@Path("/publicacao/novo")
	public void novo_form() {
		result.include("veiculos", Veiculo.values());
	}

	@Path("/publicacao/cria")
	public void cria(final Publicacao publicacao) {
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
