package ec.edu.ups.crud.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.flow.builder.ReturnBuilder;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.crud.modelo.FACT_Cabecera;
import ec.edu.ups.crud.modelo.Producto;
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
	
	public Usuario usuariolof(String correo){
		
		
		String jpql="SELECT C FROM LIB_USUARIO C WHERE C.usu_email = '"+correo+"'";
		Query query= em.createQuery(jpql,Usuario.class); 
		Usuario uw=new Usuario();
		 List<Usuario> u=query.getResultList();
		 if(u.isEmpty()) {
			 return uw;
		 }else {
			 for(Usuario usu:u) {
				 return usu;
			 }	 
		}
		 return uw;
	}
	
	public List<Usuario> usuariolof3(String correo){
		
		String jpql="SELECT C FROM LIB_USUARIO C WHERE C.usu_email = '"+correo+"'";
		Query query= em.createQuery(jpql,Usuario.class); 
	
		return query.getResultList();
	}
	
   public List<Usuario> usuarioreportNumrocompras(){
		Query query= em.createQuery("SELECT P FROM LIB_USUARIO P ORDER BY usu_numero_compras DESC",Usuario.class);
		return query.getResultList();
	}
   
   public List<Usuario> usuarioreportMontocomprado(){
		Query query= em.createQuery("SELECT P FROM LIB_USUARIO P ORDER BY usu_monto_compras DESC",Usuario.class);
		return query.getResultList();
	}
}
