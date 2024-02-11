package Recursividad;

public class FactorialNRecursividad {
    public static void main(String[] args) {
        FactorialNRecursividad factorial = new FactorialNRecursividad();
        System.out.println("factorial de 15: " + factorial.factorial(15));
        System.out.println("\nWhile factorial 15: " + factorial.factorialW(15));
        System.out.println("\nFor factorial 15: " + factorial.factorialF(15));
        System.out.println("\nDoWhile factorial 15: " + factorial.factorialDW(15));

    }

    public int factorial(int num) {

        if (num < 0) {
            return 0;
        } else {
            //caso base
            if (num == 0) {
                return 1;
            } else {
                //Dominio problema-1
                return num * factorial(num - 1);
            }
        }
    }

    //factorial ciclo WHILE
    public int factorialW(int num) {
        int factor = 1;
        if (num < 0) {
            return 0;
        } else {
            while (num != 0) {
                factor = num * factor;
                num--;
            }
            return factor;
        }
    }

    //factorial ciclo FOR
    public int factorialF(int num) {
        int factor = 1;
        if (num < 0) {
            return 0;
        } else {

            for (int i = 1; i <= num; i++) {
                factor = i * factor;
            }
            return factor;
        }
    }


    //factorial ciclo Do While
    public int factorialDW(int num) {
        int factor = 1;
        if (num < 0) {
            return 0;
        } else {
            do {
                factor = num * factor;
                num--;
            } while (num != 0);
            return factor;
        }
    }


}
