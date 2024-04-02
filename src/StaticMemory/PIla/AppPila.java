package StaticMemory.PIla;

import javax.swing.*;

public class AppPila {
    public static void main(String[] args) {
        int opcion = 0, elemento, tamanio;
        boolean estado = false;

        try {
            tamanio = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "De que tamaño quieres la pila",
                    "Solicitando tamaño",
                    JOptionPane.INFORMATION_MESSAGE));

            Pila pilita = new Pila(tamanio);
            do {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Empujar un elemento en la Pila \n"
                                + "2. Sacar un elemento de la pila\n"
                                + "3. La pila esta vacia\n"
                                + "4. La pila esta llena\n"
                                + "5. Que elemento esta en la cima\n"
                                + "6. Tamaño de la pila\n"
                                + "7. Salir\n"
                                + "Que deseas hacer?", "Menu de opciones",
                        JOptionPane.INFORMATION_MESSAGE));
                switch (opcion) {

                    case 1:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el elemento a empujar", "Apilando datos",
                                JOptionPane.INFORMATION_MESSAGE));
                        if (!pilita.estaLlena()) {
                            pilita.push(elemento);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "La pila esta llena", "pila llena", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 2:
                        if (!pilita.estaVacia()) {
                            JOptionPane.showMessageDialog(null, "El elemento obtenido es "
                                    + pilita.pop(), "Obteniendo datos de la pila", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "La pila esta vacia", "pila vacia", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 3:
                        if (pilita.estaVacia()) {
                            JOptionPane.showMessageDialog(null, "La pila esta vacia",
                                    "pila vacia", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila no esta vacia",
                                    "La pila contiene datos", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 4:
                        if (pilita.estaLlena()) {
                            JOptionPane.showMessageDialog(null, "La pila esta llena",
                                    "pila llena", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila no esta llena",
                                    "La pila contiene espacio aun", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 5:
                        if (!pilita.estaVacia()) {
                            JOptionPane.showMessageDialog(null, "El elemento que se encuentra en la cima es " + pilita.cimaPila(),
                                    "Cima de la pila", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila no esta vacia",
                                    "La pila contiene datos", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 6:
                        JOptionPane.showMessageDialog(null, "El tamaño de la pila es " + pilita.TamanoPila(),
                                "Tamaño de la pila", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case 7:
                        JOptionPane.showMessageDialog(null, "Aplicacion Finalizada",
                                "Fin", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcion incorrecta",
                                "Error", JOptionPane.INFORMATION_MESSAGE);

                }
            } while (opcion != 7);
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "Error " + n.getMessage());
        }

    }
}
