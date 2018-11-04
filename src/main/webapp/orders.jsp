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
    <title>Zlecenia</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<a href="/main">Przejdź do głównej strony</a>

<h2>Zlecenia</h2>
<table class="table">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">Problem</th>
        <th scope="col">Naprawa</th>
        <th scope="col">Data zgłoszenia</th>
        <th scope="col"></th>
    </tr>
    </thead>
    <c:forEach items="${orders}" var="item">
        <tr>
            <td>${item.orderId}</td>
            <td>${item.problemDescription}</td>
            <td>${item.repairDescription}</td>
            <td>${item.getAddDateString()}</td>
            <td><a href="/order?id=${item.orderId}">link</a></th>
        </tr>
    </c:forEach>

</table>

<h2>Dodaj</h2>
<form method="post" action="">
    <h4>${add_message}</h4>
    <div class="form-group">
        <label for="order_problem">Opis problemu</label>
        <input type="text" class="form-control" id="order_problem" placeholder="Problem" name="order_problem">
        <label for="order_solution">Opis naprawy</label>
        <input type="text" class="form-control" id="order_solution" placeholder="Naprawa" name="order_solution">
        <label for="order_date">Data przyjęcia do naprawy</label>
        <input type="date" class="form-control" id="order_date" name="order_date">
        <label for="order_planned_repair_date">Planowana data rozpoczęcia naprawy</label>
        <input type="date" class="form-control" id="order_planned_repair_date" name="order_planned_repair_date">
        <label for="order_repair_date">Data rozpoczęcia naprawy</label>
        <input type="date" class="form-control" id="order_repair_date" name="order_repair_date">
        <label for="id_employee">Przypisany do naprawy pracownik</label>
        <input type="number" min="1" class="form-control" id="id_employee" placeholder="Id pracownika" name="id_employee">
        <label for="id_status">Status naprawy</label>
        <select id="id_status" name="id_status">
            <c:forEach items="${statuses}" var="item">
                <option value="${item.statusId}">${item.description}</option>
            </c:forEach>
        </select>
        <br>
        <label for="id_vehicle">Pojazd którego dotyczy naprawa</label>
        <input type="number" min="1" class="form-control" id="id_vehicle" placeholder="Id pojazdu" name="id_vehicle">
        <label for="customer_cost">Koszt naprawy dla klienta</label>
        <input type="text" class="form-control" id="customer_cost" placeholder="Koszt klienta" name="customer_cost">
        <label for="components_cost">Koszt wykorzystanych części</label>
        <input type="text" class="form-control" id="components_cost" placeholder="Koszt części" name="components_cost">
        <label for="man_hour_quantity">Ilość roboczogodzin</label>
        <input type="number" min="1" class="form-control" id="man_hour_quantity" placeholder="Ilość roboczogodzin" name="man_hour_quantity">
    </div>
    <input type="submit" name="add_sub" class="btn btn-primary" value="Dodaj"/>
</form>

<h2>Usuń</h2>
<form method="post" action="">
    <h4>${delete_message}</h4>
    <div class="form-group">
        <label for="order_id">Podaj id zlecenia</label>
        <input type="text" class="form-control" id="order_id" placeholder="Id" name="order_id">
    </div>
    <input type="submit" name="delete_sub" class="btn btn-primary" value="Usuń"/>
</form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
