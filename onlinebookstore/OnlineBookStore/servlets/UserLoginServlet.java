package servlets;

import javax.servlet.*;

import constants.IOnlineBookStoreConstants;
import sql.IUserContants;

import java.io.*;
import java.sql.*;

public class UserLoginServlet extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		PrintWriter pw = res.getWriter();
		res.setContentType(IOnlineBookStoreConstants.CONTENT_TYPE_TEXT_HTML);
		String uName = req.getParameter(IUserContants.COLUMN_USERNAME);
		String pWord = req.getParameter(IUserContants.COLUMN_PASSWORD);
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + IUserContants.TABLE_USERS + " WHERE "
					+ IUserContants.COLUMN_USERNAME + "=? AND " + IUserContants.COLUMN_PASSWORD + "=? AND " + IUserContants.COLUMN_USERTYPE + "=2");
			ps.setString(1, uName);
			ps.setString(2, pWord);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				RequestDispatcher rd = req.getRequestDispatcher("Sample1.html");
				rd.include(req, res);
				pw.println("<div class=\"welcome\">Welcome ! " + uName + "</div><br/>");
				pw.println("<div class='tab'><a href=\"AddBook.html\">ADD BOOKS</a></div>");
				pw.println("<div class=\"tab\"><br/><a href=\"RemoveBooks.html\">REMOVE BOOK</a><br/></div>");
				pw.println("<div class='tab'><a href=\"buybook\">REQUEST BOOK</a></div>");
				pw.println("<div class='tab'><a href=\"addmoney.html\">UPDATE MONEY</a></div>");
				pw.println("<div class='tab'><a href=\"DeleteUser1.html\">DELETE ACCOUNT</a></div>");
				pw.println("<div class='tab'><a href=\"index.html\">LOGOUT</a></div>");
				
			} else {

				RequestDispatcher rd = req.getRequestDispatcher("UserLogin.html");
				rd.include(req, res);
				pw.println("<div class=\"tab\">OOPS! Incorrect Username/Password</div>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}