package ec.edu.ups.crud.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.crud.datos.UsuarioDAO;
import ec.edu.ups.crud.modelo.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioControlador {
	
	private String cedulaDATO;
	private Usuario usuario;
	
	@Inject
	private UsuarioDAO udao;
	
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
		udao.insertar(usuario);
		return null;
	}
	
	public String limpiar(){
		setUsuario(null);
		return null;
	}
	
	public String buscarpersona() {
		setUsuario(udao.buscar(this.cedulaDATO));
		System.out.println("ENCONTRO ESTO :"+udao.buscar(cedulaDATO));
		return null;
	}
	
	public String mover(String cedula) {
		buscarPER(cedula);
		return "actualizarPersona";
	}
	
	public String buscarPER(String cedula) {
		setUsuario(udao.buscar(cedula));
		System.out.println("ENCONTRO ESTO :"+cedula);
		System.out.println("ENCONTRO ESTO :"+udao.buscar(cedula));
		return null;
	}
	
	public String actualizarp() {
		udao.actualizar(usuario);
		return null;
	}
	
	
	
	
	public String eliminar(String cedula) {
		udao.eliminar(cedula);
		return null;
	}
	
     public List<Usuario> mostrar(){
  	    return udao.listaUsuario();
     }
	

	public String getCedulaDATO() {
		return cedulaDATO;
	}

	public void setCedulaDATO(String cedulaDATO) {
		this.cedulaDATO = cedulaDATO;
	}

	
}
