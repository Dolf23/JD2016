<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="z-top-menu.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <!-- Основное содержимое -->
      <div class="page-header">
        <h1>Cancel reservations</h1>
      </div>

      <h3>Your reservations</h3>


      <div class="row">
        <div class="col-md-2">Order ID</div>
        <div class="col-md-2">Guest quantity</div>
        <div class="col-md-2">Length of stay </div>
        <div class="col-md-2">Room number</div>
      </div>
       <br>
      <c:forEach items="${listOrders}" var="order">
            <div class="row">
            <form class="form-horizontal" action="readorders" method="GET">
                <div class=col-md-2>
                    <input id="order_idOrder_${order.idOrder}" name="idOrder" type="text"
                    value="${order.idOrder}" class="form-control input-md">
                </div>
                <div class=col-md-2>
                    <input id="textinput" name="guestquantity" type="text"
                    value="${order.guestQuantity}" class="form-control input-md">
                </div>
                <div class=col-md-2>
                    <input id="textinput" name="daysQuantity" type="text"
                    value="${order.daysQuantity}" class="form-control input-md">
                </div>
                <div class=col-md-2>
                    <input id="textinput" name="fkReservedRoom" type="text"
                    value="${order.fkReservedRoom}" class="form-control input-md">
                </div>
            </form>
            </div>
       <br>
       </c:forEach>

<%@ include file="zz-bottom.jsp" %>
