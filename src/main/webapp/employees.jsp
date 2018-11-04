<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 26/10/2018
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pracownicy</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<a href="/main">Przejdź do głównej strony</a>

<h2>Pracownicy</h2>
<table class="table">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">Imię</th>
        <th scope="col">Nazwisko</th>
    </tr>
    </thead>
    <c:forEach items="${employees}" var="item">
        <tr>
            <td>${item.employeeId}</td>
            <td>${item.name}</td>
            <td>${item.surname}</td>
        </tr>
    </c:forEach>

</table>

<h2>Dodaj</h2>
<form method="post" action="">
    <h4>${add_message}</h4>
    <div class="form-group">
        <label for="empl_name">Podaj imię pracownika</label>
        <input type="text" class="form-control" id="empl_name" placeholder="Imię" name="empl_name">
        <label for="empl_surname">Podaj nazwisko pracownika</label>
        <input type="text" class="form-control" id="empl_surname" placeholder="Nazwisko" name="empl_surname">
    </div>
    <input type="submit" name="add_sub" class="btn btn-primary" value="Dodaj"/>
</form>

<h2>Usuń</h2>
<form method="post" action="">
    <h4>${delete_message}</h4>
    <div class="form-group">
        <label for="empl_id">Podaj id pracownika</label>
        <input type="text" class="form-control" id="empl_id" placeholder="Id" name="employee_id">
    </div>
    <input type="submit" name="delete_sub" class="btn btn-primary" value="Usuń"/>
</form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
