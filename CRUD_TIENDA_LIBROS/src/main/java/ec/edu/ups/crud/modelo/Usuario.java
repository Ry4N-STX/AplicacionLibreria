package ec.edu.ups.crud.modelo;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity(name="LIB_USUARIO")
@Table(name="LIB_USUARIO")
public class Usuario {

	@Id
	@Column(name="usu_cedula" , length = 10)
	private String cedula;
	
	@Column(name="usu_nombres", length = 10)
	private String nombres;
	
	@Column(name="usu_apellidos", length = 10)
	private String apellidos;
	
	@Email
	@Column(name="usu_email")
	private String email;
	
	@Column(name="usu_telefono", length = 9)
	private int telefono;
	
	@Column(name="usu_fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	private Date fecha_nacimiento;
	
	@Column(name="usu_contrasenia")
	private String password;
	
	@Column(name="usu_numero_compras")
	private int numero_compras;
	
	@Column(name="usu_monto_compras")
	private int monto_compras;
	
	@Column(name="usu_direccion_vivienda")
	private String direccion_vivienda;
	
	@Column(name="usu_tipo")
	private String Tipo;
	
	@OneToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario_tarjeta_FK", referencedColumnName = "usu_cedula")
	private List<Tarjeta> tarjeta;
	
	@OneToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario_cabecera_FK", referencedColumnName = "usu_cedula")
	private List<FACT_Cabecera> cabecera;
	
	@OneToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario_direccion_FK", referencedColumnName = "usu_cedula")
	private List<Direccion> direccion;
	
	@OneToMany(cascade =  {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario_carrito_FK", referencedColumnName = "usu_cedula")
	private List<Carrito> carrito;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNumero_compras() {
		return numero_compras;
	}

	public void setNumero_compras(int numero_compras) {
		this.numero_compras = numero_compras;
	}

	public int getMonto_compras() {
		return monto_compras;
	}

	public void setMonto_compras(int monto_compras) {
		this.monto_compras = monto_compras;
	}

	public String getDireccion_vivienda() {
		return direccion_vivienda;
	}

	public void setDireccion_vivienda(String direccion_vivienda) {
		this.direccion_vivienda = direccion_vivienda;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public List<Tarjeta> getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(List<Tarjeta> tarjeta) {
		this.tarjeta = tarjeta;
	}

	public List<FACT_Cabecera> getCabecera() {
		return cabecera;
	}

	public void setCabecera(List<FACT_Cabecera> cabecera) {
		this.cabecera = cabecera;
	}

	public List<Direccion> getDireccion() {
		return direccion;
	}

	public void setDireccion(List<Direccion> direccion) {
		this.direccion = direccion;
	}

	public List<Carrito> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<Carrito> carrito) {
		this.carrito = carrito;
	}

	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email
				+ ", telefono=" + telefono + ", fecha_nacimiento=" + fecha_nacimiento + ", password=" + password
				+ ", numero_compras=" + numero_compras + ", monto_compras=" + monto_compras + ", direccion_vivienda="
				+ direccion_vivienda + ", Tipo=" + Tipo + "]";
	}
	
	


}
