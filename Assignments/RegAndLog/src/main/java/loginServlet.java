import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.logging.*;
import java.sql.*;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
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
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		dbConnector db = new dbConnector();
		Connection con = db.connector();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from users where email = '" + email +"' and password = '" + pass + "'");
			
			if (rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("name", rs.getString(2));
				session.setAttribute("email", rs.getString(3));
				session.setAttribute("pass", rs.getString(4));
				request.getRequestDispatcher("header.html").include(request, response);
				out.print("<h3 style = \"text-align: center; font-size: 18px; font-family: monospace;\">You are successfully logged in! <br> Welcome, " + email.split("@")[0] + "</h3>");
				con.close();
			} else {
				out.print("<h3 style = \"color: white; background-color: red; font-size: 20px;\">Wrong email or password! Try again!");
				request.getRequestDispatcher("login.jsp").include(request, response);
			}
			out.close();
		} catch (SQLException e) {
			Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, e);
		}
	}

}
