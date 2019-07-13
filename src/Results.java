import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Statement;

public class Results extends HttpServlet {
	
       
    
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
        out.println("<html><head><title>voting</title><link rel=\"stylesheet\" href=\"source.css\"></head><body><center>");
        
    	HttpSession session = request.getSession();
		String cname = (String) session.getAttribute("unames"); 
        String chk = "admin";
       if(cname.matches(chk))
       {
		try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/voting", "admin", "admin");
            PreparedStatement pst = conn.prepareStatement("Select name,votes from candidate");
            ResultSet rs = pst.executeQuery();
            out.println("<div class=\"head\"><h2>RESULTS</h2></div><div class=\"login\"><table border=1px width=50% height=50%>");
            out.println("<tr><th>NAME</th><th>VOTES</th></tr>");
            while (rs.next()) {
                String n = rs.getString("name");
                int v = rs.getInt("votes"); 
                out.println("<tr><td>" + n + "</td><td>" + v + "</td></tr>"); 
            }
            out.println("</table><br/>");
            out.println("<form method=\"post\" action='Vote'>\r\n" + 
            		"<input type=\"submit\" value=\"Back\" name=\"Back\" />\r\n" + 
            		"</form>");
            out.println("</div></center></body></html>");
            conn.close();
           }
            catch (Exception e) {
            	e.printStackTrace();
           }
		
       }
       else
       {
    	   out.println("<div class=\"head\"><h2> NOT AUTHORISED TO VIEW RESULTS (ONLY FOR ADMIN)<h2>");
    	   out.println("<form method=\"post\" action='vote.jsp'>\r\n" + 
           		"<input type=\"submit\" value=\"Back\" name=\"Back\"  />\r\n" + 
           		"</form></div>");
           out.println("</body></html>");
       }
             
	
	
	}
	
}
