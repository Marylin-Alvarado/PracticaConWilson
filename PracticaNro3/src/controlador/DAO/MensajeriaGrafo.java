/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;


import controlador.DAO.EnvioDao;
import controlador.DAO.MensajeriaDao;


import controlador.ed.grafo.GrafoEtiquetadoD;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import java.util.HashMap;
import java.util.Map;

import modelo.Envio;
import modelo.MensajeriaPaquete;


/**
 *
 * @author darkangel
 */
public class MensajeriaGrafo {

    private GrafoEtiquetadoD<MensajeriaPaquete> grafo;
    private ListaEnlazada<MensajeriaPaquete> lista = new ListaEnlazada<>();
    
    public MensajeriaGrafo() {
        MensajeriaDao cbd = new MensajeriaDao();
        lista = cbd.listar();
        grafo = new GrafoEtiquetadoD<>(lista.size());
        try {
            for (int i = 0; i < lista.size(); i++) {
                grafo.etiquetarVertice(i + 1, lista.get(i));
                System.out.println(lista.get(i));
            }
            System.out.println("----------------");
            llenarGrafo();
        } catch (Exception e) {
        }
    }

    public ListaEnlazada<MensajeriaPaquete> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<MensajeriaPaquete> lista) {
        this.lista = lista;
    }
    
    public GrafoEtiquetadoD<MensajeriaPaquete> getGrafo() {
        return grafo;
    }

    public void setGrafo(GrafoEtiquetadoD<MensajeriaPaquete> grafo) {
        this.grafo = grafo;
    }

    private void llenarGrafo() {
        try {
            for (int i = 0; i < lista.size(); i++) {
                MensajeriaPaquete mp = lista.get(i);
                HashMap<String, Double> mapa = new HashMap();
                ListaEnlazada<Envio> listaT = new EnvioDao().listaPorDireccion(mp.getId());
                for(int j = 0; j < listaT.size();j++) {
                    Envio t = listaT.get(j);
                    if(mapa.get(t.getDireccion()) != null) {
                        //Double suma = mapa.get(t.getNro_cuenta());
                        Double suma = mapa.get(t.getDireccion());
                        suma = t.getValor();
             
                        mapa.put(t.getDireccion(), suma);
                    } else {
                        //mapa.put(t.getNro_cuenta(), 1.0);
                        mapa.put(t.getDireccion(), t.getValor());
                    }
                }
                //ITERAR
                for(Map.Entry<String, Double> entry: mapa.entrySet()){
                    //System.out.println(entry.getKey()+" "+entry.getValue());
                    MensajeriaPaquete aux = getMensajeriaGrafo(entry.getKey());
                    
                    grafo.insertarAristaE(mp, aux, entry.getValue());
                }
            }
        } catch (Exception e) {
            System.out.println("error en crerGarfoEtiqueta"+e);
            e.printStackTrace();
        }
    }
    
    private MensajeriaPaquete getMensajeriaGrafo(String nro) throws VacioException, PosicionException {
        MensajeriaPaquete aux = null;
        for(int i = 0; i < lista.size();i++) {
            if(lista.get(i).getDireccion().equals(nro)) {
                aux = lista.get(i);
                break;
            }
        }
        return aux;
    }
    
    public ListaEnlazada<MensajeriaPaquete> camino(MensajeriaPaquete o, MensajeriaPaquete d) throws VacioException, PosicionException {
        System.out.println(grafo.getVerticeNum(o)+"    " +grafo.getVerticeNum(d));
        ListaEnlazada<Integer> listaA = grafo.camin0(grafo.getVerticeNum(o), grafo.getVerticeNum(d));
        
        ListaEnlazada<MensajeriaPaquete> camino = new ListaEnlazada<>();
        System.out.println(listaA.size());
        for(int i = 0; i < listaA.size(); i++) {
            
            camino.insertar(grafo.getEtiqueta(listaA.get(i)));
            
        }
        System.out.println("CAMINO");
        return camino;
    }
    
    public static void main(String[] args) {
        MensajeriaGrafo cbg = new MensajeriaGrafo();
        
        //new FrmGrafo(null, true, cbg.getGrafo()).setVisible(true);
    }
}






