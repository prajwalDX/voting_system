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

public class Vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("radio1");
		
		PrintWriter out = response.getWriter();
	final String uname = request.getParameter("usname"); 
		int status = 0;
		String ad ="admin";
		try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/voting", "admin", "admin");
            PreparedStatement pst = conn.prepareStatement("Select status from user where user=?");
            pst.setString(1, uname);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) 
            {
            	request.setAttribute("username",uname);
            	status = rs.getInt("status");
              
            } 
        
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
		
		if(null!=name)
		{
		  
			 if(status == 1) {
			    	request.setAttribute("statusmsg", "ALREADY VOTED");
		            RequestDispatcher rd = request.getRequestDispatcher("/vote.jsp");
		            rd.forward(request, response);
				
			    	}
			 else if(uname.matches("null")) {
				 request.setAttribute("statusmsg", "NULL USER (GOTO LOGIN PAGE)");
		            RequestDispatcher rd = request.getRequestDispatcher("/vote.jsp");
		            rd.forward(request, response);
			 }
			 else if(uname.matches(ad)) {
				 request.setAttribute("statusmsg", "ADMIN CANNOT VOTE");
		            RequestDispatcher rd = request.getRequestDispatcher("/vote.jsp");
		            rd.forward(request, response);
			 }
			
			 else
			 {
				 try {
					 Class.forName("com.mysql.jdbc.Driver");
			         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/voting", "admin", "admin");
			      java.sql.Statement stmt = conn.createStatement();
			      String sql="UPDATE candidate SET votes=votes+1 WHERE name='"+name+"'";
			      stmt.executeUpdate(sql);
			      System.out.println("successfully voted");
	
				}
				catch(Exception e)
				{
					 e.printStackTrace();
				}
				try {
					 Class.forName("com.mysql.jdbc.Driver");
			         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/voting", "admin", "admin");
			      java.sql.Statement stmt = conn.createStatement();
			      String sql="UPDATE user SET status=1 WHERE user='"+uname+"'";
			      stmt.executeUpdate(sql);
			      System.out.println("status changed");
	
				}
				catch(Exception e)
				{
					 e.printStackTrace();
				}
				request.setAttribute("statusmsg", "VOTED SUCCESSFULLY");
	            RequestDispatcher rd = request.getRequestDispatcher("/vote.jsp");
	            rd.forward(request, response);
				// out.print("voted");
	       }
		 }
		else {
				request.setAttribute("statusmsg", "SELECT ANY CANDIDATE");
	            RequestDispatcher rd = request.getRequestDispatcher("/vote.jsp");
	            rd.forward(request, response);
			
		}
}
}


