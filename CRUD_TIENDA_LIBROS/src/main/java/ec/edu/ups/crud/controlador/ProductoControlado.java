package ec.edu.ups.crud.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;

import ec.edu.ups.crud.datos.AutorDAO;
import ec.edu.ups.crud.datos.CategoriaDAO;
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

	private PieChartModel pieModel;
	
	@Inject
	private Gestionbanco pdao;
	
	@Inject
	private CategoriaDAO ct;
	
	@Inject
	private AutorDAO at;
	
	@PostConstruct
	private void init() {
		producto=new Producto();
	}
	
	public int[] vector(){
		List<Producto> a= pdao.mostrarProRepor();
		int [] losValores = new int[a.size()];
		int cont=0;
		for (Producto p :a) {
			losValores[cont]=p.getCantidad_vendidos();
		}
		return losValores;
	};


	//private List<Producto> listp =pdao.mostrarProRepor();
	//public void createPieModel() {
	//	pieModel = new PieChartModel();
	//	for (int i = 0; i < listp.size(); i++) {
	//		pieModel.set(listp.get(i).getNombre(),i);
	//	}
	//	pieModel.setTitle("mas vendidos");
	//	pieModel.setLegendPosition("c");
   // }
//
	//public List<Producto> getListp() {
	//	return listp;
	//}

	//public void setListp(List<Producto> listp) {
	//	this.listp = listp;
	//}

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
	
	public String b(int id) {
		Categoria c=ct.buscar(id);
		return c.getNombre();
	}
	public String bA(int id) {
		Autor a=at.buscar(id);
		return a.getNombre_autor();
	}
	
	public String prueba(String nombre) {
		System.out.println(producto);
		pdao.guardarProducto(producto);
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
