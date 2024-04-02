package DynamicMemory.BinaryTree;

public class Arbol {
    NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    //Logica

    //Metodo para insertar un Nodo en el Arbol
    public void agregarNodo(int dato, String nombre) {
        NodoArbol nuevo = new NodoArbol(dato, nombre);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            NodoArbol auxiliar = raiz;
            NodoArbol padre;

            while (true) {
                padre = auxiliar;
                //Si es menor
                if (dato < auxiliar.dato) {
                    auxiliar = auxiliar.HjIzquierdo;
                    if (auxiliar == null) {
                        padre.HjIzquierdo = nuevo;
                        //finalizar ejecucion sirve tambien el return metodo tipo void
                        return;
                    }
                }
                //si es mayor o igual
                else {
                    auxiliar = auxiliar.HjDerecho;
                    if (auxiliar == null) {
                        padre.HjDerecho = nuevo;
                        //finalizar ejecucion sirve tambien el return metodo tipo void
                        return;
                    }
                }
            }
        }
    }

    //Metodo para saber cuando el arvol esta vacio
    public boolean estaVacio() {
        return raiz == null;
    }

    /*Metodo para recorrer el arbol InOrden
    Hijo Izquierdo, Raiz, Hijo Derecho

    InOrden 3 pasos
    */
    public void inOrden(NodoArbol raiz) {
        if (raiz != null) {
            //1. Recorrer el subarbol Izquierdo InOrden
            inOrden(raiz.HjIzquierdo);
            //2. Mostrar la raiz
            System.out.print(raiz.dato + ", ");
            //3. Recorrer el subarbol Derecho InOrden
            inOrden(raiz.HjDerecho);
        }
    }

    /*Metodo para recorrer el arbol PreOrden
    Raiz, Hijo Izquierdo, Hijo Derecho

    PreOrden 3 pasos
    */
    public void preOrden(NodoArbol raiz) {
        if (raiz != null) {
            System.out.print(raiz.dato + ", ");
            preOrden(raiz.HjIzquierdo);
            preOrden(raiz.HjDerecho);
        }
    }

    /*Metodo para recorrer el arbol PostOrden
    Hijo Izquierdo, Hijo Derecho, Raiz

    PostOrden 3 pasos
    */
    public void postOrden(NodoArbol raiz) {
        if (raiz != null) {
            postOrden(raiz.HjIzquierdo);
            postOrden(raiz.HjDerecho);
            System.out.print(raiz.dato + ", ");
        }
    }

    /*Busqueda de un Nodo en un Arbol Binario de Busqueda*/
    /*
    1. Crear un puntero Aux. de tipo NodoArbol = raiz
    2. Mientra aux.dato != dato buscando hacer
        2.1. Si dato < aux.dato
            2.2 Apuntar aux = aux.hjIzq
            2.2.1 No
                2.2.2 aux = aux.hjderech
    4. Si aux == null
        4.1. Retornar null
    5. retornar aux.
    */

    public NodoArbol buscarNodo(int dato) {
        NodoArbol auxiliar = raiz;
        while (auxiliar.dato != dato) {
            if (dato < auxiliar.dato) {
                auxiliar = auxiliar.HjIzquierdo;
            } else {
                auxiliar = auxiliar.HjDerecho;
            }
            if (auxiliar == null) {
                return null;
            }
        }
        return auxiliar;
    }

    /*Eliminar un nodo de un arbol Binario de Busqueda*/
    /*
    1. Buscar en el arbol en el nodo la posision del Nodo
    2. IF Nodo tiene menos 2 hjs, (reajustar los enlaces de su antecesor)
    3 IF Nodo tiene 2 hjs( rama izq, drcha), es necesario subir a la posicion que esta ocupa el dato mas proximo de sus subarboles
        (el inmediato superior o el inmediatamente infeior) con el fin de mantenar la estructura de arbol binario de busqueda.
    */

    public boolean eliminar(int dato) {
        NodoArbol auxiliar = raiz;
        NodoArbol padre = raiz;
        boolean esHijoIzq = true;
        while (auxiliar.dato != dato) {
            padre = auxiliar;
            //buscar a la IZQUERDA
            if (dato < auxiliar.dato) {
                esHijoIzq = true;
                auxiliar = auxiliar.HjIzquierdo;
                //Buscar a la Derecha
            } else {
                esHijoIzq = false;
                auxiliar = auxiliar.HjDerecho;
            }
            if (auxiliar == null) {
                return false;
            }
        } //Fin de While
        //es una hoja o la raiz (unico nodo)
        if (auxiliar.HjIzquierdo == null && auxiliar.HjDerecho == null) {
            //raiz
            if (auxiliar == raiz) {
                raiz = null;
                //hijo izquierdo
            } else if (esHijoIzq) {
                padre.HjIzquierdo = null;
                //hijo derecho
            } else {
                padre.HjDerecho = null;
            }
        } else if (auxiliar.HjDerecho == null) {
            //raiz
            if (auxiliar == raiz) {
                raiz = auxiliar.HjIzquierdo;
                //hijo izquierdo
            } else if (esHijoIzq) {
                padre.HjIzquierdo = auxiliar.HjIzquierdo;
                //hijo derecho
            } else {
                padre.HjDerecho = auxiliar.HjIzquierdo;
            }
        } else if (auxiliar.HjIzquierdo == null) {
            //raiz
            if (auxiliar == raiz) {
                raiz = auxiliar.HjDerecho;
                //hijo izquierdo
            } else if (esHijoIzq) {
                padre.HjIzquierdo = auxiliar.HjDerecho;
                //hijo derecho
            } else {
                padre.HjDerecho = auxiliar.HjIzquierdo;
            }
        } else {
            NodoArbol reemplazo = obtenerNodoReemplazo(auxiliar);
            if (auxiliar == raiz) {
                raiz = reemplazo;
            } else if (esHijoIzq) {
                padre.HjIzquierdo = reemplazo;
            } else {
                padre.HjDerecho = reemplazo;
            }
            reemplazo.HjIzquierdo = auxiliar.HjIzquierdo;
        }
        return true;
    }

    //Metodo de devolver el Nodo Reemplazo
    public NodoArbol obtenerNodoReemplazo(NodoArbol nodoReemplazo){
        NodoArbol reemplazarPadre = nodoReemplazo;
        NodoArbol reemplazo = nodoReemplazo;
        NodoArbol auxiliar = nodoReemplazo.HjDerecho;

        while (auxiliar != null){
            reemplazarPadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.HjIzquierdo;
        }
        if (reemplazo != nodoReemplazo.HjDerecho){
            reemplazarPadre.HjIzquierdo = reemplazo.HjDerecho;
            reemplazo.HjDerecho = nodoReemplazo.HjDerecho;
        }
        System.out.println("El Nodo reemplazo es: " + reemplazo);
        return reemplazo;
    }


}
