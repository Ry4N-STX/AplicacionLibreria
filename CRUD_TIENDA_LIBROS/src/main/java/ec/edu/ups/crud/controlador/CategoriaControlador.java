package ec.edu.ups.crud.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.crud.datos.AutorDAO;
import ec.edu.ups.crud.datos.CategoriaDAO;
import ec.edu.ups.crud.modelo.Autor;
import ec.edu.ups.crud.modelo.Categoria;
import ec.edu.ups.crud.modelo.Producto;
import ec.edu.ups.negocios.Gestionbanco;


@ManagedBean
@ViewScoped
public class CategoriaControlador {
	
	private int idcategoria;
	private Categoria categoria;
	
	@Inject
	private Gestionbanco cdao;
	
	@PostConstruct
	private void init() {
		categoria=new Categoria();
	}

	public int getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	

	public Gestionbanco getCdao() {
		return cdao;
	}

	public void setCdao(Gestionbanco cdao) {
		this.cdao = cdao;
	}

	
	public String guardarCAT() {
		cdao.guardarCAT(categoria);
		return null;
	}

	public String buscarCAT() {
		setCategoria(cdao.buscarCAT(this.idcategoria));
		System.out.println(idcategoria);
		System.out.println(cdao.buscarCAT(this.idcategoria));
		return null;
	}
	
	public List<Categoria> mostrarCat(){
  	    return cdao.mostrarCat();
     }
	
	public List<Categoria> mostrarDT(){
		List<Categoria> li=cdao.mostrarCat();
		List list = new ArrayList(li.size());
		int cont=0;
		for (Categoria c :li) {
			list.add(c.getIdCategoria());
		}
   	    return list;
      }
	
	
	public List<Categoria> mostrarDT2(){
		List<Categoria> li=cdao.mostrarCat();
		List list = new ArrayList(li.size());
		int cont=0;
		for (Categoria c :li) {
			list.add(c.getIdCategoria());
		}
   	    return list;
      }
	
	public String eliminarCA(int id) {
		cdao.eliminarCA(id);
		return null;
	}
	
	public String buscarCA(int id) {
		setCategoria(cdao.buscarCAT(id));
		return null;
	}
	public String actualizarCA() {
		cdao.actualizarCA(categoria);
		return null;
	}

}
