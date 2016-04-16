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
        <div class="col-md-2">Guest quantity</div>
        <div class="col-md-2">First bed size </div>
        <div class="col-md-2">Second bed size</div>
        <div class="col-md-1">Seaview</div>
        <div class="col-md-1">Floor</div>
        <div class="col-md-1">Price</div>

      </div>
    <c:forEach items="${listRooms}" var="room">
            <div class="row">
            <form class="form-horizontal" action="updateorders" method="get">
                <div class=col-md-1>
                    <input id="room_idRooms_${room.idRooms}" name="idRooms" type="text"
                    value="${room.idRooms}" class="form-control input-md">
                </div>
                <div class=col-md-2>
                    <input id="textinput" name="roomNumber" type="text"
                    value="${room.roomNumber}" class="form-control input-md">
                </div>
                <div class=col-md-2>
                    <input id="textinput" name="guestQuantity" type="text"
                    value="${room.guestQuantity}" class="form-control input-md">
                </div>
                <div class=col-md-2>
                    <input id="textinput" name="fkFirstBedSize" type="text"
                    value="${room.firstBedSize}" class="form-control input-md">
                </div>
                <div class=col-md-2>
                      <input id="textinput" name="SecondBedSize" type="text"
                       value="${room.secondBedSize}" class="form-control input-md">
                </div>
                <div class=col-md-1>
                      <input id="textinput" name="Seaview" type="text"
                      value="${room.seaview}" class="form-control input-md">
                </div>
                 <div class=col-md-1>
                      <input id="textinput" name="Floor" type="text"
                      value="${room.floor}" class="form-control input-md">
                 </div>
                  <div class=col-md-1>
                       <input id="textinput" name="Price" type="text"
                       value="${room.price}" class="form-control input-md">
                  </div>


                <div class=col-md-2>
                    <button id="singlebutton" name="singlebutton" class="btn btn-danger"
                    onclick="document.getElementById('user_id_${user.id}').value=-document.getElementById('user_id_${user.id}').value;"
                    >
                        Cancel reservations
                    </button>
                </div>


            </form>
            </div>
       <br>
       </c:forEach>

<%@ include file="zz-bottom.jsp" %>
