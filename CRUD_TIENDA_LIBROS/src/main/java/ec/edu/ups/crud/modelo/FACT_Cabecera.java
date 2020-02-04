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

@Entity(name="LIB_FACT_CABECERA")
@Table(name="LIB_FACT_CABECERA")
public class FACT_Cabecera {
	
	@Id
	@Column(name="fac_cab_id")
	private int IdFactCabecera;
	
	@Column(name="fac_fecha_factura")
	private String fecha_factura;
	
	@Column(name="fac_total", length = 10)
	private double total;
	
	@Column(name="fac_iva", length = 10)
	private double iva;
	
	@Column(name="id_usuario_FK" , length = 10)
	private String id_usuario_FK;
	
	@Column(name="id_cabecera_tarjeta_FK" , length = 10)
	private int id_cabecera_tarjeta_FK;
	
	@Column(name="id_cabecera_direccion_FK" , length = 10)
	private int id_cabecera_direccion_FK;
	
	@OneToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "cabe_detalle_FK", referencedColumnName = "fac_cab_id")
	private List<FACT_Detalle> detalle;

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

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public String getId_usuario_FK() {
		return id_usuario_FK;
	}

	public void setId_usuario_FK(String id_usuario_FK) {
		this.id_usuario_FK = id_usuario_FK;
	}

	public int getId_cabecera_tarjeta_FK() {
		return id_cabecera_tarjeta_FK;
	}

	public void setId_cabecera_tarjeta_FK(int id_cabecera_tarjeta_FK) {
		this.id_cabecera_tarjeta_FK = id_cabecera_tarjeta_FK;
	}

	public List<FACT_Detalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<FACT_Detalle> detalle) {
		this.detalle = detalle;
	}

	public int getId_cabecera_direccion_FK() {
		return id_cabecera_direccion_FK;
	}

	public void setId_cabecera_direccion_FK(int id_cabecera_direccion_FK) {
		this.id_cabecera_direccion_FK = id_cabecera_direccion_FK;
	}

	@Override
	public String toString() {
		return "FACT_Cabecera [IdFactCabecera=" + IdFactCabecera + ", fecha_factura=" + fecha_factura + ", total="
				+ total + ", iva=" + iva + ", id_usuario_FK=" + id_usuario_FK + ", id_cabecera_tarjeta_FK="
				+ id_cabecera_tarjeta_FK + ", id_cabecera_direccion_FK=" + id_cabecera_direccion_FK + "]";
	}

	

	



	
}
