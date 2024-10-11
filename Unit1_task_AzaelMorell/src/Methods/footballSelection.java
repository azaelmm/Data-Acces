package Methods;

public class footballSelection implements Comparable<footballSelection>{

    private int id;
    private String name;
    private String surname;
    private int age;

    public footballSelection(int id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public footballSelection() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age ;
    }

    public void concentrate (){


    }

    public void travel (){


    }

    @Override
    public int compareTo(footballSelection f) {
        int r = Integer.compare(this.id, f.id);
        if (r != 0){
            return r;
        }

        r = this.getName().compareTo(f.getName());
        if (r != 0){
            return r;
        }

        return Integer.compare(this.age, f.age);
    }
}
