package pl.coderslab.dao;

import pl.coderslab.model.Employee;
import pl.coderslab.service.DbService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    public static Employee findById(int id){
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        List<Employee> list = prepareEmployees("SELECT employee_id, name, surname FROM employees WHERE employee_id=?",params);
        if(list!=null && list.size()>0) {
            return list.get(0);
        }
        return null;
    }

    public static List<Employee> findAll(){
        return prepareEmployees("SELECT employee_id, name, surname FROM employees",null);
    }

    public static Integer add(String name, String surname){
        List<String> params = new ArrayList<>();
        params.add(name);
        params.add(surname);
        String[] generatedColumns = {"employee_id"};
        try {
            return DbService.insertIntoDatabase("INSERT INTO employees (name, surname) values (?, ?)",
                    params,generatedColumns);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void delete(Employee employee){
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(employee.getEmployeeId()));
        try {
            DbService.executeUpdate("DELETE FROM employees WHERE employee_id=?",params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static List<Employee> prepareEmployees(String q, List<String> params){
        List<Employee> employees = null;
        try {
            List<String[]> list = DbService.getData(q,params);
            employees = new ArrayList<>();
            for(String[] item: list){
                Employee employeeItem = new Employee();
                employeeItem.setEmployeeId(Integer.parseInt(item[0]));
                employeeItem.setName(item[1]);
                employeeItem.setSurname(item[2]);
                employees.add(employeeItem);
            }
            return employees;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
