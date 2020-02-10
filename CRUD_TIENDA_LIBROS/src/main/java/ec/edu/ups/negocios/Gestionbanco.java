package ec.edu.ups.negocios;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.crud.modelo.*;
import ec.edu.ups.crud.datos.*;
@Stateless
public class Gestionbanco {
	
	
	@Inject
	private AutorDAO audao;
	@Inject
	private CarritoDAO cadao;
	@Inject
	private CategoriaDAO catdao;
	@Inject
	private DireccionDAO dirdao;
	@Inject
	private Fact_Cabecera_DAO factcadao;
	@Inject
	private Fact_Detalle_DAO factdedao;
	@Inject
	private ProductosDAO prodao;
	@Inject
	private TarjetaDAO tardao;
	@Inject
	private UsuarioDAO usudao;
	@Inject
	private VotoDAO votdao;
	
	/////////Autor
	
	public String guardarAUT(Autor autor) {
		audao.insertar(autor);
		return null;
	}
	
	public Autor buscarAUT(int id) {
		Autor a=audao.buscar(id);
		return a;
	}
	
	public List<Autor> mostrarAu(){
  	    return audao.listaAutor();
     }
	
	public String eliminarAu(int id) {
		audao.eliminar(id);
		return null;
	}
	
	public String actualizarAU(Autor autor) {
		audao.actualizar(autor);
		return null;
	}
	
	/////Categoria
	
	public String guardarCAT(Categoria categoria) {
		catdao.insertar(categoria);
		return null;
	}

	public Categoria buscarCAT(int cod) {
		Categoria c=catdao.buscar(cod);
		return c;
	}
	
	public List<Categoria> mostrarCat(){
  	    return catdao.listaCatgoria();
     }
	
	public String eliminarCA(int id) {
		catdao.eliminar(id);
		return null;
	}
	
	public List<Producto> likesre() {
 		return prodao.listaProductosLikes();
 	}
	
	public String actualizarCA(Categoria categoria) {
		catdao.actualizar(categoria);
		return null;
	}

	
	/////Producto
	
	public String guardarProducto(Producto producto) {
		prodao.insertar(producto);
		return null;
	}
	
	public List<Producto> mostrarPro(){
  	    return prodao.listaProductos();
     }
	
	public String eliminarLibro(String ISBN) {
		prodao.eliminar(ISBN);
		return null;
	}
	
	public Producto buscarPRO(String ISBN) {
		Producto pr=prodao.buscar(ISBN);
		return pr;
	}
	
	public String actualizarPRO(Producto producto) {
		prodao.actualizar(producto);
		return null;
	}
	
	/////Usuario


	public String guardarPersonaApli(Usuario usuario1) {
		usudao.insertar(usuario1);
		return "insertado";
	}
	
	public Usuario buscarPER(String cedula) {
		Usuario us=usudao.buscar(cedula);
		return us;
	}

	
	public String actualizarp(Usuario usuario1) {
		usudao.actualizar(usuario1);
		return null;
	}
	
	
	public String eliminarPersona(String cedula) {
		usudao.eliminar(cedula);
		return null;
	}
	
     public List<Usuario> mostrarPersonas(){
  	    return usudao.listaUsuario();
     }
	
     //////Fact_Cabecera
     public String guardarFac_Cabecera(FACT_Cabecera facCa) {
 		factcadao.insertar(facCa);
 		return "insertado";
 	}
 	
 	public FACT_Cabecera buscarFac_Cabecera(int id) {
 		FACT_Cabecera FC=factcadao.buscar(id);
 		return FC;
 	}

 	
 	public String actualizarFac_Cabecera(FACT_Cabecera facCa) {
 		factcadao.actualizar(facCa);
 		return null;
 	}
 	
 	
 	public String eliminarFac_Cabecera(int id) {
 		factcadao.eliminar(id);
 		return null;
 	}
 	
      public List<FACT_Cabecera> mostrarFac_Cabecera(){
   	    return factcadao.listaFACT_Cabecera();
      }

     //////Fact_Detalle
      public String guardarFACT_Detalle(FACT_Detalle facDE) {
   		factdedao.insertar(facDE);
   		return "insertado";
   	}
   	
