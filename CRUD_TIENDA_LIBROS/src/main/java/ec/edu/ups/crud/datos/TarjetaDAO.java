package ec.edu.ups.crud.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.crud.modelo.FACT_Cabecera;
import ec.edu.ups.crud.modelo.Tarjeta;

@Stateless
public class TarjetaDAO {

	@Inject
	EntityManager em;
	
	
	public void insertar(Tarjeta tar) {
		em.persist(tar);
	}
	
	public void actualizar(Tarjeta tar) {
		em.merge(tar);
	}

	public void eliminar(int codigo) {
	em.remove(buscar(codigo));
    }

	public Tarjeta buscar(int codigo) {
	 return em.find(Tarjeta.class, codigo);  
    }
	
	
	public List<Tarjeta> listaTarjetas(){
		Query query= em.createQuery("SELECT C FROM LIB_TARJETA C",Tarjeta.class);
		return query.getResultList();
	}
	
	public List<Tarjeta> listaTarjetaUsuario(String cedula){
		String jpql="SELECT C FROM LIB_TARJETA C WHERE C.id_usuario_FK = ?1";
		Query query= em.createQuery(jpql,Tarjeta.class); 
		query.setParameter(1, cedula);
		return query.getResultList();
	}
	
}
