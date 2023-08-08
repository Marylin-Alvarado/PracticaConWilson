/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.DAO.MensajeriaDao;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import javax.swing.JComboBox;
import modelo.Envio;
import modelo.MensajeriaPaquete;

/**
 *
 * @author darkangel  y Marylin A.
 */ 
public class UtilifdadesVistaGrafo {

   
    
    public static void cargarComboMensajeria(ListaEnlazada<MensajeriaPaquete> lista, JComboBox cbx) 
            throws VacioException, PosicionException{
        cbx.removeAllItems();
        
            for (int i = 0; i < lista.size(); i++) {
                cbx.addItem(lista.get(i));
            }
        
    }
    
       
    public static void cargarNombreEmpresa(JComboBox cbx ,MensajeriaDao md) throws VacioException, PosicionException{
        cbx.removeAllItems();
        ListaEnlazada<MensajeriaPaquete> lista = md.listar();
        for (int i = 0; i < lista.size(); i++) {
            cbx.addItem(lista.get(i).getNombreEmpresa());
    
        }   
    }
  
      
    public static Double obtenerComboLongitud(ListaEnlazada<MensajeriaPaquete> lista, JComboBox cbx) 
            throws VacioException, PosicionException {
        return lista.get(cbx.getSelectedIndex()).getLongitud();
    }
     public static Double obtenerComboLatitud(ListaEnlazada<MensajeriaPaquete> lista, JComboBox cbx) 
            throws VacioException, PosicionException {
        return lista.get(cbx.getSelectedIndex()).getLatitud();
    }
     
    public static Double obtenerComboLongitudEnvio(ListaEnlazada<Envio> lista, JComboBox cbx) 
            throws VacioException, PosicionException {
        return lista.get(cbx.getSelectedIndex()).getLongitud();
    }
     public static Double obtenerComboLatitudeEnvio(ListaEnlazada<Envio> lista, JComboBox cbx) 
            throws VacioException, PosicionException {
        return lista.get(cbx.getSelectedIndex()).getLatitud();
    } 
     
    public static void cargarDireccion(JComboBox cbx ,MensajeriaDao md) throws VacioException, PosicionException{
        cbx.removeAllItems();
        ListaEnlazada<MensajeriaPaquete> lista = md.listar();
        for (int i = 0; i < lista.size(); i++) {
            cbx.addItem(lista.get(i).getDireccion());
    
        }   
    }
    
    public static MensajeriaPaquete obtenerComboMensajeria(ListaEnlazada<MensajeriaPaquete> lista, JComboBox cbx) 
            throws VacioException, PosicionException {
        return lista.get(cbx.getSelectedIndex());
    }
    
    
}











