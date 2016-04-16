<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="z-top-menu.jsp" %>

<form class="form-horizontal" action="login" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Signing in</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Login">Login</label>
            <div class="col-md-4">
                <input id="Login" name="Login" type="text" value="tomcat" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Enter your login</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Password">Password</label>
            <div class="col-md-4">
                <input id="Password" name="Password" type="password" value="tomcat" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Enter your password</span>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-success">Enter</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="zz-bottom.jsp" %>
