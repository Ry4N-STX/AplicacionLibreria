package ec.edu.ups.crud.modelo;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="LIB_CATEGORIA")
public class Categoria {
	
	@Id
	@Column(name="cat_codigo")
	private int IdCategoria;
	
	@Column(name="cat_nombre", length = 10)
	private String Nombre;
	
	@OneToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cat_producto_FK", referencedColumnName = "cat_codigo")
	private List<Producto> productos;
	
	public int getIdCategoria() {
		return IdCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		IdCategoria = idCategoria;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public void addProducto(Producto pro) {
		if (productos == null) {
			productos=new ArrayList<>();
			
		}
		productos.add(pro);

	}

	@Override
	public String toString() {
		return "Categoria [IdCategoria=" + IdCategoria + ", Nombre=" + Nombre + ", productos=" + productos + "]";
	}


}
