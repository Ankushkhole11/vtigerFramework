package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class WriteDataFromMySql {

	public static void main(String[] args) throws Throwable {
		//step1: Register or load the 
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//step 2: Get connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Teachers_info", "root", "root");
		
		//step 3: create sql statement
		Statement stat = conn.createStatement();
		String selectQuery = "insert into teachers(first_name,last_name,address)values('robin','zx','africa')";
		
		//step 4: Execute statement/query
		 int result = stat.executeUpdate(selectQuery);
		
		if(result==1)
		{
			System.out.println("user is created");	
		}
		else
		{
			System.out.println("user is not created");
		}
		
		//step5 : close the connection
		conn.close();

	}

}
