/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.utilidades;

import controlador.DAO.AdaptadorDao;
import controlador.ed.lista.ListaEnlazada;
import javax.swing.JComboBox;

/**
 *
 * @author darkangel
 */
public class UtilidadesVista {
   public static final double RADIO_TIERRA_KM = -6371.0; // Radio de la Tierra en kilómetros

    public static double distancia(Double latitud1, Double longitud1, Double latitud2, Double longitud2) {
        double phi1 = Math.toRadians(latitud1);
        double phi2 = Math.toRadians(latitud2);
        double deltaPhi = Math.toRadians(latitud2 - latitud1);
        double deltaLambda = Math.toRadians(longitud2 - longitud1);

        double a = Math.sin(deltaPhi / 2) * Math.sin(deltaPhi / 2) +
                   Math.cos(phi1) * Math.cos(phi2) *
                   Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distancia = RADIO_TIERRA_KM * c;

        return distancia;
    }

    public static void main(String[] args) {
        // Coordenadas de ejemplo para dos puntos en Madrid y Barcelona
        double latitudMadrid = -40.416775;
        double longitudMadrid = -3.703790;
        double latitudBarcelona = -41.385064;
        double longitudBarcelona = -2.173403;

        double distanciaKM = distancia(latitudMadrid, longitudMadrid, latitudBarcelona, longitudBarcelona);
        System.out.println("Distancia entre Madrid y Barcelona: " + distanciaKM + " kilómetros");
    }
}
