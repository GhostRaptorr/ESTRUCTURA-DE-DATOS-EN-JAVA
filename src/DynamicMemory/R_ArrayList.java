package DynamicMemory;

import javax.swing.*;
import java.util.ArrayList;
//Methods:add, get, set, remove, size;

public class R_ArrayList {
    public static void main(String[] args) {

        //creando instancia o objecto de tipo ArrayList
        ArrayList<String> frases = new ArrayList<String>();
        String frase, respuesta="";

        do {
            try {

                frase = JOptionPane.showInputDialog(null, "Ingresa la frase", "Hello", JOptionPane.INFORMATION_MESSAGE);
                //method add
                frases.add(frase);

                respuesta = JOptionPane.showInputDialog(null, "Deseas agregar mas?", "Hello", JOptionPane.INFORMATION_MESSAGE);
                respuesta = respuesta.trim().toUpperCase();

            } catch (NullPointerException e) {
                // Manejar excepción específica cuando el usuario cancela la entrada
                System.out.println("Entrada cancelada por el usuario");
                break;  // Salir del bucle o manejar según sea necesario

            } catch (Exception e) {
                // Manejar otras excepciones de manera más general
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        } while (!respuesta.equals("NO"));

        System.out.println("Frases originales");

        for (String s : frases) {
            //method.get
            System.out.println(s);
        }

        System.out.println("\n\nFrases modificadas");
        //method set
        frases.set(1, "Modificada con set(Hello)");
        //mostrando
        //method size
        for (int i = 0; i < frases.size() ; i++) {
            System.out.println(frases.get(i));
        }

        System.out.println("\n\nFrases eliminadas");
        frases.remove(1);
        //method size
        for (int i = 0; i < frases.size() ; i++) {
            System.out.println(frases.get(i));
        }


    }
}
