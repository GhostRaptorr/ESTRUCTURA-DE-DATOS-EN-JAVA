package ListasEnlazadas.Doubly_Linked_Lists;

import javax.swing.*;

public class ListaDoble {
    private NodoDoble inicio, fin;

    //Constructor
    public ListaDoble() {
        inicio = fin = null;
    }

    //Metodo para saber cuando esta vacia
    public boolean estaVacia() {
        return inicio == null;
    }

    //metodo para agregar al final
    public void agregarAlFinal(int elemento) {
        if (!estaVacia()) {
            fin = new NodoDoble(elemento, null, fin);
            fin.anterior.siguiente = fin;
        } else {
            inicio = fin = new NodoDoble(elemento);
        }
    }

    //Metodo para agregar al inicio
    public void agregarAlInicio(int elemento) {
        if (!estaVacia()) {
            inicio = new NodoDoble(elemento, inicio, null);
            inicio.siguiente.anterior = inicio;
        } else {
            inicio = fin = new NodoDoble(elemento);
        }
    }

    //Metodo para mostrar la lista de inicio a fin
    public void mostrarInioAFin() {
        if (!estaVacia()) {
            String datos = "<=>";
            NodoDoble auxiliar = inicio;
            while (auxiliar != null) {
                datos = datos + "[" + auxiliar.dato + "]<=>";
                auxiliar = auxiliar.siguiente;
            }
            JOptionPane.showMessageDialog(null, datos, "mostrando datos de Inicio a Fin", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Metodo para mostrar la lista de inicio a fin
    public void mostrarFinAInicio() {
        if (!estaVacia()) {
            String datos = "<=>";
            NodoDoble auxiliar = fin;
            while (auxiliar != null) {
                datos = datos + "[" + auxiliar.dato + "]<=>";
                auxiliar = auxiliar.anterior;
            }
            JOptionPane.showMessageDialog(null, datos, "mostrando datos de Inicio a Fin", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Eliminar un Nodo del inicio
    public int eliminarInicio() {
        int elemento = inicio.dato;
        if (inicio == fin) {
            inicio = fin = null;
        } else {
            inicio = inicio.siguiente;
            inicio.anterior = null;
        }
        return elemento;
    }

    //Eliminar un Nodo del fin
    public int eliminarFin() {
        int elemento = fin.dato;
        if (inicio == fin) {
            inicio = fin = null;
        } else {
            fin = fin.anterior;
            fin.siguiente = null;
        }
        return elemento;
    }


}
