import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

/**
 * Servlet implementation class profile
 */
public class profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		String name = (String) session.getAttribute("name");
		String email = (String) session.getAttribute("email");
		String pass = (String) session.getAttribute("pass");
		
		if (name==null || email==null) {
			response.sendRedirect("login.jsp");
		}
		
		request.getRequestDispatcher("header.html").include(request, response);
		
		out.println("<h3 style=\"text-align: center; font-family: monospace; font-size: 16px;\">Hello "
		+ name + "<p></p>Your email is " + email + "<p></p>Your password is " + pass + "</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
