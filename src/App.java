public class App {
    public static void main(String[] args) throws Exception {
       
        int[] datos = {12, -7, 25, 0, -15, 33, 19, -22, 5, 48, -3};

        Insercion.ejecutar(datos.clone());

        System.out.println("\n" + "=".repeat(50) + "\n");

        Shell.ejecutar(datos.clone());
    }
}
