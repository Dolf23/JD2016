<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="z-top-menu.jsp" %>

<form class="form-horizontal" action="newuser" method="post">
    <fieldset>
        <legend>Registration</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Login">Login</label>
            <div class="col-md-4">
                <input id="Login" name="Login" placeholder="enter your login" class="form-control input-md" required="" type="text">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Password">Password</label>
            <div class="col-md-4">
                <input id="Password" name="Password" placeholder="enter your password" class="form-control input-md" required="" type="password">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Name">Name</label>
            <div class="col-md-4">
                <input id="Name" name="Name" placeholder="enter your name" class="form-control input-md" required="" type="text">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Surname">Surname</label>
            <div class="col-md-4">
                <input id="Surname" name="Surname" placeholder="enter your surname" class="form-control input-md" required="" type="text">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Mail">E-mail</label>
            <div class="col-md-4">
                <input id="Mail" name="Mail" placeholder="e-mail" class="form-control input-md" required="" type="text">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Phonenumber">Phonenumber</label>
            <div class="col-md-4">
                <input id="Phonenumber" name="Phonenumber" placeholder="phonenumber" class="form-control input-md" required="" type="text">

            </div>
        </div>

        <!-- Multiple Radios -->
        <div class="form-group">
          <label class="col-md-4 control-label" for="radios">You are</label>
          <div class="col-md-4">
          <div class="radio">
            <label for="radios-0">
              <input name="radios" id="radios-0" value="1"  type="radio">
              Manager
            </label>
        	</div>
          <div class="radio">
            <label for="radios-1">
              <input name="radios" id="radios-1" value="2" checked="checked" type="radio">
              Customer
            </label>
        	</div>
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