import java.io.*;

import javax.servlet.http.*;
import javax.servlet.*;

import java.sql.*;
import javax.sql.DataSource;
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 response.setContentType("text/html");
    	 String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
	           
        
		if(username.isEmpty() || password.isEmpty())
		{
			request.setAttribute("valid", "ENTER ALL DETAILS");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
		}
		else
		{
			
			  try 
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/voting", "admin", "admin");
		            PreparedStatement pst = conn.prepareStatement("Select user,pass from login where user=? and pass=?");
		            pst.setString(1, username);
		            pst.setString(2, password);
		            ResultSet rs = pst.executeQuery();
		            if (rs.next()) 
		            {
		            	
//		            	Cookie ck=new Cookie("unamec",username);//creating cookie object  
//		                response.addCookie(ck);//adding cookie in the response  
		            	HttpSession session = request.getSession();
		            	session.setAttribute("unames", username);
		                RequestDispatcher req = request.getRequestDispatcher("/vote.jsp");
		    			req.forward(request, response);
		            } 
		            else
		            {
		            	request.setAttribute("valid", "WRONG USERNAME OR PASSWORD");
			            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			            rd.forward(request, response);
		            }
		        } 
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        }
			
		}
	}

}