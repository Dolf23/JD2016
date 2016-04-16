<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="z-top-menu.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!-- Основное содержимое -->
         <div class="page-header">
           <h1>Searching appropriate rooms for you</h1>
         </div>

         <h3>Our comfortable rooms for your</h3>


         <div class="row">
           <div class="col-md-2">Room number</div>
           <div class="col-md-2">Quest quantity</div>
           <div class="col-md-2">First bed size </div>
           <div class="col-md-2">Second bed size</div>
           <div class="col-md-1">Seaview</div>
           <div class="col-md-1">Floor</div>
           <div class="col-md-1">Price</div>

         </div>
   <br>
   <!-- Коллекцию listUser мы получаем по get из сервлета UserForm -->
   <c:forEach items="${listUser}" var="user">
        <div class="row">
        <form class="form-horizontal" action=deleteUser method=POST>
            <div class=col-md-1>
                <input id="user_id_${user.id}" name="ID" type="text"
                value="${user.id}" class="form-control input-md">
            </div>
            <div class=col-md-2>
                <input id="textinput" name="Login" type="text"
                value="${user.login}" class="form-control input-md">
            </div>
            <div class=col-md-2>
                <input id="textinput" name="Password" type="text"
                value="${user.password}" class="form-control input-md">
            </div>
            <div class=col-md-3>
                <input id="textinput" name="Email" type="text"
                value="${user.email}" class="form-control input-md">
            </div>
            <div class=col-md-2>
                <button id="singlebutton" name="singlebutton" class="btn btn-danger"
                onclick="document.getElementById('user_id_${user.id}').value=-document.getElementById('user_id_${user.id}').value;"
                >
                    Удалить пользователя
                </button>
            </div>

            <div class=col-md-2>
                <button id="singlebutton" name="singlebutton" class="btn btn-success">
                    Обновить пользователя
                </button>
            </div>
        </form>
        </div>
   <br>
   </c:forEach>
   и т.д.

<%@ include file="zz-bottom.jsp" %>
