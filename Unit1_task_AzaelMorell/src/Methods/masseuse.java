package Methods;

public class masseuse extends footballSelection{

    private String titulation;
    private int Experience;

    public masseuse(int id, String name, String surname, int age, String titulation, int experience) {
        super(id, name, surname, age);
        this.titulation = titulation;
        Experience = experience;
    }

    public masseuse() {

    }

    public String getTitulation() {
        return titulation;
    }

    public void setTitulation(String titulation) {
        this.titulation = titulation;
    }

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int experience) {
        Experience = experience;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " id: " +getId() + " name: " +getName()+
                " Surnames: "+getSurname()+ " age: "+getAge()+
                " titulation='" + titulation + '\'' +
                ", Experience='" + Experience;
    }

    public void giveMassage(){
        System.out.println("Masseuse giving massage...");
    }

}
