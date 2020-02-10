package ec.edu.ups.crud.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.crud.modelo.Producto;

@Stateless
public class ProductosDAO {
	
	@Inject
	EntityManager em;
	
	public void insertar(Producto pro) {
		em.persist(pro);
	}
	
	
	public void actualizar(Producto pro) {
		em.merge(pro);
	}
	
	public void eliminar(String ISBN) {
		em.remove(buscar(ISBN));
	    }
	
	public Producto buscar(String ISBN) {
		 return em.find(Producto.class, ISBN);  
	    }
	
	public List<Producto> listaProductos(){
		Query query= em.createQuery("SELECT P FROM LIB_PRODUCTO P",Producto.class);
		return query.getResultList();
	}
	
	public List<Producto> listaProductosporOdren(){
		
		Query query= em.createQuery("SELECT P FROM LIB_PRODUCTO P ORDER BY pro_cantidad_vendidos DESC",Producto.class);
		System.out.println(query.getResultList());
		return query.getResultList();
	}
	
	
	
	

}
