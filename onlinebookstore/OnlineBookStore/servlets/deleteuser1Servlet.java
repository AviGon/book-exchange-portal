package servlets;

import java.sql.*;
import javax.servlet.*;

import sql.IBookConstants;
import sql.IUserContants;

import java.io.*;

public class deleteuser1Servlet extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String bkid = req.getParameter("username");
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement(
					"delete from " + IUserContants.TABLE_USERS + "  where " + IUserContants.COLUMN_USERNAME  + "=?");
			ps.setString(1, bkid);
			
			int k = ps.executeUpdate();
			if (k == 1) {
				RequestDispatcher rd = req.getRequestDispatcher("Sample.html");
				rd.include(req, res);
				pw.println("<div class=\"tab\">Successfully Removed! Thank You!</div>");
				pw.println("<div class=\"tab\"><a href=\"index.html\">Go to Home Page</a></div>");

			} else {
				RequestDispatcher rd = req.getRequestDispatcher("Sample.html");
				rd.include(req, res);
				pw.println("<div class=\"welcome\">Sorry! User not Available!</div>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
