package Ejer1;

public class Persona {

    private String DNI;
    private String nombre;
    private int edad;

    public Persona(String DNI, String nombre, int edad) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.edad = edad;
    }

    // Constructor para crear un objeto Ejer1.Persona a partir de una línea de texto
    public Persona(String linea) {
        String[] partes = linea.split(",");
        this.DNI = partes[0];
        this.nombre = partes[1];
        this.edad = Integer.parseInt(partes[2]);
    }

    @Override
    public String toString() {
        return "DNI: " + DNI + ", Nombre: " + nombre + ", Edad: " + edad;
    }

    // Método para convertir los datos de Ejer1.Persona a una línea de texto para el archivo
    public String toDataString() {
        return DNI + "," + nombre + "," + edad;
    }
}
