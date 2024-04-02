package ListasEnlazadas.Singly_Linked_Lists;

public class ListNode {
    public int id;

    //puntero siguiente enlace, de esta misma clase
    public ListNode siguiente;


    //Constructor para insertar al FINAL
    public ListNode(int num) {
        this.id = num;
        this.siguiente = null;
    }

    //Constructor para Insertar al INICIO
    public ListNode(int num, ListNode n) {
        this.id = num;
        this.siguiente = n;
    }
}
