<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />

    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Старт обработки форм для сервлетов</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/bootsnip-grey-menu.css" rel="stylesheet" />
    <link href="css/bootsnipp-login.css" rel="stylesheet" />
    <link href="css/bootsnipp-profile.css" rel="stylesheet" />
    <link href="css/bootsnipp-results.css" rel="stylesheet" />
    <link href="js/bootsnipp-add-feedback.js" rel="stylesheet" />
    <link href="css/bootsnipp-add-feedback.css" rel="stylesheet" />
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootsnipp-add-feedback.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0-beta1/jquery.js"></script>

    <script type="text/javascript">
          function sub(form,addr){

              var form1 = form
              form.action = addr
              form.submit()
            }

        </script>

</head>


<body>



<div class="navbar-wrapper">
    <div class="container-fluid">
        <nav class="navbar navbar-fixed-top">
            <div class="container">
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="index.jsp" class="menu">Home</a></li>

                <c:choose>
                    <c:when test="${sessionScope.auth}">
                            <li><a href="logout.jsp" class="menu">Log out</a></li>

                    </c:when>

                    <c:otherwise>
                        <li><a href="login.jsp" class="menu">Log in</a></li>
                    </c:otherwise>
                </c:choose>

                <c:if test="${!sessionScope.auth}">
                    <li><a href="register.jsp" class="menu">Register</a></li>
                </c:if>

                    <li><a href="search.jsp" class="menu">Search</a></li>
                    <li><a href="userProfile.jsp" class="menu">My Profile</a></li>
                </ul>
            </div>
            </div>
        </nav>
    </div>
</div>