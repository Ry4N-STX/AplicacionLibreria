package ec.edu.ups.crud.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.crud.modelo.Autor;
import ec.edu.ups.crud.modelo.Categoria;
import ec.edu.ups.crud.modelo.Producto;
import ec.edu.ups.negocios.*;



@ManagedBean
@ViewScoped
public class ProductoControlado {

	private String ISBNP;
	private Producto producto;
	private Categoria categoria;
	private Autor autor;
	
	@Inject
	private Gestionbanco pdao;
	
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

	public Gestionbanco getPdao() {
		return pdao;
	}

	public void setPdao(Gestionbanco pdao) {
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
		pdao.guardarProducto(producto);
		return null;
	}
	
	public String buscarPRO() {
		setProducto(pdao.buscarPRO(this.ISBNP));
		System.out.println(ISBNP);
		System.out.println(pdao.buscarPRO(this.ISBNP));
		return null;
	}
	
	public List<Producto> mostrarPro(){
  	    return pdao.mostrarPro();
     }
	
	public String eliminar(String ISBN) {
		pdao.eliminarLibro(ISBN);
		return null;
	}
	
	public String buscarPRO(String ISBN) {
		setProducto(pdao.buscarPRO(ISBN));
		return null;
	}
	public String actualizarPRO() {
		pdao.actualizarPRO(producto);
		return null;
	}

	
	public List<Producto> mostrarrepor(){
  	    return pdao.mostrarProRepor();
     }
}
