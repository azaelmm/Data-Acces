package Ejer1;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nSelecciona una opción:");
            System.out.println("1. Programa 1 - Números Aleatorios");
            System.out.println("2. Programa 2 - Leer y Guardar Números desde Teclado");
            System.out.println("3. Programa 3 - Agregar Ejer1.Persona y leerla");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            int opcion;
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();  // Limpia el buffer después de leer el número
            } else {
                System.out.println("Entrada inválida. Por favor, introduce un número.");
                scanner.nextLine();  // Limpia el buffer si la entrada no es válida
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Programa 1 - Selecciona una opción:");
                    System.out.println("1. Guardar Números Aleatorios");
                    System.out.println("2. Leer Números desde el archivo");

                    int opcionPrograma1;
                    if (scanner.hasNextInt()) {
                        opcionPrograma1 = scanner.nextInt();
                        scanner.nextLine();  // Limpia el buffer después de leer el número
                    } else {
                        System.out.println("Entrada inválida. Por favor, introduce un número.");
                        scanner.nextLine();  // Limpia el buffer si la entrada no es válida
                        continue;
                    }

                    switch (opcionPrograma1) {
                        case 1 -> almacenarNumerosAleatorios();
                        case 2 -> leerNumeros();
                        default -> System.out.println("Opción no válida en Programa 1.");
                    }
                    break;

                case 2:
                    escribirNumeros();
                    break;

                case 3:
                    System.out.println("Programa 3 - Selecciona una opción:");
                    System.out.println("1. Crear y Guardar Ejer1.Persona");
                    System.out.println("2. Leer Personas desde el archivo");

                    int opcionPrograma3;
                    if (scanner.hasNextInt()) {
                        opcionPrograma3 = scanner.nextInt();
                        scanner.nextLine();  // Limpia el buffer después de leer el número
                    } else {
                        System.out.println("Entrada inválida. Por favor, introduce un número.");
                        scanner.nextLine();  // Limpia el buffer si la entrada no es válida
                        continue;
                    }

                    switch (opcionPrograma3) {
                        case 1 -> {
                            Persona persona = crearPersona();
                            guardarPersona(persona);
                        }
                        case 2 -> leerPersonas();
                        default -> System.out.println("Opción no válida en Programa 3.");
                    }
                    break;

                case 4:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
        scanner.close();
    }

    private static void escribirNumeros() {
        //facilito la escritura de datos en varios formatos primitivos y luego abro o creo el archivo datos.dat en modo de escritura
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("datos.dat"))) {
            Scanner scanner = new Scanner(System.in);
            int numero;

            System.out.println("Introduce numeros... (introduce -1 para acabar):");

            while (true) {

                // condicion para evitar que escriban texto
                if (!scanner.hasNextInt()) {
                    System.out.println("Solo se permiten números enteros.");
                    scanner.next();
                    continue;
                }

                numero = scanner.nextInt();

                if (numero == -1) break;

                dos.writeInt(numero);
            }

        } catch (IOException e) {
            System.err.println("Error al escribir números: " + e.getMessage());
        }
    }

    private static void leerPersonas() {
        try (BufferedReader br = new BufferedReader(new FileReader("persona.dat"))) {
            System.out.println("Leyendo personas del archivo persona.dat:");
            String linea;
            while ((linea = br.readLine()) != null) {
                Persona persona = new Persona(linea);
                System.out.println(persona);
            }
        } catch (IOException e) {
            System.err.println("Error al leer las personas: " + e.getMessage());
        }
    }

    private static void guardarPersona(Persona persona) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("persona.dat", true))) {
            bw.write(persona.toDataString() +"\n");
        } catch (IOException e) {
            System.err.println("Error al guardar la persona: " + e.getMessage());
        }
    }

    private static Persona crearPersona() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ingrese el DNI: ");
        String DNI = scanner.nextLine();
        System.out.print("ingrese el Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("ingrese la Edad: ");
        int edad = scanner.nextInt();

        Persona p = new Persona(DNI, nombre, edad);
        return p;
    }

    private static void leerNumeros() {
        // Abro el archivo datos.dat para poder leer datos en formato primitivo, como enteros o caracteres.
        try (DataInputStream dis = new DataInputStream(new FileInputStream("datos.dat"))) {
            int[] numeros = new int[5];
            for (int i = 0; i < 5; i++) {
                numeros[i] = dis.readInt();
                System.out.print(numeros[i] + " ");
            }
            System.out.println();

        } catch (IOException e) {
            System.err.println("Error al leer números: " + e.getMessage());
        }
    }

    private static void almacenarNumerosAleatorios() {

        //facilito la escritura de datos en varios formatos primitivos y luego abro o creo el archivo datos.dat en modo de escritura
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("datos.dat"))) {
            Random random = new Random();
            for (int i = 0; i < 5; i++) {
                int numeroAleatorio = random.nextInt(100); // Número aleatorio entre 0 y 99
                dos.writeInt(numeroAleatorio);
            }

        } catch (IOException e) {
            System.err.println("Error al guardar números: " + e.getMessage());
        }
    }
}
