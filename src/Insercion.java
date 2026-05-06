public class Insercion {
    public void sort(int[] array, boolean asc){
        System.out.println(" METODO INSERCIÓN ");
        System.out.println(" Arreglo original:");
        imprimirArreglo(array);
        System.out.println();

        int n = array.length;
        int comparaciones = 0, iteraciones = 0, cambios = 0;

        for (int i = 1; i < n; i++){
            iteraciones++;
            int key = array[i];
            int j = i - 1;

            boolean condicion = asc ? (array[j] > key) : (array[j] < key);
            comparaciones++;
            imprimirFila("I" + iteraciones, array, j, i, array[j], key, condicion ? "si" : "no");

            while (j >= 0 && (asc ? (array[j] > key) : (array[j] < key))) {
                cambios++;
                array[j + 1] = array[j];

                if (iteraciones >= 5) {
                    imprimirFila("", array, j, j +1, array[j], key, "si");
                }

                j--;
                if (j >= 0) comparaciones++;
            }
            array[j + 1] = key;

            if (iteraciones >= 5){
                imprimirFila("", array, j, j + 1, (j >= 0 ? array[j] : 0), key, "no");
            }
            System.out.println();
        }

        System.out.println("END");
        imprimirArreglo(array);
        imprimirEstadisticas(comparaciones, iteraciones, cambios);
    }
    
    private static void imprimirArreglo(int[] arr){
        for (int x : arr) System.out.printf("%5d", x);
        System.out.println();
    }

    private static void imprimirFila(String label, int[] arr, int a, int b, int vA, int vB, String c) {
        System.out.printf("%-4s", label);
        for (int x : arr) System.out.printf("%5d", x);
        System.out.printf("    a=%-3d b=%-3d [a]=%-5d [b]=%-5d cambio=%s\n", a, b, vA, vB, c);
    } 

    private static void imprimirEstadisticas(int comp, int iter, int camb) {
        System.out.printf("\nCCOMPARACIONES = %d\nITERACIONES  =%d\nCAMBIOS    =%d\n", comp, iter, camb);
    }

    
}
