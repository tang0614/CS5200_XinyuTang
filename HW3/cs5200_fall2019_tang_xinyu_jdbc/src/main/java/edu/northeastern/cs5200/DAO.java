package edu.northeastern.cs5200;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	
	public static void main(String[] args) {
		DAO obj_DAO = new DAO();
		obj_DAO.check_data();
	}
	
	
	public static void check_data() {
		//connect to db
		DB_connection obj_DB_connection = new DB_connection();
		Connection connection = obj_DB_connection.get_connection(); 
		PreparedStatement ps=null;
		
		try {
			String q = "select * from person";
			ps = connection.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("message"));
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
