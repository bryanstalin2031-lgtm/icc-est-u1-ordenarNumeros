public class Shell {
    public static void ejecutar(int[] arr){
        System.out.println(" METODO SHELL ");
        System.out.println("Arreglo original:");
        imprimirArreglo(arr);
        System.out.println();
        
        int n = arr.length;
        int[] gaps = {4, 2, 1};
        int comp = 0, iter = 0, camb = 0;

        for(int gap : gaps) {
            for (int i = gap; i < n; i++){
                iter++;
                int key = arr[i];
                int j = i;
                comp++;

                String c = (arr[j - gap]> key) ? "si" : "no";
                imprimirFila("I" + iter, arr, gap, j - gap, i, arr[j -gap], key, c);

                while (j >= gap && arr[j - gap] > key) {
                    camb++;
                    arr[j] = arr[j -gap];
                    if (iter == 9 || iter == 17){
                        imprimirFila("", arr, gap, j - gap, j, arr[j - gap], key, "si");
                    }

                    j -= gap;
                    if(j >= gap) comp++;
                }
                arr[j] = key;

                if(iter == 9 || iter == 17){
                    imprimirFila("", arr, gap, j - gap, j, (j >= gap ? arr[j - gap] : 0), key, "no");
                }
            }
            System.out.println();
        }
        System.out.println("END");
        imprimirArreglo(arr);
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
