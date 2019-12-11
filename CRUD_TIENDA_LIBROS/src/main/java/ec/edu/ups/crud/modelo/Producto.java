package ec.edu.ups.crud.modelo;

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
@Table(name="LIB_PRODUCTO")
public class Producto {
	
	
	@Id
	@Column(name="pro_ISBN", length = 10)
	private String ISBN;
	
	@Column(name="pro_nombre", length = 10)
	private String nombre;
	
	@Column(name="pro_editorial", length = 10)
	private String editorial;
	
	@Column(name="pro_anio_publicacion", length = 10)
	private int anio_publicacion;
	
	@Column(name="pro_link", length = 100)
	private String link;
	
	@Column(name="pro_descripcion", length = 500)
	private String descripcion;
	
	@Column(name="pro_stock", length = 10)
	private int stock;
	
	@Column(name="pro_precio", length = 10)
	private long precio;
	
	@Column(name="pro_cantidad_vendidos", length = 10)
	private int cantidad_vendidos;
	
	@Column(name="pro_likes", length = 10)
	private int likes;
	
	@OneToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_prod_detalle_FK", referencedColumnName = "pro_ISBN")
	private List<FACT_Detalle> detalles;
	
	@OneToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_prod_autor_FK", referencedColumnName = "pro_ISBN")
	private List<Autor> autor;
	
	@OneToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_prod_categoria_FK", referencedColumnName = "pro_ISBN")
	private List<Categoria> categoria;
	
	@OneToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_prod_carrito_FK", referencedColumnName = "pro_ISBN")
	private List<Carrito> carrito;

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

	public long getPrecio() {
		return precio;
	}

	public void setPrecio(long precio) {
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

	public List<FACT_Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<FACT_Detalle> detalles) {
		this.detalles = detalles;
	}

	public List<Autor> getAutor() {
		return autor;
	}

	public void setAutor(List<Autor> autor) {
		this.autor = autor;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

	public List<Carrito> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<Carrito> carrito) {
		this.carrito = carrito;
	}

	@Override
	public String toString() {
		return "Producto [ISBN=" + ISBN + ", nombre=" + nombre + ", editorial=" + editorial + ", anio_publicacion="
				+ anio_publicacion + ", link=" + link + ", descripcion=" + descripcion + ", stock=" + stock
				+ ", precio=" + precio + ", cantidad_vendidos=" + cantidad_vendidos + ", likes=" + likes + "]";
	}

}
