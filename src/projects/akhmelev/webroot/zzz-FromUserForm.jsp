<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="z-top-menu.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--
=========================================================================================
Эта страница использует EL+JSTL - Java Standart Template Library
Чтобы это было возможно необходимо
1. Скачать библиотеку http://central.maven.org/maven2/javax/servlet/jstl/1.2/jstl-1.2.jar
2. Положить ее в папку lib вашего проекта (она потом деплоится в WEB-INF)
3. Объявить применение тегов JSTL указав в заголовке
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
4. После этого становятся доступными конструкции вида
    <с:out value="текст" />
    <с:forEach var="yourItem" items="yourListItems">
          ${yourItem}<br> или ${yourItem.свойство}<br>
    <с:forEach>
(НЕ КОПИРУЙТЕ КОД ВЫШЕ, ТУТ <с:out - русская, а код ниже можно копировать, он рабочий)
=========================================================================================
-->
   <div class="row">
    <b>
        <div class=col-md-1>ID</div>
        <div class=col-md-2>Имя</div>
        <div class=col-md-2>Пароль</div>
        <div class=col-md-7>Email</div>
    </b>
   </div>
   <br>
   <!-- Коллекцию listUser мы получаем по get из сервлета UserForm -->
   <c:forEach items="${listUser}" var="user">
        <div class="row">
        <form class="form-horizontal" action=deleteUser method=POST>
            <div class=col-md-1>
                <input id="user_id_${user.id}" name="ID" type="text"
                value="${user.id}" class="form-control input-md">
            </div>
            <div class=col-md-2>
                <input id="textinput" name="Login" type="text"
                value="${user.login}" class="form-control input-md">
            </div>
            <div class=col-md-2>
                <input id="textinput" name="Password" type="text"
                value="${user.password}" class="form-control input-md">
            </div>
            <div class=col-md-3>
                <input id="textinput" name="Email" type="text"
                value="${user.email}" class="form-control input-md">
            </div>
            <div class=col-md-2>
                <button id="singlebutton" name="singlebutton" class="btn btn-danger"
                onclick="document.getElementById('user_id_${user.id}').value=-document.getElementById('user_id_${user.id}').value;"
                >
                    Удалить пользователя
                </button>
            </div>

            <div class=col-md-2>
                <button id="singlebutton" name="singlebutton" class="btn btn-success">
                    Обновить пользователя
                </button>
            </div>
        </form>
        </div>
   <br>
   </c:forEach>
   и s.д.

<%@ include file="zz-bottom.jsp" %>
