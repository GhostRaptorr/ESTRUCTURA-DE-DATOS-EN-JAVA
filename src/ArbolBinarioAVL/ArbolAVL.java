package ArbolBinarioAVL;

public class ArbolAVL {
    private NodoArbolAVL raiz;

    public ArbolAVL() {
        raiz = null;
    }

    public NodoArbolAVL obtenerRaiz(){
        return raiz;
    }

    //////////
    /*Buscar*/
    //////////
    public NodoArbolAVL buscar(int d, NodoArbolAVL r) {
        if (raiz == null) {
            return null;
        } else if (r.dato == d) {
            return r;
        } else if (r.dato < d) {
            return buscar(d, r.hijoDerecho);
        } else {
            return buscar(d, r.hijoIzquierdo);
        }
    }

    //////////////////////////////
    /*Obtener Factor de eqilibrio*/
    //////////////////////////////
    public int obtenerFE(NodoArbolAVL x) {
        if (x == null) {
            return -1;
        } else {
            return x.fe;
        }
    }

    //////////////////////////////
    /*Rotacion SImple izquierda*/
    //////////////////////////////
    public NodoArbolAVL rotacionIzquierda(NodoArbolAVL c) {
        NodoArbolAVL auxiliar = c.hijoIzquierdo;
        c.hijoIzquierdo = auxiliar.hijoDerecho;
        auxiliar.hijoDerecho = c;
        c.fe = Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho)) + 1;
        auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho)) + 1;
        return auxiliar;
    }

    //////////////////////////////
    /*Rotacion SImple Derecha    */
    //////////////////////////////
    public NodoArbolAVL rotacionDerecha(NodoArbolAVL c) {
        NodoArbolAVL auxiliar = c.hijoDerecho;
        c.hijoDerecho = auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo = c;
        c.fe = Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho)) + 1;
        auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho)) + 1;
        return auxiliar;
    }

    //////////////////////////////
    /*Rotacion Doble Derecha     */
    //////////////////////////////
    public NodoArbolAVL rotacionDobleIzquierda(NodoArbolAVL c) {
        NodoArbolAVL temporal;
        c.hijoIzquierdo = rotacionDerecha(c.hijoIzquierdo);
        temporal = rotacionIzquierda(c);
        return temporal;
    }

    //////////////////////////////
    /*Rotacion Doble Izquierda    */
    //////////////////////////////
    public NodoArbolAVL rotacionDobleDerecha(NodoArbolAVL c) {
        NodoArbolAVL temporal;
        c.hijoDerecho = rotacionIzquierda(c.hijoDerecho);
        temporal = rotacionDerecha(c);
        return temporal;
    }

    //////////////////////////////
    /*Metodo para insertar AVL   */
    //////////////////////////////
    public NodoArbolAVL insertarAVL(NodoArbolAVL nuevo, NodoArbolAVL subAr) {
        NodoArbolAVL nuevoPadre = subAr;
        if (nuevo.dato < subAr.dato) {
            if (subAr.hijoIzquierdo == null) {
                subAr.hijoIzquierdo = nuevo;
            } else {
                subAr.hijoIzquierdo = insertarAVL(nuevo, subAr.hijoIzquierdo);
                if ((obtenerFE(subAr.hijoIzquierdo) - obtenerFE(subAr.hijoDerecho) == 2)) {
                    if (nuevo.dato < subAr.hijoIzquierdo.dato) {
                        nuevoPadre = rotacionIzquierda(subAr);
                    } else {
                        nuevoPadre = rotacionDobleIzquierda(subAr);
                    }
                }
            }
        } else if (nuevo.dato > subAr.dato) {
            if (subAr.hijoDerecho == null) {
                subAr.hijoDerecho = nuevo;
            } else {
                subAr.hijoDerecho = insertarAVL(nuevo, subAr.hijoDerecho);
                if ((obtenerFE(subAr.hijoDerecho) - obtenerFE(subAr.hijoIzquierdo) == 2)) {
                    if (nuevo.dato > subAr.hijoDerecho.dato) {
                        nuevoPadre = rotacionDerecha(subAr);
                    } else {
                        nuevoPadre = rotacionDobleDerecha(subAr);
                    }
                }
            }
        } else {
            System.out.println("Nodo Duplicado");
        }

    //////////////////////////
    /*Actualizando la altura*/
    //////////////////////////

        if ((subAr.hijoIzquierdo == null) && (subAr.hijoDerecho != null)) {
            subAr.fe = subAr.hijoDerecho.fe + 1;
        } else if ((subAr.hijoDerecho == null) && (subAr.hijoIzquierdo != null)) {
            subAr.fe = subAr.hijoIzquierdo.fe + 1;
        } else {
            subAr.fe = Math.max(obtenerFE(subAr.hijoIzquierdo), obtenerFE(subAr.hijoDerecho)) + 1;
        }
        return nuevoPadre;
    }

    //////////////////////////////
    /*Metodo para insertar    */
    /////////////////////////////

    public void  insertar(int d){
        NodoArbolAVL nuevo = new NodoArbolAVL(d);
        if (raiz==null){
            raiz=nuevo;
        } else {
            raiz=insertarAVL(nuevo,raiz);
        }
    }

    //////////////////////////////
    /*Recorridos                */
    /////////////////////////////

    ///////////////////////////////////////////
    /*Metodo para rrecorrer el Arbol InOrder */
    ///////////////////////////////////////////
    public void inOrden(NodoArbolAVL r, StringBuilder sb){
        if (r!=null){
            inOrden(r.hijoIzquierdo, sb);
            sb.append(r.dato).append(", -->");
            //System.out.print(r.dato + ", -->");
            inOrden(r.hijoDerecho, sb);
        }
    }

    public String inOrdenString() {
        StringBuilder sb = new StringBuilder();
        inOrden(obtenerRaiz(), sb);
        return sb.toString();
    }

    ///////////////////////////////////////////
    /*Metodo para rrecorrer el Arbol PreOrden */
    ///////////////////////////////////////////
    public void preOrden(NodoArbolAVL r, StringBuilder sb){
        if (r!=null){
            //System.out.print(r.dato + ", -->");
            sb.append(r.dato).append(", -->");
            preOrden(r.hijoIzquierdo, sb);
            preOrden(r.hijoDerecho, sb);
        }
    }

    public String preOrdenString() {
        StringBuilder sb = new StringBuilder();
        preOrden(obtenerRaiz(), sb);
        return sb.toString();
    }

    ////////////////////////////////////////////
    /*Metodo para rrecorrer el Arbol PostOrden */
    //////////////////// ////////////////////////

    public void postOrden(NodoArbolAVL r, StringBuilder sb){
        if (r!=null){
            postOrden(r.hijoIzquierdo, sb);
            postOrden(r.hijoDerecho, sb);
            sb.append(r.dato).append(", -->");
            //System.out.print(r.dato + ", -->");
        }
    }

    public String postOrdenString() {
        StringBuilder sb = new StringBuilder();
        postOrden(obtenerRaiz(), sb);
        return sb.toString();
    }





    //////////////////////////////
    /*Metodo para obtener el nodo con valor mínimo en un subárbol */
    //////////////////////////////
    private NodoArbolAVL obtenerMinimo(NodoArbolAVL nodo) {
        if (nodo == null) {
            return null;
        }

        while (nodo.hijoIzquierdo != null) {
            nodo = nodo.hijoIzquierdo;
        }

        return nodo;
    }

    //////////////////////////////
    /*Metodo para eliminar AVL  */
    //////////////////////////////
    public NodoArbolAVL eliminarAVL(NodoArbolAVL nodo, int dato) {
        if (nodo == null) {
            return null;
        }

        // Búsqueda del nodo a eliminar
        if (dato < nodo.dato) {
            nodo.hijoIzquierdo = eliminarAVL(nodo.hijoIzquierdo, dato);
        } else if (dato > nodo.dato) {
            nodo.hijoDerecho = eliminarAVL(nodo.hijoDerecho, dato);
        } else {
            // Nodo encontrado, proceder con la eliminación

            // Caso 1: Nodo con un solo hijo o sin hijos
            if (nodo.hijoIzquierdo == null || nodo.hijoDerecho == null) {
                NodoArbolAVL temp = null;
                if (nodo.hijoIzquierdo == null) {
                    temp = nodo.hijoDerecho;
                } else {
                    temp = nodo.hijoIzquierdo;
                }

                // No tiene hijos
                if (temp == null) {
                    temp = nodo;
                    nodo = null;
                } else { // Tiene un hijo
                    nodo = temp;
                }
            } else {
                // Caso 2: Nodo con dos hijos, buscar sucesor inorden y reemplazar
                NodoArbolAVL temp = obtenerMinimo(nodo.hijoDerecho);
                nodo.dato = temp.dato;
                nodo.hijoDerecho = eliminarAVL(nodo.hijoDerecho, temp.dato);
            }
        }

        // Si el árbol solo tenía un nodo, no es necesario reequilibrar
        if (nodo == null) {
            return nodo;
        }

        // Actualizar factor de equilibrio
        nodo.fe = Math.max(obtenerFE(nodo.hijoIzquierdo), obtenerFE(nodo.hijoDerecho)) + 1;

        // Verificar el equilibrio del nodo
        int balance = obtenerFE(nodo.hijoIzquierdo) - obtenerFE(nodo.hijoDerecho);

        // Casos de rotación para reequilibrar
        if (balance > 1) {
            if (obtenerFE(nodo.hijoIzquierdo.hijoIzquierdo) >= obtenerFE(nodo.hijoIzquierdo.hijoDerecho)) {
                nodo = rotacionDerecha(nodo); // Rotación simple derecha
            } else {
                nodo = rotacionDobleIzquierda(nodo); // Rotación doble izquierda
            }
        } else if (balance < -1) {
            if (obtenerFE(nodo.hijoDerecho.hijoDerecho) >= obtenerFE(nodo.hijoDerecho.hijoIzquierdo)) {
                nodo = rotacionIzquierda(nodo); // Rotación simple izquierda
            } else {
                nodo = rotacionDobleDerecha(nodo); // Rotación doble derecha
            }
        }

        return nodo;
    }


}


