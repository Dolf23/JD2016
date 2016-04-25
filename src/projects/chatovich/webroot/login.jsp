<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="top_menu.jsp" %>

<form action="login" method="POST" class="form-horizontal">

    <div class = "container">
        <div class="wrapper">
            <form action="" method="post" name="Login_Form" class="form-signin">
                <h3 class="form-signin-heading">Welcome Back! Please Sign In</h3>
                <hr class="colorgraph"><br>


                <input type="text" class="form-control" name="login" placeholder="Login" required="" autofocus="" />
                <input type="password" class="form-control" name="password" placeholder="Password" required=""/>

                <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">Login</button>
            </form>
        </div>
    </div>

</form>


<%@ include file="bottom.jsp" %>