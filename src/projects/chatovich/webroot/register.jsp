<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="top_menu.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>"

<form name = "register" action="register" method="POST" class="form-horizontal" onSubmit="return validate(this)">

<div class = "container">
        <div class="wrapper">
            <form action="" method="post" name="Login_Form" class="form-signin">
<c:if test="${loginExists}">
                                <h3 class="form-signin-heading1">There is already a user with these login and password<br>Please try again</h3>
                            </c:if>
                <h3 class="form-signin-heading">Fill the registration form</h3>
                <hr class="colorgraph"><br>




                <input type="text" class="form-control" name="name" placeholder="First name" required="" autofocus="" />
                <input type="text" class="form-control" name="surname" placeholder="Last name" required=""/>
                <input type="text" class="form-control" name="login" placeholder="Login" required=""/>
                <input type="password" class="form-control" name="password" placeholder="Password" required=""/>
                <input type="date" class="form-control" name="birthdate" placeholder="Birthdate" required=""/>
                <input type="text" class="form-control" name="city" placeholder="City" required=""/>
                <input type="email" class="form-control" name="email" placeholder="Email" required=""/>
                <input type="text" class="form-control" name="describtion" placeholder="Describe yourself and the place where you live"/>
                <input type="hidden" class="form-control" name="id" value="0"/>

                <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Register" type="Submit">Register</button>
            </form>
        </div>
</div>

</form>

<%@ include file="bottom.jsp" %>