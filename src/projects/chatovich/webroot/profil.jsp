<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="top_menu.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>

<div class="heading">
<div class="container">
    <div class="fb-profile">

        <img align="left" class="fb-image-profile thumbnail" src="http://lorempixel.com/180/180/people/9/" alt="Profile image example"/>
        <div class="fb-profile-text">
            <c:forEach var="user" items="${users}">
                 <h1>${user.name} ${user.surname}</h1>
                     <p>${user.age} years old, ${city}</p>
                     <p>${user.email}</p>
                     <p>${user.describtion}</p>

    <c:forEach var="feedback" items="${feedbacks}">
        <c:forEach var="allUser" items="${allUsers}">
            <c:if test="${feedback.feedback_from==allUser.id}">
                <p><b>${allUser.name} ${allUser.surname} wrote about ${user.name}: </b>${feedback.feedback_text}</p>
            </c:if>
        </c:forEach>
    </c:forEach>


<form name = "addFeedback" action="addFeedback" method="POST" class="form-horizontal">
     <div class="container">
         <div>
             <br style="clear:both">
                 <div class="form-group col-md-4 ">
                     <label id="messageLabel" for="message">Write your feedback about ${user.name} </label>
                     <textarea class="form-control input-sm " type="textarea" id="message" name="message" maxlength="140" rows="7"></textarea>
                         <span class="help-block"><p id="characterLeft" class="help-block ">You have reached the limit</p></span>
                 </div>
             <br style="clear:both">
             <div class="form-group col-md-2">
             <input id="id" name="idFBreceiver" type="hidden" value="${user.id}" class="form-control input-md"/>
             <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Register" type="Submit">Send</button>
         </div>
     </div>
</form>



         </c:forEach>

            </div>
        </div>

            </div>
            </div> <!-- /container -->

            <%@ include file="bottom.jsp" %>