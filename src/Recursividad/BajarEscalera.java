package Recursividad;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BajarEscalera {
    public static void main(String[] args) {

        BajarEscalera bjrEscalera = new BajarEscalera();
        BajarEscalera bjrEscalera1 = new BajarEscalera();

        // Crear dos hilos y asignarles las instancias de BajarEscalera
        Thread thread1 = new Thread(() -> bjrEscalera.bajarEscalera(15));
        Thread thread2 = new Thread(() -> bjrEscalera1.bajarEscalera(20));

        // Iniciar ambos hilos
        thread1.start();
        thread2.start();
    }

        public void bajarEscalera(int escalones){
            if (escalones==0){
                //caso base, ya termino, Respuesta
                System.out.println("Terminaste de bajar la escalera");
            } else {
                try {
                Thread.sleep(1000);
                //Dominio: la division del problema original (problema -1)
                System.out.println("Bajando escalon " + escalones);
                //Haciendo la recursividad
                bajarEscalera(escalones-1);
                }catch (InterruptedException e){
                    Logger.getLogger(BajarEscalera.class.getName()).log(Level.SEVERE, "An error occurred while waiting", e);
                }
            }
        }

}
