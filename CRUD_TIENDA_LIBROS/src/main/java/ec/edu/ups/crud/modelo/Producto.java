package ec.edu.ups.crud.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="LIB_PRODUCTO")
@Table(name="LIB_PRODUCTO")
public class Producto {
	
	@Id
	@Column(name="pro_ISBN", length = 10)
	private String ISBN;
	
	@Column(name="pro_nombre", length = 200)
	private String nombre;
	
	@Column(name="pro_editorial", length = 200)
	private String editorial;
	
	@Column(name="pro_anio_publicacion", length = 200)
	private int anio_publicacion;
	
	@Column(name="pro_link", length = 200)
	private String link;
	
	@Column(name="pro_descripcion", length = 500)
	private String descripcion;
	
	@Column(name="pro_stock", length = 10)
	private int stock;
	
	@Column(name="pro_precio", length = 10)
	private double precio;
	
	@Column(name="pro_cantidad_vendidos")
	private int cantidad_vendidos;
	 
	@Column(name="pro_likes", length = 10)
	private int likes;
	
	@Column(name="id_cat_producto_FK")
	private int id_cat_producto_FK;
	
	@Column(name="id_aut_producto_FK")
	private int id_aut_producto_FK;
	
	//@ManyToOne(cascade =  {CascadeType.ALL}, fetch = FetchType.LAZY)
	//private Categoria categoria;
	
	//@ManyToOne(cascade =  {CascadeType.ALL}, fetch = FetchType.LAZY)
	//private Autor autor;
	
	//@OneToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.LAZY)
	//@JoinColumn(name = "id_prod_detalle_FK", referencedColumnName = "pro_ISBN")
	//private List<FACT_Detalle> detalles;
	
	//@OneToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.LAZY)
	//@JoinColumn(name = "id_prod_carrito_FK", referencedColumnName = "pro_ISBN")
	//private List<Carrito> carrito;

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getAnio_publicacion() {
		return anio_publicacion;
	}

	public void setAnio_publicacion(int anio_publicacion) {
		this.anio_publicacion = anio_publicacion;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad_vendidos() {
		return cantidad_vendidos;
	}

	public void setCantidad_vendidos(int cantidad_vendidos) {
		this.cantidad_vendidos = cantidad_vendidos;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	//public List<FACT_Detalle> getDetalles() {
//		return detalles;
	//}

	//public void setDetalles(List<FACT_Detalle> detalles) {
	//this.detalles = detalles;
	//}

	//public List<Carrito> getCarrito() {
	//	return carrito;
	//}

	//public void setCarrito(List<Carrito> carrito) {
	//		this.carrito = carrito;
	//}
	
	

	//public Categoria getCategoria() {
	//	return categoria;
	//}

	//public void setCategoria(Categoria categoria) {
	//	this.categoria = categoria;
	//}

	public int getId_cat_producto_FK() {
		return id_cat_producto_FK;
	}

	public void setId_cat_producto_FK(int id_cat_producto_FK) {
		this.id_cat_producto_FK = id_cat_producto_FK;
	}

	public int getId_aut_producto_FK() {
		return id_aut_producto_FK;
	}

	public void setId_aut_producto_FK(int id_aut_producto_FK) {
		this.id_aut_producto_FK = id_aut_producto_FK;
	}

	@Override
	public String toString() {
		return "Producto [ISBN=" + ISBN + ", nombre=" + nombre + ", editorial=" + editorial + ", anio_publicacion="
				+ anio_publicacion + ", link=" + link + ", descripcion=" + descripcion + ", stock=" + stock
				+ ", precio=" + precio + ", cantidad_vendidos=" + cantidad_vendidos + ", likes=" + likes
				+ ", id_cat_producto_FK=" + id_cat_producto_FK + ", id_aut_producto_FK=" + id_aut_producto_FK + "]";
	}
	
	


	//public Autor getAutor() {
	//	return autor;
	//}

	//public void setAutor(Autor autor) {
	//	this.autor = autor;
	//}
	
	



	


}
