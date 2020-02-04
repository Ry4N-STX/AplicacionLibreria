package ec.edu.ups.crud.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="LIB_CARRITO")
@Table(name="LIB_CARRITO")
public class Carrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="car_id")
	private int idCarrito;
	//comtrio
	
	@Column(name="car_cantidad")
	private int cantidad;
	
	@Column(name="car_total")
	private double total;
	
	@Column(name="id_prod_carrito_FK")
	private String id_prod_carrito_FK;
	
	@Column(name="id_usuario_FK")
	private String id_usuario_FK;

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

	public String getId_prod_carrito_FK() {
		return id_prod_carrito_FK;
	}

	public void setId_prod_carrito_FK(String id_prod_carrito_FK) {
		this.id_prod_carrito_FK = id_prod_carrito_FK;
	}

	public String getId_usuario_FK() {
		return id_usuario_FK;
	}

	public void setId_usuario_FK(String id_usuario_FK) {
		this.id_usuario_FK = id_usuario_FK;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", cantidad=" + cantidad + ", total=" + total
				+ ", id_prod_carrito_FK=" + id_prod_carrito_FK + ", id_usuario_FK=" + id_usuario_FK + "]";
	}

	
	
	
}
