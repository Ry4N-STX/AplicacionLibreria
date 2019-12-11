package ec.edu.ups.crud.controlador;

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


@ManagedBean
@ViewScoped
public class CategoriaControlador {
	
	private int idcategoria;
	private Categoria categoria;
	
	@Inject
	private CategoriaDAO cdao;
	
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
	

	public CategoriaDAO getCdao() {
		return cdao;
	}

	public void setCdao(CategoriaDAO cdao) {
		this.cdao = cdao;
	}

	
	public String guardarCAT() {
		cdao.insertar(categoria);
		return null;
	}

	public String buscarCAT() {
		setCategoria(cdao.buscar(this.idcategoria));
		System.out.println(idcategoria);
		System.out.println(cdao.buscar(this.idcategoria));
		return null;
	}
	
	public List<Categoria> mostrarCat(){
  	    return cdao.listaCatgoria();
     }
	
	public String eliminarCA(int id) {
		cdao.eliminar(id);
		return null;
	}
	
	public String buscarCA(int id) {
		setCategoria(cdao.buscar(id));
		return null;
	}
	public String actualizarCA() {
		cdao.actualizar(categoria);
		return null;
	}

}
