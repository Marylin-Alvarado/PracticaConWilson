/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.DAO.AdaptadorDao;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import java.io.IOException;
import modelo.MensajeriaPaquete;
import java.text.DecimalFormat;

/**
 *
 * @author darkangel
 */
public class MensajeriaDao extends AdaptadorDao<MensajeriaPaquete>{
    private MensajeriaPaquete mp;
    public MensajeriaDao() {
        super(MensajeriaPaquete.class);
    }

    public MensajeriaPaquete getMp() {
        if(mp == null)
            mp = new MensajeriaPaquete();
        return mp;
    }

    public void setmP(MensajeriaPaquete cb) {
        this.mp = cb;
    }
    public void guardar() throws IOException {
        mp.setId(generateId());
        this.guardar(mp);
    }

    public void modificar(Integer pos) throws IOException, VacioException, PosicionException {

        this.modificar(mp, pos);
    }
 

    private Integer generateId() {
        return listar().size() + 1;
    }
    
//    public MensajeriaPaquete buscarId(String nroCuenta) throws VacioException, PosicionException {
//        MensajeriaPaquete cuenta = null;
//        ListaEnlazada<MensajeriaPaquete> lista = listar();
//        for(int i = 0; i < lista.size(); i++) {
//            MensajeriaPaquete aux = lista.get(i);
//            if(aux.getLatitud().equalsIgnoreCase(nroCuenta)) {
//                cuenta = aux;
//                break;
//            }
//        }
//        return cuenta;
//    }
//    
    public static final double RADIO_TIERRA_KM = 6371.0; // Radio de la Tierra en kilómetros

