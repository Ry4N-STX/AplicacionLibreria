package ec.edu.ups.crud.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.crud.modelo.Carrito;
import ec.edu.ups.crud.modelo.Direccion;

@Stateless
public class DireccionDAO {

	@Inject
	EntityManager em;
	
	
	public void insertar(Direccion dic) {
		em.persist(dic);
	}
	
	public void actualizar(Direccion dic) {
		em.merge(dic);
	}

	public void eliminar(int codigo) {
	em.remove(buscar(codigo));
    }

	public Direccion buscar(int codigo) {
	 return em.find(Direccion.class, codigo);  
    }
	
	
	public List<Direccion> listaDireccion(){
		Query query= em.createQuery("SELECT C FROM LIB_DIRECCION C",Direccion.class);
		return query.getResultList();
	}
	public List<Direccion> listaDireccionUsu(String CI){
		String jpql="SELECT C FROM LIB_DIRECCION C WHERE C.id_usuario_FK = '"+CI+"'";
		Query query= em.createQuery(jpql,Direccion.class); 
		return query.getResultList();
	}
	
}
