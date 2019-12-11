package ec.edu.ups.crud.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.crud.modelo.Autor;

@Stateless
public class AutorDAO {
	
	@Inject
	EntityManager em;
	
	public void insertar(Autor aut) {
		em.persist(aut);
	}
	
	public void actualizar(Autor aut) {
		em.merge(aut);
	}
	
	public void eliminar(int idAUT) {
		em.remove(buscar(idAUT));
	    }
	
	public Autor buscar(int idAUT) {
		 return em.find(Autor.class, idAUT);  
	    }
	
	public List<Autor> listaAutor(){
		Query query= em.createQuery("SELECT L FROM LIB_AUTOR L",Autor.class);
		return query.getResultList();
	}
		

}
