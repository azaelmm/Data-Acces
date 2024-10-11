package Methods;

import java.util.Collections;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        
        int cont_class_player = 0;
        int cont_class_coach = 0;
        int cont_class_masseuse = 0;
        
        LinkedList<footballSelection> staff = new LinkedList<footballSelection>();

        staff.add(new player(1, "Daniel", "Gómez Garcia", 24, 22, "striker"));
        staff.add(new player(4, "Luis", "Rioja Martínez", 30, 11, "Defender"));
        staff.add(new player(3, "Joan", "Garcia López", 38, 13, "Goalkeeper"));
        staff.add(new Coach(8, "Ruben", "Baraja Tenes", 47, "e721o"));
        staff.add(new Coach(3, "Marcel", "Morell Canos", 44, "a219d"));
        staff.add(new masseuse(5, "Nicolas", "Rodríguez Mas", 33, "Majista", 4));

        // CASTING 1
        printStaff(staff);
        System.out.println();

        //CASTING 2
        casting_2(staff);
        System.out.println();

        quantityObjects(staff, cont_class_player, cont_class_coach, cont_class_masseuse);
        System.out.println();

        //Lista Ordenada por id, nombre, edad
        Collections.sort(staff);
        printStaff(staff);

    }

    public static void quantityObjects(LinkedList<footballSelection> staff, int cont_class_player, int cont_class_coach, int cont_class_masseuse) {

        for (int i = 0; i < staff.size(); i++) {

            if (staff.get(i) instanceof player){
                cont_class_player++;
            }

            if (staff.get(i) instanceof Coach){
               cont_class_coach++;
            }

            if (staff.get(i) instanceof masseuse){
                cont_class_masseuse++;
            }

        }

        System.out.println("Numero de objetos de tipo player en la lista staff: "+ cont_class_player);
        System.out.println("Numero de objetos de tipo coach en la lista staff: "+ cont_class_coach);
        System.out.println("Numero de objetos de tipo masseuse en la lista staff: "+ cont_class_masseuse);
    }

    public static void casting_2(LinkedList<footballSelection> staff) {
        for (int i = 0; i < staff.size(); i++) {

            if (staff.get(i) instanceof player){
                player p = (player) staff.get(i);
                printObjects(p);
                //Usando los metodos de la clase:
                p.playMatch();
                p.workout();
            }

            if (staff.get(i) instanceof Coach){
                Coach c = (Coach) staff.get(i);
                printObjects(c);
                //Usando los metodos de la clase:
                c.leadMatch();
                c.leadTraining();
            }

            if (staff.get(i) instanceof masseuse){
                masseuse m = (masseuse) staff.get(i);
                printObjects(m);
                //Usando los metodos de la clase:
                m.giveMassage();
            }

        }
    }

    public static void printStaff(LinkedList<footballSelection> staff){
        for (footballSelection f:
             staff) {
            System.out.println(f.toString());
        }
    }

    public static void printObjects(Object object){

        System.out.println(object.toString());

    }
}