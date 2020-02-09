package ec.edu.ups.crud.modelo;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="Votoproducto")
@Table(name="Votoproducto")
public class Votoproducto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="vot_id")
	private int id;
	
	@Column(name="vot_idPr")
	private String idPr;
	
	@Column(name="vot_idUsu")
	private String isUsu;
	
	@Column(name="vot_Estado")
	private int estado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdPr() {
		return idPr;
	}

	public void setIdPr(String idPr) {
		this.idPr = idPr;
	}

	public String getIsUsu() {
		return isUsu;
	}

	public void setIsUsu(String isUsu) {
		this.isUsu = isUsu;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Votoproducto [id=" + id + ", idPr=" + idPr + ", isUsu=" + isUsu + ", estado=" + estado + "]";
	}
	

}
