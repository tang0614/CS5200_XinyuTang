package daos;
import java.sql.Date;
import java.util.List;

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

public class WebsiteDaolmpl implements WebsiteDao{
	
	DB_connection obj_DB_connection = new DB_connection();
	Connection connection = obj_DB_connection.get_connection(); 
	
	public void createWebsiteForDeveloper(int developerId, Website website) {
		
		try {
			
			String q = "insert into website (id, developer, name, description, created, updated, visits) values (?,?,?,?,?,?,?)";	
			PreparedStatement ps = connection.prepareStatement(q);
		
			
			ps.setInt(1, website.getId());
	        ps.setInt(2, developerId);
	        ps.setString(3, website.getName());
	        ps.setString(4, website.getDescription());
	        ps.setDate(5, website.getCreated());
	        ps.setDate(6, website.getUpdated());
	        ps.setInt(7, website.getVisits());

	        ps.executeUpdate();
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
          	int id = rs.getInt("id");
          	String name = rs.getString("name");
            String description = rs.getString("description");
            Date created = rs.getDate("created");
            Date updated = rs.getDate("updated");
            int visits = rs.getInt("visits");

            Website web = new Website(id, name, description, created, updated, visits);

			ps.execute();
			return web;
			
			}catch(SQLException e) {
				System.out.println(e);
			}
		return null;
		
	}
	

	public Collection<Website> findAllWebsites() {
		try {
			List<Website> webs = new ArrayList<Website>();
			
			String q = "select * from Websites";	
			PreparedStatement ps = connection.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                int developerId = rs.getInt("developer");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Date created = rs.getDate("created");
                Date updated = rs.getDate("updated");
                int visits = rs.getInt("visits");

                Website web = new Website(id, name, description, created, updated, visits);
                webs.add(web);
            }

            return webs;
			
			
			}catch(SQLException e) {
				System.out.println(e);
			}
		return null;
		
	}
	
		
		public Collection<Website> findWebsitesForDeveloper(int developer_id){
			try {
			String q = "select * from Website where developer_id =" + developer_id;
			PreparedStatement ps = connection.prepareStatement(q);
	        ResultSet rs = ps.executeQuery(q);
	        Collection<Website> webs = new ArrayList<Website>();
	        
	        while(rs.next()) {
	        	int id = rs.getInt("id");
	            String name = rs.getString("name");
	            String description = rs.getString("description");
	            Date created = rs.getDate("created");
	            Date updated = rs.getDate("updated");
	            int visits = rs.getInt("visits");

	            Website web = new Website(id, name, description, created, updated, visits);
	            webs.add(web);
	        }
	        
			return webs;
			
			}catch(SQLException e) {
				System.out.println(e);
			}return null;
	   	
		}
		
		public int updateWebsite(int websiteId, Website website) {
			try {
				
				String q = "UPDATE website SET id=?, developer=?, name=?, description=?, visits=? WHERE id=" + websiteId;
				
				PreparedStatement ps = connection.prepareStatement(q);
				
				ps.setInt(1, website.getId());
			    ps.setInt(2, website.getDeveloperId());
			    ps.setString(3, website.getName());
			    ps.setString(4, website.getDescription());
			    ps.setInt(5, website.getVisits());
				

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
