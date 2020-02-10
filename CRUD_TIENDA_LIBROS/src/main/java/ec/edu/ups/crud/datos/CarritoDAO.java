package ec.edu.ups.crud.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.crud.modelo.Carrito;
import ec.edu.ups.crud.modelo.FACT_Cabecera;

@Stateless
public class CarritoDAO {

	@Inject
	EntityManager em;
	
	
	public void insertar(Carrito ca) {
		em.persist(ca);
	}
	
	public void actualizar(Carrito ca) {
		em.merge(ca);
	}

	public void eliminar(int ca) {
	em.remove(buscar(ca));
    }

	public Carrito buscar(int ca) {
	 return em.find(Carrito.class, ca);  
    }
	
	public List<Carrito> listaCarritoprueba(String cedula){
		String jpql="SELECT C FROM LIB_CARRITO C WHERE C.id_usuario_FK = '"+cedula+"'";
		Query query= em.createQuery(jpql,Carrito.class); 
		return query.getResultList();
	}
	
	public List<Carrito> listaCarrito3(String cedula,String isbn){
		String jpql="SELECT C FROM LIB_CARRITO C WHERE C.id_usuario_FK = '"+cedula+"' AND C.id_prod_carrito_fk = '"+isbn+"'";
		Query query= em.createQuery(jpql,Carrito.class); 
		return query.getResultList();
	}
	
	public List<Carrito> listaCarrito(){
		Query query= em.createQuery("SELECT C FROM LIB_CARRITO C",Carrito.class);
		return query.getResultList();
	}
	
	public List<Carrito> listaCarritoUsuario(String cedula){
		String jpql="SELECT C FROM LIB_CARRITO C WHERE C.id_usuario_FK = '"+cedula+"'";
		Query query= em.createQuery(jpql,Carrito.class); 
		return query.getResultList();
	}
}
