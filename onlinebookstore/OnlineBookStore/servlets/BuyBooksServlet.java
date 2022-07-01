package servlets;
import java.io.*;
import java.sql.*;
import javax.servlet.*;

import constants.IOnlineBookStoreConstants;
import sql.IBookConstants;
import sql.IUserContants;
public class BuyBooksServlet extends GenericServlet{
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType(IOnlineBookStoreConstants.CONTENT_TYPE_TEXT_HTML);
		try {
			Connection con = DBConnection.getCon();
			
			PreparedStatement ps = con.prepareStatement("Select * from " + IBookConstants.TABLE_BOOK);
			ResultSet rs = ps.executeQuery();
			RequestDispatcher rd = req.getRequestDispatcher("ViewBooks.html");
			rd.include(req, res);
			pw.println("<div class=\"tab hd brown \">Books Available Currently</div>");
			pw.println("<div class=\"tab\"><form action=\"buys\" method=\"post\">");
			pw.println("<table>\r\n" + 
					"			<tr>\r\n" + 
					"				<th>Books</th>\r\n" + 
					"				<th>Code</th>\r\n" + 
					"				<th>Name</th>\r\n" + 
					"				<th>Author</th>\r\n" + 
					"				<th>Price</th>\r\n" + 
					"				<th>Avail</th>\r\n" + 
					"				<th>firstname</th>\r\n" + 
					"				<th>phone</th>\r\n" + 
					"				<th>Qty</th>\r\n" + 
					"			</tr>");
			int i=0;
			while(rs.next())
			{
				String bCode = rs.getString(1);
				String bName = rs.getString(2);
				String bAuthor = rs.getString(3);
				int bPrice = rs.getInt(4);
				int bAvl = rs.getInt(5);
				String firstname=rs.getString(6);
				String phone=rs.getString(7);
				i=i+1;
				String n = "checked"+ Integer.toString(i);
				String q = "qty"+Integer.toString(i);
				pw.println("<tr>\r\n" + 
						"				<td>\r\n" + 
						"					<input type=\"checkbox\" name="+n+" value=\"pay\">\r\n" + //Value is made equal to bcode
						"				</td>");
				pw.println("<td>"+bCode+"</td>");
				pw.println("<td>"+bName+"</td>");
				pw.println("<td>"+bAuthor+"</td>");
				pw.println("<td>"+bPrice+"</td>");
				pw.println("<td>"+bAvl+"</td>");
				pw.println("<td>"+firstname+"</td>");
				pw.println("<td>"+phone+"</td>");
				pw.println("<td><input type=\"text\" name="+q+" value=\"0\" text-align=\"center\"></td></tr>");
				
			}
			pw.println("</table>\r\n" + "<input type=\"submit\" value=\" REQUEST NOW \">"+"<br/>"+
					"	</form>\r\n" + 
					"	</div>");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
