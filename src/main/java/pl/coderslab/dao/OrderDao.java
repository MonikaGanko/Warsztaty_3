package pl.coderslab.dao;

import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;
import pl.coderslab.service.DbService;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    public static Order findById(int id) {
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        List<Order> list = prepareOrders("SELECT order_id, problem_description, repair_description, add_date, repair_planned_start_date, repair_start_date, employee_id, status_id, vehicle_id, customer_cost, components_cost, man_hour_quantity FROM orders WHERE order_id=?",params);
        if(list!=null && list.size()>0) {
            return list.get(0);
        }
        return null;
    }

    public static List<Order> findAll() {
        return prepareOrders("SELECT order_id, problem_description, repair_description, add_date, repair_planned_start_date, repair_start_date, employee_id, status_id, vehicle_id, customer_cost, components_cost, man_hour_quantity FROM orders ORDER BY add_date DESC",null);
    }

    public static Integer add(String problem, String solution, String post_date_string, String order_planned_repair_date,
                               String order_repair_date, String id_employee, String status_id, String id_vehicle, String customer_cost,
                               String components_cost, String man_hour_quantity) {
        List<String> params = new ArrayList<>();
        params.add(problem);
        params.add(solution);
        params.add(post_date_string);
        params.add(order_planned_repair_date);
        params.add(order_repair_date);
        params.add(id_employee);
        params.add(status_id);
        params.add(id_vehicle);
        params.add(customer_cost);
        params.add(components_cost);
        params.add(man_hour_quantity);

        String[] generatedColumns = {"order_id"};
        try {
            return DbService.insertIntoDatabase("INSERT INTO orders (problem_description, repair_description, add_date, repair_planned_start_date, repair_start_date, employee_id, status_id, vehicle_id, customer_cost, components_cost, man_hour_quantity) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    params,generatedColumns);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Boolean update(String id, String problem, String solution, String post_date_string, String order_planned_repair_date,
                              String order_repair_date, String id_employee, String status_id, String id_vehicle, String customer_cost,
                              String components_cost, String man_hour_quantity) {
        List<String> params = new ArrayList<>();
        params.add(problem);
        params.add(solution);
        params.add(post_date_string);
        params.add(order_planned_repair_date);
        params.add(order_repair_date);
        params.add(id_employee);
        params.add(status_id);
        params.add(id_vehicle);
        params.add(customer_cost);
        params.add(components_cost);
        params.add(man_hour_quantity);
        params.add(id);

        try {
            DbService.executeUpdate("UPDATE orders SET problem_description = ?, repair_description =?, add_date =?, repair_planned_start_date = ?, repair_start_date = ?, employee_id = ?, status_id = ?, vehicle_id = ?, customer_cost = ?, components_cost = ?, man_hour_quantity =?) WHERE order_id=?",
                    params);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void delete(Order order) {
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(order.getOrderId()));
        try {
            DbService.executeUpdate("DELETE FROM orders WHERE order_id=?",params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static List<Order> prepareOrders(String q, List<String> params){
        List<Order> orders = null;
        try {
            List<String[]> list = DbService.getData(q,params);
            orders = new ArrayList<>();
            for(String[] item: list){
                Order orderItem = new Order();
                orderItem.setOrderId(Integer.parseInt(item[0]));
                orderItem.setProblemDescription(item[1]);
                orderItem.setRepairDescription(item[2]);
                SimpleDateFormat st = new SimpleDateFormat("yyyy-MM-dd");

                if(item[3]!=null){
                    orderItem.setAddDate(st.parse(item[3]));
                }
                if(item[4]!=null){
                    orderItem.setRepairPlannedStartDate(st.parse(item[4]));
                }
                if(item[5]!=null){
                    orderItem.setRepairStartDate(st.parse(item[5]));
                }
                if(item[6]!=null) {
                    orderItem.setEmployee(EmployeeDao.findById(Integer.parseInt(item[6])));
                }

                if(item[7]!=null) {
                    orderItem.setStatus(StatusDao.findById(Integer.parseInt(item[7])));
                }
                if(item[8]!=null) {
                    orderItem.setVehicle(VehicleDao.findById(Integer.parseInt(item[8])));
                }
                if(item[9]!=null) {
                    orderItem.setCustomerCost(Double.parseDouble(item[9]));
                }
                if(item[10]!=null) {
                    orderItem.setComponentsCost(Double.parseDouble(item[10]));
                }
                if(item[11]!=null) {
                    orderItem.setManHourQuantity(Double.parseDouble(item[11]));
                }

                orders.add(orderItem);
            }
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
