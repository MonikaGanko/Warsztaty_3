package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeesController",urlPatterns = "/employees")
public class EmployeesController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("add_sub")!=null){
            processAdd(request);
        }else if (request.getParameter("delete_sub")!=null){
            processDelete(request);
        }
        doGet(request,response);
    }

    private void processAdd(HttpServletRequest request) {
        String name = request.getParameter("empl_name");
        String surname = request.getParameter("empl_surname");
        if(name!=null && !name.isEmpty() && surname!=null && !surname.isEmpty()) {
            Integer empl_id = EmployeeDao.add(name, surname);
            if(empl_id!=null) {
                request.setAttribute("add_message", "Pracownik dodany.");
            } else {
                request.setAttribute("add_message", "Coś poszło nie tak.");
            }
        } else {
            request.setAttribute("add_message", "Imię i nazwisko nie mogą być puste.");
        }
    }

    private void processDelete(HttpServletRequest request) {
        String empl_id = request.getParameter("employee_id");
        if(empl_id!=null && !empl_id.isEmpty()) {
            try {
                int id = Integer.parseInt(empl_id);
                Employee employee = EmployeeDao.findById(id);
                if (employee != null) {
                    EmployeeDao.delete(employee);
                } else {
                    request.setAttribute("delete_message", "Nie istnieje pracownik o takim id.");
                }
            } catch (NumberFormatException e) {
                request.setAttribute("delete_message", "Id musi być liczbą.");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = EmployeeDao.findAll();
        request.setAttribute("employees",employees);
        request.getRequestDispatcher("/employees.jsp").forward(request,response);
    }
}

