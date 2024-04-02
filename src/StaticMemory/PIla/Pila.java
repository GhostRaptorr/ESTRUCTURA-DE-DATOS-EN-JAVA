package StaticMemory.PIla;

public class Pila {
    int VectorPila[];
    int cima;

    public Pila(int tamano) {
        VectorPila = new int[tamano];
        //posicion de array comienza en 0, por ello en -1
        cima = -1;
    }

    //Metodo PUSH
    public void push(int dato) {
        cima++;
        VectorPila[cima] = dato;
    }

    //Metodo POP
    public int pop() {
        int fuera = VectorPila[cima];
        cima--;
        return fuera;
    }

    //Metodo para saber si la pila esta vacia
    public boolean estaVacia() {
        return cima == -1;
    }

    //Metodo para saber si la pila esta llena
    public boolean estaLlena() {
        return VectorPila.length - 1 == cima;
    }

    //Metodo para que elemento se encuentra en la cima
    public int cimaPila(){
        return VectorPila[cima];
    }

    //Metodo para saber Tamano de la pila
    public int TamanoPila(){
        return VectorPila.length;
    }


}
