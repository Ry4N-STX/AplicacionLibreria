package ec.edu.ups.crud.modelo;



public class FacCabemos {

	
	
	private int IdFactCabecera;
	
	
	private String fecha_factura;
	
	
	private double total;


	public int getIdFactCabecera() {
		return IdFactCabecera;
	}


	public void setIdFactCabecera(int idFactCabecera) {
		IdFactCabecera = idFactCabecera;
	}


	public String getFecha_factura() {
		return fecha_factura;
	}


	public void setFecha_factura(String fecha_factura) {
		this.fecha_factura = fecha_factura;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "FacCabemos [IdFactCabecera=" + IdFactCabecera + ", fecha_factura=" + fecha_factura + ", total=" + total
				+ "]";
	}
	
	
}
