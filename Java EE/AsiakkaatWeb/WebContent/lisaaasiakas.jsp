<%@include file="onkokirjauduttu.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="main.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<title>Asiakkaiden lis�ys</title>
</head>
<body>
	<div id="error"></div>
	<div class="lomake">
		<form action="LisaaAsiakas" method="post" name="lisaaLomake" onsubmit="return validateForm()" id="lisaaLomake">
			<div class="form-group row">
		   		<label for="etunimi" class="col-sm-2 col-form-label">Etunimi:</label>
		    	<div class="col-sm-6">
		      		<input type="text" class="form-control" name="etunimi" id="etunimi">
		    	</div>
	  		</div>
	  		<div class="form-group row">
		   		<label for="sukunimi" class="col-sm-2 col-form-label">Sukunimi:</label>
		    	<div class="col-sm-6">
		      		<input type="text" class="form-control" name="sukunimi" id="sukunimi">
		    	</div>
	  		</div>
	  		<div class="form-group row">
		   		<label for="puhelin" class="col-sm-2 col-form-label">Puhelin:</label>
		    	<div class="col-sm-6">
		      		<input type="text" class="form-control" name="puhelin" id="puhelin">
		    	</div>
	  		</div>
	  		<div class="form-group row">
		   		<label for="sposti" class="col-sm-2 col-form-label">S�hk�postiosoite:</label>
		    	<div class="col-sm-6">
		      		<input type="text" class="form-control" name="sposti" id="sposti">
		    	</div>
	  		</div>
	  		<button type="submit" class="btn btn-primary" value="lis��">Lis�� asiakas</button>
	  		<a href="haeasiakkaat.jsp"><button type="button" class="btn btn-light">N�yt� kaikki asiakkaat</button></a>
		</form>
	</div>
	
	
	<script>
		function validateForm() {
			var error = "";
			
			var etunimi = document.forms["lisaaLomake"]["etunimi"].value;
			if (etunimi == "") {
				error = error + "Etunimi on pakollinen<br>";
			}
			
			var sukunimi = document.forms["lisaaLomake"]["sukunimi"].value;
			if (sukunimi == "") {
				error = error + "Sukunimi on pakollinen<br>";
			}
			
			var puhelin = document.forms["lisaaLomake"]["puhelin"].value;
			if (puhelin == "") {
				error = error + "Puhelinnumero on pakollinen<br>";
			}
			
			if (error !== "") {
				$("#error").html(error);
				return false;
			}
		}
	</script>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</body>
</html>