   	public FACT_Detalle buscarFACT_Detalle(int id) {
   		FACT_Detalle FC=factdedao.buscar(id);
   		return FC;
   	}

   	
   	public String actualizarFACT_Detalle(FACT_Detalle facDE) {
   		factdedao.actualizar(facDE);
   		return null;
   	}
   	
   	
   	public String eliminarFACT_Detalle(int id) {
   		factdedao.eliminar(id);
   		return null;
   	}
   	
        public List<FACT_Detalle> mostrarFACT_Detalle(){
     	    return factdedao.listaFACT_Detalle();
        }
 
      
     //////Carrito

       
       	
       	public Carrito buscarCarrito(int id) {
       		Carrito c=cadao.buscar(id);
       		return c;
       	}

       	
       	public String actualizarCarrito(Carrito Carrito) {
       		cadao.actualizar(Carrito);
       		return null;
       	}
       	
       	
       	public String eliminarCarrito(int id) {
       	cadao.eliminar(id);
       		return null;
       	}
       	
            public List<Carrito> mostrarCarrito(){
         	    return cadao.listaCarrito();
            }
        
     //////Tarjeta 
     
            public String guardarTarjeta(Tarjeta Tarjeta) {
           		tardao.insertar(Tarjeta);
           		return "insertado";
           	}
           	
           	public Tarjeta buscarTarjeta(int id) {
           		Tarjeta t=tardao.buscar(id);
           		return t;
           	}

           	
           	public String actualizarTarjeta(Tarjeta Tarjeta) {
           		 tardao.actualizar(Tarjeta);
           		return null;
           	}
           	
           	
           	public String eliminarTarjeta(int id) {
           tardao.eliminar(id);
           		return null;
           	}
           	
                public List<Tarjeta> mostrarTarjeta(){
             	    return tardao.listaTarjetas  ();
                }     
            
            
     //////Direccion
                
                public String guardarDireccion(Direccion dir) {
               		dirdao.insertar(dir);;
               		return "insertado";
               	}
               	
               	public Direccion buscarDireccion(int id) {
               		Direccion dir=dirdao.buscar(id);
               		return dir;
               	}

               	
               	public String actualizarDireccion(Direccion dir) {
               		 dirdao.actualizar(dir);
               		return null;
               	}
               	
               	
               	public String eliminarDireccion(int id) {
               dirdao.eliminar(id);
               		return null;
               	}
               	
                    public List<Direccion> mostrarDireccion(){
                 	    return dirdao.listaDireccion();
                    }       
//////////////compra
                    public boolean carritoexis(String ci) {
                    	System.out.println("carro exits");
                    	List<Carrito> c=cadao.listaCarritoprueba(ci);
                    	if(c.isEmpty()) {
                    		return false;
                    	}else {
							return true;
						}   	
                    }
                    
                    public String guardarCarrito(String ISBN,String ci,int idcarr,int cant) {
                   		boolean ce=carritoexis(ci);
                   		System.out.println("antes del if");
                   		if (ce) { 
							List<Carrito> li=cadao.listaCarritoUsuario(ci);
						   for (Carrito c: li) {
								if (ISBN.equals(c.getId_prod_carrito_FK())) {
									Producto pr=prodao.buscar(ISBN);
									if((pr.getStock()-cant)>=0) {
										int canti=c.getCantidad();
										c.setCantidad(canti+1);
										c.setTotal((double)c.getCantidad()*pr.getPrecio());
										cadao.actualizar(c);
										return "insertado";
									}else {
										return "No existe el stock";
									}	
								}
							}
							Producto pr=prodao.buscar(ISBN);
							if((pr.getStock()-cant)>=0) {
								Carrito c= new Carrito();
		                   		c.setCantidad(cant);
		                   		c.setId_prod_carrito_FK(ISBN);
		                   		c.setId_usuario_FK(ci);
		                   		c.setTotal((double)c.getCantidad()*pr.getPrecio());
		                    	cadao.insertar(c);
		                   		return "insertado";
							}else {
								return "No existe el stock";
							}
							
							
						}else {
							System.out.println("este es el isbn---"+ISBN);
							Producto pr=prodao.buscar(ISBN);
							if((pr.getStock()-cant)>=0) {
								Carrito c= new Carrito();
		                   		c.setCantidad(cant);
		                   		c.setId_prod_carrito_FK(ISBN);
		                   		c.setId_usuario_FK(ci);
		                   		c.setTotal((double)c.getCantidad()*pr.getPrecio());
		                    	cadao.insertar(c);
		                   		return "insertado";
							}else {
								return "No existe el stock";
							}
	                   	
						}
                    	
                   	}   
                    
                    
                public List<Carrito> listaCarritoUsuario(String ci){
                	return cadao.listaCarritoUsuario(ci);
                }
                
