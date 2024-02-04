package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class ToExecuteUpdate {

	public static void main(String[] args) throws SQLException {

		//1.Creating an object of driver of mysql vendor
				Driver dataBaseDriver = new Driver();
				//2.registering driver to jdbc api
				DriverManager.registerDriver(dataBaseDriver);
				//3.Establishing connection with the database
			    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectDemo", "root", "root");
				
			  int result = connection.createStatement().executeUpdate("insert into lead values('akash','deb','testYantra')");
	
	          if(result==1) {
	        	  System.out.println("data base has been updated");
	          }
	          else
	        	  System.out.println("database has not been updated");
	    connection.close();
	
	}

}

