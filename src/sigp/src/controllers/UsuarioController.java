package sigp.src.controllers;

import sigp.src.Usuario;
import sigp.src.dao.UsuarioDao;
import sigp.src.hash.PasswordCodificator;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Resource
public class UsuarioController {
    private final Result result;
    private final UsuarioDao dao;
    private final Validator validator;

    public UsuarioController(Result result, Validator validator, UsuarioDao dao) {
        this.result = result;
        this.validator = validator;
        this.dao = dao;
    }

    @Path("/login/")
    public void index() {
    }

    @Path("/login/cadastro")
    public void form() {
    }

    @Post
    @Path("/login/verifica")
    public void verifica(String login, String senha) {
        Usuario usuario = dao.pegaUsuarioPorLogin(login);
        if (usuario == null) {
            validator.add(new ValidationMessage(
                    "Verifique se sua senha e login estão corretos.", "login"));
            validator.onErrorForwardTo(this).index();
            return;
        }

        // Codifica a senha digitada pelo usuario
        PasswordCodificator p = new PasswordCodificator(senha);
        System.out.println("*******" + senha + "**************");

        // E compara com a do usuário no banco de dados.

        System.out.println("AQUI ------------------------" + p.codificado()
                + "----" + usuario.getSenha());
        if (!(p.codificado().equals(usuario.getSenha()))) {
            validator.add(new ValidationMessage(
                    "Verifique se sua senha e login estão corretos.", "login"));
            validator.onErrorForwardTo(this).index();
            return;
        }

        result.include("logado", "Usuario " + usuario.getLogin() + " logado.");
        result.redirectTo(UsuarioController.class).index();
    }

    @Path("/login/novoUsuario")
    public void novoUsuario() {
    }

    @Path("/login/salva")
    public void salva(Usuario usuario, String confirma) {

        validator.validate(usuario);
        // Login indisponível.
        if (dao.pegaUsuarioPorLogin(usuario.getLogin()) != null) {
            validator.add(new ValidationMessage("Login já existe.", "login"));
        }

        // Senhas diferentes
        if (!usuario.getSenha().equals(confirma)) {
            validator.add(new ValidationMessage(
                    "Campo senha difere do campo de confirmação.",
                    "confirmação"));
        }
        validator.onErrorForwardTo(this).novoUsuario();
        if (!validator.hasErrors()) {
            // Codifica a senha antes de armazenar no banco de dados.
            usuario.codificaSenha();

            dao.save(usuario);
            result.redirectTo(UsuarioController.class).index();
        }
    }

}
