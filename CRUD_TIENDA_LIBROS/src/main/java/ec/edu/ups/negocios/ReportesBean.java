package ec.edu.ups.negocios;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import org.primefaces.model.chart.PieChartModel;

import ec.edu.ups.crud.datos.ProductosDAO;
import ec.edu.ups.crud.modelo.Producto;
import ec.edu.ups.crud.modelo.Usuario;

@ManagedBean
@RequestScoped
public class ReportesBean implements Serializable{

	private PieChartModel pieModel;
	//private PieChartModel pieModel1;
	//private PieChartModel pieModel2;
	
	@Inject
	private ProductosDAO pdao;
	
	@Inject
	private Gestionbanco dao;
	private List<Producto> lpro;
	//private List<Usuario> usu1;
	//private List<Usuario> usu2;
	
	@PostConstruct
	public void init(){
		lpro=dao.mostrarProRepor();
		//usu1=dao.mostrarusuReportMontocompras();
		//usu2=dao.mostrarusuReportcompras();
		createPieModel();

	}
	
	public void createPieModel() {
		
		pieModel =new PieChartModel();
		System.out.println(lpro);
		for (int i = 0; i < 10; i++) {
			
			pieModel.set(lpro.get(i).getNombre(),lpro.get(i).getCantidad_vendidos());
			
		}
		pieModel.setTitle("LIBROS MAS COMPRADOS");
		pieModel.setLegendPosition("c");
	
	}
	





	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

	public ProductosDAO getPdao() {
		return pdao;
	}

	public void setPdao(ProductosDAO pdao) {
		this.pdao = pdao;
	}

	public List<Producto> getLpro() {
		return lpro;
	}

	public void setLpro(List<Producto> lpro) {
		this.lpro = lpro;
	}

	public Gestionbanco getDao() {
		return dao;
	}

	public void setDao(Gestionbanco dao) {
		this.dao = dao;
	}

	
	
	
}
