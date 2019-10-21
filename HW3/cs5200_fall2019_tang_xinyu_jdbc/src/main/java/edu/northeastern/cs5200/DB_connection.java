package edu.northeastern.cs5200;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB_connection {
	
	public static void main(String[] args) {
		DB_connection obj_DB_connection = new DB_connection();
		Connection connection = null;
		connection = obj_DB_connection.get_connection();
		System.out.println(connection);
		
	}
	
	
	public Connection get_connection() {
		Connection connection =null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection =DriverManager.getConnection("jdbc:mysql://cs5200-fall2018-tang.c1iy3op9i59h.us-east-2.rds.amazonaws.com/cs5200","xinyu_tang","CS2020er..");
		}catch (Exception e) {
			System.out.println(e);
		};
		return connection;
	}
}
