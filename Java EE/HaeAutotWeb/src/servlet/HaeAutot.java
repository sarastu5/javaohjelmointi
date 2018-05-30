package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Auto;
import dao.Dao;

@WebServlet("/HaeAutot")
public class HaeAutot extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public HaeAutot() {
        super();
        System.out.println("HaeAutot.HaeAutot()");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HaeAutot.doGet()");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HaeAutot.doPost()");
		String hakusana = request.getParameter("hakusana");
		if(hakusana.isEmpty()){
			response.sendRedirect("haeautot.jsp?ilmo=Anna hakusana");
			return;
		}
		Dao dao = new Dao();
		ArrayList<Auto> autot = dao.listaaKaikki(hakusana);
		request.setAttribute("autot", autot);		
		String jsp = "/haeautot.jsp"; 
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

}









