package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.northeastern.cs5200.DB_connection;

public interface PriviliageDao {
	DB_connection obj_DB_connection = new DB_connection();
	Connection connection = obj_DB_connection.get_connection(); 

	public static void assignWebsitePrivilege(int developerId, int websiteId, String priviledge) {
		
		try {
			String q = "insert into Privilege(developerId,websiteId,priviledge)"
					+"values(?,?,?)";	
			PreparedStatement ps = connection.prepareStatement(q);
			ps.setInt(1,developerId);
			ps.setInt(2,websiteId);
			ps.setString(3,priviledge);
			ps.execute();
			ps.close();

			
			}
			catch(SQLException e) {
				System.out.println(e);
			}
		
	}
	
	public static void assignPagePriviledge(int developerId, int pageId, String priviledge) {
		try {
			String q = "insert into Privilege(developerId,pageId,priviledge)"
					+"values(?,?,?)";	
			PreparedStatement ps = connection.prepareStatement(q);
			ps.setInt(1,pageId);
			ps.setInt(2,pageId);
			ps.setString(3,priviledge);
			ps.execute();
			ps.close();

			
			}
			catch(SQLException e) {
				System.out.println(e);
			}
		
	}
	public static void Priviledg(int developerId, int websiteId, String priviledge) {
		try {
			String q = "delete from Priviledge where websiteId= ?";
			PreparedStatement ps = connection.prepareStatement(q);
			ps.setInt(1,websiteId);
	        ps.executeUpdate();
	        System.out.println("delete row with the websiteId");
	  
			}
			catch(SQLException e) {
				System.out.println(e);
			}
	}
	public static void deletePagePriviledge(int developerId, int pageId, String priviledge) {
		try {
			String q = "delete from Priviledge where pageId= ?";
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
