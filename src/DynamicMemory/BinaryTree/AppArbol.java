package DynamicMemory.BinaryTree;

import javax.swing.*;

public class AppArbol {
    public static void main(String args[]) {

        int opcion = 0, elemento = 0;
        String nombre;

        Arbol arbolito = new Arbol();

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Elige una opcion \n\n" +

                                "1. Agregar un Nodo\n" +
                                "2. Recorrer el Arbol InOrden\n" +
                                "3. Recorrer el Arbol en PreOrden\n" +
                                "4. Recorrer el Arbol en PostOrden\n" +
                                "5. Buscar un Nodo en el Arbol\n" +
                                "6. Eliminar Nodo\n" +
                                "7. Salir\n",
                        "Arbol Binario", JOptionPane.QUESTION_MESSAGE));

                switch (opcion) {
                    case 1:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero del Nodo: ", "Agregando Nodo", JOptionPane.QUESTION_MESSAGE));
                        nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre del Nodo", "Agregando Nodo", JOptionPane.QUESTION_MESSAGE);
                        arbolito.agregarNodo(elemento, nombre);
                        break;
                    case 2:
                        if (!arbolito.estaVacio()) {
                            System.out.println();
                            arbolito.inOrden(arbolito.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "El arbol esta Vacio", "Alvertencia!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 3:
                        if (!arbolito.estaVacio()) {
                            System.out.println();
                            arbolito.preOrden(arbolito.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "El arbo esta vacio", "Alvertencia!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 4:
                        if (!arbolito.estaVacio()) {
                            System.out.println();
                            arbolito.postOrden(arbolito.raiz);
                        } else {
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio", "Advertncia!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 5:
                        if (!arbolito.estaVacio()) {
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Elemento del Nodo a buscar", "Buscar Nodo", JOptionPane.INFORMATION_MESSAGE));
                            if (arbolito.buscarNodo(elemento) == null) {
                                JOptionPane.showMessageDialog(null, "El Nodo no se encuentra en el arbol",
                                        "Nodo No encontrado", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                System.out.println("Nodo Encontrado, Sus datos son: " + arbolito.buscarNodo(elemento));
                                JOptionPane.showMessageDialog(null, "Nodo Encontrado, Sus datos son: " + arbolito.buscarNodo(elemento), "Nodo encontrado", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio", "Advertncia!", JOptionPane.INFORMATION_MESSAGE);
                        }

                        break;
                    case 6:
                        if (!arbolito.estaVacio()) {
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Elemento del Nodo a Eliminar", "Eliminando Nodo", JOptionPane.INFORMATION_MESSAGE));
                            if (arbolito.eliminar(elemento) == false) {
                                JOptionPane.showMessageDialog(null, "El Nodo no se encuentra en el arbol",
                                        "Nodo No encontrado", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "El Nodo ha sido eliminado del arbol","Nodo eliminado", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio", "Advertncia!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null, "Aplicacion Finalizada", "Fin", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion Invalida", "CUIDADO!", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
            }

        } while (opcion != 7);

    }
}
