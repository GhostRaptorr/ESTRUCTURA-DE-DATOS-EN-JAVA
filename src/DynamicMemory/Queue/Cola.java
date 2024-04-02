package DynamicMemory.Queue;

public class Cola {
    NodoCola inicio, fin;
    int tamanio;

    public Cola() {
        inicio = fin = null;
        tamanio = 0;
    }

    //Metodo Si esta vacia
    public boolean estaVacia() {
        return inicio == null;
    }

    //Metodo para saber Insertar
    public void insertar(int elemento) {
        NodoCola nuevo = new NodoCola(elemento);
        if (estaVacia()) {
            inicio = nuevo;
        } else {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        tamanio++;
    }

    //Metodo para quitar de la fila
    public int quitar() {
        int auxiliar = inicio.dato;
        inicio = inicio.siguiente;
        tamanio--;
        return auxiliar;
    }

    //Metodo Quien esta al inicio

    public int inicioDato(){
        return inicio.dato;
    }

    //Metodo tamaño
    public int tamanio(){
        return tamanio;
    }


}
