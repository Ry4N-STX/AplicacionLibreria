package ec.edu.ups.crud.datos;



import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.crud.modelo.Votoproducto;


@Stateless
public class VotoDAO {

	@Inject
	EntityManager em;
	
	
	public void insertar(Votoproducto tar) {
		em.persist(tar);
	}
	
	public void actualizar(Votoproducto tar) {
		em.merge(tar);
	}

	public void eliminar(int codigo) {
	em.remove(buscar(codigo));
    }

	public Votoproducto buscar(int codigo) {
	 return em.find(Votoproducto.class, codigo);  
    }
	
	
	public List<Votoproducto> listaVotoproducto(){
		Query query= em.createQuery("SELECT C FROM Votoproducto C",Votoproducto.class);
		return query.getResultList();
	}
	
	public int EstadoLibro(String cedula,String idp){
		String jpql="SELECT C FROM Votoproducto C WHERE C.vot_idPr = '"+idp+"'  AND C.vot_idUsu = '"+cedula+"'";
		Query query= em.createQuery(jpql,Votoproducto.class); 
		List<Votoproducto> i=query.getResultList();
		for (Votoproducto v: i ) {
			return v.getEstado();
		}
		return 0;	
	}
	
	public boolean votprev(String cedula,String idp){
		String jpql="SELECT C FROM Votoproducto C WHERE C.vot_idPr = '"+idp+"'  AND C.vot_idUsu = '"+cedula+"'";
		Query query= em.createQuery(jpql,Votoproducto.class); 
		List<Votoproducto> i=query.getResultList();
		if (i.isEmpty()) {
			return false;
		}else {
			return true;
		}
			
	}
	
	public Votoproducto buscarvot(String cedula,String idp){
		String jpql="SELECT C FROM Votoproducto C WHERE C.vot_idPr = '"+idp+"'  AND C.vot_idUsu = '"+cedula+"'";
		Query query= em.createQuery(jpql,Votoproducto.class); 
	
		List<Votoproducto> i=query.getResultList();
		for (Votoproducto v: i ) {
			return v;
		}
		return null;	
	}
	
}