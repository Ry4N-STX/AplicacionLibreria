package ec.edu.ups.crud.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.crud.modelo.Carrito;
import ec.edu.ups.crud.modelo.FACT_Cabecera;
import ec.edu.ups.crud.modelo.FACT_Detalle;

@Stateless
public class Fact_Detalle_DAO {

	@Inject
	EntityManager em;
	
	
	public void insertar(FACT_Detalle fade) {
		em.persist(fade);
	}
	
	public void actualizar(FACT_Detalle fade) {
		em.merge(fade);
	}

	public void eliminar(int codigo) {
	em.remove(buscar(codigo));
    }

	public FACT_Detalle buscar(int codigo) {
	 return em.find(FACT_Detalle.class, codigo);  
    }
	
	
	public List<FACT_Detalle> listaFACT_Detalle(){
		Query query= em.createQuery("SELECT C FROM LIB_FACT_Detalle C",FACT_Detalle.class);
		return query.getResultList();
	}
	
	public List<FACT_Detalle> listaFACT_DetalleUsuario(int codigo){
		String jpql="SELECT C FROM LIB_FACT_Detalle C WHERE C.cabe_detalle_FK = ?1";
		Query query= em.createQuery(jpql,FACT_Detalle.class); 
		query.setParameter(1, codigo);
		return query.getResultList();
	}
}
