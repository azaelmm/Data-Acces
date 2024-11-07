import java.io.*;
import java.util.Scanner;

public class Ejer2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Sistema de Registro de Personajes ---");
            System.out.println("1. Registrar nuevo Personaje");
            System.out.println("2. Mostrar todos los personajes");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarPersonajes(scanner);
                    break;
                case 2:
                    mostrarPersonajes();
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor elige una opción correcta.");
            }
        } while (opcion != 3);

    }

    private static void mostrarPersonajes() {

        try {
            File archivo = new File("personajes.csv");
            if (!archivo.exists()) {
                System.out.println("No hay personajes registrados.");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            System.out.println("\n--- Personajes Registrados ---");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

    }

    private static void registrarPersonajes(Scanner scanner){

        try {
            File archivo = new File("personajes.csv");
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            String nombre = "";
            String casa = "";
            String rol = "";

            do {
                System.out.println("ingrese el nombre del personaje: ");
                nombre = scanner.nextLine();
                System.out.println("ingrese el casa del personaje: ");
                casa = scanner.nextLine();
                System.out.println("ingrese el rol del personaje: ");
                rol = scanner.nextLine();

                if (nombre.isEmpty() || casa.isEmpty() || rol.isEmpty()) {
                    System.out.println("Error: Los datos no pueden estar vacíos.");
                }

            }while (nombre.isEmpty() || casa.isEmpty() || rol.isEmpty());


            try (FileWriter fileWriter = new FileWriter("personajes.csv", true)){
                fileWriter.write("- Nombre del personaje: "+nombre+", casa: "+casa+", rol del personaje: "+rol+"\n");
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }catch (Exception exception){

        }

    }
}
