package servlets;

import java.sql.*;
import javax.servlet.*;

import sql.IBookConstants;
import sql.IUserContants;

import java.io.*;

public class deleteuserServlet extends GenericServlet {
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
				pw.println("<div class=\"tab\">User Removed Successfully</div>");
				pw.println("<div class=\"tab\"><a href=\"DeleteUser.html\">Remove more Users</a></div>");

			} else {
				RequestDispatcher rd = req.getRequestDispatcher("Sample.html");
				rd.include(req, res);
				pw.println("<div class=\"welcome\">Sorry! User not Available!</div>");
				pw.println("<div class=\"rmbook\"><a href=\"DeleteUser.html\">Remove more Users</a></div>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
