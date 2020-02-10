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

@Entity(name="LIB_CATEGORIA")
@Table(name="LIB_CATEGORIA")
public class Categoria {
	
	@Id
	@Column(name="cat_codigo")
	private int IdCategoria;
	
	@Column(name="cat_nombre")
	private String cat_nombre;
	
	@OneToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cat_producto_FK", referencedColumnName = "cat_codigo")
	private List<Producto> productos;
	
	public int getIdCategoria() {
		return IdCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		IdCategoria = idCategoria;
	}

	

	public String getCat_nombre() {
		return cat_nombre;
	}

	public void setCat_nombre(String cat_nombre) {
		this.cat_nombre = cat_nombre;
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
		return "Categoria [IdCategoria=" + IdCategoria + ", cat_nombre=" + cat_nombre + "]";
	}

	


}