                public double calculartotal(String ci) {
                	List<Carrito> listca= cadao.listaCarritoUsuario(ci);
                	double t=0;
                	for(Carrito c:listca) {
                		t=t+c.getTotal();
                	}
                	
                	return t;
                }
                
                public void generardatalles(String CI,int codfac) {
                	List<Carrito> c= cadao.listaCarritoUsuario(CI);
                	System.out.println("llea asta aqui 2");
                	for(Carrito ca: c){
                		System.out.println("llea asta aqui 3: "+ca.getIdCarrito());
                		FACT_Detalle fad=new FACT_Detalle();
                		fad.setCabe_detalle_FK(codfac);
                		fad.setCantidad(ca.getCantidad());
                		fad.setIdFactDetalle(ca.getIdCarrito());
                		fad.setTotal(ca.getTotal());
                		fad.setId_prod_detalle_FK(ca.getId_prod_carrito_FK());
                		System.out.println("llea asta aqui 4: "+codfac);
                		factdedao.insertar(fad);
                	}
                }
                public void cambiarstock_numeroventas(String CI,int codfac) {
                	List<Carrito> c= cadao.listaCarritoUsuario(CI);
                	for(Carrito ca: c){
                		Producto pr=prodao.buscar(ca.getId_prod_carrito_FK());
                		int sto=pr.getStock();
                		pr.setStock(sto-ca.getCantidad());
                		int nven=pr.getCantidad_vendidos();
                		pr.setCantidad_vendidos(nven+1);
                		prodao.actualizar(pr);
                	}
                }
                
                public void numerocomprasmonto(String CI, double total){
                	Usuario u = usudao.buscar(CI);
                	System.out.println("llea asta aqui: ");
                	int ncom=u.getNumero_compras();
                	u.setNumero_compras(ncom+1);
                	double mcom=u.getMonto_compras();
                	u.setMonto_compras(mcom+total);
                	usudao.actualizar(u);	
                }
                
                 public String eliminararticulo(int id) {
                	 try {
                		 cadao.eliminar(id);
                		 return "eliminado";
					} catch (Exception e) {
						return "Error al eliminar del carrito";
					}
                 }
                 
                 public String vaciarCarrito(String CI) {
                	 try {
                		 List<Carrito> c= cadao.listaCarritoUsuario(CI);
                     	for(Carrito ca: c){
                     		cadao.eliminar(ca.getIdCarrito());
                     	}	 
                		 return "eliminado";
					} catch (Exception e) {
						return "Error al eliminar del carrito";
					}
                 }
                 
                 
                 public String cambiarDcarrito(Carrito ca) {
                	
                	 try {
                		 Carrito c= cadao.buscar(ca.getIdCarrito());
                    	 Producto pr=prodao.buscar(c.getId_prod_carrito_FK());
                    	 c.setTotal((double)ca.getCantidad()*pr.getPrecio());
                    	 return "Cambio Realizado";
					} catch (Exception e) {
						return "Error cambio de cantidad";
					} 
                 }
                 
