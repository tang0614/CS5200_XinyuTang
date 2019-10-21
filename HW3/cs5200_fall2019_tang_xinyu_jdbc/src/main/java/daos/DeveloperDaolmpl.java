package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import models.Developer;


import edu.northeastern.cs5200.DB_connection;


public class DeveloperDaolmpl {

	
	DB_connection obj_DB_connection = new DB_connection();
	Connection connection = obj_DB_connection.get_connection(); 
	
	public void createDeveloper(int developer_id,String k,int id, String first_name, String last_name,
			String user_name,String password,String email){
		try {
			
		String q = "insert into Developer(developer_id,k,id,first_name,last_name,user_name,password,email)"
				+"values(?,?,?,?,?,?,?,?)";	
		PreparedStatement ps = connection.prepareStatement(q);
	
		
		ps.setInt(1,developer_id);
		ps.setString(2,k);
		ps.setInt(3,id);
		ps.setString(4,first_name);
		ps.setString(5,last_name);
		ps.setString(6,user_name);
		ps.setString(7,password);
		ps.setString(8,email);

	
		ps.execute();
		ps.close();

		
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
	
		
	}
	
	public Developer findAllDevelopers(int developer_id) {
		try {
			
			String q = "select * from Developer where developer_id =" +developer_id;	
			PreparedStatement ps = connection.prepareStatement(q);
            ResultSet rs = ps.executeQuery(q);
          	rs.next();
          	
			String k = rs.getString("k");
			int id = rs.getInt("id");
			String first_name = rs.getString("first_name");
			String last_name =rs.getString("last_name");
			String user_name = rs.getString("user_name");
			String password = rs.getString("password");
			String email = rs.getString("email");
			ps.execute();
			ps.close();
			return new Developer(this, id, first_name, last_name, user_name, "", password,"", email, developer_id, k);
			}catch(SQLException e) {
				System.out.println(e);
			}
		return null;
		
	}
	
	public Developer findAllDeveloperByUserName(String user_name) {
		try {
			
			String q = "select * from Developer where user_name =" +user_name;	
			PreparedStatement ps = connection.prepareStatement(q);
            ResultSet rs = ps.executeQuery(q);
          	rs.next();
          	
			String k = rs.getString("k");
			int id = rs.getInt("id");
			String first_name = rs.getString("first_name");
			String last_name =rs.getString("last_name");
			int developer_id = rs.getInt("developer_id");
			String password = rs.getString("password");
			String email = rs.getString("email");
			ps.execute();
			ps.close();
			return new Developer(this, id, first_name, last_name, user_name, "", password,"", email, developer_id, k);
			}catch(SQLException e) {
				System.out.println(e);
			}
		return null;
		
	}
	
	public Developer findAllDeveloperByCredential(String user_name,String password) {
		try {
			
			String q = "select * from Developer where user_name =" +user_name+
					"and password =" +password;	
			PreparedStatement ps = connection.prepareStatement(q);
            ResultSet rs = ps.executeQuery(q);
          	rs.next();
          	
			String k = rs.getString("k");
			int id = rs.getInt("id");
			String first_name = rs.getString("first_name");
			String last_name =rs.getString("last_name");
			int developer_id = rs.getInt("developer_id");
			String email = rs.getString("email");
			ps.execute();
			ps.close();
			return new Developer(this, id, first_name, last_name, user_name, "", password,"", email, developer_id, k);
			}catch(SQLException e) {
				System.out.println(e);
			}
		return null;
		
	}
	
	//Q2
	public Collection<Developer> findAllDevelopers(){
		try {
		String q = "select * from Developer";
		PreparedStatement ps = connection.prepareStatement(q);
        ResultSet rs = ps.executeQuery(q);
        Collection<Developer> es = new ArrayList<Developer>();
        while(rs.next()) {
        	int id = rs.getInt("developer_id");
        	es.add(findAllDevelopers(id));
        	ps.execute();
			ps.close();
        }
		return es;
		}catch(SQLException e) {
			System.out.println(e);
		}return null;
   	
	}
	
	
	public int updateDeveloper(int developer_id,String k,int id, String first_name, String last_name,
			String user_name,String password,String email){
		try {
			
		String q = "update Developer set k=?, id=?, first_name=?,last_name=?,"
				+ "user_name=?, password=?,email=? where developer_id =" + developer_id;
		
		PreparedStatement ps = connection.prepareStatement(q);
		ps.setString(1,k);
		ps.setInt(2,id);
		ps.setString(3,first_name);
		ps.setString(4,last_name);
		ps.setString(5,user_name);
		ps.setString(6,password);
		ps.setString(7,email);
		

		return ps.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return 0;	
	}
	
	public int deleteDeveloper(int developer_id) {
		try {
			String q = "delete from Developer where developer_id = ?";
			PreparedStatement ps = connection.prepareStatement(q);
			ps.setInt(1,developer_id);
	        ps.executeUpdate();
	        System.out.println("delete row with the developer_id");
	        return ps.executeUpdate();
			}
		
			catch(SQLException e) {
				System.out.println(e);
			}return 0;
		
	}

	
}
