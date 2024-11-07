package Models;

import Exceptions.DepartmentNotFound;
import Exceptions.EmployeeNotFound;
import interfaces.ICompany;
import interfaces.IWorkers;

import java.util.ArrayList;

public class company implements ICompany, IWorkers {

    private String name;
    private  String CIF;
    private ArrayList<departments> list_departaments = new ArrayList<departments>();

    public company(String name, String CIF, ArrayList<departments> list_departaments) {
        this.name = name;
        this.CIF = CIF;
        this.list_departaments = list_departaments;
    }

    public company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public ArrayList<departments> getList_departaments() {
        return list_departaments;
    }

    public void setList_departaments(ArrayList<departments> list_departaments) {
        this.list_departaments = list_departaments;
    }

    @Override
    public String toString() {
        return super.toString() +" "+getClass().getSimpleName() +
                "name='" + name + '\'' +
                ", CIF='" + CIF + '\'' +
                ", list_departaments=" + list_departaments +
                '}';
    }

    @Override
    public void employeesDepartment(String department) throws DepartmentNotFound {
        boolean departmentFound = false;

        for (departments d : list_departaments) {
            if (d.getName().equalsIgnoreCase(department)) {
                departmentFound = true;
                System.out.println("Empleados que están en " + department + ":");
                for (employees e : d.getList_employees()) {
                    if (e.getPosition().equalsIgnoreCase(department)){
                        System.out.println(e.getName());
                    }
                }
                System.out.println();
                break;
            }
        }

        if (!departmentFound) {
            throw new DepartmentNotFound("El departamento " + department + " no fue encontrado.");
        }
    }

    @Override
    public void departmentData(String department) throws DepartmentNotFound {
        boolean departmentFound = false;

        for (departments d : list_departaments) {
            if (d.getName().equalsIgnoreCase(department)) {
                departmentFound = true;
                System.out.println(d.toString() + "\n");
                break;
            }
        }

        if (!departmentFound) {
            throw new DepartmentNotFound("El departamento " + department + " no fue encontrado.");
        }
    }

    @Override
    public void employeeData(String NIF) throws EmployeeNotFound {
        boolean employeeFound = false;

        for (departments d : list_departaments) {
            for (employees e : d.getList_employees()) {
                if (e.getNIF().equalsIgnoreCase(NIF)) {
                    employeeFound = true;
                    System.out.println("El empleado con NIF " + NIF + " es: " + e.getName());
                    break;
                }
            }
            if (employeeFound) {
                break;
            }
        }

        if (!employeeFound) {
            throw new EmployeeNotFound("Empleado con NIF " + NIF + " no fue encontrado.");
        }
    }

    @Override
    public void listDepartments() {
        ArrayList<departments> result = new ArrayList<>();
        for (departments departamento : list_departaments) {
            if (departamento.getList_employees().size() > 1) {
                result.add(departamento);
            }
        }

        System.out.println("Departamentos con más de un empleado: ");
        for (departments d : result) {
            System.out.println(d.getName());
            break;
        }
    }

    @Override
    public void getLowerEmployeesDepartment() {
        if (list_departaments.isEmpty()) {
            System.out.println("No hay departamentos disponibles.");
            return;
        }

        ArrayList<departments> result = new ArrayList<>();
        int minEmployees = list_departaments.get(0).getList_employees().size();

        // Encontrar el número mínimo de empleados
        for (departments de : list_departaments) {
            if (de.getList_employees().size() < minEmployees) {
                minEmployees = de.getList_employees().size();
            }
        }

        // Agregar los departamentos con el número mínimo de empleados
        for (departments de : list_departaments) {
            if (de.getList_employees().size() == minEmployees) {
                result.add(de);
            }
        }

        System.out.println("Departamentos con menos empleados (" + minEmployees + " empleados):");
        for (departments dept : result) {
            System.out.println(dept.getName());
            break;
        }
    }
}
