/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2018-05-10 19:24:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.Dao;
import model.Vene;
import java.util.ArrayList;

public final class listaaveneet_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("dao.Dao");
    _jspx_imports_classes.add("model.Vene");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"main.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css\" integrity=\"sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4\" crossorigin=\"anonymous\">\r\n");
      out.write("\t<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("\t<title>Veneiden listaus</title>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<h2>Veneiden listaus</h2>\r\n");
      out.write("\t\t<table class=\"table table-striped\">\r\n");
      out.write("\t\t  <thead>\r\n");
      out.write("\t\t    <tr>\r\n");
      out.write("\t\t    \t<th scope=\"col\">Tunnus</th>\r\n");
      out.write("\t\t    \t<th scope=\"col\">Nimi</th>\r\n");
      out.write("\t\t    \t<th scope=\"col\">Merkkimalli</th>\r\n");
      out.write("\t\t    \t<th scope=\"col\">Pituus</th>\r\n");
      out.write("\t\t    \t<th scope=\"col\">Leveys</th>\r\n");
      out.write("\t\t    \t<th scope=\"col\">Hinta</th>\r\n");
      out.write("\t\t    </tr>\r\n");
      out.write("\t\t  </thead>\r\n");
      out.write("\t\t  <tbody>\r\n");
      out.write("\t\t\t\t");

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
				
      out.write("\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<a href=\"lisaavene.jsp\"><button type=\"button\" class=\"btn btn-light\">Lisää uusi vene</button></a>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}