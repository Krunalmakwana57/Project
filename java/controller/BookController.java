package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookingDao;
import model.BookService;

/**
 * Servlet implementation class BookingController
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("action");
		System.out.println(action);
		if(action.equalsIgnoreCase("book")) {
			BookService b = new BookService();
			b.setSid(Integer.parseInt(request.getParameter("sid")));
			b.setCid(Integer.parseInt(request.getParameter("cid")));
			b.setServiceman_id(Integer.parseInt(request.getParameter("serviceman_id")));
			b.setBooking_status("pending");
			b.setPayment_status("pending");
			BookingDao.bookService(b);
			response.sendRedirect("customer-home.jsp");
		}
		else if(action.equalsIgnoreCase("confirm")) {
			int id = Integer.parseInt(request.getParameter("bid"));
			BookingDao.updateBookingStatus(id);
			response.sendRedirect("serviceman-home.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
