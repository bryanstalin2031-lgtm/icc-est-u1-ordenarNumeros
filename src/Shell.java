public class Shell {
    public void sort(int[] array, boolean asc){
        System.out.println(" METODO SHELL ");
        System.out.println("Arreglo original:");
        imprimirArreglo(array);
        System.out.println();
        
        int n = array.length;
        int[] gaps = {4, 2, 1};
        int comp = 0, iter = 0, camb = 0;

        for(int gap : gaps) {
            for (int i = gap; i < n; i++){
                iter++;
                int key = array[i];
                int j = i;
                comp++;

                boolean condicion = asc ? (array[j - gap] > key) : (array[j - gap] < key);
                imprimirFila("I" + iter, array, gap, j - gap, i, array[j -gap], key, condicion ? "si" : "no");

                while (j >= gap && (asc ? (array[j - gap] > key) : (array[j - gap] < key))) {
                    camb++;
                    array[j] = array[j -gap];
                    if (iter == 9 || iter == 17){
                        imprimirFila("", array, gap, j - gap, j, array[j - gap], key, "si");
                    }

                    j -= gap;
                    if(j >= gap) comp++;
                }
                array[j] = key;

                if(iter == 9 || iter == 17){
                    imprimirFila("", array, gap, j - gap, j, (j >= gap ? array[j - gap] : 0), key, "no");
                }
            }
            System.out.println();
        }
        System.out.println("END");
        imprimirArreglo(array);
        imprimirEstadisticas(comp, iter, camb);
    }

    private static void imprimirArreglo(int[] arr){
        for (int x : arr) System.out.printf("%5d", x);
        System.out.println();
    }

    private static void imprimirFila(String lbl, int[] arr, int g, int a, int b, int vA, int vB, String c) {
        System.out.printf("%-4s", lbl);
        for (int x : arr) System.out.printf("%5d", x);
        System.out.printf("    gap=%-2d a=%-3d b=%-3d [a]=%-5d [b]=%-5d cambio=%s\n",g, a, b, vA, vB, c);
    } 

    private static void imprimirEstadisticas(int comp, int iter, int camb) {
        System.out.printf("\nCCOMPARACIONES = %d\nITERACIONES  =%d\nCAMBIOS    =%d\n", comp, iter, camb);
    }

}
