<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="top.jsp" %>

<form class="form-horizontal" action="select" method="post">
    <fieldset>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasicTypeTour">Type tour</label>
            <div class="col-md-4">
                <select id="selectbasicTypeTour" name="selectbasicTypeTour" class="form-control">
                    <option value="1">Option one</option>
                    <option value="2">Option two</option>
                    <option value="3">Option three</option>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasicCountry">Country</label>
            <div class="col-md-4">
                <select id="selectbasicCountry" name="selectbasicCountry" class="form-control">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasicTransport">Transport</label>
            <div class="col-md-4">
                <select id="selectbasicTransport" name="selectbasicTransport" class="form-control">
                    <option value="1">Option one</option>
                    <option value="2">Option two</option>
                    <option value="3">Option three</option>
                    <option value="4">Option four</option>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasicHotel">Hotel</label>
            <div class="col-md-4">
                <select id="selectbasicHotel" name="selectbasicHotel" class="form-control">
                    <option value="1">3</option>
                    <option value="2">3+</option>
                    <option value="3">4</option>
                    <option value="4">4+</option>
                    <option value="5">5</option>
                    <option value="6">5+</option>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasicFoodComplex">Food complex</label>
            <div class="col-md-4">
                <select id="selectbasicFoodComplex" name="selectbasicFoodComplex" class="form-control">
                    <option value="1">Option one</option>
                    <option value="2">Option two</option>
                </select>
            </div>
        </div>

        <!-- Button (Double) -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="buttonSelect"></label>
            <div class="col-md-8">
                <button id="buttonSelect" name="buttonSelect" class="btn btn-info">Good Button</button>
                <button id="button" name="button" class="btn btn-success">Discount</button>
                <button id="buttonCreateTour" name="buttonCreateTour" class="btn btn-warning">Create tour</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="bottom.jsp" %>