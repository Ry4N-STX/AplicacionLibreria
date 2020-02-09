package ec.edu.ups.crud.modelo;

public class LibroDetalle {
	
	
	private String nombre;
	
	
	private String cantidad;
	

	private String precio;
	
	
	private String total;
	
	
	private String url;
	
	private int idcarrito;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getIdcarrito() {
		return idcarrito;
	}

	public void setIdcarrito(int idcarrito) {
		this.idcarrito = idcarrito;
	}

	@Override
	public String toString() {
		return "LibroDetalle [nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + ", total=" + total
				+ ", url=" + url + ", idcarrito=" + idcarrito + "]";
	}
	
	

}
