package Tarea_Ejercicio;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        String directoryName = "bd";
        String fileName = "tunombre.csv";
        Scanner scanner = new Scanner(System.in);

        try {
            File file = createFile(directoryName, fileName);
            ArrayList<String> content = readFileAsList(file.getAbsolutePath());
            int choice;

            do {
                System.out.println("\nMenú:");
                System.out.println("1. Leer contenido del archivo");
                System.out.println("2. Verificar si el archivo existe");
                System.out.println("3. Añadir líneas al archivo");
                System.out.println("4. Mostrar contenido como tabla");
                System.out.println("5. Contar campos en la cabecera");
                System.out.println("6. Contar líneas (sin contar la cabecera)");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (choice) {
                    case 1:
                        readFile(file);
                        break;
                    case 2:
                        System.out.println("¿El archivo existe? --> " + isFileExists(file));
                        break;
                    case 3:
                        addLines(file, scanner);
                        System.out.println("Líneas añadidas al archivo.");
                        break;
                    case 4:
                        printTable(content);
                        break;
                    case 5:
                        int fieldCount = countFields(content);
                        System.out.println("Número de campos en la cabecera: " + fieldCount);
                        break;
                    case 6:
                        int lineCount = countLines(content);
                        System.out.println("Número de líneas (sin contar la cabecera): " + lineCount);
                        break;
                    case 0:
                        System.out.println("adiooss");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } while (choice != 0);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    public static File createFile(String directoryName, String fileName) throws IOException {
        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }

        File file = new File(directory, fileName);
        if (!file.exists()) {
            file.createNewFile();
        }

        return file;
    }

    public static void readFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        System.out.println("Contenido del archivo:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public static boolean isFileExists(File file) {
        return file.exists() && file.isFile();
    }

    public static ArrayList<String> readFileAsList(String filePath) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    public static void addLines(File file, Scanner scanner) throws IOException {
        System.out.print("Introduce tu nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce tus apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Introduce tu fecha de nacimiento (dd/MM/yyyy): ");
        String fechaNacimiento = scanner.nextLine();

        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            writer.println(nombre + "," + apellidos + "," + fechaNacimiento);
        }

        System.out.print("Introduce tu nombre: ");
        String nombre2 = scanner.nextLine();
        System.out.print("Introduce tus apellidos: ");
        String apellidos2 = scanner.nextLine();
        System.out.print("Introduce tu fecha de nacimiento (dd/MM/yyyy): ");
        String fechaNacimiento2 = scanner.nextLine();
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            writer.println(nombre2 + "," + apellidos2 + "," + fechaNacimiento2);
        }
    }

    public static void printTable(ArrayList<String> content) {
        System.out.println("Contenido en forma de tabla:");
        for (String line : content) {
            String[] fields = line.split(",");
            for (int i = 0; i < fields.length; i++) {
                if (i == fields.length - 1) {
                    System.out.printf("%-15s%n", fields[i]); // Añadir separacion lateral con los demas campos y salto de línea al final
                } else {
                    System.out.printf("%-20s", fields[i]);
                }
            }
        }
    }

    public static int countFields(ArrayList<String> content) {
        if (content.isEmpty()) {
            return 0;
        }
        return content.get(0).split(";").length;
    }

    public static int countLines(ArrayList<String> content) {
        if (content.isEmpty()) {
            return 0;
        } else {
            // Restar 1 para no contar la cabecera
            return content.size() - 1;
        }
    }

}
