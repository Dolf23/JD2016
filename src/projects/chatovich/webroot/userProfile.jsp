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
</div>
</div> <!-- /container -->

<%@ include file="bottom.jsp" %>
