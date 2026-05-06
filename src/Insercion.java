public class Insercion {
    public static void ejecutar(int[] arr){
        System.out.println(" METODO INSERCIÓN ");
        System.out.println(" Arreglo original:");
        imprimirArreglo(arr);
        System.out.println();

        int n = arr.length;
        int comparaciones = 0, iteraciones = 0, cambios = 0;

        for (int i = 1; i < n; i++){
            iteraciones++;
            int key = arr[i];
            int j = i - 1;

            comparaciones++;
            String cambioStr = (arr[j] > key) ? "si" : "no";
            imprimirFila("I" + iteraciones, arr, j, i, arr[j], key, cambioStr);

            while (j >= 0 && arr[j] > key) {
                cambios++;
                arr[j + 1] = arr[j];

                if (iteraciones >= 5) {
                    imprimirFila("", arr, j, j +1, arr[j], key, "si");
                }

                j--;
                if (j >= 0) comparaciones++;
            }
            arr[j + 1] = key;

            if (iteraciones >= 5){
                imprimirFila("", arr, j, j + 1, (j >= 0 ? arr[j] : 0), key, "no");
            }
            System.out.println();
        }

        System.out.println("END");
        imprimirArreglo(arr);
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
