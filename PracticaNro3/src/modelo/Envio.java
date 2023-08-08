/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.Date;
/**
 *
 * @author Gonzalez G
 */
public class Envio {
    private Integer id ;
    private String nombre_empresa;
    private String destinatario;
    private String direccion;
    private String paquete;
    private Double latitud ,longitud;
    private Double distancia ;
    private Date fecha;
    private Integer id_Mensajeria;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_Empresa() {
        return nombre_empresa;
    }

    public void setNombre_Empresa(String remitente) {
        this.nombre_empresa = remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getPaquete() {
        return paquete;
    }

    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getId_Mensajeria() {
        return id_Mensajeria;
    }

    public void setId_Mensajeria(Integer id_Mensajeria) {
        this.id_Mensajeria = id_Mensajeria;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getValor() {
        return distancia;
    }

    public void setValor(Double valor) {
        this.distancia = valor;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    
    
    @Override
    public String toString() {
        return  direccion ;
    }

    
    
    
    
}
