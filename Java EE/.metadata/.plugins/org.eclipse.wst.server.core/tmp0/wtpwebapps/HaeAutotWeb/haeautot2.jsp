<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dao.Dao"%>  
<%@ page import="model.Auto"%>  
<%@ page import="java.util.ArrayList"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Autojen haku</title>
</head>
<body>
<%
Dao dao = new Dao();
ArrayList<Auto> autot = dao.listaaKaikki();
for(int i=0;i<autot.size();i++){	
	out.print(autot.get(i).getRekNo() + " ");
	out.print(autot.get(i).getMerkki() + " ");
	out.print(autot.get(i).getMalli() + " ");
	out.print(autot.get(i).getVuosi() + "<br>");	
}
%>

</body>
</html>