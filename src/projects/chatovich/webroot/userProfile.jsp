<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="top_menu.jsp" %>


<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>

<div class="heading">
<div class="container">
    <div class="fb-profile">

        <img align="left" class="fb-image-profile thumbnail" src="http://lorempixel.com/180/180/people/9/" alt="Profile image example"/>
        <div class="fb-profile-text">
            <h1>${user.name} ${user.surname}</h1>
            <p>${user.age} years old, ${user.city}</p>
            <p>${user.email}</p>
            <p>${user.describtion}</p>
        </div>
    </div>

    <form action="delete" id="" method="POST" class="form-horizontal">
    <fieldset>


    <div class="form-group">
        <label class="col-md-4 control-label" for="button1id"></label>
        <div class="col-md-8">

        <input id="id" name="id" type="hidden" value="${user.id}" class="form-control input-md"/>

            <button id="button1id" name="button1id" class="btn btn-success">Update</button>
            <button id="" name="" class="btn btn-danger"
                 onclick="document.getElementById('id').value=-document.getElementById('id').value;"
            >
                Delete
            </button>
      </div>
    </div>

    </fieldset>
    </form>

</div>
</div> <!-- /container -->

<%@ include file="bottom.jsp" %>
