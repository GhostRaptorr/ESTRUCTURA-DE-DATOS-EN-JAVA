package DynamicMemory.Queue;

import javax.swing.*;

public class AppCola {
    public static void main(String[] args) {
        int opcion = 0, elemento = 0;

        Cola colita = new Cola();


        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Menu de Opciones\n\n" +
                                "1. Insertar\n" +
                                "2. Quitar\n" +
                                "3. Quien esta al inicio\n" +
                                "4. Tamaño\n" +
                                "5. Salir\n" +
                                "\n \n", JOptionPane.QUESTION_MESSAGE));


                switch (opcion) {
                    case 1:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Elemento a insertar: ", "Insertar", JOptionPane.QUESTION_MESSAGE));
                        colita.insertar(elemento);
                        break;
                    case 2:
                        if (!colita.estaVacia()) {
                            JOptionPane.showMessageDialog(null, "Quitando ..." + colita.quitar(), "Borrar", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Vacia: ", "Esta vacia", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 3:
                        if (!colita.estaVacia()) {
                            JOptionPane.showMessageDialog(null, "Inicio: " + colita.inicioDato(), "Inicio", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Vacia: ", "Esta vacia", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 4:
                        if (!colita.estaVacia()) {
                            JOptionPane.showMessageDialog(null, "El tamaño es: " + colita.tamanio(), "Tamaño", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Vacia: ", "Esta vacia", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Saliendo..: ", "Salir", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion invalida ", "Default", JOptionPane.INFORMATION_MESSAGE);
                }


            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } while (opcion != 5);

    }
}
