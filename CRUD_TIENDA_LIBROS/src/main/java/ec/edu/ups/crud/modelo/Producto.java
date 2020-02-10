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
	@Column(name="pro_ISBN")
	private String ISBN;
	
	@Column(name="pro_nombre")
	private String nombre;
	
	@Column(name="pro_editorial")
	private String editorial;
	
	@Column(name="pro_anio_publicacion")
	private String anio_publicacion;
	
	@Column(name="pro_link")
	private String link;
	
	@Column(name="pro_descripcion")
	private String descripcion;
	
	@Column(name="pro_stock")
	private int stock;
	
	@Column(name="pro_precio")
	private double precio;
	
	@Column(name="pro_cantidad_vendidos")
	private int cantidad_vendidos;
	 
	@Column(name="pro_likes")
	private int likes;
	
	@Column(name="id_cat_producto_FK")
	private int id_cat_producto_FK;
	
	@Column(name="id_aut_producto_FK")
	private int id_aut_producto_FK;
	
	
	@OneToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_prod_detalle_FK", referencedColumnName = "pro_ISBN")
	private List<FACT_Detalle> detalles;
	
	@OneToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_prod_carrito_FK", referencedColumnName = "pro_ISBN")
	private List<Carrito> carrito;
	
	@OneToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "idPr", referencedColumnName = "pro_ISBN")
	private List<Votoproducto> votos;

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

	public String getAnio_publicacion() {
		return anio_publicacion;
	}

	public void setAnio_publicacion(String anio_publicacion) {
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
