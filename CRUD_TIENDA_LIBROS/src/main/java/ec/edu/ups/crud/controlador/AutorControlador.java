package ec.edu.ups.crud.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.crud.datos.AutorDAO;
import ec.edu.ups.crud.modelo.Autor;

@ManagedBean
@ViewScoped
public class AutorControlador {
	
	private int idAutor;
	private Autor autor;
	
	@Inject
	private AutorDAO adao;
	
	@PostConstruct
	private void init() {
	autor=new Autor();
	}
	
	
	public int getIdAutor() {
		return idAutor;
	}


	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	public AutorDAO getAdao() {
		return adao;
	}


	public void setAdao(AutorDAO adao) {
		this.adao = adao;
	}


	public String guardarAUT() {
		adao.insertar(autor);
		return null;
	}
	
	public String buscarAUT() {
		setAutor(adao.buscar(this.idAutor));
		System.out.println(idAutor);
		System.out.println(adao.buscar(this.idAutor));
		return null;
	}
	
	public List<Autor> mostrarAu(){
  	    return adao.listaAutor();
     }
	
	public String eliminarAu(int id) {
		adao.eliminar(id);
		return null;
	}
	
	public String buscarAu(int id) {
		setAutor(adao.buscar(id));
		return null;
	}
	public String actualizarAU() {
		adao.actualizar(autor);
		return null;
	}

	
	

}
