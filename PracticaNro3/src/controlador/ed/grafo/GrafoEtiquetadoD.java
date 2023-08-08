/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ed.grafo;

import controlador.ed.grafo.exception.GrafoSizeExeption;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import java.util.HashMap;

/**
 *
 * @author darkangel
 */
public class GrafoEtiquetadoD<E> extends GrafoD {
    //   1       2       3      4      5
    // marylin  chamba  Pool   Alice  Cobos
    protected E etiquetas[];
    protected HashMap<E, Integer> dicVertices;

    public GrafoEtiquetadoD(Integer verc) {
        super(verc);
        //etiquetas = (E[]) java.lang.reflect.Array.newInstance(clazz, verc+1);
        etiquetas = (E[]) new Object[verc + 1];
        dicVertices = new HashMap<>(verc);
        
    }
    
    public Boolean existeAristaE(E i, E j) throws GrafoSizeExeption {
        return this.existeArista(getVerticeNum(i), getVerticeNum(j));
    }
    
    public Integer getVerticeNum(E etiqueta) {
        
        return dicVertices.get(etiqueta);
    }
    
    public E getEtiqueta(Integer vertNum) {
        return etiquetas[vertNum];
    }
    
    public void insertarAristaE(E i, E j, Double peso) throws GrafoSizeExeption {
        this.insertar(getVerticeNum(i), getVerticeNum(j), peso);
    }
    
    public void insertarAristaE(E i, E j) throws GrafoSizeExeption {
        this.insertar(getVerticeNum(i), getVerticeNum(j));
    }
    
    public ListaEnlazada<Adycencia> adyacentesGE(E i) {
        return this.adycentes(getVerticeNum(i));
    }
    
    public void etiquetarVertice(Integer vertice, E etiqueta) {
        etiquetas[vertice] = etiqueta;
        dicVertices.put(etiqueta, vertice);
        
    }
    
      public Integer obtenerCodigo(E etiqueta) throws Exception {
        Integer key = dicVertices.get(etiqueta);
        if (key != null) {
                     return key;

    }
                    return key;

      }
    public void matrizPesos(Integer[][] matriz_C, Integer[][] matriz_Caminos, Double[][] matriz_D) throws Exception {
        for (int i = 1; i <= numVertices(); i++) {
            for (int j = 1; j <= numVertices(); j++) {
                matriz_C[i][j] = j;
                matriz_Caminos[i][j] = i;
                if (i == j) {
                    matriz_D[i][j] = 0.0;
                    matriz_C[i][j] = 0;
                    matriz_Caminos[i][j] = 0;
                } else {
                    matriz_D[i][j] = ((! existeArista(i, j)) ? Double.POSITIVE_INFINITY : pesoArista(i, j));
                }

            }
        }
    }
    
