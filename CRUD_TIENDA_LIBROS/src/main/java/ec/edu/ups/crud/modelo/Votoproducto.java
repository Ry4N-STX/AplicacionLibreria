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
	private String vot_idPr;
	
	@Column(name="vot_idUsu")
	private String vot_idUsu;
	
	@Column(name="vot_Estado")
	private int estado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVot_idPr() {
		return vot_idPr;
	}

	public void setVot_idPr(String vot_idPr) {
		this.vot_idPr = vot_idPr;
	}

	public String getVot_idUsu() {
		return vot_idUsu;
	}

	public void setVot_idUsu(String vot_idUsu) {
		this.vot_idUsu = vot_idUsu;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Votoproducto [id=" + id + ", vot_idPr=" + vot_idPr + ", vot_idUsu=" + vot_idUsu + ", estado=" + estado
				+ "]";
	}

	
	
	

}
