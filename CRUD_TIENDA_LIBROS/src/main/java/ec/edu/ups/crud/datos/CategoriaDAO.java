package ec.edu.ups.crud.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.crud.modelo.Categoria;



@Stateless
public class CategoriaDAO {
	
	@Inject
	EntityManager em;
	
	public void insertar(Categoria cat) {
		em.persist(cat);
	}
	
	public void actualizar(Categoria cat) {
		em.merge(cat);
	}
	
	public void eliminar(int id) {
	em.remove(buscar(id));
    }
	
	public Categoria buscar(int id) {
		 return em.find(Categoria.class, id);  
	    }
	
	public List<Categoria> listaCatgoria(){
		Query query= em.createQuery("SELECT C FROM LIB_CATEGORIA C",Categoria.class);
		return query.getResultList();
	}
		

}
