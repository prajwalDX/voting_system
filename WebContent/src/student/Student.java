package student;

import java.sql.*;

public class Student{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/STUDENT";

   static final String USER = "root";
   static final String PASS = "admin";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
   
      Class.forName("com.mysql.jdbc.Driver");

      System.out.println("Connecting to database");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
 
      System.out.println("Creating statement");
      stmt = conn.createStatement();
      String sql="INSERT INTO student VALUES ('abc','a1')";
      
      stmt.executeUpdate(sql);
     
 
      sql="INSERT INTO student VALUES ('xyz','a2')";
      stmt.executeUpdate(sql);
      System.out.println("records updated");
    
   } 
   
   /*
   try{
	   
	      Class.forName("com.mysql.jdbc.Driver");
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	      
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
   String sql = "SELECT username, password FROM student";
   ResultSet rs = stmt.executeQuery(sql);
   //STEP 5: Extract data from result set
   while(rs.next()){
      //Retrieve by column name
      String username  = rs.getString("username");
      String password = rs.getString("password");
     
      //Display values
      System.out.print("\n username: " + username);
      System.out.print("\t password: " + password);
   }
   rs.close();
   }*/
   
   catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   } catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
    finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("\n Goodbye!");
	}//end main
	}//end JDBCExample   