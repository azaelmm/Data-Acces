package Models;

import java.util.ArrayList;

public class departments extends company{


    private String name;
    private int tamanyo;
    private ArrayList<employees> list_employees = new ArrayList<employees>();

    public departments(String name, int tamanyo, ArrayList<employees> list_employees) {
        this.name = name;
        this.tamanyo = tamanyo;
        this.list_employees = list_employees;
    }

    public departments() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(int tamanyo) {
        this.tamanyo = tamanyo;
    }

    public ArrayList<employees> getList_employees() {
        return list_employees;
    }

    public void setList_employees(ArrayList<employees> list_employees) {
        this.list_employees = list_employees;
    }

    @Override
    public String toString() {
        return super.toString() + " " + getClass().getName() +
                " name='" + name + '\'' +
                ", tamaño=" + tamanyo +
                ", list_employees=" + list_employees +
                '}';
    }
}
