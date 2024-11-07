import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        crearCamposCabecera();
        crearDatosParaCampos();
        list=devolverArraylist();
        imprimirFichero(list);
    }

    private static void imprimirFichero(ArrayList<String> list) {

        for (String s:list) {
            System.out.println(s);
        }
    }

    private static ArrayList<String> devolverArraylist() {

        ArrayList<String> list = new ArrayList<>();
        File f = new File("fichero.csv");
        try (Scanner scanner = new Scanner(f)){
            while (scanner.hasNextLine()){
                String linea = scanner.nextLine();
                list.add(linea);
            }
            scanner.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    private static void crearDatosParaCampos() {

        Scanner scanner = new Scanner(System.in);

        try (FileWriter fw = new FileWriter("fichero.csv", true)){
            System.out.println("ingrese su NIA: ");
            String NIA = scanner.nextLine();
            System.out.println("ingrese su nombre: ");
            String nombre = scanner.nextLine();
            System.out.println("ingrese su dirección: ");
            String address = scanner.nextLine();

            fw.write("\n"+NIA+";"+nombre+";"+address);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static void crearCamposCabecera() {

        try (FileWriter fw = new FileWriter("fichero.csv")){
            fw.write("NIA;Nombre;Dirección");
        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
}