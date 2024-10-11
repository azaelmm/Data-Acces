package Methods;

public class player extends footballSelection{


    private int dorsal;
    private String position;

    public player(int id, String name, String surname, int age, int dorsal, String position) {
        super(id, name, surname, age);
        this.dorsal = dorsal;
        this.position = position;
    }

    public player() {

    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " id: " +getId() + " name: " +getName()+
                " Surnames: "+getSurname()+ " age: "+getAge()+ " dorsal=" + dorsal +
                ", position='" + position;
    }

    public void playMatch() {

        System.out.println("player playing match...");
    }

    public void workout(){

        System.out.println("player training...");

    }

}
