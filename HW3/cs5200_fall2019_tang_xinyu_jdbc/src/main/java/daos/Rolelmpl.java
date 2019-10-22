package daos;
import java.sql.Date;
import java.util.List;

import edu.northeastern.cs5200.DB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import models.Developer;
import models.Role;
import models.Website;


public class Rolelmpl implements RoleDao{
	DB_connection obj_DB_connection = new DB_connection();
	Connection connection = obj_DB_connection.get_connection(); 

	public void assignWebsiteRole(int developerId, int websiteId, String role) {
	
		try {
			String q = "insert into website_role (role, developer, website) values (?,?,?)";	
			PreparedStatement ps = connection.prepareStatement(q);
			ps.setString(1, role);
	        ps.setInt(2, developerId);
	        ps.setInt(3, websiteId);
	        ps.executeUpdate();
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

	@Override
	public void assignPageRole(int developerId, int pageId, String role) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteWebsiteRole(int developerId, int websiteId, String role)
			throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePageRole(int developerId, int pageId, String role) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}



}
