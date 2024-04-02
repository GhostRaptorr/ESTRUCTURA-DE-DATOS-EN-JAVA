package Grafos;

public class Grafos {
    public static void main(String[] args) {
        /*matriz de pesos: cuanto pesa cada arista o camino de Vertice a Vertice*/
        long[][] matrizA = {
                {0, 3, 4, 999999999L, 8, 999999999L},
                {999999999L, 0, 999999999L, 999999999L, 5, 999999999L},
                {999999999L, 999999999L, 0, 999999999L, 3, 999999999L},
                {999999999L, 999999999L, 999999999L, 0, 999999999L, 999999999L},
                {999999999L, 999999999L, 999999999L, 7, 0, 3},
                {999999999L, 999999999L, 999999999L, 2, 999999999L, 0}
        };
        CaminoMinimosFloyd ruta = new CaminoMinimosFloyd();
        System.out.println(ruta.algoritmoFloyd(matrizA));
    }
}
