package ArbolBinarioAVL;

public class AppAVL {
    public static void main(String[] args) {
        ArbolAVL arbolitoAVL = new ArbolAVL();
        //Insertando NODOS
        arbolitoAVL.insertar(10);
        arbolitoAVL.insertar(5);
        arbolitoAVL.insertar(13);
        arbolitoAVL.insertar(1);
        arbolitoAVL.insertar(6);
        arbolitoAVL.insertar(17);


        //10, 5, 1, 6, 13, 17,

        //        10,
        //     5,     13,
        //   1, 6,      17,

        arbolitoAVL.insertar(16);
        //arbolitoAVL.preOrden(arbolitoAVL.obtenerRaiz());

        // Eliminando un nodo (por ejemplo, eliminar el nodo con valor 13)
        arbolitoAVL.eliminarAVL(arbolitoAVL.obtenerRaiz(),16);
        System.out.println("OTRO");
        //10, 5, 1, 6, 16, 13, 17,

        //       10,
        //   5,      16,
        // 1, 6,    13, 17,




       // arbolitoAVL.preOrden(arbolitoAVL.obtenerRaiz());
    }
}
