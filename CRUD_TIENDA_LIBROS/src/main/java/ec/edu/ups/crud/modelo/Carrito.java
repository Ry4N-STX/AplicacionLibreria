package ec.edu.ups.crud.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LIB_CARRITO")
public class Carrito {
	@Id
	@Column(name="car_id")
	private int idCarrito;
	
	
	@Column(name="car_cantidad")
	private int cantidad;


	public int getIdCarrito() {
		return idCarrito;
	}


	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", cantidad=" + cantidad + "]";
	}
	
	

}
