import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ejer4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;
        String directorio_jugadores = "jugadores";

        File directorioJugadores = new File(directorio_jugadores);
        if (!directorioJugadores.exists()) {
            directorioJugadores.mkdir();
        }
        
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear jugador nuevo");
            System.out.println("2. Registrar partida");
            System.out.println("3. Ver historial de partidas");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearJugador(scanner, directorio_jugadores);
                    break;
                case 2:
                    registrarPartida(scanner, directorio_jugadores);
                    break;
                case 3:
                    verHistorial(scanner, directorio_jugadores);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();

    }

    private static void verHistorial(Scanner scanner, String directorio_jugadores) {

        System.out.print("ingrese el nombre: ");
        String nombre = scanner.nextLine();
        String archivo = directorio_jugadores + "/" + nombre + ".txt";

        File archivoRuta = new File(archivo);
        if (!archivoRuta.exists()) {
            System.out.println("Fichero no encontrado.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            System.out.println("\n--- Historial de partidas de " + nombre + " ---");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: ");
        }
    }

    private static void registrarPartida(Scanner scanner, String directorio_jugadores) {


        System.out.print("ingrese el nombre del jugador: ");
        String nombreJugador = scanner.nextLine();
        String archivoJugador = directorio_jugadores + "/" + nombreJugador + ".txt";

        File archivo = new File(archivoJugador);
        if (!archivo.exists()) {
            System.out.println("El fichero no existe");
            return;
        }

        System.out.print("ingrese el nombre del juego: ");
        String nombreJuego = scanner.nextLine();
        System.out.print("ingrese la puntuación obtenida: ");
        int puntuacion = scanner.nextInt();
        System.out.print("ingrese la duración de la partida en minutos: ");
        int duracion = scanner.nextInt();
        scanner.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaPartida = sdf.format(new Date());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            bw.write("Juego: " + nombreJuego + ", Fecha: " + fechaPartida + ", Puntuación: " + puntuacion + ", Duración: " + duracion + " minutos\n");
            System.out.println("Partida registrada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
    }

    private static void crearJugador(Scanner scanner, String directorio_jugadores) {
        System.out.print("Introduce el nombre del nuevo jugador: ");
        String nombreJugador = scanner.nextLine();
        String archivoJugador = directorio_jugadores + "/" + nombreJugador + ".txt";

        File archivo = new File(archivoJugador);
        if (archivo.exists()) {
            System.out.println("El jugador ya existe");
        } else {
            try {
                archivo.createNewFile();
                System.out.println("Jugador creado");
            } catch (Exception e) {
                System.out.println("Error al crear el archivo del jugador: " + e.getMessage());
            }
        }
    }
}