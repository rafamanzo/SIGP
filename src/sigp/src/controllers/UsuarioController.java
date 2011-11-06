package sigp.src.controllers;

import sigp.src.Usuario;
import sigp.src.dao.UsuarioDao;
import sigp.src.hash.PasswordCodificator;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class UsuarioController {
	private final Result result;
	private final UsuarioDao dao;
	
	public UsuarioController(Result result, UsuarioDao dao) {
		this.result = result;
		this.dao = dao;
	}
	
	@Path("/login/")
	public void index() {
	}
	
	@Path("/login/cadastro")
	public void form(){
	}
		
	@Post
	@Path("/login/verifica")
	public void verifica(String login, String senha){
		Usuario usuario = dao.pegaUsuarioPorLogin(login);
		PasswordCodificator p = new PasswordCodificator(senha);
		System.out.println("*******"+senha+"**************");
		if(usuario == null){
			result.include("usuarioNaoCadastrado", "Usuario nao cadastrado.");
			result.redirectTo(UsuarioController.class).index();	
		}
		System.out.println("AQUI ------------------------"+p.codificado() + "----" + usuario.getSenha());
		if ((usuario != null) && (p.codificado() == usuario.getSenha())) {
			result.include("logado", "Usuario "+usuario.getLogin()+" logado.");
			result.redirectTo(UsuarioController.class).index();	
		}
		if ((usuario != null) && (p.codificado() != usuario.getSenha())) {
			result.include("usuarioOuSenhaIncorreta", "Verifique se sua senha e login estão corretos.");
			result.redirectTo(UsuarioController.class).index();	
		}
	}
	
	@Path("/login/novoUsuario")
	public void novoUsuario(){
	}
	
	@Path("/login/salva")
	public void salva(Usuario usuario){
		if (dao.pegaUsuarioPorLogin(usuario.getLogin()) != null){
			result.include("usuarioJaExistente", "Login nao disponivel.");
			result.redirectTo(UsuarioController.class).novoUsuario();
			return;
		}
		if (usuario.getConfirma() == usuario.getSenha()){
			result.include("senhasDiferentes", "Campo senha difere do campo de confirmação.");
			result.redirectTo(UsuarioController.class).novoUsuario();
			return;
		}
		dao.save(usuario);
		result.redirectTo(UsuarioController.class).index();
	}
	
}
