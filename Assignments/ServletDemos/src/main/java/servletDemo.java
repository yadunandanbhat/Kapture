import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class servletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;
		
	/**
     * @see HttpServlet#HttpServlet()
     */
	public servletDemo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
    protected void doGet(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

        processRequest(request, response);
    }

	/**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
	protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String pass = request.getParameter("passwd");
		String email = request.getParameter("email");
		out.println("<h3>Logged in successfully! Your name is " + name + " and your email is " + email + "</h3>");
	}
}