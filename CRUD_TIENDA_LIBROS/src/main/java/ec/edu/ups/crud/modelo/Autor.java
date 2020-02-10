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
	@Column(name="aut_id")
	private int IdAutor;

	@Column(name="aut_nombre_autor")
	private String aut_nombre_autor;
	
	@Column(name="aut_nacionalidad")
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



	public String getAut_nombre_autor() {
		return aut_nombre_autor;
	}

	public void setAut_nombre_autor(String aut_nombre_autor) {
		this.aut_nombre_autor = aut_nombre_autor;
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
		return "Autor [IdAutor=" + IdAutor + ", aut_nombre_autor=" + aut_nombre_autor + ", nacionalidad=" + nacionalidad
				+ "]";
	}
	


}
