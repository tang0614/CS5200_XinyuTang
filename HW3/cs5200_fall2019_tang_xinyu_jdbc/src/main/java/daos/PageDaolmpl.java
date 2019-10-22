package daos;

import edu.northeastern.cs5200.DB_connection;
import java.sql.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import models.Page;


public class PageDaolmpl implements PageDao{
	
	DB_connection obj_DB_connection = new DB_connection();
	Connection connection = obj_DB_connection.get_connection(); 
	
	public void createPageForWebsite(int websiteId, Page page)
 {
		
		try {
			
			String q = "insert into page (id, website, title, description, created, updated, views) values (?,?,?,?,?,?,?)";	
			
		
			PreparedStatement ps = connection.prepareStatement(q);
		
			
			ps.setInt(1, page.getId());
	        ps.setInt(2, websiteId);
	        ps.setString(3, page.getTitle());
	        ps.setString(4, page.getDescription());
	        ps.setDate(5, page.getCreated());
	        ps.setDate(6, page.getUpdated());
	        ps.setInt(7, page.getViews());
		
	        ps.executeUpdate();

			
			}
			catch(SQLException e) {
				System.out.println(e);
			}
		
	}
	
	public Page findPageById(int pageId) {
		
		try {
			
			String q = "select * from Page where page_id =" +pageId;	
			PreparedStatement ps = connection.prepareStatement(q);
            ResultSet rs = ps.executeQuery(q);
          	rs.next();
          	
          	int id = rs.getInt("id");
            String title = rs.getString("title");
            String description = rs.getString("description");
            Date created = rs.getDate("created");
            Date updated = rs.getDate("updated");
            int views = rs.getInt("views");

            Page page = new Page(id, title, description, created, updated, views);

           
            return page;
			
	
			}catch(SQLException e) {
				System.out.println(e);
			}
		return null;
		
	}
	
	public Collection<Page> findAllPages(){
		try {
			List<Page> pages = new ArrayList<Page>();
			String q = "select * from Page" ;	
			PreparedStatement ps = connection.prepareStatement(q);
            ResultSet rs = ps.executeQuery(q);
          	rs.next();
          	
          	 while (rs.next()) {
                 int id = rs.getInt("id");
                 int websiteId = rs.getInt("website");
                 String title = rs.getString("title");
                 String description = rs.getString("description");
                 Date created = rs.getDate("created");
                 Date updated = rs.getDate("updated");
                 int views = rs.getInt("views");


                 Page page = new Page(id, title, description, created, updated, views);
                 page.setWebsiteId(websiteId);
                 pages.add(page);

             }
			
          	return pages;
			
			}catch(SQLException e) {
				System.out.println(e);
			}
		return null;
		
	}
	
	
	
	public Collection<Page> findPagesForWebsite(int websiteId){
		try {
			String q = "select * from Website where web_id =" + websiteId;
			PreparedStatement ps = connection.prepareStatement(q);
	        ResultSet rs = ps.executeQuery(q);
	        Collection<Page> pages = new ArrayList<Page>();
	        
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String title = rs.getString("title");
	            String description = rs.getString("description");
	            Date created = rs.getDate("created");
	            Date updated = rs.getDate("updated");
	            int views = rs.getInt("views");

	            Page page = new Page(id, title, description, created, updated, views);
	            pages.add(page);

	        }

	        return pages;
			}catch(SQLException e) {
				System.out.println(e);
			}return null;
	}
			
	public int updatePage(int pageId, Page page) {
		
		try {
			
			String q = "UPDATE page SET id=?, website=?, title=?, description=?, views=? WHERE id=" + pageId;
			
			PreparedStatement ps = connection.prepareStatement(q);
			ps.setInt(1, page.getId());
	        ps.setInt(2, page.getWebsiteId());
	        ps.setString(3, page.getTitle());
	        ps.setString(4, page.getDescription());
	        ps.setInt(5, page.getViews());

	        return ps.executeUpdate();
			
			
			}
			catch(SQLException e) {
				System.out.println(e);
			}
			return 0;	
	}
	
	
	public int deletePage(int page_id) {
			
		try {
			String q = "delete from Page where page_id = ?";
			PreparedStatement ps = connection.prepareStatement(q);
			ps.setInt(1,page_id);
			ps.executeUpdate();
			System.out.println("delete row ");
			return ps.executeUpdate();
		 }
				
		catch(SQLException e) {
			System.out.println(e);
		}return 0;
				
	}
	


	

}
