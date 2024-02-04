package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ToExecuteQuerry {

	public static void main(String[] args) throws SQLException {

		//1.Creating an object of driver of mysql vendor
		Driver dataBaseDriver = new Driver();
		//2.registering driver to jdbc api
		DriverManager.registerDriver(dataBaseDriver);
		//3.Establishing connection with the database
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectDemo", "root", "root");
		//4.creating statement to pass the select querry
	  Statement statement = connection.createStatement();
	  //5.fetching the data from the database
	  ResultSet result = statement.executeQuery("select * from lead;");

      while(result.next()) {
    	  System.out.println(result.getString(1)+"  "+result.getString(2)+"  "+result.getString(3));
      }
      connection.close();
	}
}
	