    public ListaEnlazada<Integer> algoritmo_Floyd(Integer origen, Integer destino) throws Exception {
    ListaEnlazada<Integer> retornar_camino = new ListaEnlazada<>();
    Integer[][] matriz_C = new Integer[numV + 1][numV + 1];
    Integer[][] matriz_Caminos = new Integer[numV + 1][numV + 1];
    Double[][] matriz_D = new Double[numV + 1][numV + 1];
    matrizPesos(matriz_C, matriz_Caminos, matriz_D);
        
            
          // Algoritmo Floyd
    for (int i = 1; i <= numVertices(); i++) {
        for (int j = 1; j <= numVertices(); j++) {
            for (int k = 1; k <= numVertices(); k++) {
                if (matriz_D[j][i] + matriz_D[i][k] < matriz_D[j][k]) {
                    matriz_D[j][k] = matriz_D[j][i] + matriz_D[i][k];
                    matriz_C[j][k] = matriz_C[j][i]; // Corregimos aquí
                }
            }
        }
    }

    // Construir el camino desde el origen hasta el destino
    if (matriz_C[origen][destino] != null) {
        retornar_camino.insertarFinal(origen);
        while (!origen.equals(destino)) {
            origen = matriz_C[origen][destino];
            retornar_camino.insertarFinal(origen);
        }
    } else {
        // No hay camino entre el origen y el destino
        System.out.println("No existe un camino entre el origen y el destino.");
    }   
        
   

    return retornar_camino;
}

   
public ListaEnlazada<Integer> algoritmo_BellmanFord(Integer origen, Integer destino) throws Exception {
    ListaEnlazada<Integer> retornar_camino = new ListaEnlazada<>();
    Double[] distancias = new Double[numVertices() + 1];
    Integer[] predecesores = new Integer[numVertices() + 1];
    
    if (BPP()) {
        for (int i = 1; i <= numVertices(); i++) {
        distancias[i] = Double.POSITIVE_INFINITY;
        predecesores[i] = null;
    }
    distancias[origen] = 0.0;

    // Relajación de las aristas V - 1 veces
    for (int i = 1; i <= numVertices() - 1; i++) {
        for (int u = 1; u <= numVertices(); u++) {
            for (int v = 1; v <= numVertices(); v++) {
                Double pesoUV = pesoArista(u, v);
                if (pesoUV != null && distancias[u] + pesoUV < distancias[v]) {
                    distancias[v] = distancias[u] + pesoUV;
                    predecesores[v] = u;
                }
            }
        }
    }

    // Detección de ciclos de peso negativo
    for (int u = 1; u <= numVertices(); u++) {
        for (int v = 1; v <= numVertices(); v++) {
            Double pesoUV = pesoArista(u, v);
            if (pesoUV != null && distancias[u] + pesoUV < distancias[v]) {
                // El grafo contiene un ciclo de peso negativo accesible desde el vértice de origen
                // En este punto, podrías lanzar una excepción o manejar el caso según tus necesidades
                System.out.println("El grafo contiene ciclos de peso negativo.");
            }
        }
    }

    }
    
    

    // Reconstruir el camino más corto desde el origen hasta el destino
    int destinoActual = destino;
    while (destinoActual != origen) {
        retornar_camino.insertarInicio(destinoActual);
        destinoActual = predecesores[destinoActual];
    }
    retornar_camino.insertarInicio(origen);

    return retornar_camino;
}

     
    //Recorrido en anchura (BPA) 
public boolean BPA(Integer origen) throws PosicionException, VacioException, Exception {
    visita = new Integer[numVertices() + 1];
    
    for (int i = 0; i <= numVertices(); i++) {
        visita[i] = 0;
        System.out.println(i);
    }
    
    boolean encontradoNull = BusquedaPorAnchura(origen);
    
    return !encontradoNull;
}

public boolean BusquedaPorAnchura(Integer origen) throws Exception {
    if (origen == null) {
        return false; // Se encontró un null, devolvemos false
    }
    
    int inicio = 0;
    int fin = 0;
    Integer[] cola = new Integer[numVertices()]; // Creamos un arreglo para simular la cola
    cola[fin++] = origen;
    visita[origen] = 1;
    
    while (inicio < fin) {
        Integer actual = cola[inicio++];
        ListaEnlazada<Adycencia> lista = listaAdycencia[actual];
        
        for (int i = 0; i < lista.size(); i++) {
            Adycencia a = lista.get(i); 
            if (visita[a.getDestino()] == 0) {
                cola[fin++] = a.getDestino();
                visita[a.getDestino()] = 1;
            }
        }
    }
    
    return true; // No se encontraron nulls, devolvemos true
} 

public boolean BPP() throws Exception {
    Integer[] recorrido = new Integer[numVertices()];
    Integer[] visita = new Integer[numVertices() + 1]; // Crear el arreglo visita
    Integer ordenVisita = 1; // Inicializar ordenVisita en 1
    
    for (int i = 0; i <= numVertices(); i++) {
        visita[i] = 0;
    }

    boolean encontradosTodos = true; // Suponemos inicialmente que encontramos todos los datos

    for (int i = 1; i <= numVertices(); i++) {
        if (visita[i] == 0) {
            encontradosTodos = encontradosTodos && BporProfundiDad(i, recorrido, visita, ordenVisita); // Pasar visita y ordenVisita como argumentos
        }
    }

    return encontradosTodos;
}

private boolean BporProfundiDad(Integer origen, Integer res[], Integer visita[], Integer ordenVisita) throws Exception {
    res[ordenVisita - 1] = origen; // Restamos 1 para acceder al índice correcto en el arreglo res
    visita[origen] = ordenVisita++;
    ListaEnlazada<Adycencia> lista = listaAdycencia[origen];
    
    boolean encontradosTodos = true; // Suponemos inicialmente que encontramos todos los datos en este subárbol

    for (int i = 0; i < lista.size(); i++) {
        Adycencia a = lista.get(i);
        if (lista.existeDato(i)) {
            break;
        } else {
            a = lista.get(i);
        }

        lista.setCabecera(lista.getCabecera().getSig());
        if (visita[a.getDestino()] == 0) {
            encontradosTodos = encontradosTodos && BporProfundiDad(a.getDestino(), res, visita, ordenVisita); // Pasar visita y ordenVisita como argumentos
        } else if (a.getDestino() == null) {
            encontradosTodos = false; // Encontramos un null, cambiamos el resultado a false
        }
    }

    return encontradosTodos;
}
 
public Integer[] BporA(Integer origen) throws  Exception {
    Integer[] recorrido = new Integer[numVertices()];
    visita = new Integer[numVertices() + 1];
    
    for (int i = 0; i <= numVertices(); i++) {
        visita[i] = 0;
    }
    
    ListaEnlazada<Integer> listaRecorrido = new ListaEnlazada<>();

    for (int i = 1; i <= numVertices(); i++) {
        if (visita[i] == 0) {
            BPA(i, listaRecorrido);
        }
    }

    for (int i = 0; i < listaRecorrido.size(); i++) {
        recorrido[i] = listaRecorrido.get(i);
    }

    return recorrido;
}

private void BPA(Integer origen, ListaEnlazada<Integer> recorrido) throws Exception {
    recorrido.insertarFinal(origen);
    visita[origen] = 1;
     
   ListaEnlazada<Adycencia> lista = listaAdycencia[origen];
    for (int i = 0; i < lista.size(); i++) {
        Adycencia a = lista.get(i); 
       if (visita[a.getDestino()] == 0) {
            BPA(a.getDestino(), recorrido);
        }
    }
}     
   
    
     public String toStringBPA(Integer origen) throws Exception {
        return arrayToString(BporA(origen));
    }
    
