package ec.edu.ups.crud.controlador;
  
import java.sql.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.crud.datos.UsuarioDAO;
import ec.edu.ups.crud.modelo.Usuario;
import ec.edu.ups.negocios.Gestionbanco;

@ManagedBean
@ViewScoped
public class UsuarioControlador {
	
	private String cedulaDATO;
	private Usuario usuario;
	
	@Inject
	private Gestionbanco udao;
	
	@PostConstruct
	private void init() {
		usuario=new Usuario();

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String guardarPersona() {
		System.out.println(usuario);
		udao.guardarPersonaApli(usuario);
		return null;
	}
	public String guardarPersonaApli(Usuario usuario1) {
		udao.guardarPersonaApli(usuario1);
		return "incertado";
	}
	
	public String limpiar(){
		setUsuario(null);
		return null;
	}
	
	public String buscarpersona() {
		setUsuario(udao.buscarPER(this.cedulaDATO));
		System.out.println("ENCONTRO ESTO :"+udao.buscarPER(cedulaDATO));
		return null;
	}
	
	public String mover(String cedula) {
		buscarPER(cedula);
		return "actualizarPersona";
	}
	
	public String buscarPER(String cedula) {
		setUsuario(udao.buscarPER(cedula));
		System.out.println("ENCONTRO ESTO :"+cedula);
		System.out.println("ENCONTRO ESTO :"+udao.buscarPER(cedula));
		return null;
	}
	public Usuario buscarapli(String cedula) {
		Usuario u=udao.buscarPER(cedula);
		return u;
	}
	

	
	public String actualizarp() {
		udao.actualizarp(usuario);
		return null;
	}
	
	
	public String eliminar(String cedula) {
		udao.eliminarPersona(cedula);
		return null;
	}
	
     public List<Usuario> mostrar(){
  	    return udao.mostrarPersonas();
     }
	

	public String getCedulaDATO() {
		return cedulaDATO;
	}

	public void setCedulaDATO(String cedulaDATO) {
		this.cedulaDATO = cedulaDATO;
	}

	
}
