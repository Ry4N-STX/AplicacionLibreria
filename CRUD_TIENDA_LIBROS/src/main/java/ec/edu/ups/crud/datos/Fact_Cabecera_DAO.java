package ec.edu.ups.crud.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.crud.modelo.FACT_Cabecera;


@Stateless
public class Fact_Cabecera_DAO {

	@Inject
	EntityManager em;
	
	
	public void insertar(FACT_Cabecera faca) {
		em.persist(faca);
	}
	
	public void actualizar(FACT_Cabecera faca) {
		em.merge(faca);
	}

	public void eliminar(int codigo) {
	em.remove(buscar(codigo));
    }

	public FACT_Cabecera buscar(int codigo) {
	 return em.find(FACT_Cabecera.class, codigo);  
    }
	
	
	public List<FACT_Cabecera> listaFACT_Cabecera(){
		Query query= em.createQuery("SELECT C FROM LIB_FACT_CABECERA C",FACT_Cabecera.class);
		return query.getResultList();
	}
	
	public List<FACT_Cabecera> listaFACTCabeceraUsuario(String cedula){
		String jpql="SELECT C FROM LIB_FACT_CABECERA C WHERE C.id_usuario_FK = ?1";
		Query query= em.createQuery(jpql,FACT_Cabecera.class); 
		query.setParameter(1, cedula);
		return query.getResultList();
	}
}
