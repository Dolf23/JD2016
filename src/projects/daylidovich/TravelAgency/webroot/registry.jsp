<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="top.jsp" %>

<form class="form-horizontal" action="registry" method="post">
    <fieldset>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="name">Name</label>
            <div class="col-md-4">
                <input id="name" name="name" type="text" placeholder="" class="form-control input-md">
                <span class="help-block">Enter name</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="surname">Surname</label>
            <div class="col-md-4">
                <input id="surname" name="surname" type="text" placeholder="" class="form-control input-md">
                <span class="help-block">Enter surname</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="email">E-mail</label>
            <div class="col-md-4">
                <input id="email" name="email" type="text" placeholder="" class="form-control input-md">
                <span class="help-block">Enter e-mail</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="login">Login</label>
            <div class="col-md-4">
                <input id="login" name="login" type="text" placeholder="" class="form-control input-md">
                <span class="help-block">Enter login</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Password</label>
            <div class="col-md-4">
                <input id="password" name="password" type="password" placeholder="" class="form-control input-md">
                <span class="help-block">Enter password</span>
            </div>
        </div>

        <!-- Multiple Checkboxes -->
        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <div class="checkbox">
                    <label for="checkboxTravelagent-0">
                        <input type="checkbox" name="checkboxTravelagent" id="checkboxTravelagent-0" value="1">
                        Travel agent
                    </label>
                </div>
            </div>
        </div>


        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="buttonRegistry"></label>
            <div class="col-md-4">
                <button id="buttonRegistry" name="buttonRegistry" class="btn btn-success">Registry</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="bottom.jsp" %>