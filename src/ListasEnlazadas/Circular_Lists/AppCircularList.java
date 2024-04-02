package ListasEnlazadas.Circular_Lists;

import javax.swing.*;

public class AppCircularList {
    public static void main(String[] args) {

        CircularList listita = new CircularList();


        int opcion = 0, elemento;
        boolean eliminado = false;

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1 Agregar un elemeto a la lista circular\n" +
                                "2 eliminar un nodo de la lista circular\n" +
                                "3 Mostrar datos de la lista circular\n" +
                                "4 Salir", "Menu de opciones", JOptionPane.QUESTION_MESSAGE));
                switch (opcion) {
                    case 1:
                        try {
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "ingresa el elemento",
                                    "Insertar nodo", JOptionPane.QUESTION_MESSAGE));
                            //agregando al NOOD
                            listita.insertar(elemento);
                        } catch (NumberFormatException n) {
                            JOptionPane.showInputDialog(null, "error: " + n.getMessage(), JOptionPane.INFORMATION_MESSAGE);
                        }

                        break;
                    case 2:
                        if (!listita.estaVacia()) {
                            try {
                                elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "ingresa el elemento",
                                        "Eliminar Nodo", JOptionPane.QUESTION_MESSAGE));
                                //eliminando NOOD
                                eliminado = listita.eliminar(elemento);
                                if (eliminado) {
                                    JOptionPane.showInputDialog(null, "Nodo eliminado: " + elemento, "Eliminando...", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showInputDialog(null, "Nodo no eliminado: " + elemento, "Nodo no encontrado en la lista", JOptionPane.INFORMATION_MESSAGE);
                                }

                                //listita.agregarFinal(elemento);
                            } catch (NumberFormatException n) {
                                JOptionPane.showInputDialog(null, "error: " + n.getMessage(), JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showInputDialog(null, "Aun hay nodos", "Lista vacia", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 3:
                        if (!listita.estaVacia()) {
                            //mostrando lista
                            listita.mostrarLista();
                        } else {
                            JOptionPane.showInputDialog(null, "Aun hay nodos", "Lista vacia", JOptionPane.INFORMATION_MESSAGE);

                        }

                        break;
                    case 4:
                        JOptionPane.showInputDialog(null, "SALIENDO", "Fin", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:

                        JOptionPane.showInputDialog(null, "Opcion invalida", "Incorrecto", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showInputDialog(null, "error: " + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
            }

        } while (opcion != 4);
    }
}
