<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="top_menu.jsp" %>


<div class="container">

  <div class="row" style="padding-top:70px;">

    <div class="col-md-4 col-md-push-4">
      <div class="alert alert-danger">Contact them and arrange a meeting</div>
      <img class="img-responsive img-circle" src="https://farm1.staticflickr.com/1/2759520_6dea8b9007.jpg" alt="Greece-1173 - Temple of Athena by Dennis Jarvis, on Flickr">
    </div>

    <div class="col-md-4 col-md-pull-4 ">
      <div class="alert alert-info">Find hosts in the city you wanna travel</div>
      <img class="img-responsive img-circle" src="https://farm2.staticflickr.com/1109/809710325_4289dc484e.jpg" alt="Greece-1173 - Temple of Athena by Dennis Jarvis, on Flickr">
    </div>

    <div class="col-md-4">
      <div class="alert alert-success">Have fun with your new friends</div>
      <img class="img-responsive img-circle" src="https://farm3.staticflickr.com/2353/2216602404_679d01cd4b.jpg" alt="Greece-1173 - Temple of Athena by Dennis Jarvis, on Flickr">
    </div>

  </div>

<form action="search" method="GET" class="form-horizontal">

        <fieldset>

            <!-- Form Name -->
            <legend>Search city</legend>

            <!-- Search input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="city"></label>
                <div class="col-md-5">
                    <input id="city" name="city" type="text" placeholder="Enter the city you wanna stay" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for=""></label>
                <div class="col-md-4">
                    <button id="" name="" class="btn btn-primary">Search</button>
                </div>
            </div>

        </fieldset>

</form>

<%@ include file="bottom.jsp" %>