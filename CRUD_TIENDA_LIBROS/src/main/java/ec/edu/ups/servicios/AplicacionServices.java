package ec.edu.ups.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

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
@GET
@Path("/Logearse")
@Produces("application/json")
public String log(@QueryParam("correo")String correo,@QueryParam("pssw")String pssw){
respues r=new respues();
try {
	System.out.println("correo "+correo+" psw "+pssw);
Usuario u1=uc.usuloedo(correo);
if(pssw.equals(u1.getPassword())){
	return "Logeado";
}else {
	return "Parametros Inconrrectos 4";
}	
	} catch (Exception e) {
		return "Parametros Inconrrectos";
		
	}

	}


@GET
@Path("/obtenerLogearseusu")
@Produces("application/json")
//@Consumes("application/json")
public List<Usuario> logusuobtener(@QueryParam("correo")String correo){
try {
	return uc.usuloedo3(correo);

	} catch (Exception e) {
		return null;
		
	}

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
public List<Carrito> listavcarrito(Carrito c){
	return gtio.listaCarritoUsuario(c.getId_usuario_FK());
}


@GET
@Path("/listaDirusuario")
@Produces("application/json")
public List<Direccion> listaDirUsu(@QueryParam("CI") String CI){
	return gtio.listaDirecUsu(CI);
}

@GET
@Path("/listafactcabe")
@Produces("application/json")
public List<FacCabemos> listafacusu(@QueryParam("CI") String CI){
	List<FACT_Cabecera> fa=gtio.listaFactUsu(CI);
	List<FacCabemos> faM= new ArrayList<FacCabemos>();
	for (FACT_Cabecera f:fa) {
		FacCabemos fm=new FacCabemos();
		fm.setIdFactCabecera(f.getIdFactCabecera());
		fm.setFecha_factura(f.getFecha_factura());
		fm.setTotal(f.getTotal());
		faM.add(fm);
	}
	 
	return faM;
}



@GET
@Path("/listaTarjetausuario")
@Produces("application/json")
public List<Tarjeta> listaTarjeUsu(@QueryParam("CI") String CI){
	return gtio.listaTarjcUsu(CI);
}



@GET
@Path("/listacarritousuarionuevo")
@Produces("application/json")
public List<LibroDetalle> listavcarritonueva(@QueryParam("CI")String ci){
	List<Carrito> ca= gtio.listaCarritoUsuario(ci);
	List<LibroDetalle> nuev = new ArrayList<LibroDetalle>();
	for(Carrito c: ca) {
		LibroDetalle lid=new LibroDetalle();
		Producto p=gtio.buscarPRO(c.getId_prod_carrito_FK());
		lid.setNombre(p.getNombre());
		lid.setCantidad(String.valueOf(c.getCantidad()));
		lid.setIdcarrito(c.getIdCarrito());
		lid.setPrecio(String.valueOf(p.getPrecio()));
		lid.setTotal(String.valueOf(c.getTotal()));
		lid.setUrl(p.getLink());
		System.out.println("esta aqui 1");
		boolean a=nuev.add(lid);
		System.out.println("esta aqui 3");
	}
	return nuev;
}




@GET
@Path("/listadetallesfact")
@Produces("application/json")
public List<LibroDetalle> listadetallesfact(@QueryParam("codfac")int idfac){
	List<FACT_Detalle> det= gtio.listaFactdetaUsu(idfac);
	List<LibroDetalle> nuev = new ArrayList<LibroDetalle>();
	for(FACT_Detalle detll: det) {
		LibroDetalle lid=new LibroDetalle();
		Producto p=gtio.buscarPRO(detll.getId_prod_detalle_FK());
		lid.setNombre(p.getNombre());
		lid.setCantidad(String.valueOf(detll.getCantidad()));
		lid.setIdcarrito(detll.getIdFactDetalle());
		lid.setPrecio(String.valueOf(p.getPrecio()));
		lid.setTotal(String.valueOf(detll.getTotal()));
		lid.setUrl(p.getLink());
		boolean a=nuev.add(lid);
	}
	return nuev;
}




@GET
@Path("/listapruieba")
@Produces("application/json")
	public List<FACT_Cabecera> getfacabe(){
		return gtio.mostrarFac_Cabecera();
	}

@POST
@Path("/agregaralcarrito")
@Produces("application/json")
@Consumes("application/json")
public respues ingresarcarrito(Carrito ca){
	
	respues r=new respues();
	try {
		String mn=gtio.guardarCarrito(ca.getId_prod_carrito_FK(),ca.getId_usuario_FK(),	ca.getIdCarrito(),ca.getCantidad());
		r.setId(1);
		r.setMensaje(mn);
		
	} catch (Exception e) {
		r.setId(99);
		r.setMensaje("error");
		
	}
	return r;
}


@GET
@Path("/eliminararticulo")
@Produces("application/json")
public respues borarcarrito(@QueryParam("idcarrito")int idCarrito){
	respues r=new respues();
	try {
		String mn=gtio.eliminararticulo(idCarrito);
		r.setId(1);
		r.setMensaje(mn);
		
	} catch (Exception e) {
		r.setId(99);
		r.setMensaje("error");
		
	}
	return r;
}


@GET
@Path("/generarfactura")
@Produces("application/json")
public respues generarfactura(@QueryParam("CI")String CI,@QueryParam("idtar")int idtar,@QueryParam("iddir")int iddir){
	respues r=new respues();
	try {
		String mn=gtio.generarCompra(CI,idtar,iddir);
		r.setId(1);
		r.setMensaje(mn);
		
	} catch (Exception e) {
		r.setId(99);
		r.setMensaje("error");
		
	}
	return r;
}


@POST
@Path("/buscarproducto")
@Produces("application/json")
@Consumes("application/json")
public Producto buscarproducto(String ISBN){
	Producto p=gtio.buscarPRO(ISBN);
	return p;
}

@GET
@Path("/votar")
@Produces("application/json")
	public boolean votarpro(@QueryParam("cedula") String CI,@QueryParam("isbn") String isbn,@QueryParam("estado") int estado){
		return gtio.votar(CI, isbn, estado);
	}


@POST
@Path("/ingresardir")
@Produces("application/json")
@Consumes("application/json")
	public respues IngresarDir(Direccion dir){
	respues r=new respues();
	try {
		String mn=gtio.insertardirec(dir);
		r.setId(1);
		r.setMensaje(mn);
		
	} catch (Exception e) {
		r.setId(99);
		r.setMensaje("error al insertar");
		
	}
	return r;
	}

@POST
@Path("/ingresartar")
@Produces("application/json")
@Consumes("application/json")
	public respues IngresarTarj(Tarjeta tar){
	respues r=new respues();
	try {
		String mn=gtio.insertartarj(tar);
		r.setId(1);
		r.setMensaje(mn);
		
	} catch (Exception e) {
		r.setId(99);
		r.setMensaje("error al insertar");
		
	}
	return r;
	}
}





