package ListasEnlazadas.Circular_Lists;



import javax.swing.*;

public class CircularList {
    CircularNode ultimo;

    CircularList() {
        ultimo = null;
    }

    //lista vacia
    public boolean estaVacia() {
        return ultimo == null;
    }

    //metodo para insertar
    public CircularList insertar(int elemento) {
        CircularNode nuevo = new CircularNode(elemento);
        if (ultimo != null) {
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
        }
        ultimo = nuevo;
        return this;
    }

    //metodo mostrar lista
    public void mostrarLista() {
        CircularNode auxiliar = ultimo.siguiente;
        String cadena = "";
        do {
            cadena = cadena + "[" + auxiliar.dato + "]->";
            auxiliar = auxiliar.siguiente;
        } while (auxiliar != ultimo.siguiente);
        JOptionPane.showMessageDialog(null, cadena, "Mostrando lista circular", JOptionPane.INFORMATION_MESSAGE);
    }

    //Metodo para eliminar nodo
    public boolean eliminar(int elemento) {
        CircularNode actual;
        boolean encontrado = false;
        actual = ultimo;

        while (actual.siguiente != ultimo && !encontrado) {
            encontrado = (actual.siguiente.dato == elemento);
            if (!encontrado) {
                actual = actual.siguiente;
            }
        }
            encontrado = (actual.siguiente.dato == elemento);
            if (encontrado) {
                CircularNode auxiliar = actual.siguiente;
                if (ultimo == ultimo.siguiente) {
                    ultimo = null;
                } else {
                    if (auxiliar == ultimo) {
                        ultimo = actual;
                    }
                    actual.siguiente = auxiliar.siguiente;
                }
                auxiliar = null;
            }
            return encontrado==true;
    }


}










