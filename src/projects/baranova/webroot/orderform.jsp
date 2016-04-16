<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="z-top-menu.jsp" %>
<form class="form-horizontal" action="neworder" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Make a reservation (order information)</legend>
             <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="guestQuantity">Guest quantity</label>
                            <div class="col-md-4">
                                <input id="guestQuantity" name="guestQuantity" placeholder="" class="form-control input-md" required="" type="text">

                            </div>
                        </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="daysQuantity">Days quantity</label>
                <div class="col-md-4">
                    <input id="daysQuantity" name="daysQuantity" placeholder="" class="form-control input-md" required="" type="text">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Confirm"></label>
                <div class="col-md-4">
                    <button id="Confirm" name="Confirm" class="btn btn-primary">Confirm</button>
                </div>
            </div>

        </fieldset>
    </form>
<%@include file="zz-bottom.jsp" %>