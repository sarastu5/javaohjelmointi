<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="main.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
<title>Veneen tietojen muutos</title>
</head>
<%
int tunnus = 0;
if(request.getParameter("tunnus")!= null){
	tunnus = Integer.parseInt(request.getParameter("tunnus"));
}

String nimi = "";
if(request.getParameter("nimi") != null) {
	nimi = request.getParameter("nimi");
}

String merkkimalli = "";
if(request.getParameter("merkkimalli") != null) {
	merkkimalli = request.getParameter("merkkimalli");
}

String pituus = "";
if(request.getParameter("pituus")!= null) {
	pituus = request.getParameter("pituus");
}

String leveys = "";
if(request.getParameter("leveys")!= null) {
	leveys = request.getParameter("leveys");
}

int hinta = 0;
if(request.getParameter("hinta")!= null) {
	hinta = Integer.parseInt(request.getParameter("hinta"));
}
%>

<body>
	<h2>Veneen tietojen muuttaminen</h2>
	<div class="lomake">
		<form action="MuutaVene" name="muutaLomake" id="muutaLomake" method="post">
			<input type="hidden" name="tunnus" value="<%=tunnus%>">
			
			<div class="form-group row">
			   	<label for="nimi" class="col-sm-2 col-form-label">Nimi:</label>
			   	<div class="col-sm-6">
			    	<input type="text" class="form-control" name="nimi" id=nimi value="<%=nimi%>">
			    </div>
		  	</div>
		  	
		  	<div class="form-group row">
			   	<label for="merkkimalli" class="col-sm-2 col-form-label">Merkkimalli:</label>
			    <div class="col-sm-6">
			      	<input type="text" class="form-control" name="merkkimalli" id="merkkimalli" value="<%=merkkimalli%>">
			    </div>
		  	</div>
		  	
		  	<div class="form-group row">
			   	<label for="pituus" class="col-sm-2 col-form-label">Pituus:</label>
			    <div class="col-sm-6">
			      	<input type="text" class="form-control" name="pituus" id="pituus" value="<%=pituus%>">
			    </div>
		  	</div>
		  	
		  	<div class="form-group row">
			   	<label for="leveys" class="col-sm-2 col-form-label">Leveys:</label>
			    <div class="col-sm-6">
			      	<input type="text" class="form-control" name="leveys" id="leveys" value="<%=leveys%>">
			    </div>
		  	</div>
		  	<div class="form-group row">
			   	<label for="hinta" class="col-sm-2 col-form-label">Hinta:</label>
			    <div class="col-sm-6">
			      	<input type="text" class="form-control" name="hinta" id="hinta" value="<%=hinta%>">
			    </div>
		  	</div>
		  	
		  	<button type="submit" class="btn btn-primary" value="lis��">Muuta veneen tietoja</button>
		  	<a href="listaaveneet.jsp"><button type="button" class="btn btn-light">N�yt� kaikki veneet</button></a>
		</form>
	</div>
	
	<script>
		$(document).ready(function() {
			$("#muutaLomake").validate({
				rules: {
					nimi: {
						required: true,
						minlength: 1,
						maxlength: 20
					},
					merkkimalli: {
						required: true,
						minlength: 1,
						maxlength: 20
					},
					pituus: {
						required: true,
						number: true,
						min: 0
					},
					leveys: {
						required: true,
						number: true,
						min: 0
					},
					hinta: {
						required: true,
						number: true,
						min: 0
					}
				},
				messages: {
					nimi: {
						required: "Kentt� on pakollinen",
						minlength: "Nimen pituus ei riit�",
						maxlength: "Nimi on liian pitk�"
					},
					merkkimalli: {
						required: "Kentt� on pakollinen",
						minlength: "Nimen pituus ei riit�",
						maxlength: "Nimi on liian pitk�"
					},
					pituus: {
						required: "Kentt� on pakollinen",
						number: "Anna luku",
						min: "Anna positiivinen luku"
					},
					leveys: {
						required: "Kentt� on pakollinen",
						number: "Anna luku",
						min: "Anna positiivinen luku"
					},
					hinta: {
						required: "Kentt� on pakollinen",
						number: "Anna luku",
						min: "Anna positiivinen luku"
					}
				},
				submitHandler: function (form) {				
					document.forms["muutaLomake"].submit();
				}		
			});
		});
	</script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</body>
</html>