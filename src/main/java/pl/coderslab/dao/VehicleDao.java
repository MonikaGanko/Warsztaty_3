package pl.coderslab.dao;

import pl.coderslab.model.Employee;
import pl.coderslab.model.Vehicle;
import pl.coderslab.service.DbService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    public static Vehicle findById(int id){
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        List<Vehicle> list = prepareVehicles("SELECT vehicle_id, customer_id, brand, model, manufactur_year, registration_number, next_servicing FROM vehicles WHERE vehicle_id=?",params);
        if(list!=null && list.size()>0) {
            return list.get(0);
        }
        return null;
    }

    public static List<Vehicle> findAll(){
        return prepareVehicles("SELECT vehicle_id, customer_id, brand, model, manufactur_year, registration_number, next_servicing FROM vehicles",null);
    }

 /*   public static Integer add(String name, String surname){
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
    }*/

   /* public static void delete(Employee employee){
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(employee.getEmployeeId()));
        try {
            DbService.executeUpdate("DELETE FROM employees WHERE employee_id=?",params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    private static List<Vehicle> prepareVehicles(String q, List<String> params){
        List<Vehicle> vehicles = null;
        try {
            List<String[]> list = DbService.getData(q,params);
            vehicles = new ArrayList<>();
            for(String[] item: list){
//                vehicle_id, customer_id, brand, model, manufactur_year, registration_number, next_servicing
                Vehicle vehicleItem = new Vehicle();
                vehicleItem.setVehicleId(Integer.parseInt(item[0]));
//                vehicleItem.setCustomer(item[1]);
                vehicleItem.setBrand(item[2]);
//                TODO
                vehicles.add(vehicleItem);
            }
            return vehicles;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
}
