package Grafos;

public class CaminoMinimosFloyd {
    //Metodo para determinar todos los caminos Floyd

    /*recibira de parametro una matriz de pesos: cuanto pesa cada arista o camino de Vertice a Vertice*/
    /*matriz de pesos
      |0 3 4 ∞ 8 ∞|
      |∞ 0 ∞ ∞ 5 ∞|
      |∞ ∞ 0 ∞ 3 ∞|
      |∞ ∞ ∞ 0 ∞ ∞|
      |∞ ∞ ∞ 7 0 3|
      |∞ ∞ ∞ 2 ∞ 0|
       */
    /*long[][] matrizA = {
            {0, 3, 4, 999999999L, 8, 999999999L},
            {999999999L, 0, 999999999L, 999999999L, 5, 999999999L},
            {999999999L, 999999999L, 0, 999999999L, 3, 999999999L},
            {999999999L, 999999999L, 999999999L, 0, 999999999L, 999999999L},
            {999999999L, 999999999L, 999999999L, 7, 0, 3},
            {999999999L, 999999999L, 999999999L, 2, 999999999L, 0}
        };*/
    public String algoritmoFloyd(long[][] mAdy) {
        int verticesTotales = mAdy.length;
        long matrizAdyacencia[][] = mAdy;
        String caminos[][] = new String[verticesTotales][verticesTotales];
        String caminosAuxiliares[][] = new String[verticesTotales][verticesTotales];
        String caminosRecorridos = "", cadena = "", caminitos = "";
        int i, j, k;
        float temporal1, temporal2, temporal3, temporal4, minimo;

        //Inicializando las matrices caminos y caminosAuxiliares
        for (i = 0; i < verticesTotales; i++) {
            for (j = 0; j < verticesTotales; j++) {
                caminos[i][j] = "";
                caminosAuxiliares[i][j] = "";

            }
        }

        /*Logica*/
        for (k = 0; k < verticesTotales; k++) {
            for (i = 0; i < verticesTotales; i++) {
                for (j = 0; j < verticesTotales; j++) {
                    temporal1 = matrizAdyacencia[i][j];
                    temporal2 = matrizAdyacencia[i][k];
                    temporal3 = matrizAdyacencia[k][j];
                    temporal4 = temporal2 + temporal3;

                    //Encontrando el camino minimo
                    minimo = Math.min(temporal1, temporal4);
                    if (temporal1 != temporal4) {
                        if (minimo == temporal4) {
                            caminosRecorridos = "";
                            caminosAuxiliares[i][j] = k + "";
                            caminos[i][j] = caminosR(i, k, caminosAuxiliares, caminosRecorridos) + (k + 1);
                        }
                    }
                    //casteo de float a long
                    matrizAdyacencia[i][j] = (long) minimo;
                }
            }
        }
        //Agregando el camino minimo a cadena
        for (i = 0; i < verticesTotales; i++) {
            for (j = 0; j < verticesTotales; j++) {
                cadena = cadena + "[" + matrizAdyacencia[i][j] + "]";
            }
            cadena = cadena + "\n";
        }
        //////////
        /*Logica*/
        /////////
        for (i = 0; i < verticesTotales; i++) {
            for (j = 0; j < verticesTotales; j++) {
                if (matrizAdyacencia[i][j] != 1000000000) {
                    if (i != j) {
                        if (caminos[i][j].equals("")) {
                            caminitos += "De (" + (i + 1) + "--->" + (j + 1) + ") Irse por...(" + (i + 1) + ", " + (j + 1) + ")\n";
                        } else {
                            caminitos += "De (" + (i + 1) + "--->" + (j + 1) + ") Irse Por..(" + (i + 1) + ", " + caminos[i][j] + ", " + (j + 1) + ")\n";
                        }
                    }
                }
            }
        }
        return "La Matriz de caminos mas cortos entre los diferentes vertices :\n" + cadena + "\nLos diferentess caminos mas cortos entre ertices son:\n" + caminitos;

    }

    //Metodo Camino Recusrivo
    public String caminosR(int i, int k, String[][] caminosAuxiliares, String caminoRecorrido) {
        if (caminosAuxiliares[i][k].equals("")) {
            return "";
        } else {
            //Recursividad
            caminoRecorrido += caminosR(i, Integer.parseInt(caminosAuxiliares[i][k].toString()), caminosAuxiliares, caminoRecorrido) + (Integer.parseInt(caminosAuxiliares[i][k].toString())+1)+", ";
            return caminoRecorrido;
        }
    }


}
