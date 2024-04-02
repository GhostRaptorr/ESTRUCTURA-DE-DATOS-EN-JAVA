package ListasEnlazadas.Singly_Linked_Lists;

import javax.swing.*;

public class AppList {
    public static void main(String[] args) {
        List listita = new List();


        int opcion = 0, elemento;

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1 Agregar un elemeto al inicio\n" +
                                "2 Agregar un elemeto al final\n" +
                                "3 Mostrar datos de la lista\n" +
                                "4 Eliminar nodo inicio de la lista\n" +
                                "5 Eliminar nodo final de la lista\n" +
                                "6 Eliminar un nodo en especificode la lista\n" +
                                "7 Buscar Id del Nodo en especifico\n" +
                                "8 Salir", "Menu de opciones", JOptionPane.QUESTION_MESSAGE));
                switch (opcion) {
                    case 1:
                        try {
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "ingresa el elemento",
                                    "Insertar nodo al inicio", JOptionPane.QUESTION_MESSAGE));
                            //agregando al NOOD
                            listita.agregarInicio(elemento);
                        } catch (NumberFormatException n) {
                            JOptionPane.showInputDialog(null, "error: " + n.getMessage(), JOptionPane.INFORMATION_MESSAGE);
                        }

                        break;
                    case 2:
                        try {
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "ingresa el elemento",
                                    "Insertar nodo al final", JOptionPane.QUESTION_MESSAGE));
                            //agregando al NOOD
                            listita.agregarFinal(elemento);
                        } catch (NumberFormatException n) {
                            JOptionPane.showInputDialog(null, "error: " + n.getMessage(), JOptionPane.INFORMATION_MESSAGE);
                        }

                        break;
                    case 3:
                        //mostrando lista
                        listita.mostrarLista();

                        break;
                    case 4:
                        elemento = listita.borrarInicio();
                        JOptionPane.showInputDialog(null, "El elemento eliminado es: " + elemento, "eliminando nodo del inicio", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 5:
                        elemento = listita.borrarFinal();
                        JOptionPane.showInputDialog(null, "El elemento eliminado es: " + elemento, "eliminando nodo del Final", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 6:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el" + "... elemento a eliminar ...", "Eliminar Nodo especifco", JOptionPane.INFORMATION_MESSAGE));

                        if (listita.buscarIdNodo(elemento)) {
                            listita.borraNodoEnEspecifico(elemento);
                            JOptionPane.showMessageDialog(null, "elemento eliminado" + elemento, "elemento eliminado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "El elemento " + elemento + " no esta en la lista ", " Nodo no encontrado ", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 7:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el" + "... id a buscar ...", "Buscar Nodo especifco", JOptionPane.INFORMATION_MESSAGE));
                        if (listita.buscarIdNodo(elemento)) {
                            JOptionPane.showMessageDialog(null, "El elemento " + elemento + " si esta en la lista ", " Nodo encontrado ", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "El elemento " + elemento + " no esta en la lista ", " Nodo no encontrado ", JOptionPane.INFORMATION_MESSAGE);

                        }
                        break;
                    case 8:
                        JOptionPane.showInputDialog(null, "SALIENDO", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:

                        JOptionPane.showInputDialog(null, "Opcion invalida", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showInputDialog(null, "error: " + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
            }

        } while (opcion != 8);


    }
}
