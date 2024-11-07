package interfaces;

import Exceptions.DepartmentNotFound;
import Models.departments;

import java.util.ArrayList;

public interface ICompany {

    public void employeesDepartment (String department) throws DepartmentNotFound;

    public void departmentData(String department) throws DepartmentNotFound;
}
