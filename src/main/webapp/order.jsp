<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Monika
  Date: 26/10/2018
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zlecenie #${order.orderId}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<a href="/main">Przejdź do głównej strony</a>

<h2>Zlecenie</h2>
<table class="table">
    <tr>
        <td><b>Id:</b></td>
        <td>${order.orderId}</td>
    </tr>
    <tr>
        <td><b>Data przyjęcia do naprawy:</b></td>
        <td>${order.getAddDateString()}</td>
    </tr>
    <tr>
        <td><b>Planowana data rozpoczęcia naprawy:</b></td>
        <td>${order.getRepairPlannedStartDateString()}</td>
    </tr>
    <tr>
        <td><b>Data rozpoczęcia naprawy:</b></td>
        <td>${order.getRepairStartDateString()}</td>
    </tr>
    <tr>
        <td><b>Przypisany do naprawy pracownik:</b></td>
        <td>${order.employee}</td>
    </tr>
    <tr>
        <td><b>Problem:</b></td>
        <td>${order.problemDescription}</td>
    </tr>
    <tr>
        <td><b>Naprawa:</b></td>
        <td>${order.repairDescription}</td>
    </tr>
    <tr>
        <td><b>Status:</b></td>
        <td>${order.status}</td>
    </tr>
    <tr>
        <td><b>Pojazd:</b></td>
        <td>${order.vehicle}</td>
    </tr>
    <tr>
        <td><b>Koszt naprawy dla klienta:</b></td>
        <td>${order.customerCost}</td>
    </tr>
    <tr>
        <td><b>Koszt wykorzystanych części:</b></td>
        <td>${order.componentsCost}</td>
    </tr>
    <tr>
        <td><b>Koszt roboczogodziny:</b></td>
        <td>${order.employee.manHourCost}</td>
    </tr>
    <tr>
        <td><b>Liczba roboczogodzin:</b></td>
        <td>${order.manHourQuantity}</td>
    </tr>
</table>

<h2>Edycja</h2>
<form method="post" action="">
    <h4>${edit_message}</h4>
    <div class="form-group">
        <label for="order_problem">Opis problemu</label>
        <input type="text" class="form-control" id="order_problem" value="${order.problemDescription}" name="order_problem">
        <label for="order_solution">Opis naprawy</label>
        <input type="text" class="form-control" id="order_solution" value="${order.repairDescription}" name="order_solution">
        <label for="order_date">Data przyjęcia do naprawy</label>
        <input type="date" class="form-control" id="order_date" value="${order.getAddDateString()}" name="order_date">
        <label for="order_planned_repair_date">Planowana data rozpoczęcia naprawy</label>
        <input type="date" class="form-control" id="order_planned_repair_date" value="${order.getRepairPlannedStartDateString()}" name="order_planned_repair_date">
        <label for="order_repair_date">Data rozpoczęcia naprawy</label>
        <input type="date" class="form-control" id="order_repair_date" value="${order.getRepairStartDateString()}" name="order_repair_date">
        <label for="id_employee">Przypisany do naprawy pracownik</label>
        <input type="number" min="1" class="form-control" id="id_employee" value="${order.employee.employeeId}" placeholder="Id pracownika" name="id_employee">
        <label for="id_status">Status naprawy</label>
        <select id="id_status" name="id_status">
            <c:forEach items="${statuses}" var="item">
                <option value="${item.statusId}" <c:if test="${order.status.statusId}==value" > selected="selected" </c:if> ${item.description} </option>
            </c:forEach>
        </select>
        <br>
        <label for="id_vehicle">Pojazd którego dotyczy naprawa</label>
        <input type="number" min="1" class="form-control" id="id_vehicle" value="${order.vehicle.vehicleId}" name="id_vehicle">
        <label for="customer_cost">Koszt naprawy dla klienta</label>
        <input type="text" class="form-control" id="customer_cost" value="${order.customerCost}" name="customer_cost">
        <label for="components_cost">Koszt wykorzystanych części</label>
        <input type="text" class="form-control" id="components_cost" value="${order.componentsCost}" name="components_cost">
        <label for="man_hour_quantity">Ilość roboczogodzin</label>
        <input type="number" min="1" class="form-control" id="man_hour_quantity" value="${order.manHourQuantity}" name="man_hour_quantity">
    </div>
    <input type="submit" name="add_sub" class="btn btn-primary" value="Zatwierdź zmiany"/>
</form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
