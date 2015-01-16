package prasad.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

import prasad.beans.Bean_surey;




public class DatabaseConnection {
	
	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/test";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "1234";
	   
	   
	   public static ArrayList<Bean_surey> getSurveyRecords(Bean_surey dataBean) {
		   Connection conn = null;
		   Statement stmt = null;
		   ArrayList<Bean_surey> studentRecordList=new  ArrayList();
		   try{
				
				
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query		      
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * from   test.DataTable";
		      if(dataBean.getFirstname()==null)
		      {
		    	  		    		  
		      }
		      else
		      {
		      String whereCluase="";
		      if(dataBean !=null)
		      {
		    	  String str1="",str2="",str3="",str4="";
		    	  if(dataBean.getFirstname().isEmpty()==false && dataBean.getFirstname()!=null)
		    	  {
		    		  String str=dataBean.getFirstname();
		    		  if(str.indexOf("*") > 0)
		    		  {
		    			  str=  str.replace("*", "%");
		    			  str1="  Firstname     LIKE '"+str+"%' ";
		    		  }
		    		  else
		    			  str1="  Firstname ='"+str+"'";
		    		 
		    	  }
		    	  if(dataBean.getLastname().isEmpty()==false  && dataBean.getLastname()!=null)
		    	  {
		    		  String str=dataBean.getLastname();
		    		  if(str.indexOf("*") > 0)
		    		  {
		    			  str=  str.replace("*", "%");
		    		     str2="   Lastname     LIKE '"+str+"%' ";
		    		  }
		    		  else
		    			 str2=" Lastname ='"+str+"'";
		    		  
		    	  }
		    	  if(dataBean.getCity().isEmpty()==false && dataBean.getCity()!=null)
		    	  {
		    		  String str=dataBean.getCity();
		    		  if(str.indexOf("*") > 0)
		    		  {
		    			  str=  str.replace("*", "%");
		    		  str3="   City     LIKE '"+str+"%' ";
		    		  }
		    		  else
		    			  str3="  City ='"+str+"'";
		    		  System.out.println("str3 city "+str3);
		    	  }
		    	  if(dataBean.getState().isEmpty()==false && dataBean.getState()!=null)
		    	  {
		    		  String str=dataBean.getState();
		    		  if(str.indexOf("*") > 0)
		    		  {
		    			  str=  str.replace("*", "%");
		    		     str4="   State     LIKE '"+str+"%' ";
		    		  }
		    		  else
		    			  str4="  State ='"+str+"'";
		    		  System.out.println("str4 STATE "+str4);
		    	  }
		    	  if(str1.isEmpty()==false)
		    	  {
		    		  whereCluase=" where " +str1;
		    		  if(str2.isEmpty()==false)
		    			  whereCluase= whereCluase +" and  " +str2;
		    		  if(str3.isEmpty()==false)
		    			  whereCluase= whereCluase+" and  " +str3;
		    		  if(str4.isEmpty()==false)
		    			  whereCluase=whereCluase+ " and  " +str4;
		    		  System.out.println(" if(str1!= "+whereCluase);
		    	  }
		    	  else if (str2.isEmpty()==false)
		    	  {
		    		  
		    		  whereCluase=" where " +str2;
		    		 
		    		  if(str3.isEmpty()==false)
		    			  whereCluase= whereCluase + " and  " +str3;
		    		  if(str4.isEmpty()==false)
		    			  whereCluase= whereCluase +  " and  " +str4;
		    		  System.out.println("else if (str2 "+whereCluase);
		    	  }
		    	  else if (str3.isEmpty()==false)
		    	  {
		    		  
		    		  whereCluase=" where " +str3;
		    		 
		    		  if(str4.isEmpty()==false)
		    			  whereCluase= whereCluase +  " and  " +str4;
		    		  System.out.println( "else if (str3! "+whereCluase);
		    	  }
		    	  else if(str4.isEmpty()==false)
		    	  {
	    			  whereCluase= " where  " +str4;
	    			  System.out.println( " else if(str4! "+whereCluase);
		    	  }
		    	  
		      }
		      sql=sql+whereCluase;
		      System.out.println("Testing :"+sql);
		      }
		      ResultSet rs = stmt.executeQuery(sql);

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         //int id  = rs.getInt("student_id");first_name,last_name ,city ,STATE,zip_code "+
	              
		    	   Bean_surey student_record=new Bean_surey();
		    	   student_record.setFirstname(rs.getString("Firstname"));
		    	   student_record.setLastname(rs.getString("Lastname"));
		    	   student_record.setCity(rs.getString("City"));
		    	   student_record.setState(rs.getString("State"));
		    	   student_record.setZip(rs.getString("Zip"));
		    	   //student_record.setLike(rs.getString("Like"));
		    	   student_record.setPhone(rs.getString("Phone"));
		    	  studentRecordList.add(student_record);
		    	  //recor(rs.getString("survey_date"));
				
		      }
		      //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		      //return studentRecordList;
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		 
		   System.out.println("Goodbye!");
		   return  studentRecordList;
		}//end main
	   
	   public static void insertSurveyRecords(Bean_surey databean) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      java.util.Date date = new java.util.Date();
	      java.sql.Date sqlDate = new java.sql.Date(date.getTime());        
	   // Using DateFormat format method we can create a string 
	   // representation of a date with the defined format.
	  // String reportDate = df.format(today);
	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      //Firstname, Lastname, City, State, Zip,  Phone 
	      sql = "INSERT INTO test.DataTable "+
	                " ( Firstname,Lastname ,City ,State,Zip "+
	                 "  ,Phone )"+
	                " VALUES (   "+  "'"+databean.getFirstname()+"',"+ "'"+databean.getLastname()+"',"+ 
	                 "'"+databean.getCity()+"'," +  "'"+databean.getState()+"',"+  
	                "'"+databean.getZip()+  "','"+databean.getPhone()+"')";
	      stmt.executeUpdate(sql);

	      //STEP 5: Extract data from result set
	     
	      stmt.close();
	      conn.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}//end main

}
//end FirstExample