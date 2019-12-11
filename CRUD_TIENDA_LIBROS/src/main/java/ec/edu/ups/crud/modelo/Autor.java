package ec.edu.ups.crud.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LIB_AUTOR")
public class Autor {
	
	@Id
	@Column(name="aut_id" , length = 10)
	private int IdAutor;

	@Column(name="aut_nombre_autor" , length = 10)
	private String nombre_autor;
	
	@Column(name="aut_nacionalidadr" , length = 10)
	private String nacionalidad;

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

	@Override
	public String toString() {
		return "Autor [IdAutor=" + IdAutor + ", nombre_autor=" + nombre_autor + ", nacionalidad=" + nacionalidad + "]";
	}
	
	

}
