package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import model.Auto;

@WebServlet("/LisaaAuto")
public class LisaaAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LisaaAuto() {
        super();
        System.out.println("LisaaAuto.LisaaAuto()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			System.out.println("LisaaAuto.doGet()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LisaaAuto.doPost()");
		String rekno = request.getParameter("rekno");
		String merkki = request.getParameter("merkki");
		String malli = request.getParameter("malli");
		int vuosi = Integer.parseInt(request.getParameter("vuosi"));
		
		Auto auto = new Auto(rekno, merkki, malli, vuosi);
		
		Dao dao = new Dao();
		
		if (dao.lisaaAuto(auto)) {
			response.sendRedirect("lisaaauto.jsp?ilmo=1");
		} else {
			response.sendRedirect("lisaaauto.jsp?ilmo=0");
		}
	}

}
