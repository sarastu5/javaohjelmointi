<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dao.Dao" %>
<%@ page import="model.Vene" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="main.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
	<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Veneiden listaus</title>
	</head>
	<body>
		<h2>Veneiden listaus</h2>
		<table class="table table-striped">
		  <thead>
		    <tr>
		    	<th scope="col">Tunnus</th>
		    	<th scope="col">Nimi</th>
		    	<th scope="col">Merkkimalli</th>
		    	<th scope="col">Pituus</th>
		    	<th scope="col">Leveys</th>
		    	<th scope="col">Hinta</th>
		    </tr>
		  </thead>
		  <tbody>
				<%
				Dao dao = new Dao();
				ArrayList<Vene> veneet = dao.listaaKaikki();
				for (int i=0; i<veneet.size(); i++) {
					out.print("<tr>");
					out.print("<td>" + veneet.get(i).getTunnus() + "</td>");
					out.print("<td>" + veneet.get(i).getNimi() + "</td>");
					out.print("<td>" + veneet.get(i).getMerkkimalli() + "</td>");
					out.print("<td>" + veneet.get(i).getPituus() + " m</td>");
					out.print("<td>" + veneet.get(i).getLeveys() + " m</td>");
					out.print("<td>" + veneet.get(i).getHinta() + " e</td>");
					out.print("<td><a href='muutavene.jsp?tunnus=" + veneet.get(i).getTunnus() + "&nimi=" + veneet.get(i).getNimi() + "&merkkimalli=" + veneet.get(i).getMerkkimalli() + "&pituus=" + veneet.get(i).getPituus() + "&leveys=" + veneet.get(i).getLeveys() + "&hinta=" + veneet.get(i).getHinta() + "'>Muuta</a></td>");
					//out.print("<input type='hidden' name='tunnus' value=" + veneet.get(i).getTunnus() + "&nimi=" + veneet.get(i).getNimi() + "&merkkimalli=" + veneet.get(i).getMerkkimalli() + "&pituus=" + veneet.get(i).getPituus() + "&leveys=" + veneet.get(i).getLeveys() + "&hinta=" + veneet.get(i).getHinta() + ">");
					//out.print("<button type='submit' class='btn btn-primary' value='muuta'>Muuta</button></form></td>");
					out.print("<td><form action='PoistaVene' method='post' name='poistaLomake' id='poistaLomake'>");
					out.print("<input type='hidden' name='poista_tunnus' value=" + veneet.get(i).getTunnus() + ">");
					out.print("<button type='submit' class='btn btn-danger' value='poista'>Poista</button></form></td>");
					out.print("</tr>");
				}
				%>
			</tbody>
		</table>
		<a href="lisaavene.jsp"><button type="button" class="btn btn-light">Lis�� uusi vene</button></a>
	</body>
</html>