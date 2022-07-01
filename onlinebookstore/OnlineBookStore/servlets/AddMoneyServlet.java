package servlets;

import java.sql.*;
import javax.servlet.*;

import constants.IOnlineBookStoreConstants;
import sql.IBookConstants;
import sql.IUserContants;

import java.io.*;

public class AddMoneyServlet extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		PrintWriter pw = res.getWriter();
		res.setContentType(IOnlineBookStoreConstants.CONTENT_TYPE_TEXT_HTML);
		String username = req.getParameter("username");
		String Amount=req.getParameter("amount");
		try {
			Connection con = DBConnection.getCon();
			
			Statement st1=con.createStatement();
			int i=st1.executeUpdate("update onlinebookstore.users set Amount='"+Amount+"' where username='"+username+"'");
			pw.println("Amount Updated Successfully and your new amount is "+Amount);
			pw.println();
			
		}
		catch(Exception e)
		{
			pw.println("Not done");
			e.printStackTrace();
		}
	}
}