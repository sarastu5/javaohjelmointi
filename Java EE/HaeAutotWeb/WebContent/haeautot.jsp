<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Auto"%>  
<%@ page import="java.util.ArrayList"%>  
<%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Autojen haku</title>
</head>
<body>
<form action="HaeAutot" method="post">
Hakusana:
<input type="text" name="hakusana">&nbsp;
<input type="submit" value="Hae">
</form>
<%
if(request.getParameter("ilmo")!=null){
	out.print(request.getParameter("ilmo"));	
}
%>
<br></br>
<table border="1">
<tr>
<td>Rekisterinumero</td>
<td>Merkki</td>
<td>Malli</td>
<td>Vuosimalli</td>
</tr>
<%
if(request.getAttribute("autot")!=null){	
	ArrayList<Auto> autot = (ArrayList<Auto>)request.getAttribute("autot");
	for(int i=0;i<autot.size();i++){
		out.print("<tr>");
		out.print("<td>" + autot.get(i).getRekNo() + "</td>");
		out.print("<td>" + autot.get(i).getMerkki() + "</td>");
		out.print("<td>" + autot.get(i).getMalli() + "</td>");
		out.print("<td>" + autot.get(i).getVuosi() + "</td>");
		out.print("</tr>");
	}	
}
%>
</table>
</body>
</html>