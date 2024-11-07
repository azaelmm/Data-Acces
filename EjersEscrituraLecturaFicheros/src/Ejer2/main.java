package Ejer2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nSelecciona una opción:");
            System.out.println("1. Guardar texto en info.dat");
            System.out.println("2. Leer texto desde info.dat y mostrar");
            System.out.println("3. Imprimir texto leído desde info.dat");
            System.out.println("4. Guardar productos en productos.dat");
            System.out.println("5. Leer productos desde productos.dat y mostrar");
            System.out.println("6. Guardar productos en productos.csv");
            System.out.println("7. Leer productos desde productos.csv y mostrar");
            System.out.println("8. Llamar a los tres métodos de la primera parte");
            System.out.println("9. Salir");
            System.out.print("Opción: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número.");
                scanner.next();
                continue;
            }

            int opcion = scanner.nextInt();
            ArrayList<String> palabras = new ArrayList<>(); // Inicialización de palabras fuera del switch

            switch (opcion) {
                case 1:
                    guardarTexto();
                    break;
                case 2:
                    palabras = leerTexto();
                    break;
                case 3:
                    imprimirArrayList(palabras);
                    break;
                case 4:
                    guardarProductos();
                    break;
                case 5:
                    leerProductos();
                    break;
                case 6:
                    guardarProductosCSV();
                    break;
                case 7:
                    leerProductosCSV();
                    break;
                case 8:
                    ejecutarMetodosPrimeraParte();
                    break;
                case 9:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
        scanner.close();
    }

    // Método que llama a los tres métodos de la primera parte
    public static void ejecutarMetodosPrimeraParte() {
        guardarTexto();
        ArrayList<String> palabras = leerTexto();
        imprimirArrayList(palabras);
    }

    // Parte 1a: Método para guardar en info.dat las palabras "Say My Name" usando writeUTF
    public static void guardarTexto() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("info.dat"))) {
            dos.writeUTF("Say");
            dos.writeUTF("My");
            dos.writeUTF("Name");
        } catch (IOException e) {
            System.err.println("Error al guardar texto: " + e.getMessage());
        }
    }

    // Parte 1b: Método para leer el texto del archivo info.dat y devolverlo en un ArrayList<String>
    public static ArrayList<String> leerTexto() {
        ArrayList<String> palabras = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream("info.dat"))) {
            while (true) {
                palabras.add(dis.readUTF());
            }
        } catch (EOFException e) {
            System.out.println("Texto leído de info.dat.");
        } catch (IOException e) {
            System.err.println("Error al leer texto: " + e.getMessage());
        }
        return palabras;
    }

    // Parte 1c: Método que recibe un ArrayList<String> y muestra su contenido por pantalla
    public static void imprimirArrayList(ArrayList<String> palabras) {
        System.out.println("Contenido del ArrayList:");
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
    }

    // Parte 2a: Método para guardar en productos.dat un arreglo de precios, unidades y descripciones
    public static void guardarProductos() {
        double[] precios = {1350, 400, 890, 6200, 8730};
        int[] unidades = {5, 7, 12, 8, 30};
        String[] descripciones = {"paquetes de papel", "lápices", "bolígrafos", "carteras", "mesas"};

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("productos.dat"))) {
            for (int i = 0; i < precios.length; i++) {
                dos.writeDouble(precios[i]);
                dos.writeInt(unidades[i]);
                dos.writeUTF(descripciones[i]);
            }
        } catch (IOException e) {
            System.err.println("Error al guardar productos: " + e.getMessage());
        }
    }

    // Parte 2b: Método que lee del fichero productos.dat la información y la muestra por pantalla
    public static void leerProductos() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("productos.dat"))) {
            System.out.println("Productos almacenados:");
            while (true) {
                double precio = dis.readDouble();
                int unidad = dis.readInt();
                String descripcion = dis.readUTF();
                System.out.println("Descripción: " + descripcion + ", Precio: " + precio + ", Unidades: " + unidad);
            }
        } catch (EOFException e) {
            System.out.println("Fin de productos en productos.dat.");
        } catch (IOException e) {
            System.err.println("Error al leer productos: " + e.getMessage());
        }
    }

    // Parte 2c: Método que guarda la cabecera en productos.csv
    public static void guardarCabeceraCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("productos.csv", false))) {
            bw.write("ID;DESCRIPCION;PRECIO;UNIDAD");
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar cabecera en productos.csv: " + e.getMessage());
        }
    }

    // Parte 2d: Método que guarda los datos de productos en productos.csv
    public static void guardarProductosCSV() {
        int[] idProducto = {1, 2, 3, 4, 5};
        String[] descripciones = {"paquetes de papel", "lápices", "bolígrafos", "carteras", "mesas"};
        double[] precios = {1350, 400, 890, 6200, 8730};
        int[] unidades = {5, 7, 12, 8, 30};

        // Guardamos la cabecera
        guardarCabeceraCSV();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("productos.csv", true))) {
            for (int i = 0; i < idProducto.length; i++) {
                bw.write(idProducto[i] + ";" + descripciones[i] + ";" + precios[i] + ";" + unidades[i] + ";");
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar productos en productos.csv: " + e.getMessage());
        }
    }

    // Parte 2e: Método que lee del fichero productos.csv la información y la muestra por pantalla
    public static void leerProductosCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader("productos.csv"))) {
            String linea;
            System.out.println("Contenido de productos.csv:");
            while ((linea = br.readLine()) != null) {
                System.out.printf("%s%n", linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer productos.csv: " + e.getMessage());
        }
    }
}
