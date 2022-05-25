import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.logging.*;

/**
 * Servlet implementation class registerServlet
 */
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		
		dbConnector db = new dbConnector();
		Connection con = db.connector();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into users(name, email, password) value ('" + name + "', '" + email + "', '" + pass + "')" );
			out.print("You have been registered successfully! Now please log back in!");
			con.close();
			request.getRequestDispatcher("login.jsp").include(request, response); 
		} catch (SQLIntegrityConstraintViolationException e) {
		    out.print("<h3 style = \"color: white; background-color: red; font-size: 20px;\">You are already registered! Please login!");
			request.getRequestDispatcher("login.jsp").include(request, response);
		} catch (SQLException e) {
			Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, e);
		}
		out.close();
	}

}
