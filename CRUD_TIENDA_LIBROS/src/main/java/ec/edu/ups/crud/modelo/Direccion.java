package ec.edu.ups.crud.modelo;

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

@Entity(name="LIB_DIRECCION")
@Table(name="LIB_DIRECCION")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dir_id" , length = 10)
	private int IdDireccion;
	
	@Column(name="dir_pais" , length = 10)
	private String pais;
	
	@Column(name="dir_ciudad" , length = 10)
	private String ciudad;
	
	@Column(name="dir_calle1" , length = 10)
	private String calle1;
	
	@Column(name="dir_calle2" , length = 10)
	private String calle2;
	
	@Column(name="dir_numero_casa" , length = 10)
	private String numero_casa;
	
	@Column(name="id_usuario_FK" , length = 10)
	private String id_usuario_FK;
	
	@OneToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cabecera_direccion_FK", referencedColumnName = "dir_id")
	private List<FACT_Cabecera> cabecera;


	public int getIdDireccion() {
		return IdDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		IdDireccion = idDireccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCalle1() {
		return calle1;
	}

	public void setCalle1(String calle1) {
		this.calle1 = calle1;
	}

	public String getCalle2() {
		return calle2;
	}

	public void setCalle2(String calle2) {
		this.calle2 = calle2;
	}

	public String getNumero_casa() {
		return numero_casa;
	}

	public void setNumero_casa(String numero_casa) {
		this.numero_casa = numero_casa;
	}

	public String getId_usuario_FK() {
		return id_usuario_FK;
	}

	public void setId_usuario_FK(String id_usuario_FK) {
		this.id_usuario_FK = id_usuario_FK;
	}

	@Override
	public String toString() {
		return "Direccion [IdDireccion=" + IdDireccion + ", pais=" + pais + ", ciudad=" + ciudad + ", calle1=" + calle1
				+ ", calle2=" + calle2 + ", numero_casa=" + numero_casa + ", id_usuario_FK=" + id_usuario_FK + "]";
	}
	

}	

