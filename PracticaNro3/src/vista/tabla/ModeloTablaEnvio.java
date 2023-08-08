/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tabla;

import controlador.DAO.MensajeriaDao;
import controlador.Utilidades;
import controlador.ed.cola.ColaI;
import controlador.ed.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Envio;
import modelo.MensajeriaPaquete;

/**
 *
 * @author darkangel
 */
public class ModeloTablaEnvio extends AbstractTableModel {
    private ListaEnlazada<Envio> lista = new ListaEnlazada<>();

    public ListaEnlazada<Envio> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Envio> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Envio en = null;
        try {
            en = lista.get(i);
        } catch (Exception e) {
        }
        switch(i1){
            case 0: return en.getNombre_Empresa();
           case 1 :return  new MensajeriaDao().obtener(en.getId_Mensajeria()).getDireccion();
            case 2: return en.getDestinatario();
            case 3: return en.getPaquete();
            case 4 : return Utilidades.formatDate(en.getFecha());
            case 5: return en.getDireccion();
            case 6 : return  en.getValor()+"km";
            default: return null;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Nombre Empresa";
            case 1: return "Direccion de envio";
            case 2: return "Destinataria";
            case 3: return "Paquete";
            case 4 :return "Fecha";
            case 5 : return "Direccion de llegada";
            case 6 : return "Distancia";
            default: return null;
        }
//return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
