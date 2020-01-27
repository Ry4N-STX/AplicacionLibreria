package ec.edu.ups.crud.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LIB_FACT_Detalle")
public class FACT_Detalle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="factdetalle_id")
	private int IdFactDetalle;
	
	@Column(name="factdetalle_cantidad")
	private int cantidad;
	
	@Column(name="factdetalle_total")
	private double total;

	@Column(name="cabe_detalle_FK")
	private int cabe_detalle_FK;
	
	@Column(name="id_prod_detalle_FK")
	private String id_prod_detalle_FK;

	public int getIdFactDetalle() {
		return IdFactDetalle;
	}

	public void setIdFactDetalle(int idFactDetalle) {
		IdFactDetalle = idFactDetalle;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getCabe_detalle_FK() {
		return cabe_detalle_FK;
	}

	public void setCabe_detalle_FK(int cabe_detalle_FK) {
		this.cabe_detalle_FK = cabe_detalle_FK;
	}

	public String getId_prod_detalle_FK() {
		return id_prod_detalle_FK;
	}

	public void setId_prod_detalle_FK(String id_prod_detalle_FK) {
		this.id_prod_detalle_FK = id_prod_detalle_FK;
	}

	@Override
	public String toString() {
		return "FACT_Detalle [IdFactDetalle=" + IdFactDetalle + ", cantidad=" + cantidad + ", total=" + total
				+ ", cabe_detalle_FK=" + cabe_detalle_FK + ", id_prod_detalle_FK=" + id_prod_detalle_FK + "]";
	}
	
	

}
