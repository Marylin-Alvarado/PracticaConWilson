/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tabla;

import controlador.ed.cola.ColaI;
import controlador.ed.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.MensajeriaPaquete;

/**
 *
 * @author darkangel
 */
public class ModeloTablaMensajeria extends AbstractTableModel {
    private ListaEnlazada<MensajeriaPaquete> lista = new ListaEnlazada<>();

    public ListaEnlazada<MensajeriaPaquete> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<MensajeriaPaquete> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int i, int i1) {
        MensajeriaPaquete m = null;
        try {
            m = lista.get(i);
        } catch (Exception e) {
        }
        switch(i1){
            case 0: return m.getNombreEmpresa();
            case 1: return m.getDireccion();
            case 2: return m.getLatitud();
            case 3: return (m.getLongitud());
            default: return null;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Nombre Empresa";
            case 1: return "Direccion";
            case 2: return "Latitud";
            case 3: return "Longitud ";
            default: return null;
        }
//return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
