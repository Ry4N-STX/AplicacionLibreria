package ec.edu.ups.servicios;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ec.edu.ups.crud.controlador.CategoriaControlador;
import ec.edu.ups.crud.controlador.ProductoControlado;
import ec.edu.ups.crud.controlador.UsuarioControlador;
import ec.edu.ups.crud.modelo.*;
import ec.edu.ups.negocios.Gestionbanco;
import ec.edu.ups.crud.modelo.Categoria;
import ec.edu.ups.servicios.respues;


@Path("/services")
public class AplicacionServices {

	@Inject
	private ProductoControlado pc;
	@Inject
	private UsuarioControlador uc;
	@Inject
	private CategoriaControlador cc;
	
	@Inject
	private Gestionbanco gtio;
	/**
     * Metodo que nos permite listar todos los productos 
     * que se encuentran en la base
     * @return una lista de todos Productos de la base
     */
@GET
@Path("/listaproduct")
@Produces("application/json")
	public List<Producto> getproductos(){
		return pc.mostrarPro();
	}
/**
 * Metodo que nos permite listar todos los usuarios
 * este metodo se implemento con el fin de obtener a los usuarios en un json
 * @return una lista de todos los Usuarios de la base
 */
@GET
@Path("/listausu")
@Produces("application/json")
	public List<Usuario> getusu(){
		return uc.mostrar();
	}
/**
 * Metodo que nos permite listar todos las categorias
 * que se encuentran en la base
 * @return una lista de todas las categorias de la base
 */
@GET
@Path("/listacat")
@Produces("application/json")
	public List<Categoria> getcat(){
		return cc.mostrarCat();
	}
/**
 * Metodo que nos permite registrar un cliente 
 * en la base de datos
 * @param recibe una usuario de tipo Usuario para ingresarlo
 * @return nos da una respuesta con el estado de la transaccion
 */
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
		r.setMensaje("error al insertar");
		
	}
	return r;
	}
/**
 * Metodo que nos permite comparar las contraseñas 
 * y dar acceso a la aplicacion
 * @param recibe una usuario de tipo Usuario para comparar
 * @return nos da una respuesta con el estado de la transaccion
 */
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


/**
 * Metodo que nos permite comparar las contraseñas 
 * y dar acceso a la aplicacion
 * @param recibe una usuario de tipo Usuario para comparar
 * @return nos da una respuesta con el estado de la transaccion
 */
@POST
@Path("/listacarritousuario")
@Produces("application/json")
@Consumes("application/json")
public List<Carrito> listavcarrito(String CI){
	return gtio.listaCarritoUsuario(CI);
}


@GET
@Path("/listapruieba")
@Produces("application/json")
	public List<Carrito> getcarrito(){
		return gtio.listaCarritoUsuario("1600537029");
	}

@POST
@Path("/agregaralcarrito")
@Produces("application/json")
@Consumes("application/json")
public respues ingresarcarrito(String ISBN){
	respues r=new respues();
	try {
		String mn=gtio.guardarCarrito(ISBN,"1600537029");
		r.setId(1);
		r.setMensaje(mn);
		
	} catch (Exception e) {
		r.setId(99);
		r.setMensaje("error");
		
	}
	return r;
}


@POST
@Path("/eliminararticulo")
@Produces("application/json")
@Consumes("application/json")
public respues borarcarrito(int cod){
	respues r=new respues();
	try {
		String mn=gtio.eliminararticulo(cod);
		r.setId(1);
		r.setMensaje(mn);
		
	} catch (Exception e) {
		r.setId(99);
		r.setMensaje("error");
		
	}
	return r;
}


@POST
@Path("/generarfactura")
@Produces("application/json")
@Consumes("application/json")
public respues generarfactura(String CI){
	respues r=new respues();
	try {
		String mn=gtio.generarCompra(CI);
		r.setId(1);
		r.setMensaje(mn);
		
	} catch (Exception e) {
		r.setId(99);
		r.setMensaje("error");
		
	}
	return r;
}




}




