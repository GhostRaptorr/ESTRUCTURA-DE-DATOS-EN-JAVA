package StaticMemory;
import javax.swing.*;
import java.util.Arrays;
public class R_Arrays {
    public static void main(String args []){

        int numeros[] = new int [5];
        int numerotes [] = new int [numeros.length];
        String palabras [] = new String[5];

        int i;
        for(i=0; i<5; i++){
            numeros [i] = Integer.parseInt(JOptionPane.showInputDialog
                    (null,"Ingresa el elemento " + i));

        }

        //Mostrando los datos como fueron ingresados
        System.out.println("Datos sin ordenar son: ");
        for (i=0; i<numeros.length;i++){
            System.out.print("{ " + numeros[i] + " }");
        }

        //Datos ordenados
        System.out.println("\n\nDatos ordenados");
        Arrays.sort(numeros);
        for (i=0; i<5; i++){
            System.out.print("{ " + numeros[i] + " }");
        }

        //Rellenando el array palabras
        Arrays.fill(palabras, " Hello world");
        System.out.println("\n\nElementos de array palabras");
        for (i=0; i<5; i++){
            System.out.print("{ " + palabras[i] + " }");
        }

        //Copiando los elementos de array numeros a array numerostes
        System.arraycopy(numeros,0,numerotes,0,numeros.length);
        System.out.println("\n\nElementos de array numerotes");
        for (i=0; i<5; i++){
            System.out.print("{ " + numerotes[i] + " }");
        }

    }
}