                 public String generarCompra(String CI,int tarid,int dirid) {
                	 int idfac=(int) ((Math.random()*(10 - 50000)+ 10)*-1);
                	 FACT_Cabecera fc=new FACT_Cabecera();
                	 
                	 Date date = new Date();
                	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                	String acf=dateFormat.format(date);
                	 fc.setFecha_factura(acf);
                	 fc.setId_usuario_FK(CI);
                	 fc.setIdFactCabecera(idfac);
                	 fc.setIva(0.14*calculartotal(CI));
                	 fc.setTotal(calculartotal(CI)+fc.getIva());
                	 fc.setId_cabecera_tarjeta_FK(tarid);
                	 fc.setId_cabecera_direccion_FK(dirid);
                	 factcadao.insertar(fc); 
                	generardatalles(CI, fc.getIdFactCabecera());
                	 cambiarstock_numeroventas(CI, idfac);
                	 numerocomprasmonto(fc.getId_usuario_FK(), fc.getTotal());
                	 vaciarCarrito(CI);
                	 return "compra registrada";
                 }
                
             	public List<Producto> mostrarProRepor(){
              	    return prodao.listaProductosporOdren();
                 }	
             	
             	
             	public List<Usuario> mostrarusuReportcompras(){
              	    return usudao.usuarioreportNumrocompras();
                 }
             	public List<Usuario> mostrarusuReportMontocompras(){
              	    return usudao.usuarioreportMontocomprado();
                 }
             	public boolean votar(String CI,String isbn, int estado) {
             		boolean vpr=votdao.votprev(CI, isbn);
             		if(vpr) {
             			Votoproducto v=votdao.buscarvot(CI, isbn);
             			Producto p=prodao.buscar(isbn);
             			if (v.getEstado()==1) {
             				v.setEstado(0);
             				int na=p.getLikes();
             				p.setLikes(na-1);
             				prodao.actualizar(p);
             				votdao.actualizar(v);
             				return true;
						}
             			if (v.getEstado()==0) {
             				v.setEstado(1);
             				int na=p.getLikes();
             				p.setLikes(na+1);
             				prodao.actualizar(p);
             				votdao.actualizar(v);
             				return true;
						}
   			
             		}else {
             			Votoproducto v1=new Votoproducto();
             			Producto p=prodao.buscar(isbn);
             			v1.setEstado(1);
             			v1.setVot_idPr(isbn);
             			v1.setVot_idUsu(CI);
             			int na=p.getLikes();
         				p.setLikes(na+1);
         				prodao.actualizar(p);
             			votdao.insertar(v1);
             		return true;	
					}  		
             		return false;
             	}
             	
             	public String insertardirec(Direccion d) {
             		
             		Direccion dir=new Direccion();
             		dir.setCalle1(d.getCalle1());
             		dir.setCalle2(d.getCalle2());
             		dir.setCiudad(d.getCiudad());
             		dir.setId_usuario_FK(d.getId_usuario_FK());
             		dir.setNumero_casa(d.getNumero_casa());
             		dir.setPais(d.getPais());
             		dirdao.insertar(dir);
             		return "direccion reistrada";
             	}
             	public String insertartarj(Tarjeta j) {
             		Tarjeta tr=new Tarjeta();
             		tr.setCodigo_validacion(j.getCodigo_validacion());
             		tr.setId_usuario_FK(j.getId_usuario_FK());
             		tr.setNumeroTarjeta(j.getNumeroTarjeta());
             		tr.setPropietario(j.getPropietario());
             		tardao.insertar(tr);
             		return "tarjeta reistrada";
             	}
             	
             	public Usuario usuloedo(String correo) {
             		return usudao.usuariolof(correo);
             	}
             	
             	public List<Usuario> usuloedo3(String correo) {
             		return usudao.usuariolof3(correo);
             	}
             	
             	public List<Direccion> listaDirecUsu(String CI) {
             		return dirdao.listaDireccionUsu(CI);
             	}
             	
             	public List<Tarjeta> listaTarjcUsu(String CI) {
             		return tardao.listaTarjetaUsuario(CI);
             	}
             	
             	public List<FACT_Cabecera> listaFactUsu(String CI) {
             		return factcadao.listaFACTCabeceraUsuario(CI);
             	}
             	
             	public List<FACT_Detalle> listaFactdetaUsu(int codigo) {
             		return factdedao.listaFACT_DetalleUsuario(codigo);
             	}
             	
             	public int idautor(String nombre) {
             		return audao.listid(nombre);
             	}
             	
             	public int idcat(String nombre) {
             		return catdao.listidcat(nombre);
             	}
             	
}	
