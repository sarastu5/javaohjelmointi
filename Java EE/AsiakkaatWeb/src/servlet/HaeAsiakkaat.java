package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import model.Asiakas;

@WebServlet("/HaeAsiakkaat")
public class HaeAsiakkaat extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HaeAsiakkaat() { //oletuskonstruktori
        super();
        System.out.println("HaeAsiakkaat.HaeAsiakkaat()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("HaeAsiakkaat.doGet()");
		
		Dao dao = new Dao();
		
		ArrayList<Asiakas> asiakkaat = dao.listaaKaikki();
		request.setAttribute("asiakkaat", asiakkaat); //tehd��n attribuutti, jonka sis�ll� on arraylist autot
		String jsp = "/haeasiakkaat.jsp"; //l�hetet��n datan haeasiakkaat.jsp:lle
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HaeAsiakkaat.doPost()");
		String hakusana = request.getParameter("hakusana");
		System.out.println(hakusana);
		if (hakusana.isEmpty()) {
			response.sendRedirect("haeasiakkaat.jsp?ilmo=Anna hakusana");
			return;
		}
		
		Dao dao = new Dao();
		
		ArrayList<Asiakas> asiakkaat = dao.listaaKaikki(hakusana);
		request.setAttribute("asiakkaat", asiakkaat); //tehd��n attribuutti, jonka sis�ll� on arraylist autot
		String jsp = "/haeasiakkaat.jsp"; //l�hetet��n datan haeasiakkaat.jsp:lle
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

}
