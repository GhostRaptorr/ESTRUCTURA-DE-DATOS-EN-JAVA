package ListasEnlazadas.Doubly_Linked_Lists;

import javax.swing.*;

public class AppListaDoble {
    public static void main(String[] args) {
        ListaDoble listitaDoble = new ListaDoble();

        int opcion = 0, elemento;

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1 Agregar un nodo al inicio\n" +
                                "2 Agregar un nodo al final\n" +
                                "3 Mostrar la lista de Inicio a Fin\n" +
                                "4 Mostrar la lista de Fin a Inicio\n" +
                                "5 Eliminar un nodo del inicio\n" +
                                "6 Eliminar un nodo del final\n" +
                                "7 Salir\n" +
                                "Que deseas hacer?", "Menu de Opciones", JOptionPane.INFORMATION_MESSAGE));

                switch (opcion) {
                    case 1:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el elemento del Nodo", "Agregando al inicio", JOptionPane.INFORMATION_MESSAGE));
                        listitaDoble.agregarAlInicio(elemento);
                        break;
                    case 2:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el elemento del Nodo", "Agregando al inicio", JOptionPane.INFORMATION_MESSAGE));
                        listitaDoble.agregarAlFinal(elemento);
                        break;
                    case 3:
                        if (!listitaDoble.estaVacia()) {
                            listitaDoble.mostrarInioAFin();
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay nodos aun", "Lista vacia", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 4:
                        if (!listitaDoble.estaVacia()) {
                            listitaDoble.mostrarFinAInicio();
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay nodos aun", "Lista vacia", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 5:
                        if (!listitaDoble.estaVacia()) {
                            elemento = listitaDoble.eliminarInicio();
                            JOptionPane.showMessageDialog(null, "Elemento eliminado es: " + elemento, "Eliminando del inicio", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            JOptionPane.showMessageDialog(null, "No hay nodos aun", "Lista vacia", JOptionPane.INFORMATION_MESSAGE);

                        }
                        break;
                    case 6:
                        if (!listitaDoble.estaVacia()) {
                            elemento = listitaDoble.eliminarFin();
                            JOptionPane.showMessageDialog(null, "Elemento eliminado es: " + elemento, "Eliminando del final", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            JOptionPane.showMessageDialog(null, "No hay nodos aun", "Lista vacia", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null, "Aplicacion Finalizada", "Fin", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "La opcion no esta en Menu", "Incorrecto", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }

            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Error: " + n.getMessage());
            }
        } while (opcion != 7);
    }
}
