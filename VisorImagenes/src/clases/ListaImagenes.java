/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Alejandro RG
 */
public class ListaImagenes {
    private NodoD inicio;
    private NodoD fin;
    private NodoD actual;
    
    public ListaImagenes() {
        inicio= null;
        fin= null;
    }

    public void insertarOrden(NodoD nuevo){
        NodoD aux;
        // Caso 1: Lista Vacia
        if(inicio==null){
            inicio= nuevo;
            fin=nuevo;
        } else {
            aux = inicio;
            //Busca donde insertar la canción de la lista
            while(aux!=null && nuevo.getDatos().getTitulo().compareTo(aux.getDatos().getTitulo())>0){
                aux= aux.getSig();
            }
            //Caso 2: Inseción al inicio
            if(aux== inicio){
                nuevo.setSig(inicio);
                inicio.setAnt(nuevo);
                inicio= nuevo;
            } else if(aux== null) { //Caso 3: Inserción al final
                fin.setSig(nuevo);
                nuevo.setAnt(fin);
                fin= nuevo;
            } else if(aux != null && aux.getAnt()!= null) { //Caso 4: Inserción al medio
                nuevo.setSig(aux);
                nuevo.setAnt(aux.getAnt());
                
                aux.getAnt().setSig(nuevo);
                aux.setAnt(nuevo);
           }
        }
    }
    
    public void recorrerLista(char orden){
        NodoD aux;
        if(orden=='A'){// Si es ascendente
            aux= inicio;
            while(aux!=null){
                System.out.println("-->"+ aux.getDatos().toString());
                aux= aux.getSig();
            }
        } else { //Orden descendente
            System.out.println("Recorrido desde el final hasta el inicio...");
            aux= fin;
            while(aux!=null){
                System.out.println("-->"+ aux.getDatos().toString());
                aux= aux.getAnt();
            }
        }
    }
    
    public NodoD irPrimero(){
        actual= inicio;
        return inicio;
    }
    
    public NodoD irUltimo() {
        actual= fin;
        return fin;
    }
    
    public NodoD irAnterior() {
        if(actual.getAnt()!=null) {
            actual= actual.getAnt();
        }
        return actual;
    }
    
    public NodoD irSiguiente() {
        if(actual.getSig()!=null) {
            actual.getSig();
        }
        return actual;
    }

    public NodoD getActual() {
        return actual;
    }
    
    public NodoD getReproducir(){
        if(actual == inicio){
            return irPrimero();
        } else if(actual == fin) {
            return irUltimo();
        } else if (actual.getAnt() != null) {
            return irAnterior();
        } else
            return irSiguiente();
    }
}
