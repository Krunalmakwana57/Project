package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ServiceDao;
import dao.ServicemanDao;
import model.Serviceman_Services;

/**
 * Servlet implementation class ServiceController
 */
@WebServlet("/ServiceController")
public class ServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("upload")) {
			Serviceman_Services s = new Serviceman_Services();
			s.setSer_id(Integer.parseInt(request.getParameter("ser_id")));
			s.setStype(request.getParameter("stype"));
			s.setCar_model(request.getParameter("cmodel"));
			s.setSprice(Integer.parseInt(request.getParameter("sprice")));
			s.setDuration(request.getParameter("duration"));
			ServiceDao.insertService(s);
			response.sendRedirect("serviceman-home.jsp");
		}
		else if(action.equalsIgnoreCase("update")) {
			Serviceman_Services s = new Serviceman_Services();
			s.setSid(Integer.parseInt(request.getParameter("sid")));
			s.setStype(request.getParameter("stype"));
			s.setCar_model(request.getParameter("cmodel"));
			s.setSprice(Integer.parseInt(request.getParameter("sprice")));
			s.setDuration(request.getParameter("duration"));
			ServiceDao.udpateService(s);
			response.sendRedirect("serviceman-manage-service.jsp");
		}
	}

}