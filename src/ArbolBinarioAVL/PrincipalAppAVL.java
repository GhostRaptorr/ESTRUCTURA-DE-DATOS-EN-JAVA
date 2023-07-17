package ArbolBinarioAVL;
import javax.swing.JOptionPane;
public class PrincipalAppAVL {
    public static void main(String[] args) {
        ArbolAVL arbolitoAVL = new ArbolAVL();

        while (true) {
            try {
                String opcion = JOptionPane.showInputDialog(
                        "Elije una opción:\n" +
                                "1. Insertar nodo\n" +
                                "2. Eliminar nodo\n" +
                                "3. Buscar nodo\n" +
                                "4. Recorrido InOrden\n" +
                                "5. Recorrido PreOrden\n" +
                                "6. Recorrido PostOrden\n" +
                                "7. Salir"
                );

                if (opcion == null) {
                    // El usuario ha cerrado la ventana de diálogo
                    break;
                }

                switch (opcion) {
                    case "1":
                        int valorInsertar = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el valor del nodo a insertar:"));
                        arbolitoAVL.insertar(valorInsertar);
                        break;
                    case "2":
                        int valorEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el valor del nodo a eliminar:"));
                        arbolitoAVL.eliminarAVL(arbolitoAVL.obtenerRaiz(),valorEliminar);
                        break;
                    case "3":
                        int valorBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el valor del nodo a buscar:"));
                        NodoArbolAVL nodoEncontrado = arbolitoAVL.buscar(valorBuscar, arbolitoAVL.obtenerRaiz());
                        if (nodoEncontrado != null) {
                            JOptionPane.showMessageDialog(null, "Nodo encontrado: " + nodoEncontrado.dato);
                        } else {
                            JOptionPane.showMessageDialog(null, "Nodo no encontrado.");
                        }
                        break;
                    case "4":
                        //arbolitoAVL.inOrden(arbolitoAVL.obtenerRaiz());
                        System.out.println();
                        JOptionPane.showMessageDialog(null, "Recorrido InOrden:\n" + arbolitoAVL.inOrdenString());
                        break;
                    case "5":
                        //arbolitoAVL.preOrden(arbolitoAVL.obtenerRaiz());
                        System.out.println();
                        JOptionPane.showMessageDialog(null, "Recorrido PreOrden:\n" + arbolitoAVL.preOrdenString());
                        break;
                    case "6":
                        //arbolitoAVL.postOrden(arbolitoAVL.obtenerRaiz());
                        System.out.println();
                        JOptionPane.showMessageDialog(null, "Recorrido PostOrden:\n" + arbolitoAVL.postOrdenString());
                        break;
                    case "7":
                        JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                        System.exit(0);
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, elija una opción válida.");
                }
            } catch (NumberFormatException e) {
                // Capturar excepción si el usuario ingresa un valor no numérico
                JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese un valor numérico válido.");
            }
        }
    }
}
