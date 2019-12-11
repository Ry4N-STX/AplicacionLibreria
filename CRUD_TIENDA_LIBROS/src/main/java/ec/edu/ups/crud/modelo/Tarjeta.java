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
@Table(name="LIB_TARJETA")
public class Tarjeta {
	
	@Id
	@Column(name="tar_id")
	private int IdTarjeta;
	
	@Column(name="tar_numero_tarjeta", length = 50)
	private String numeroTarjeta;
	
	@Column(name="tar_codigo_validacion")
	private int codigo_validacion;
	
	@Column(name="tar_propietario", length = 10)
	private String propietario;
	
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

	public List<FACT_Cabecera> getCabecera() {
		return cabecera;
	}

	public void setCabecera(List<FACT_Cabecera> cabecera) {
		this.cabecera = cabecera;
	}

	@Override
	public String toString() {
		return "Tarjeta [IdTarjeta=" + IdTarjeta + ", numeroTarjeta=" + numeroTarjeta + ", codigo_validacion="
				+ codigo_validacion + ", propietario=" + propietario + "]";
	}
	

}
