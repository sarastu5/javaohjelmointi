package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import model.Asiakas;

@WebServlet("/MuutaAsiakas")
public class MuutaAsiakas extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MuutaAsiakas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("MuutaAsiakas.doGet()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("MuutaAsiakas.doPost()");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String etunimi = request.getParameter("etunimi");
		String sukunimi = request.getParameter("sukunimi");
		String puhelin = request.getParameter("puhelin");
		String sposti = request.getParameter("sposti");
		
		Asiakas asiakas = new Asiakas(etunimi, sukunimi, puhelin, sposti);
		Dao dao = new Dao();		
		dao.muutaAsiakas(asiakas, id);
		response.sendRedirect("HaeAsiakkaat");
	}

}
