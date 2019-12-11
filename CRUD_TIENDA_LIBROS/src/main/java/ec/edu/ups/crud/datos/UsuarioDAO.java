package ec.edu.ups.crud.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.crud.modelo.Usuario;

@Stateless
public class UsuarioDAO {

	@Inject
	EntityManager em;
	
	
	public void insertar(Usuario usu) {
		em.persist(usu);
	}
	
	public void actualizar(Usuario usu) {
		em.merge(usu);
	}

	public void eliminar(String cedula) {
	em.remove(buscar(cedula));
    }

	public Usuario buscar(String cedula) {
	 return em.find(Usuario.class, cedula);  
    }
	
	public List<Usuario> listaUsuario(){
		Query query= em.createQuery("SELECT C FROM LIB_USUARIO C",Usuario.class);
		return query.getResultList();
	}
	
}
