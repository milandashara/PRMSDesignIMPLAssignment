package sg.edu.nus.iss.phoenix.authenticate.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sg.edu.nus.iss.phoenix.authenticate.delegate.AuthenticateDelegate;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.frontcontroller.FCUtilities;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController/*")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	 /**
     * Process requests from front controller. 
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (FCUtilities.stripPath(request.getPathInfo()).equalsIgnoreCase("login") ) {
			AuthenticateDelegate ad = new AuthenticateDelegate();
			User user = new User();
			user.setId(request.getParameter("id"));
			user.setPassword(request.getParameter("password"));
			user = ad.validateUserIdPassword(user);
			RequestDispatcher rd;
			if (null != user) {
				request.getSession().setAttribute("user", user);
				rd = getServletContext().getRequestDispatcher("/pages/home.jsp");;
			} else
				rd = getServletContext().getRequestDispatcher("/pages/error.jsp");;
		    rd.forward(request, response);
		} else {
			 HttpSession session = request.getSession();
		     session.invalidate();
		     RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/logout.jsp");;
			 rd.forward(request, response);
		}
		
	 }

}