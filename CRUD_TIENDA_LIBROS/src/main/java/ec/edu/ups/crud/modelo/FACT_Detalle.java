package ec.edu.ups.crud.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LIB_FACT_Detalle")
public class FACT_Detalle {
	
	@Id
	@Column(name="factdetalle_id")
	private int IdFactDetalle;
	
	@Column(name="factdetalle_cantidad")
	private int cantidad;
	
	@Column(name="factdetalle_total")
	private long total;

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

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "FACT_Detalle [IdFactDetalle=" + IdFactDetalle + ", cantidad=" + cantidad + ", total=" + total + "]";
	}
	

}
