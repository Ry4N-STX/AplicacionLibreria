package ec.edu.ups.crud.modelo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="LIB_FACT_CABECERA")
public class FACT_Cabecera {
	
	@Id
	@Column(name="fac_cab_id")
	private int IdFactCabecera;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fac_fecha_factura")
	private Date fecha_factura;
	
	@Column(name="fac_numero_fact", length = 10)
	private int numero_fact;
	
	@Column(name="fac_total", length = 10)
	private double total;
	
	@Column(name="fac_iva", length = 10)
	private int iva;
	
	@OneToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "cabe_detalle_FK", referencedColumnName = "fac_cab_id")
	private List<FACT_Detalle> detalle;

	public int getIdFactCabecera() {
		return IdFactCabecera;
	}

	public void setIdFactCabecera(int idFactCabecera) {
		IdFactCabecera = idFactCabecera;
	}

	public Date getFecha_factura() {
		return fecha_factura;
	}

	public void setFecha_factura(Date fecha_factura) {
		this.fecha_factura = fecha_factura;
	}

	public int getNumero_fact() {
		return numero_fact;
	}

	public void setNumero_fact(int numero_fact) {
		this.numero_fact = numero_fact;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public List<FACT_Detalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<FACT_Detalle> detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "FACT_Cabecera [IdFactCabecera=" + IdFactCabecera + ", fecha_factura=" + fecha_factura + ", numero_fact="
				+ numero_fact + ", total=" + total + ", iva=" + iva + ", detalle=" + detalle + "]";
	}
	
	
	



}
