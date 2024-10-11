package Methods;

public class Coach extends footballSelection{

    private String idFederation;

    public Coach(int id, String name, String surname, int age, String idFederation) {
        super(id, name, surname, age);
        this.idFederation = idFederation;
    }

    public Coach() {



    }

    public String getIdFederation() {
        return idFederation;
    }

    public void setIdFederation(String idFederation) {
        this.idFederation = idFederation;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " id: " +getId() + " name: " +getName()+
                " Surnames: "+getSurname()+ " age: "+getAge()+
                " idFederation='" + idFederation;
    }

    public void leadMatch (){

        System.out.println("coach leading match...");

    }

    public void leadTraining(){

        System.out.println("coach leading workout...");

    }

}
