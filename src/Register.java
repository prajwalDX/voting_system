import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		if(username.isEmpty() || password.isEmpty())
		{
			request.setAttribute("errmsg", "ENTER ALL DETAILS");
			RequestDispatcher req = request.getRequestDispatcher("register.jsp");
			req.forward(request, response);
		}
		else
		{
			try {
				 Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/voting", "admin", "admin");
		      java.sql.Statement stmt = conn.createStatement();
		      String sql="INSERT INTO login VALUES ('"+username+"','"+password+"')";
		      stmt.executeUpdate(sql);
		      java.sql.Statement stmt1 = conn.createStatement();
		      String sql1="INSERT INTO user VALUES ('"+username+"', 0 )";
		      stmt1.executeUpdate(sql1);
		      System.out.println("added successfully");
			
			
			
			}
			catch(Exception e)
			{
				 e.printStackTrace();
			}
			RequestDispatcher req = request.getRequestDispatcher("index.jsp");
			req.forward(request, response);
		}
		
		
		
	}

}