package sigp.src.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sigp.src.Usuario;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

@Component
@RequestScoped
public class UsuarioDao {
	private final Session session;
	
	public UsuarioDao(Session session) {
		this.session = session;
	}

	public void save(Usuario usuario){
		Transaction t = session.beginTransaction();
		session.save(usuario);
		t.commit();
	}
	
	public Usuario pegaUsuarioPorLogin (String login){
		List<Usuario> usuarios = this.session.createCriteria(Usuario.class).add(Restrictions.eq("login", login)).list();
		if(usuarios.size() > 0)
			return usuarios.get(0);
		return null;
		 
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> list(){
		return this.session.createCriteria(Usuario.class).list();
	}
	public void delete(Usuario usuario){
		Transaction t = session.beginTransaction();
		session.delete(usuario);
		t.commit();
	}
	public void update(Usuario usuario){
		Transaction t = session.beginTransaction();
		session.update(usuario);
		t.commit();
	}
	
	
}