    public  Double distancia(double latitud1, double longitud1, double latitud2, double longitud2) {
        Double phi1 = Math.toRadians(latitud1);
        Double phi2 = Math.toRadians(latitud2);
        Double deltaPhi = Math.toRadians(latitud2 - latitud1);
        Double deltaLambda = Math.toRadians(longitud2 - longitud1);

        Double a = Math.sin(deltaPhi / 2) * Math.sin(deltaPhi / 2) + Math.cos(phi1) * Math.cos(phi2) *
                   Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2);

        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        Double distancia = RADIO_TIERRA_KM * c;
    
          
        return distancia;
        
    }

    public static void main(String[] args) {
        try {
        MensajeriaDao mp = new MensajeriaDao();
//       mp.getMp().setNombreEmpresa("Expresito");
//       mp.getMp().setDireccion("Quito");
//       mp.getMp().setLatitud(-0.2298500);
//       mp.getMp().setLongitud(-78.5249500);
//       mp.guardar();
//       mp.setmP(null);
//       
//       mp.getMp().setNombreEmpresa("Courir");
//       mp.getMp().setDireccion("Zapotillo");
//       mp.getMp().setLatitud(-4.3863);
//       mp.getMp().setLongitud(-80.2447);
//       mp.guardar();
//       mp.setmP(null);
//       
//       mp.getMp().setNombreEmpresa("Fedmex");
//       mp.getMp().setDireccion("Catacocha");
//       mp.getMp().setLatitud(-4.0489);
//       mp.getMp().setLongitud(-79.6485);
//       mp.guardar();
//       mp.setmP(null);
//       
//       mp.getMp().setNombreEmpresa("Ecucorreo");
//       mp.getMp().setDireccion("Cotopaxi");
//       mp.getMp().setLatitud(-1.2503);
//       mp.getMp().setLongitud(-78.6252);
//       mp.guardar();
//       mp.setmP(null);
//       
//        mp.getMp().setNombreEmpresa("EntregaExpress");
//       mp.getMp().setDireccion("Manabi");
//       mp.getMp().setLatitud(-0.7417);
//       mp.getMp().setLongitud(-79.9193);
//       mp.guardar();
//       mp.setmP(null);
//       
//        mp.getMp().setNombreEmpresa("Expressito");
//       mp.getMp().setDireccion("Machala");
//       mp.getMp().setLatitud(-3.5551);
//       mp.getMp().setLongitud(-80.0594);
//       mp.guardar();
//       mp.setmP(null);
//       
////        MensajeriaDao mp = new MensajeriaDao();
//       mp.getMp().setNombreEmpresa("Expresito");
//       mp.getMp().setDireccion("Loja");
//       mp.getMp().setLatitud(-3.9931300);
//       mp.getMp().setLongitud(-79.2042200);
//       mp.guardar();
//       mp.setmP(null);
//       
       //cambiar latitud
        mp.getMp().setNombreEmpresa("EntregaExpress");
       mp.getMp().setDireccion("Pastaza");
       mp.getMp().setLatitud(-1.3975);
       mp.getMp().setLongitud(-78.4252);
       mp.guardar();
       mp.setmP(null);
       //cambiar latitud
        mp.getMp().setNombreEmpresa("Expressito");
       mp.getMp().setDireccion("Carchi");
       mp.getMp().setLatitud(-0.6626);
       mp.getMp().setLongitud(-78.0195);
       mp.guardar();
       mp.setmP(null);
       //cambiar latitud
       mp.getMp().setNombreEmpresa("Vilcabamba");
       mp.getMp().setDireccion("SantoDomingo");
       mp.getMp().setLatitud(-0.25);
       mp.getMp().setLongitud(-79.15);
       mp.guardar();
       mp.setmP(null);
       
       
       // 10 MAS 
       mp.getMp().setNombreEmpresa("Expresito");
       mp.getMp().setDireccion("Orellana");
       mp.getMp().setLatitud(-0.7113);
       mp.getMp().setLongitud(-77.1543);
       mp.guardar();
       mp.setmP(null);
       
       mp.getMp().setNombreEmpresa("Courir");
       mp.getMp().setDireccion("Imbabura");
       mp.getMp().setLatitud(0.3672);
       mp.getMp().setLongitud(-78.3842);
       mp.guardar();
       mp.setmP(null);
       
       mp.getMp().setNombreEmpresa("Fedmex");
       mp.getMp().setDireccion("Latacunga");
       mp.getMp().setLatitud( -0.9319);
       mp.getMp().setLongitud(-78.6161);
       mp.guardar();
       mp.setmP(null);
       
       mp.getMp().setNombreEmpresa("Ecucorreo");
       mp.getMp().setDireccion("Saraguro");
       mp.getMp().setLatitud(-3.6217);
       mp.getMp().setLongitud(-79.2381);
       mp.guardar();
       mp.setmP(null);
       
        mp.getMp().setNombreEmpresa("EntregaExpress");
       mp.getMp().setDireccion("SantaElena");
       mp.getMp().setLatitud(-2.1935);
       mp.getMp().setLongitud(-80.5438);
       mp.guardar();
       mp.setmP(null);
       
        mp.getMp().setNombreEmpresa("Expressito");
       mp.getMp().setDireccion("Esmeraldas");
       mp.getMp().setLatitud(0.95);
       mp.getMp().setLongitud(-79.6667);
       mp.guardar();
       mp.setmP(null);
       
       mp.getMp().setNombreEmpresa("Expresito");
       mp.getMp().setDireccion("MoronaSantiago");
       mp.getMp().setLatitud(-2.5628);
       mp.getMp().setLongitud(-78.1108);
       mp.guardar();
       mp.setmP(null);

        mp.getMp().setNombreEmpresa("EntregaExpress");
       mp.getMp().setDireccion("Pangui");
       mp.getMp().setLatitud(-3.629);
       mp.getMp().setLongitud(-78.5206);
       mp.guardar();
       mp.setmP(null);
       
        mp.getMp().setNombreEmpresa("Expressito");
       mp.getMp().setDireccion("Napo");
       mp.getMp().setLatitud(-0.7371);
       mp.getMp().setLongitud(-78.1108);
       mp.guardar();
       mp.setmP(null);
       
       mp.getMp().setNombreEmpresa("Vilcabamba");
       mp.getMp().setDireccion("Bolivar");
       mp.getMp().setLatitud(-1.2385);
       mp.getMp().setLongitud(-78.626);
       mp.guardar();
       mp.setmP(null);
        } catch (Exception e) {
        }
    }
    
}
