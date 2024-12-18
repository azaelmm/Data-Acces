package org.example.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Testing {

    String db = "instituto";
    String port = "3306";
    String jbdc = "jdbc:mysql://localhost:" +port+ "/" +db;
    String dbUser = "root";
    String dbPassword = "root";


    public void test(){

        String query = "";

        ConnectDB connectDB = new ConnectDB(port, dbUser, dbPassword, jbdc, db);

        connectDB.initConnectDB();

        createStudentsTable(connectDB);
        createProfesorTable(connectDB);
        createAsignaturaTable(connectDB);
        createMatriculaTable(connectDB);

        insertarDatosStudents(connectDB);
        insertarDatosProfesor(connectDB);
        insertarDatosAsignatura(connectDB);
        insertarDatosMatricula(connectDB);

        System.out.println("\n*************************************************************************\n");
        connectDB.mostrarAllStudents();
        System.out.println("\n*************************************************************************\n");
        connectDB.contarAlumnosAntes1972(connectDB);
        System.out.println("\n*************************************************************************\n");
        connectDB.mostrarAllProfesores(connectDB);
        System.out.println("\n*************************************************************************\n");
        connectDB.mostrarProfesores19001950(connectDB);
        System.out.println("\n*************************************************************************\n");
        connectDB.showListaProfesoresAsignaturas(connectDB);
        System.out.println("\n*************************************************************************\n");
        connectDB.obtenerAsignaturasPorIdProfesor(connectDB, 1);
        System.out.println("\n*************************************************************************\n");
        connectDB.showTablaMatricula(connectDB);
        System.out.println("\n*************************************************************************\n");


        modificarNombreAsignaturas(connectDB);

        System.out.println("\n*************************************************************************\n");

        ArrayList<String> getAsignaturasPorAlumno = connectDB.obtenerAsignaturasPorAlumno(connectDB, 1);
        ArrayList<String> getTodasLasAsignaturas = connectDB.obtenerTodasLasAsignaturas(connectDB);


        connectDB.closeConnection();

    }

    public static void createStudentsTable(ConnectDB connectDB){
        String query = "CREATE TABLE IF NOT EXISTS students (ID_alumno int PRIMARY KEY auto_increment,\n" +
                "                nombre VARCHAR(30) NOT NULL,\n" +
                "                apellidos VARCHAR(30) NOT NULL,\n" +
                "                fecha_nac DATE NOT NULL);";

        connectDB.createTable(query);
    }

    public static void createProfesorTable(ConnectDB connectDB){
        String query = "CREATE TABLE IF NOT EXISTS profesor (ID_teacher int PRIMARY KEY auto_increment,\n" +
                "                nombre VARCHAR(32) NOT NULL,\n" +
                "                apellidos VARCHAR(100) NOT NULL,\n" +
                "                fecha_nac DATE NOT NULL);";

        connectDB.createTable(query);
    }

    public static void createAsignaturaTable(ConnectDB connectDB){
        String query = "CREATE TABLE IF NOT EXISTS asignatura (ID_asignatura int PRIMARY KEY auto_increment,\n" +
                "                               nombre VARCHAR(32) NOT NULL,\n" +
                "                               ID_teacher INT (5) NOT NULL,\n" +
                "                               FOREIGN KEY id_profesor(ID_teacher) REFERENCES profesor(ID_teacher)\n" +
                "                                );";

        connectDB.createTable(query);
    }

    public static void createMatriculaTable(ConnectDB connectDB){
        String query = "CREATE TABLE IF NOT EXISTS matricula (" +
                "id_alumno INT NOT NULL, " +
                "id_asignatura INT NOT NULL, " +
                "fecha DATE NOT NULL, " +
                "nota INT, " +
                "PRIMARY KEY (id_alumno, id_asignatura, fecha), " +
                "FOREIGN KEY (id_alumno) REFERENCES students(ID_alumno), " +
                "FOREIGN KEY (id_asignatura) REFERENCES asignatura(ID_asignatura)" +
                ");";

        connectDB.createTable(query);
    }

    // Método para insertar dos alumnos en la tabla students
    public static void insertarDatosStudents(ConnectDB connectDB) {
        String query1 = "INSERT INTO students (nombre, apellidos, fecha_nac) VALUES ('Azael', 'Morell', '2005-08-15');";
        String query2 = "INSERT INTO students (nombre, apellidos, fecha_nac) VALUES ('Cesar', 'García', '2005-04-23');";
        String query3 = "INSERT INTO students (nombre, apellidos, fecha_nac) VALUES ('Bilbo', 'Bolson', '1969-09-22');";
        String query4 = "INSERT INTO students (nombre, apellidos, fecha_nac) VALUES ('Papá', 'Noel', '1970-12-25');";
        String query5 = "INSERT INTO students (nombre, apellidos, fecha_nac) VALUES ('Thomas', 'Anderson', '1971-09-13');";
        String query6 = "INSERT INTO students (nombre, apellidos, fecha_nac) VALUES ('Geralt', 'de Rivia', '1968-05-15');";

        connectDB.executeUpdate(query1);
        connectDB.executeUpdate(query2);
        connectDB.executeUpdate(query3);
        connectDB.executeUpdate(query4);
        connectDB.executeUpdate(query5);
        connectDB.executeUpdate(query6);
    }

    // Método para insertar dos profesores en la tabla profesor
    public static void insertarDatosProfesor(ConnectDB connectDB) {
        String query1 = "INSERT INTO profesor (nombre, apellidos, fecha_nac) VALUES ('Luis', 'Martínez', '1987-12-25');";
        String query2 = "INSERT INTO profesor (nombre, apellidos, fecha_nac) VALUES ('María', 'Lopez', '1992-09-04');";
        String query3 = "INSERT INTO profesor (nombre, apellidos, fecha_nac) VALUES ('Gandalf', 'el Blanco', '1909-02-14');";
        String query4 = "INSERT INTO profesor (nombre, apellidos, fecha_nac) VALUES ('Morfeo', 'Neo', '1971-09-13');";
        String query5 = "INSERT INTO profesor (nombre, apellidos, fecha_nac) VALUES ('Yennefer', 'de Vengerberg', '1968-05-15');";

        connectDB.executeUpdate(query1);
        connectDB.executeUpdate(query2);
        connectDB.executeUpdate(query3);
        connectDB.executeUpdate(query4);
        connectDB.executeUpdate(query5);
    }

    // Método para insertar dos asignaturas en la tabla asignatura
    public static void insertarDatosAsignatura(ConnectDB connectDB) {
        String query1 = "INSERT INTO asignatura (nombre, ID_teacher) VALUES ('Acceso a Datos', 1);";
        String query2 = "INSERT INTO asignatura (nombre, ID_teacher) VALUES ('Desarrollo de Interfaces', 2);";
        String query3 = "INSERT INTO asignatura (nombre, ID_teacher) VALUES ('Hobbit', 3);"; // Gandalf
        String query4 = "INSERT INTO asignatura (nombre, ID_teacher) VALUES ('Matrix', 4);"; // Morfeo
        String query5 = "INSERT INTO asignatura (nombre, ID_teacher) VALUES ('The Witcher', 5);"; // Yennefer

        connectDB.executeUpdate(query1);
        connectDB.executeUpdate(query2);
        connectDB.executeUpdate(query3);
        connectDB.executeUpdate(query4);
        connectDB.executeUpdate(query5);
    }

    // Método para insertar dos registros en la tabla matricula
    public static void insertarDatosMatricula(ConnectDB connectDB) {
        String query1 = "INSERT INTO matricula (id_alumno, id_asignatura, fecha, nota) VALUES (1, 1, '2024-12-17', 10);";
        String query2 = "INSERT INTO matricula (id_alumno, id_asignatura, fecha, nota) VALUES (2, 2, '2024-12-17', 10);";

        connectDB.executeUpdate(query1);
        connectDB.executeUpdate(query2);
    }

    public static void modificarNombreAsignaturas(ConnectDB connectDB) {
        String query1 = "UPDATE asignatura SET nombre = 'Cómo encontrar el anillo' WHERE nombre = 'Hobbit';";
        String query2 = "UPDATE asignatura SET nombre = 'En busca de la verdad' WHERE nombre = 'Matrix';";
        String query3 = "UPDATE asignatura SET nombre = 'Brujo' WHERE nombre = 'The Witcher';";

        connectDB.executeUpdate(query1);
        connectDB.executeUpdate(query2);
        connectDB.executeUpdate(query3);

        connectDB.verificarLosUpdate();
    }


}
