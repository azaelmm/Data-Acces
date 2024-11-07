package interfaces;

import Exceptions.EmployeeNotFound;

import java.util.ArrayList;

public interface IWorkers {

    public void employeeData(String NIF) throws EmployeeNotFound;

    public void listDepartments();

    public void getLowerEmployeesDepartment ();

}
