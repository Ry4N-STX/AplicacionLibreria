package ec.edu.ups.crud.controlador;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.crud.datos.CategoriaDAO;
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
		categoria.addProducto(new Producto());
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
	
	public String addProducto() {
		categoria.addProducto(new Producto());
		return null;
	}
	
	public String guardarCAT() {
		cdao.insertar(categoria);
		return null;
	}

}
