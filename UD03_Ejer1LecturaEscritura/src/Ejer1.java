import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Ejer1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Sistema de Registro de Empleados ---");
            System.out.println("1. Registrar nuevo empleado");
            System.out.println("2. Mostrar todos los empleados");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarEmpleado(scanner);
                    break;
                case 2:
                    mostrarEmpleados();
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor elige una opción correcta.");
            }
        } while (opcion != 3);
        
    }

    private static void mostrarEmpleados() {

        String rutaTexto = "empleados.csv";

        try {

            // Lectura del contenido del fichero
            Path path = Paths.get(rutaTexto);
            List<String> lines = Files.readAllLines(path);

            //Mostrar datos por consola
            for (String s:lines) {
                System.out.println(s);
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }

    }

    private static void registrarEmpleado(Scanner scanner) {

        int idEmpleado = 0;
        String nombre = "";
        String departamento = "";

        try (FileWriter fileWriter = new FileWriter("empleados.csv", true)){
            System.out.println("ingrese su id de empleado: ");
            idEmpleado = scanner.nextInt();
            scanner.nextLine();
            System.out.println("ingrese su nombre: ");
            nombre = scanner.nextLine();
            System.out.println("ingrese su departamento: ");
            departamento = scanner.nextLine();

            fileWriter.write("- ID empleado: "+idEmpleado+", nombre: "+nombre+", departamento: "+departamento +"\n");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}