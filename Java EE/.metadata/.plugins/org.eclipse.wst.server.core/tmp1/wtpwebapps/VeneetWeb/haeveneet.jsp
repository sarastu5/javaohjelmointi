<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dao.Dao"%>
<%@ page import="model.Vene"%>
<%@ page import="java.util.ArrayList"%>
<%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="main.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
	
	<title>Veneiden haku</title>
	</head>
	<body>
	<%
		if (request.getParameter("ilmo")!=null) {
			out.print(request.getParameter("ilmo"));
		}
	%>
	<br><br>
	<table class="table table-striped">						
		<div class="container-fluid">
			<form action="HaeVeneet" method="post">
				Hakusana:
				<input type="text" name="hakusana" id="hakusana">&nbsp;
				<input type="submit" value="Hae">
				<input type="button" value="Lis�� uusi vene" id="lisaa">
			</form>
		</div>
		<thead>
			<tr>
				<td class="otsikko"><b>Tunnus</b></td>
				<td class="otsikko"><b>Nimi</b></td>
				<td class="otsikko"><b>Merkkimalli</b></td>
				<td class="otsikko"><b>Pituus</b></td>
				<td class="otsikko"><b>Leveys</b></td>
				<td class="otsikko"><b>Hinta</b></td>
				<br>
			</tr>
		</thead>
		<tbody>
		<%
		if (request.getAttribute("veneet") != null) {
			ArrayList<Vene> veneet = (ArrayList<Vene>)request.getAttribute("veneet");
			for (int i=0; i<veneet.size(); i++) {
				out.print("<tr>");
				out.print("<td>" + veneet.get(i).getTunnus() + "</td>");
				out.print("<td>" + veneet.get(i).getNimi() + "</td>");
				out.print("<td>" + veneet.get(i).getMerkkimalli() + "</td>");
				out.print("<td>" + veneet.get(i).getPituus() + "</td>");
				out.print("<td>" + veneet.get(i).getLeveys() + "</td>");
				out.print("<td>" + veneet.get(i).getHinta() + "</td>");
				out.print("<td><a href='muutavene.jsp?tunnus=" + veneet.get(i).getTunnus() + "&nimi=" + veneet.get(i).getNimi() + "&merkkimalli=" + veneet.get(i).getMerkkimalli() + "&pituus=" + veneet.get(i).getPituus() + "&leveys=" + veneet.get(i).getLeveys() + "&hinta=" + veneet.get(i).getHinta() + "'>Muuta</a></td>");
				out.print("<td><form action='PoistaVene' method='post' name='poistaLomake' id='poistaLomake'>");
				out.print("<input type='hidden' name='poista_tunnus' value=" + veneet.get(i).getTunnus() + ">");
				out.print("<button type='submit' class='btn btn-danger' value='poista'>Poista</button></form></td>");
				out.print("</tr>");
			}
		}
		else {
			Dao dao = new Dao();
			ArrayList<Vene> veneet = dao.listaaKaikki();
			for (int i=0; i<veneet.size(); i++) {
				out.print("<tr>");
				out.print("<td>" + veneet.get(i).getTunnus() + "</td>");
				out.print("<td>" + veneet.get(i).getNimi() + "</td>");
				out.print("<td>" + veneet.get(i).getMerkkimalli() + "</td>");
				out.print("<td>" + veneet.get(i).getPituus() + "</td>");
				out.print("<td>" + veneet.get(i).getLeveys() + "</td>");
				out.print("<td>" + veneet.get(i).getHinta() + "</td>");
				out.print("<td><a href='muutavene.jsp?tunnus=" + veneet.get(i).getTunnus() + "&nimi=" + veneet.get(i).getNimi() + "&merkkimalli=" + veneet.get(i).getMerkkimalli() + "&pituus=" + veneet.get(i).getPituus() + "&leveys=" + veneet.get(i).getLeveys() + "&hinta=" + veneet.get(i).getHinta() + "'>Muuta</a></td>");
				out.print("<td><form action='PoistaVene' method='post' name='poistaLomake' id='poistaLomake'>");
				out.print("<input type='hidden' name='poista_tunnus' value=" + veneet.get(i).getTunnus() + ">");
				out.print("<button type='submit' class='btn btn-danger' value='poista'>Poista</button></form></td>");
				out.print("</tr>");
			}
		}
		%>
		</tbody>
	</table>
	
	<script>
		$(document).ready(function() {
			$("#hakusana").focus();
			$("#lisaa").click(function() {
				window.location.href = 'lisaavene.jsp';
			});
		});
	</script>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
	
	<a href="haeveneet.jsp"><button type="button" class="btn btn-light">N�yt� kaikki veneet</button></a>
	</body>
</html>