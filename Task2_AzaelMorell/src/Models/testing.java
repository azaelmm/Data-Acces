package Models;

import Exceptions.DepartmentNotFound;
import Exceptions.EmployeeNotFound;

import java.util.ArrayList;

public class testing {

    ArrayList<departments> list_departments = new ArrayList<departments>();
    ArrayList<employees> list_employees = new ArrayList<employees>();

    public void testing (){

        employees e1 = new employees("24434433D", "Manolo", "López Garcia", "Admin");
        employees e2 = new employees("51125412W", "Claudia", "Morell Ballester", "Admin");

        employees e3 = new employees("12345678A", "Juan", "Pérez Rodriguez", "Gerente");
        employees e4 = new employees("51254124L", "David", "Marín Pellicer", "Gerente");

        employees e5 = new employees("87158412P", "Blanca", "Tarín López", "Analista");
        employees e6 = new employees("82264255F", "Azael", "Morell Martínez", "Analista");


        list_employees.add(e1);
        list_employees.add(e2);
        list_employees.add(e3);
        list_employees.add(e4);
        list_employees.add(e5);
        list_employees.add(e6);

        departments d1 = new departments("Admin", 2, list_employees);
        departments d2 = new departments("Admin", 2, list_employees);
        departments d3 = new departments("Admin", 2, list_employees);

        list_departments.add(d1);
        list_departments.add(d2);
        list_departments.add(d3);

        company c1 = new company("SPB", "S0794867B", list_departments);

        try {
            c1.employeesDepartment("Admin");
        }catch (DepartmentNotFound e){
            System.out.println(e.getMessage());
        }

        try {
            c1.departmentData("Admin");
            System.out.println();
        }catch (DepartmentNotFound e){
            System.out.println(e.getMessage());
        }

        try {
            c1.employeeData("24434433D");
            System.out.println();
        }catch (EmployeeNotFound e){
            System.out.println(e.getMessage());
        }


        c1.listDepartments();
        System.out.println();
        c1.getLowerEmployeesDepartment();
    }

}
