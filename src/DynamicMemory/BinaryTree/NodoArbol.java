package DynamicMemory.BinaryTree;

public class NodoArbol {
    int dato;
    String nombre;
    NodoArbol HjIzquierdo, HjDerecho;

    public NodoArbol(int d, String n){
        this.dato = d;
        this.nombre = n;
        this.HjDerecho = null;
        this.HjIzquierdo = null;
    }

    //toString: metodo ya implementado en JAVA. Para mostrar la informacion completa de todos los atributos o aquellos que tu quieras usar
    public String toString(){
        return nombre + " Su dato es: " + dato;
    }
}
