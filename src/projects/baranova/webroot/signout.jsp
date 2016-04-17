<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="z-top-menu.jsp" %>

<form class="form-horizontal" action="logout" method="get">
    <fieldset>

        <!-- Form Name -->
        <legend>you are successfully logged out!</legend>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-success">Logout</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="zz-bottom.jsp" %>
