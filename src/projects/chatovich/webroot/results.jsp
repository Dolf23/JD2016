<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="top_menu.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="heading">
<div class="containerRes">

    <hgroup class="mb20">
		<h1>Search Results</h1>

		<c:if test="${anyUser}">
            <h2 class="lead"><strong class="text-danger">${usersQuantity}</strong> hosts were found in <strong class="text-danger">${city}</strong></h2>
        </c:if>

        <c:if test="${!anyUser}">
            <h1>We could not find any host in ${city}</h1>
        </c:if>
	</hgroup>


    <section class="col-xs-12 col-sm-6 col-md-12">

    <c:forEach var="user" items="${users}" >
            <article class="search-result row">

            <form action="userProfile" id="profile_${user.id}" method="POST">
            			<div class="col-xs-12 col-sm-12 col-md-4">
            				<img src="http://lorempixel.com/250/140/people" alt="Lorem ipsum" />
            			</div>

            			<div class="col-xs-12 col-sm-12 col-md-6 excerpet">

                        <input type="hidden" name="id_user" value="${user.id}" position:/>

            		    <h3><a href="" onclick="document.getElementById('profile_${user.id}').submit(); return false" title="">
            		        ${user.name} ${user.surname}, ${user.age} years old
            		       </a>
            		    </h3>

            			</div>
            			<span class="clearfix borda"></span>
            			    </form>
            </article>
    </c:forEach>




	</section>
</div>
</div>


<%@ include file="bottom.jsp" %>