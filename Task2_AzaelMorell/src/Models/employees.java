package Models;

public class employees extends company implements Comparable<employees>{

    private String NIF;
    private String name;
    private String surnames;
    private String position;

    public employees (String NIF, String name, String surnames, String position) {
        this.NIF = NIF;
        this.name = name;
        this.surnames = surnames;
        this.position = position;
    }

    public employees() {
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    @Override
    public String toString() {
        return super.toString() + " "+ getClass().getName() +
                "NIF='" + NIF + '\'' +
                ", name='" + name + '\'' +
                ", surnames='" + surnames + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public int compareTo(employees employee){

        int result = this.getPosition().compareToIgnoreCase(employee.position);
        if (result != 0){
            return result;
        }

        result = this.getSurnames().compareToIgnoreCase(employee.surnames);
        if (result != 0){
            return result;
        }

        return this.NIF.compareToIgnoreCase(employee.NIF);
    }
}
