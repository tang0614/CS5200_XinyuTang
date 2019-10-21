package daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import models.Developer;

import edu.northeastern.cs5200.DB_connection;
import models.Page;
import models.Website;

public class WebsiteDaolmpl {
	
	DB_connection obj_DB_connection = new DB_connection();
	Connection connection = obj_DB_connection.get_connection(); 
	
	public void createWebsiteForDeveloper(int id,String name,String description,String created,String updated,
			int visits, int developer_id) {
		
		try {
			
			String q = "insert into Website(id,description,name, created,updated,visits,developer_id)"
					+"values(?,?,?,?,?,?,?)";	
			PreparedStatement ps = connection.prepareStatement(q);
		
			
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setString(3,description);
			ps.setString(4,created);
			ps.setString(5,updated);
			ps.setInt(6,visits);
			ps.setInt(7,developer_id);
	
		
			ps.execute();
			ps.close();

			
			}
			catch(SQLException e) {
				System.out.println(e);
			}
			
		
	}
	public Website findWebsiteById(int websiteId) {
		
try {
			
			String q = "select * from Website where id =" +websiteId;	
			PreparedStatement ps = connection.prepareStatement(q);
            ResultSet rs = ps.executeQuery(q);
          	rs.next();
          	
			String description = rs.getString("description");
			String name = rs.getString("name");
			String created = rs.getString("created");
			String updated =rs.getString("updated");
			int visits = rs.getInt("visits");
			int developer_id = rs.getInt("developer_id");

			ps.execute();
			ps.close();
			
			return new Website(this,websiteId,name,description,created,updated,visits, null, developer_id);
			}catch(SQLException e) {
				System.out.println(e);
			}
		return null;
		
	}
	
	//Q2
	public Website findAllWebsites(int id) {
		try {
			
			String q = "select * from Websites where id =" +id;	
			PreparedStatement ps = connection.prepareStatement(q);
            ResultSet rs = ps.executeQuery(q);
          	rs.next();
          	
          	String description = rs.getString("description");
          	String name = rs.getString("name");
			String created = rs.getString("created");
			String updated =rs.getString("updated");
			int visits = rs.getInt("visits");
			int developer_id = rs.getInt("developer_id");
			
			
			ps.execute();
			ps.close();
			
			return new Website(this,id,name,description,created,updated,visits, null, developer_id);
			
			}catch(SQLException e) {
				System.out.println(e);
			}
		return null;
		
	}
	
		public Collection<Website> findAllWebsites(){
			try {
			String q = "select * from Website";
			PreparedStatement ps = connection.prepareStatement(q);
	        ResultSet rs = ps.executeQuery(q);
	        Collection<Website> es = new ArrayList<Website>();
	        
	        while(rs.next()) {
	        	int id = rs.getInt("id");
	        	es.add(findAllWebsites(id));
	        	ps.execute();
				ps.close();
	        }
			return es;
			}catch(SQLException e) {
				System.out.println(e);
			}return null;
	   	
		}
		
		public Collection<Website> findWebsitesForDeveloper(int developer_id){
			try {
			String q = "select * from Website where developer_id =" + developer_id;
			PreparedStatement ps = connection.prepareStatement(q);
	        ResultSet rs = ps.executeQuery(q);
	        Collection<Website> es = new ArrayList<Website>();
	        
	        while(rs.next()) {
	        	int id = rs.getInt("id");
	        	es.add(findAllWebsites(id));
	        	ps.execute();
				ps.close();
	        }
			return es;
			}catch(SQLException e) {
				System.out.println(e);
			}return null;
	   	
		}
		
		public int updateWebsite(int id,String description,String name, String created,String updated,
				int visits, int developer_id) {
			try {
				
				String q = "update Website set name=?,description=?, created=?, updated=?,visits=?,"
						+ "id=" + id;
				
				PreparedStatement ps = connection.prepareStatement(q);
				
				ps.setString(1,name);
				ps.setString(2,description);
				ps.setString(3,created);
				ps.setString(4,updated);
				ps.setInt(5,visits);
				ps.setInt(6,developer_id);
				

				return ps.executeUpdate();
				}
				catch(SQLException e) {
					System.out.println(e);
				}
				return 0;	
		}
		
		public int deleteWebsite(int websiteId) {
			try {
				String q = "delete from Website where id = ?";
				PreparedStatement ps = connection.prepareStatement(q);
				ps.setInt(1,websiteId);
		        ps.executeUpdate();
		        System.out.println("delete row with the websiteId");
		        return ps.executeUpdate();
				}
			
				catch(SQLException e) {
					System.out.println(e);
				}return 0;
			
		}


		
	
	

}
