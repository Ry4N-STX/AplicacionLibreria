package ec.edu.ups.servicios;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ec.edu.ups.crud.controlador.ProductoControlado;
import ec.edu.ups.crud.controlador.UsuarioControlador;
import ec.edu.ups.crud.modelo.Producto;
import ec.edu.ups.crud.modelo.Usuario;
import ec.edu.ups.servicios.respues;


@Path("/services")
public class AplicacionServices {
	
	@Inject
	private ProductoControlado pc;
	@Inject
	private UsuarioControlador uc;

@GET
@Path("/listaproduct")
@Produces("application/json")
	public List<Producto> getproductos(){
		return pc.mostrarPro();
	}
@GET
@Path("/listausu")
@Produces("application/json")
	public List<Usuario> getusu(){
		return uc.mostrar();
	}

@POST
@Path("/ingresar")
@Produces("application/json")
@Consumes("application/json")
	public respues Ingresar(Usuario us){
	respues r=new respues();
	try {
		String mn=uc.guardarPersonaApli(us);
		r.setId(1);
		r.setMensaje(mn);
		
	} catch (Exception e) {
		r.setId(99);
		r.setMensaje("error al incertar");
		
	}
	return r;
	}



@POST
@Path("/Logearse")
@Produces("application/json")
@Consumes("application/json")
public respues log(Usuario us){
respues r=new respues();
try {
Usuario u1=uc.buscarapli(us.getCedula());
if(us.getPassword().equals(u1.getPassword())){
	r.setId(1);
	r.setMensaje("logeado");
}else {
	r.setId(2);
	r.setMensaje("contraseña incorrecta");
}	
	} catch (Exception e) {
		r.setId(99);
		r.setMensaje("error al incertar");
		
	}
	return r;
	}
}
