<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="top.jsp" %>

<form class="form-horizontal" action="createtour" method="post">
    <fieldset>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinputTypeTour">Type tour</label>
            <div class="col-md-4">
                <input id="textinputTypeTour" name="textinputTypeTour" type="text" placeholder="" class="form-control input-md">
                <span class="help-block">Enter type tour</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinputCountry">Country</label>
            <div class="col-md-4">
                <input id="textinputCountry" name="textinputCountry" type="text" placeholder="" class="form-control input-md">
                <span class="help-block">Enter country</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinputTransport">Transport</label>
            <div class="col-md-4">
                <input id="textinputTransport" name="textinputTransport" type="text" placeholder="" class="form-control input-md">
                <span class="help-block">Enter transport</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinputHotel">Hotel</label>
            <div class="col-md-4">
                <input id="textinputHotel" name="textinputHotel" type="text" placeholder="" class="form-control input-md">
                <span class="help-block">Enter hotel</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinputFoodComplex">Food complex</label>
            <div class="col-md-4">
                <input id="textinputFoodComplex" name="textinputFoodComplex" type="text" placeholder="" class="form-control input-md">
                <span class="help-block">Enter food complex</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinputCost">Cost</label>
            <div class="col-md-4">
                <input id="textinputCost" name="textinputCost" type="text" placeholder="" class="form-control input-md">
                <span class="help-block">Enter cost</span>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebuttonCreateTour"></label>
            <div class="col-md-4">
                <button id="singlebuttonCreateTour" name="singlebuttonCreateTour" class="btn btn-success">Create</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="bottom.jsp" %>