package ListasEnlazadas.Doubly_Linked_Lists;

public class NodoDoble {
    public int dato;
    NodoDoble anterior, siguiente;

    //constructor para cuando aun no hay nodos
    public NodoDoble(int elemento) {
        //referencia al constructor de abajo "" this() ""
        this(elemento, null, null);
    }

    //constructor para cuando ya hay nodos
    public NodoDoble(int elemento, NodoDoble s, NodoDoble a) {
        this.dato = elemento;
        this.siguiente = s;
        this.anterior = a;
    }


}
