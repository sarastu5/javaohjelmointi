<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auton lis��minen</title>
</head>
<body>
	<form action="LisaaAuto" method="post">
		<table border="1">
			<tr>
				<td align="right">Rekisterinumero:</td>
				<td><input type="text" name="rekno"></td>
			</tr>
			<tr>
				<td align="right">Merkki:</td>
				<td><input type="text" name="merkki"></td>
			</tr>
			<tr>
				<td align="right">Malli:</td>
				<td><input type="text" name="malli"></td>
			</tr>
			<tr>
				<td align="right">Vuosi:</td>
				<td><input type="number" name="vuosi"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Lis��" style="width:260px"></td>
			</tr>
		</table>
	</form>
	<%
	if  (request.getParameter("ilmo") != null) {
		if (request.getParameter("ilmo").equals("1")) {
			out.print("Auton lis��minen onnistui.");
		} else if (request.getParameter("ilmo").equals("0")) {
			out.print("Auton lis��minen ei onnistunut.");
		}
	}
	%>
	<br>
	<a href="haeautot.jsp">N�yt� kaikki autot</a>
</body>
</html>