package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;

@WebServlet("/PoistaVene")
public class PoistaVene extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PoistaVene() {
        super();
        System.out.println("PoistaVene.PoistaVene()");
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //do get tulee esim. kun painetaan linkki�
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("PoistaVene.doGet()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //post k�ytet��n silloin, kun painetaan formin nappia
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("PoistaVene.doPost()");
		
		int tunnus = Integer.parseInt(request.getParameter("poista_tunnus"));
		Dao dao = new Dao();
		if(dao.poistaVene(tunnus)){
			response.sendRedirect("haeveneet.jsp");
		} else {
			response.sendRedirect("haeveneet.jsp?ilmo=2");
		}
	}

}
