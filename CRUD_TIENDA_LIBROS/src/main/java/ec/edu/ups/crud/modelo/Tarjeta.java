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

@Entity
@Table(name="LIB_TARJETA")
public class Tarjeta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tar_id")
	private int IdTarjeta;
	
	@Column(name="tar_numero_tarjeta", length = 50)
	private String numeroTarjeta;
	
	@Column(name="tar_codigo_validacion")
	private int codigo_validacion;
	
	@Column(name="tar_propietario", length = 10)
	private String propietario;
	
	@Column(name="id_usuario_FK", length = 10)
	private String id_usuario_FK;
	
	@OneToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cabecera_tarjeta_FK", referencedColumnName = "tar_id")
	private List<FACT_Cabecera> cabecera;

	public int getIdTarjeta() {
		return IdTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		IdTarjeta = idTarjeta;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public int getCodigo_validacion() {
		return codigo_validacion;
	}

	public void setCodigo_validacion(int codigo_validacion) {
		this.codigo_validacion = codigo_validacion;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getId_usuario_FK() {
		return id_usuario_FK;
	}

	public void setId_usuario_FK(String id_usuario_FK) {
		this.id_usuario_FK = id_usuario_FK;
	}

	public List<FACT_Cabecera> getCabecera() {
		return cabecera;
	}

	public void setCabecera(List<FACT_Cabecera> cabecera) {
		this.cabecera = cabecera;
	}

	@Override
	public String toString() {
		return "Tarjeta [IdTarjeta=" + IdTarjeta + ", numeroTarjeta=" + numeroTarjeta + ", codigo_validacion="
				+ codigo_validacion + ", propietario=" + propietario + ", id_usuario_FK=" + id_usuario_FK
				+ ", cabecera=" + cabecera + "]";
	}

}
