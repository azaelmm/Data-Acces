import java.io.*;
import java.util.Scanner;

public class Ejer3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Sistema de Registro de campeón ---");
            System.out.println("1. Registrar nuevo campeon");
            System.out.println("2. Mostrar todos los campeones");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarCampeones(scanner);
                    break;
                case 2:
                    mostrarCampeones();
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor elige una opción correcta.");
            }
        } while (opcion != 3);
    }

    private static void mostrarCampeones() {

        try {
            File archivo = new File("campeones.csv");
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;

            System.out.println("\n--- Campeones Registrados ---");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void registrarCampeones(Scanner scanner) {


        String nombreCampeon = "";
        String rolCampeon = "";

        try (FileWriter fileWriter = new FileWriter("campeones.csv", true)){
            System.out.println("ingrese el nombre: ");
            nombreCampeon = scanner.nextLine();
            System.out.println("ingrese el rol: ");
            rolCampeon = scanner.nextLine();

            fileWriter.write(nombreCampeon+";"+rolCampeon+";");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}