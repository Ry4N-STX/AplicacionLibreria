package ec.edu.ups.crud.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.negocios.*;
import ec.edu.ups.crud.modelo.Autor;
import ec.edu.ups.crud.modelo.Categoria;

@ManagedBean
@ViewScoped
public class AutorControlador {
	
	private int idAutor;
	private Autor autor;
	
	@Inject
	private Gestionbanco adao;
	
	@PostConstruct
	private void init() {
	autor=new Autor();
	}
	
	public List<Categoria> mostrarAutor(){
		List<Autor> li=adao.mostrarAu();
		List list = new ArrayList(li.size());
		int cont=0;
		for (Autor a :li) {
			list.add(a.getIdAutor());
		}
   	    return list;
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


	public Gestionbanco getAdao() {
		return adao;
	}


	public void setAdao(Gestionbanco adao) {
		this.adao = adao;
	}


	public String guardarAUT() {
		adao.guardarAUT(autor);
		return null;
	}
	
	public String buscarAUT() {
		setAutor(adao.buscarAUT(this.idAutor));
		System.out.println(idAutor);
		System.out.println(adao.buscarAUT(this.idAutor));
		return null;
	}
	
	public List<Autor> mostrarAu(){
  	    return adao.mostrarAu();
     }
	
	public String eliminarAu(int id) {
		adao.eliminarAu(id);
		return null;
	}
	
	public String buscarAu(int id) {
		setAutor(adao.buscarAUT(id));
		return null;
	}
	public String actualizarAU() {
		adao.actualizarAU(autor);
		return null;
	}

	
	

}
