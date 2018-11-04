package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.StatusDao;
import pl.coderslab.model.Order;
import pl.coderslab.model.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "OrderController",urlPatterns = "/order")
public class OrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String order_id = request.getParameter("id");
        String problem = request.getParameter("order_problem");
        String solution = request.getParameter("order_solution");
        String date = request.getParameter("order_date");
        String order_planned_repair_date = request.getParameter("order_planned_repair_date");
        String order_repair_date = request.getParameter("order_repair_date");
        String id_employee = request.getParameter("id_employee");
        String id_status = request.getParameter("id_status");
        String id_vehicle = request.getParameter("id_vehicle");
        String customer_cost = request.getParameter("customer_cost");
        String components_cost = request.getParameter("components_cost");
        String man_hour_quantity = request.getParameter("man_hour_quantity");

        if(order_id!= null && !order_id.isEmpty() && problem!=null && !problem.isEmpty() && solution!=null && !solution.isEmpty() && date!=null && !date.isEmpty() &&
                order_planned_repair_date!=null && !order_planned_repair_date.isEmpty() && order_repair_date!=null && !order_repair_date.isEmpty() && id_employee!=null && !id_employee.isEmpty()&&
                id_status!=null && !id_status.isEmpty() && id_vehicle!=null && !id_vehicle.isEmpty() && customer_cost!=null && !customer_cost.isEmpty() &&
                components_cost!=null && !components_cost.isEmpty() && man_hour_quantity!=null && !man_hour_quantity.isEmpty()) {
            try {
                SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
                sdf.parse(date);
                sdf.parse(order_planned_repair_date);
                sdf.parse(order_repair_date);
                Boolean update_ok = OrderDao.update(order_id, problem, solution, date, order_planned_repair_date, order_repair_date, id_employee, id_status, id_vehicle, customer_cost, components_cost, man_hour_quantity);
                if(update_ok) {
                    request.setAttribute("edit_message", "Zlecenie dodane.");
                } else {
                    request.setAttribute("edit_message", "Coś poszło nie tak.");
                }
            } catch (ParseException e) {
                request.setAttribute("edit_message", "Wpisz poprawny format daty (yyyy-mm-dd).");
            }
        } else {
            request.setAttribute("edit_message", "Żadne pole nie może być puste.");
        }
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer order_id = Integer.parseInt(request.getParameter("id"));
        Order order = OrderDao.findById(order_id);
        request.setAttribute("order",order);
        List<Status> statuses = StatusDao.findAll();
        request.setAttribute("statuses", statuses);
        request.getRequestDispatcher("/order.jsp").forward(request,response);
    }
}
