package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.northeastern.cs5200.DB_connection;

public class RoleDao {
	DB_connection obj_DB_connection = new DB_connection();
	Connection connection = obj_DB_connection.get_connection(); 

	public void assignWebsiteRole(int RoleId, int websiteId, int roleId) {
	
		try {
			String q = "insert into Role(roleId,developerId,websiteId)"
					+"values(?,?,?)";	
			PreparedStatement ps = connection.prepareStatement(q);
			ps.setInt(1,RoleId);
			ps.setInt(2,websiteId);
			ps.setInt(3,roleId);
			ps.execute();
			ps.close();

			
			}
			catch(SQLException e) {
				System.out.println(e);
			}
	}
	public void assignPageRole(int developerId, int pageId, int roleId) {
		try {
			String q = "insert into Role(roleId,developerId,pageId)"
					+"values(?,?,?)";	
			PreparedStatement ps = connection.prepareStatement(q);
			ps.setInt(1,roleId);
			ps.setInt(2,developerId);
			ps.setInt(3,pageId);
			ps.execute();
			ps.close();

			}
			catch(SQLException e) {
				System.out.println(e);
			}
		
	}
	public void deleteWebsiteRole(int developerId, int websiteId, int roleId) {
		try {
			String q = "delete from Role where websiteId= ?";
			PreparedStatement ps = connection.prepareStatement(q);
			ps.setInt(1,websiteId);
	        ps.executeUpdate();
	        System.out.println("delete row with the websiteId");
	  
			}
		
			catch(SQLException e) {
				System.out.println(e);
			}
		
	}
	public void deletePageRole(int developerId, int pageId, int roleId) {
		try {
			String q = "delete from Role where pageId= ?";
			PreparedStatement ps = connection.prepareStatement(q);
			ps.setInt(1,pageId);
	        ps.executeUpdate();
	        System.out.println("delete row with the websiteId");
	  
			}
			catch(SQLException e) {
				System.out.println(e);
			}
		
	}


}
