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

@ManagedBean
@RequestScoped
public class ReportesBean implements Serializable{

	private PieChartModel pieModel;
	
	@Inject
	private ProductosDAO pdao;
	@Inject
	private Gestionbanco dao;
	private List<Producto> lpro;
	
	@PostConstruct
	public void init(){
		lpro=dao.mostrarPro();
		createPieModel();
	}
	

	
	public void createPieModel() {
		
		pieModel =new PieChartModel();
		System.out.println(lpro);
		for (int i = 0; i < lpro.size(); i++) {
			
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
	
	
}
