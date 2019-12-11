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

@Entity(name="LIB_AUTOR")
@Table(name="LIB_AUTOR")
public class Autor {
	
	@Id
	@Column(name="aut_id" , length = 10)
	private int IdAutor;

	@Column(name="aut_nombre_autor" , length = 10)
	private String nombre_autor;
	
	@Column(name="aut_nacionalidad" , length = 10)
	private String nacionalidad;
	
	
	@OneToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_aut_producto_FK", referencedColumnName = "aut_id")
	private List<Producto> productos;

	public int getIdAutor() {
		return IdAutor;
	}

	public void setIdAutor(int idAutor) {
		IdAutor = idAutor;
	}

	public String getNombre_autor() {
		return nombre_autor;
	}

	public void setNombre_autor(String nombre_autor) {
		this.nombre_autor = nombre_autor;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	
	public List<Producto> getProductos() {
	return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public void addProducto(Producto prod) {
		if (productos == null) {
			productos=new ArrayList<>();
		}
		productos.add(prod);

	}
	@Override
	public String toString() {
		return "Autor [IdAutor=" + IdAutor + ", nombre_autor=" + nombre_autor + ", nacionalidad=" + nacionalidad
				+ "]";
	}


}
