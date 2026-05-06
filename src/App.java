import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);  
        int[] datos = {12, -7, 25, 0, -15, 33, 19, -22, 5, 48, -3};
        int opcion;

        do {
            System.out.println(".  PROGRAMA DE ORDENAMIENTO " );
            System.out.println("1. Ejecutar ordenamientos");
            System.out.println("2. Salir");
            System.out.print("\nSeleccione una opción: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.print("¿Inserción ascendente? (true/false): ");
                boolean ascIns = sc.nextBoolean();
                System.out.print("¿Shell ascendente? (true/false): ");
                boolean ascShell = sc.nextBoolean();

                
                Insercion ins = new Insercion();
                ins.sort(datos.clone(), ascIns);

                System.out.println(".                                         ");

                Shell sh = new Shell();
                sh.sort(datos.clone(), ascShell);
            }

        } while (opcion != 2);

        System.out.println("Programa finalizado.");
        sc.close();
    }
    
}
