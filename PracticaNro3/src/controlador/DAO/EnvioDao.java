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
import java.util.Date;
import modelo.Envio;

/**
 *
 * @author darkangel
 */
public class EnvioDao extends AdaptadorDao<Envio> {

    private Envio cb;

    public EnvioDao() {
        super(Envio.class);
    }

    public Envio getCb() {
        if (cb == null) {
            cb = new Envio();
        }
        return cb;
    }

    public void setCb(Envio cb) {
        this.cb = cb;
    }

    public void guardar() throws IOException {
        cb.setId(generateId());
        this.guardar(cb);
    }

    public void modificar(Integer pos) throws IOException, VacioException, PosicionException {

        this.modificar(cb, pos);
    }

    private Integer generateId() {
        return listar().size() + 1;
    }

    public Envio buscarId(String nroCuenta) throws VacioException, PosicionException {
        Envio cuenta = null;
        ListaEnlazada<Envio> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Envio aux = lista.get(i);
            if (aux.getNombre_Empresa().equalsIgnoreCase(nroCuenta)) {
                cuenta = aux;
                break;
            }
        }
        return cuenta;
    }

    public ListaEnlazada<Envio> listaPorDireccion(Integer id) throws VacioException, PosicionException {
        ListaEnlazada<Envio> lista = new ListaEnlazada<>();
        ListaEnlazada<Envio> listado = listar();
        for (int i = 0; i < listado.size(); i++) {
            Envio aux = listado.get(i);
            if (aux.getId_Mensajeria().intValue() == id) {
                lista.insertar(aux);
            }
        }
        return lista;
    }

    public static void main(String[] args) {
        try {
            EnvioDao ed = new EnvioDao();
            ed.getCb().setId_Mensajeria(0);
            ed.getCb().setNombre_Empresa("Correos");
                ed.getCb().setDireccion("Loja");
            ed.getCb().setPaquete("celular");
            ed.getCb().setDestinatario("Wilson");
            ed.getCb().setFecha(new Date());
            ed.getCb().setValor(200.00);
            ed.guardar();
            ed.setCb(null);

            ed.getCb().setId_Mensajeria(6);
            ed.getCb().setNombre_Empresa("ServiEntrega");
            ed.getCb().setDireccion("Machala");
            ed.getCb().setPaquete("lampara");
            ed.getCb().setDestinatario("Carlos");
            ed.getCb().setFecha(new Date());
            ed.getCb().setValor(500.00);
            ed.guardar();
            ed.setCb(null);

            ed.getCb().setId_Mensajeria(2);
            ed.getCb().setNombre_Empresa("Correos");
            ed.getCb().setDireccion("Manabi");
            ed.getCb().setPaquete("iphone");
            ed.getCb().setDestinatario("Marilyn");
            ed.getCb().setFecha(new Date());
            ed.getCb().setValor(300.00);

            ed.guardar();
            ed.setCb(null);

            ed.getCb().setId_Mensajeria(5);
            ed.getCb().setNombre_Empresa("ServiEntrega");
            ed.getCb().setDireccion("Catacocha");
            ed.getCb().setPaquete("tv");
            ed.getCb().setDestinatario("Alyce");
            ed.getCb().setFecha(new Date());
            ed.getCb().setValor(400.00);
            ed.guardar();
            ed.setCb(null);

            ed.getCb().setId_Mensajeria(5);
            ed.getCb().setNombre_Empresa("Correos");
            ed.getCb().setDireccion("Guayaquil");
            ed.getCb().setPaquete("celular");
            ed.getCb().setDestinatario("Alexs");
            ed.getCb().setFecha(new Date());
            ed.getCb().setValor(1000.00);
            ed.guardar();
            ed.setCb(null);

            ed.getCb().setId_Mensajeria(0);
            ed.getCb().setNombre_Empresa("Courir");
            ed.getCb().setDireccion("Zapotillo");
            ed.getCb().setPaquete("celular");
            ed.getCb().setDestinatario("Wilson");
            ed.getCb().setFecha(new Date());
            ed.getCb().setValor(200.00);
            ed.guardar();
            ed.setCb(null);

            ed.getCb().setId_Mensajeria(3);
            ed.getCb().setNombre_Empresa("ServiEntrega");
            ed.getCb().setDireccion("Quito");
            ed.getCb().setPaquete("lampara");
            ed.getCb().setDestinatario("Carlos");
            ed.getCb().setFecha(new Date());
            ed.getCb().setValor(500.00);

            ed.guardar();
            ed.setCb(null);

            ed.getCb().setId_Mensajeria(1);
            ed.getCb().setNombre_Empresa("Correos");
            ed.getCb().setDireccion("Machala");
            ed.getCb().setPaquete("iphone");
            ed.getCb().setDestinatario("Marilyn");
            ed.getCb().setFecha(new Date());
            ed.getCb().setValor(300.00);

            ed.guardar();
            ed.setCb(null);

            ed.getCb().setId_Mensajeria(2);
            ed.getCb().setNombre_Empresa("ServiEntrega");
            ed.getCb().setDireccion("Loja");
            ed.getCb().setPaquete("tv");
            ed.getCb().setDestinatario("Alyce");
            ed.getCb().setFecha(new Date());
            ed.getCb().setValor(400.00);

            ed.guardar();
            ed.setCb(null);

            ed.getCb().setId_Mensajeria(1);
            ed.getCb().setNombre_Empresa("Correos");
            ed.getCb().setDireccion("Cotopaxi");
            ed.getCb().setPaquete("celular");
            ed.getCb().setDestinatario("Alexs");
            ed.getCb().setFecha(new Date());
            ed.getCb().setValor(1000.00);

            ed.guardar();
            ed.setCb(null);
            ed.getCb().setId_Mensajeria(1);
            ed.getCb().setNombre_Empresa("Correos");
            ed.getCb().setDireccion("Quito");
            ed.getCb().setPaquete("celular");
            ed.getCb().setDestinatario("Alexs");
            ed.getCb().setFecha(new Date());
            ed.getCb().setValor(1000.00);

            ed.guardar();
            ed.setCb(null);
            
            /*td.getT().setFecha(new Date());
            td.getT().setId_cuenta(1);
            td.getT().setNro_cuenta("858700");
            td.getT().setTipo(TipoTransaccion.DEPOSITO);
            td.getT().setValor(500.00);
            td.guardar();
            td.setT(null);
            td.getT().setFecha(new Date());
            td.getT().setId_cuenta(1);
            td.getT().setNro_cuenta("858700");
            td.getT().setTipo(TipoTransaccion.DEPOSITO);
            td.getT().setValor(500.00);
            td.guardar();
            td.setT(null);
            td.getT().setFecha(new Date());
            td.getT().setId_cuenta(1);
            td.getT().setNro_cuenta("858700");
            td.getT().setTipo(TipoTransaccion.DEPOSITO);
            td.getT().setValor(1500.00);
            td.guardar();
            td.setT(null);
            td.getT().setFecha(new Date());
            td.getT().setId_cuenta(1);
            td.getT().setNro_cuenta("858700");
            td.getT().setTipo(TipoTransaccion.DEPOSITO);
            td.getT().setValor(9000.00);
            td.guardar();
            td.setT(null);

            td.getT().setFecha(new Date());
            td.getT().setId_cuenta(2);
            td.getT().setNro_cuenta("686121");
            td.getT().setTipo(TipoTransaccion.DEPOSITO);
            td.getT().setValor(300.00);
            td.guardar();
            td.setT(null);

            td.getT().setFecha(new Date());
            td.getT().setId_cuenta(2);
            td.getT().setNro_cuenta("543556");
            td.getT().setTipo(TipoTransaccion.DEPOSITO);
            td.getT().setValor(300.00);
            td.guardar();
            td.setT(null);

            td.getT().setFecha(new Date());
            td.getT().setId_cuenta(3);
            td.getT().setNro_cuenta("229444");
            td.getT().setTipo(TipoTransaccion.DEPOSITO);
            td.getT().setValor(425.00);
            td.guardar();
            td.setT(null);

            td.getT().setFecha(new Date());
            td.getT().setId_cuenta(4);
            td.getT().setNro_cuenta("858700");
            td.getT().setTipo(TipoTransaccion.DEPOSITO);
            td.getT().setValor(155.00);
            td.guardar();
            td.setT(null);

            td.getT().setFecha(new Date());
            td.getT().setId_cuenta(5);
            td.getT().setNro_cuenta("686121");
            td.getT().setTipo(TipoTransaccion.DEPOSITO);
            td.getT().setValor(12500.00);
            td.guardar();
            td.setT(null);

            td.getT().setFecha(new Date());
            td.getT().setId_cuenta(6);
            td.getT().setNro_cuenta("435409");
            td.getT().setTipo(TipoTransaccion.DEPOSITO);
            td.getT().setValor(2500.00);
            td.guardar();
            td.setT(null);

            td.getT().setFecha(new Date());
            td.getT().setId_cuenta(1);
            td.getT().setNro_cuenta("435409");
            td.getT().setTipo(TipoTransaccion.DEPOSITO);
            td.getT().setValor(2500.00);
            td.guardar();
            td.setT(null);

            td.getT().setFecha(new Date());
            td.getT().setId_cuenta(7);
            td.getT().setNro_cuenta("4444444444");
            td.getT().setTipo(TipoTransaccion.DEPOSITO);
            td.getT().setValor(4500.00);
            td.guardar();
            td.setT(null);

            td.getT().setFecha(new Date());
            td.getT().setId_cuenta(1);
            td.getT().setNro_cuenta("4444444444");
            td.getT().setTipo(TipoTransaccion.DEPOSITO);
            td.getT().setValor(4500.00);
            td.guardar();
            td.setT(null);*/

        } catch (Exception e) {
        }
    }

}
