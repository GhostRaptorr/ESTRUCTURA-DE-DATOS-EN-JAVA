package ListasEnlazadas.Circular_Lists;

public class CircularNode {
    int dato;
    CircularNode siguiente;

    public CircularNode(int d){
        dato=d;
        //Se va apuntaar asi mismo
        siguiente=this;
    }
}
