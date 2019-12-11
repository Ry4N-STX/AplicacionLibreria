package ec.edu.ups.crud.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.crud.datos.ProductosDAO;
import ec.edu.ups.crud.modelo.Autor;
import ec.edu.ups.crud.modelo.Categoria;
import ec.edu.ups.crud.modelo.Producto;



@ManagedBean
@ViewScoped
public class ProductoControlado {

	private String ISBNP;
	private Producto producto;
	private Categoria categoria;
	private Autor autor;
	
	@Inject
	private ProductosDAO pdao;
	
	@PostConstruct
	private void init() {
		producto=new Producto();
	}

	public String getISBNP() {
		return ISBNP;
	}

	public void setISBNP(String iSBNP) {
		ISBNP = iSBNP;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public ProductosDAO getPdao() {
		return pdao;
	}

	public void setPdao(ProductosDAO pdao) {
		this.pdao = pdao;
	}
	
	
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String guardarProducto() {
		System.out.println(producto);
		pdao.insertar(producto);
		return null;
	}
	
	public String buscarPRO() {
		setProducto(pdao.buscar(this.ISBNP));
		System.out.println(ISBNP);
		System.out.println(pdao.buscar(this.ISBNP));
		return null;
	}
	
	public List<Producto> mostrarPro(){
  	    return pdao.listaProductos();
     }
	
	public String eliminar(String ISBN) {
		pdao.eliminar(ISBN);
		return null;
	}
	
	public String buscarPRO(String ISBN) {
		setProducto(pdao.buscar(ISBN));
		return null;
	}
	public String actualizarPRO() {
		pdao.actualizar(producto);
		return null;
	}

	
	
}