     public String arrayToString(Integer v[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < v.length; i++) {
            sb.append(v[i] );
        }
        return sb.toString();
    }
     
     Integer[] visita ;
   Integer ordenVisita= 0;
    //busqueda en profundidad (DFS)
    public Integer[] toArrayDFS() throws Exception {
        Integer[] recorrido = new Integer[numVertices()];
         visita = new Integer[numVertices() + 1];
       
        
        for (int i = 0; i <= numVertices(); i++) {
            visita[i] = 0;
        }

        for (int i = 1; i <= numVertices(); i++) {
            if (visita[i] == 0) {
                toArrayDFS(i, recorrido);
            }
        }
        Integer aux[] = recorrido;
        for (int j = 0; j < recorrido.length; j++) {
            for (int k = 0; k < aux.length; k++) {
                if (j != k) {
                    if (recorrido[j] == aux[k]) {
                        for (int i = k; i < aux.length-1; i++) {
                                recorrido[i] = aux[i + 1];
                           
                        }
                    }
                }
            }
        }
        
        return recorrido;
    }

    private void toArrayDFS(Integer origen, Integer res[]) throws Exception {
        res[ordenVisita] = origen;
        visita[origen] = ordenVisita++;
        ListaEnlazada<Adycencia> lista = listaAdycencia[origen];
        for (int i = 0; i < lista.size(); i++) {
            Adycencia a;           
            if (lista.existeDato(i)) {
                 break;
            } else {
                a = lista.get(i);
            }
            
            lista.setCabecera(lista.getCabecera().getSig());
            if (visita[a.getDestino()] == 0) {
                toArrayDFS(a.getDestino(), res);
                
            }
        }
    }
    
    

    public String toStringDFS() throws Exception {
        return arrayToString(toArrayDFS());
    }
    @Override
    public String toString() {
        StringBuilder grafo = new StringBuilder("GRAFO"+"\n");
        for(int i = 1; i <= numVertices(); i++){
            grafo.append(" V "+i + " *("+getEtiqueta(i)+")"+"\n");
            ListaEnlazada<Adycencia> lista = adycentes(i);
            grafo.append((!lista.isEmpty())? "Adycencias":"No Adycencias");
            grafo.append("\n");
            for(int j = 0; j < lista.size();j++) {
                try {
                    Adycencia aux = lista.get(j);                    
                    grafo.append(" -- V "+aux.getDestino()+ " ("+getEtiqueta(aux.getDestino())+")"+" PESO --> "+aux.getPeso()+"\n");
                } catch (Exception e) {
                }
            }
        }
        return grafo.toString();
    }
    
     
}










