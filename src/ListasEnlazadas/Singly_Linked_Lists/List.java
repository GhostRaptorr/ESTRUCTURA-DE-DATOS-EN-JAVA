package ListasEnlazadas.Singly_Linked_Lists;

public class List {

    //Punteros para saber inicio y fin
    protected ListNode inicio, fin;

    //Constructor Iniciacion inicio y fin a null
    public List() {
        inicio = null;
        fin = null;
    }

    //Metodo para saber si la lista esta vacia
    public boolean estaVacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    //Metodo para insertar NODO al final de la lista
    public void agregarFinal(int elemento) {
        //si no esta vacia
        if (!estaVacia()) {
            fin.siguiente = new ListNode(elemento);
            fin = fin.siguiente;
        } else {
            inicio = fin = new ListNode(elemento);
        }
    }

    //Metodo para insertar NODO al inicio de la lista
    public void agregarInicio(int elemento) {
        //Creando el LIST-NODE
        inicio = new ListNode(elemento, inicio);
        //checar si esta vacia la lista
        if (fin == null) {
            //apuntar fin a inicio
            fin = inicio;
        }

    }

    //Metodo para mostrar los datos
    public void mostrarLista() {
        //nodo auxiliar posicionado en el nodo inicio
        ListNode recorrer = inicio;
        System.out.println();
        while (recorrer != null) {
            System.out.print("[" + recorrer.id + "]-->");
            //recorrera cada nodo sacando el id de cada nodo
            recorrer = recorrer.siguiente;
        }
    }

    //Buscar dato en epecifico
    public boolean buscarIdNodo(int elemento){
        ListNode temporal = inicio;
        while (temporal != null & temporal.id != elemento) {
            temporal =  temporal.siguiente;
        }
        return temporal!=null;
    }


    //Metodo borrar del inicio
    public int borrarInicio() {
        int elemento = inicio.id;
        if (inicio == fin) {
            inicio = fin = null;
        } else {
            inicio = inicio.siguiente;
        }
        return elemento;
    }

    //Metodo borrar al final
    public int borrarFinal() {
        int elemento = fin.id;
        if (inicio == fin) {
            inicio = fin = null;
        } else {
            ListNode temporal = inicio;
            while(temporal.siguiente != fin){
                temporal = temporal.siguiente;
            }
            fin = temporal;
            fin.siguiente = null;
        }
        return elemento;
    }


    //Metodo a eliminar nodo en especifico
    public void borraNodoEnEspecifico(int elemento){
        if (!estaVacia()){
            if (inicio == fin && elemento==inicio.id){
                inicio=fin=null;
            } else if(elemento==inicio.id){
                inicio = inicio.siguiente;
            } else {
                ListNode anterior, temporal;
                anterior=inicio;
                temporal=inicio.siguiente;
                while (temporal!=null && temporal.id !=elemento){
                    anterior=anterior.siguiente;
                    temporal=temporal.siguiente;

                }
                if(temporal!=null){
                    anterior.siguiente=temporal.siguiente;
                    if(temporal==fin){
                        fin=anterior;
                    }
                }
            }
        }
    }



}
