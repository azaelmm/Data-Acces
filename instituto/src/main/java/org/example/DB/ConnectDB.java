package org.example.DB;

import java.sql.*;
import java.util.ArrayList;

public class ConnectDB {

    private String port;
    private String user;
    private String password;
    private String jbdc;
    private String db;
    Connection connection;
    ResultSet configs;

    public ConnectDB(String port, String user, String password, String jbdc, String db) {
        this.port = port;
        this.user = user;
        this.password = password;
        this.jbdc = jbdc;
        this.db = db;
    }

    public void initConnectDB(){

        try{

            connection = DriverManager.getConnection(jbdc, user, password);
            System.out.println("DB connection correcta!");

        } catch (SQLException e) {
            System.out.println("Error al realizar la conexion con MySQL: "+e.getMessage());
        }

    }

    public void closeConnection(){

        try{
            connection.close();
            System.out.println("conexion cerrada correctamente!");

        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion con MySQL: "+e.getMessage());
        }

    }

    public void createTable(String query){

        try{

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Tabla creada!");

        }catch (SQLException e){
            System.out.println("error SQL: "+e.getMessage());
        }


    }

    public void executeUpdate(String query) {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(query);
            System.out.println("insercion de datos ejecutados correctamente.");
        } catch (SQLException e) {
            System.out.println("error SQL: "+e.getMessage());
        }
    }

    public void executeQuery (String query) {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeQuery(query);
            System.out.println("Consulta de datos ejecutada correctamente.");
        } catch (SQLException e) {
            System.out.println("error SQL: "+e.getMessage());
        }
    }

    public void mostrarAllStudents() {
        String query = "SELECT * FROM students;";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.printf("%-5s %-15s %-20s %-12s\n", "ID", "Nombre", "Apellidos", "Fecha Nac.");
            System.out.println("-------------------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("ID_alumno");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                Date fechaNac = rs.getDate("fecha_nac");

                System.out.printf("%-5d %-15s %-20s %-12s\n", id, nombre, apellidos, fechaNac.toString());
            }
            System.out.println("Consulta de datos ejecutada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al mostrar alumnos: " + e.getMessage());
        }
    }

    public void contarAlumnosAntes1972(ConnectDB connectDB) {
        String query = "SELECT COUNT(*) AS total FROM students WHERE fecha_nac < '1972-01-01';";
        try (Statement stmt = connectDB.connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                System.out.printf("Número total de alumnos nacidos antes de 1972: %d\n", rs.getInt("total"));
            }
            System.out.println("Consulta de datos ejecutada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al contar alumnos: " + e.getMessage());
        }
    }

    public void mostrarAllProfesores(ConnectDB connectDB) {
        String query = "SELECT * FROM profesor;";
        try (Statement stmt = connectDB.connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.printf("%-5s %-15s %-25s %-12s\n", "ID", "Nombre", "Apellidos", "Fecha Nac.");
            System.out.println("--------------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-5d %-15s %-25s %-12s\n",
                        rs.getInt("ID_teacher"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getDate("fecha_nac"));
            }
            System.out.println("Consulta de datos ejecutada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al mostrar profesores: " + e.getMessage());
        }
    }

    public void mostrarProfesores19001950(ConnectDB connectDB) {
        String query = "SELECT * FROM profesor WHERE fecha_nac BETWEEN '1900-01-01' AND '1950-12-31';";
        try (Statement stmt = connectDB.connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.printf("%-5s %-15s %-25s %-12s\n", "ID", "Nombre", "Apellidos", "Fecha Nac.");
            System.out.println("--------------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-5d %-15s %-25s %-12s\n",
                        rs.getInt("ID_teacher"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getDate("fecha_nac"));
            }
            System.out.println("Consulta de datos ejecutada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al mostrar profesores: " + e.getMessage());
        }
    }

    public void obtenerAsignaturasPorIdProfesor(ConnectDB connectDB, int idProfesor) {
        String query = "SELECT * FROM asignatura WHERE ID_teacher = " + idProfesor + ";";
        try (Statement stmt = connectDB.connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.printf("Asignaturas impartidas por el profesor con ID %d:\n", idProfesor);
            System.out.printf("%-5s %-20s\n", "ID", "Nombre");
            System.out.println("-----------------------------");
            while (rs.next()) {
                System.out.printf("%-5d %-20s\n",
                        rs.getInt("ID_asignatura"),
                        rs.getString("nombre"));
            }
            System.out.println("Consulta de datos ejecutada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al obtener asignaturas: " + e.getMessage());
        }
    }

    public void showListaProfesoresAsignaturas(ConnectDB connectDB) {
        String query = "SELECT p.nombre AS Profesor, p.apellidos AS Apellidos, a.nombre AS Asignatura " +
                "FROM profesor p " +
                "LEFT JOIN asignatura a ON p.ID_teacher = a.ID_teacher;";
        try (Statement stmt = connectDB.connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.printf("%-15s %-25s %-20s\n", "Profesor", "Apellidos", "Asignatura");
            System.out.println("-----------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-15s %-25s %-20s\n",
                        rs.getString("Profesor"),
                        rs.getString("Apellidos"),
                        rs.getString("Asignatura"));
            }
            System.out.println("Consulta de datos ejecutada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al mostrar lista de profesores y asignaturas: " + e.getMessage());
        }
    }

    public void showTablaMatricula(ConnectDB connectDB) {
        String query = "SELECT s.nombre AS Alumno, a.nombre AS Asignatura " +
                "FROM matricula m " +
                "INNER JOIN students s ON m.id_alumno = s.ID_alumno " +
                "INNER JOIN asignatura a ON m.id_asignatura = a.ID_asignatura;";
        try (Statement stmt = connectDB.connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.printf("%-20s %-20s\n", "Alumno", "Asignatura");
            System.out.println("----------------------------------------");
            while (rs.next()) {
                System.out.printf("%-20s %-20s\n",
                        rs.getString("Alumno"),
                        rs.getString("Asignatura"));
            }
            System.out.println("Consulta de datos ejecutada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al mostrar tabla matrícula: " + e.getMessage());
        }
    }

    public void verificarLosUpdate(){
        String query = "SELECT * FROM asignatura;";
        try (Statement stmt =connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.printf("%-5s %-30s %-10s\n", "ID", "Nombre", "ID Profesor");
            System.out.println("----------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-5d %-30s %-10d\n",
                        rs.getInt("ID_asignatura"),
                        rs.getString("nombre"),
                        rs.getInt("ID_teacher"));
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar las asignaturas: " + e.getMessage());
        }
    }

    public ArrayList<String> obtenerAsignaturasPorAlumno(ConnectDB connectDB, int idAlumno) {
        ArrayList<String> asignaturas = new ArrayList<>();
        String query = "SELECT a.nombre " +
                "FROM matricula m " +
                "INNER JOIN asignatura a ON m.id_asignatura = a.ID_asignatura " +
                "WHERE m.id_alumno = " + idAlumno + ";";

        try (Statement stmt = connectDB.connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                asignaturas.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener asignaturas para el alumno con ID " + idAlumno + ": " + e.getMessage());
        }

        return asignaturas;
    }

    public ArrayList<String> obtenerTodasLasAsignaturas(ConnectDB connectDB) {
        ArrayList<String> asignaturas = new ArrayList<>();
        String query = "SELECT nombre FROM asignatura;";

        try (Statement stmt = connectDB.connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                asignaturas.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener todas las asignaturas: " + e.getMessage());
        }

        return asignaturas;
    }

}
