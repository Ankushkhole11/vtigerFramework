package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDatabase {

	public static void main(String[] args) throws Throwable {
		//step1: Register or load the 
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//step 2: Get connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Teachers_info", "root", "root");
		
		//step 3: create sql statement
		Statement stat = conn.createStatement();
		String Query = "insert into student(first_name,last_name,address)values('blake','abc','india')";

		int result = stat.executeUpdate(Query);
		
		int result1 = 0;
		if(result1==1)
		{
			System.out.println("user is created");
		}
		else
		{
			System.out.println("user is not created");
		}
		
		conn.close();
	}

}
