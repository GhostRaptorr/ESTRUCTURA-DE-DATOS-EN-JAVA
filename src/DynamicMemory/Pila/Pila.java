package DynamicMemory.Pila;

public class Pila {
    private NodoPila cima;
    int tamano;

    public Pila(){
        cima = null;
        tamano = 0;
    }

    //Metodo para saber cuando la pila esta vacia
    public boolean estaVacia(){
        return cima==null;
    }

    //Metodo para empujar (push) un elemento en la pila
    public void push(int elem){
        NodoPila nuevo = new NodoPila(elem);
        nuevo.siguiente = cima;
        cima = nuevo;
        tamano++;
    }

    //Metodo para sacar (pop) un elemento en la pila
    public int pop(){
        int auxiliar = cima.dato;
        cima =  cima.siguiente;
        tamano--;
        return auxiliar;
    }

    //Metodo para saber quien esta en la cima de la pila
    public int cima(){
        return cima.dato;
    }

    //Metodo para saber el tamaño de la pila
    public int tamanoPila(){
        return tamano;
    }

    //Vaciar la pila
    public void limpiarPila(){
        while (!estaVacia()){
            pop();
        }
    }
}
