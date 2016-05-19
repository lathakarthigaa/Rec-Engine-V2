package Simulation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class HumanPresenceSimulation 
{
	public static void main(String a[])
	{
		HumanPresenceSimulation humanPresenceSimulation = new HumanPresenceSimulation();
		System.out.println(humanPresenceSimulation.getHumanPresenceStatus("02:14:00"));
	}
	
	public boolean getHumanPresenceStatus(String time)
	{
		boolean humanPresenceStatus = false;
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:D:/Projects/Recommendation Engine/simulation");
	      System.out.println("Creating statement...");
	      stmt = c.createStatement();

	      String sql = "SELECT Time_of_the_day,isHumanPresent FROM human_presence where Time_of_the_day='"+time+"'";
	      ResultSet rs = stmt.executeQuery(sql);
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         int Time_of_the_day  = rs.getInt("Time_of_the_day");
	         int isHumanPresent = rs.getInt("isHumanPresent");//0 or 1

	         //Display values
	         System.out.print("Time_of_the_day: " + Time_of_the_day);
	         System.out.print(", isHumanPresent: " + isHumanPresent);
	         if(isHumanPresent == 1)
	         {
	        	 humanPresenceStatus = true;
	         }
	         else if(isHumanPresent == 0)
	         {
	        	 humanPresenceStatus = false;
	         }
	         else
	         {
	        	 humanPresenceStatus = false;
	         }
	      }
	      rs.close();
	    }
	    catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		return humanPresenceStatus;
	}
	
	/*public static void main( String args[] )
	  {
	    Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:D:/Projects/Recommendation Engine/simulation");
	      
	      System.out.println("Inserting records into the table...");
	      stmt = c.createStatement();
	      
	      for(int j=20;j<=23;j++)
	      {
		      for(int i=0;i<=9;i++)
		      {
			      String sql = "INSERT INTO human_presence VALUES ('"+j+":0"+i+":00',0)";
			      stmt.executeUpdate(sql);
		      }
		      
		      for(int i=11;i<=59;i++)
		      {
			      String sql = "INSERT INTO human_presence VALUES ('"+j+":"+i+":00',0)";
			      stmt.executeUpdate(sql);
		      }
	      }
	      
	      System.out.println("Inserted records into the table...");
	      
	    } 
	    catch(SQLException e1)
	    {
	    	System.err.println( e1.getClass().getName() + ": " + e1.getMessage() );
		      System.exit(0);
	    }
	    
	    catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	  }*/
}
