package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromMySql {

	public static void main(String[] args) throws Throwable {
		//step1: Register or load the 
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//step 2: Get connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Teachers_info", "root", "root");
		
		//step 3: create sql statement
		Statement stat = conn.createStatement();
		String selectQuery = "select * from teachers";
		
		//step 4: Execute statement/query
		ResultSet result = stat.executeQuery(selectQuery);
		
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
			
		}
		
		//step5 : close the connection
		conn.close();

	}

}
