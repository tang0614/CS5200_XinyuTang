package daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.DB_connection;
import models.Page;
import models.Website;

public class PageDaolmpl {
	
	DB_connection obj_DB_connection = new DB_connection();
	Connection connection = obj_DB_connection.get_connection(); 
	
	public void createPageForWebsite(int websiteId, int page_id, String page_title,
String page_description,String page_created,String page_updated,int page_views)
 {
		
		try {
			
			String q = "insert into Website(websiteId, page_id, page_title,page_description" + 
					"page_created,page_updated,page_views)"
					+"values(?,?,?,?,?,?,?)";	
			
		
			PreparedStatement ps = connection.prepareStatement(q);
		
			
			ps.setInt(1,websiteId);
			ps.setInt(2,page_id);
			ps.setString(3,page_title);
			ps.setString(4,page_description);
			ps.setString(5,page_created);
			ps.setString(6,page_updated);
			ps.setInt(7,page_views);
	
		
			ps.execute();
			ps.close();

			
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
          	
			String page_description = rs.getString("page_description");
			String page_title = rs.getString("page_title");
			String page_created =rs.getString("page_created");
			String page_updated =rs.getString("page_updated");
			int page_views = rs.getInt("page_views");
			int websiteId = rs.getInt("websiteId");

			ps.execute();
			ps.close();
			
			return new Page(this, pageId, page_title,page_description,page_created,page_updated
					,page_views, websiteId);
			}catch(SQLException e) {
				System.out.println(e);
			}
		return null;
		
	}
	
	public Page findAllPage(int id) {
		try {
			
			String q = "select * from Page where page_id =" +id;	
			PreparedStatement ps = connection.prepareStatement(q);
            ResultSet rs = ps.executeQuery(q);
          	rs.next();
          	
          	String page_description = rs.getString("page_description");
			String page_title = rs.getString("page_title");
			String page_created =rs.getString("page_created");
			String page_updated =rs.getString("page_updated");
			int page_views = rs.getInt("page_views");
			int websiteId = rs.getInt("websiteId");
			
			
			ps.execute();
			ps.close();
			
			return new Page(this, id, page_title,page_description,page_created,page_updated
					,page_views, websiteId);
			
			}catch(SQLException e) {
				System.out.println(e);
			}
		return null;
		
	}
	
	public Collection<Page> findAllPages(){
		try {
		String q = "select * from Page";
		PreparedStatement ps = connection.prepareStatement(q);
        ResultSet rs = ps.executeQuery(q);
        Collection<Page> es = new ArrayList<Page>();
        
        while(rs.next()) {
        	int id = rs.getInt("id");
        	es.add(findAllPage(id));
        	
        	ps.execute();
			ps.close();
        }
		return es;
		}catch(SQLException e) {
			System.out.println(e);
		}return null;
   	
	}
	
	public Collection<Page> findPagesForWebsite(int websiteId){
		try {
			String q = "select * from Website where web_id =" + websiteId;
			PreparedStatement ps = connection.prepareStatement(q);
	        ResultSet rs = ps.executeQuery(q);
	        Collection<Page> es = new ArrayList<Page>();
	        
	        while(rs.next()) {
	        	int id = rs.getInt("id");
	        	es.add(findAllPage(id));
	        	ps.execute();
				ps.close();
	        }
			return es;
			}catch(SQLException e) {
				System.out.println(e);
			}return null;
	}
			
	public int updatePage(int websiteId, int page_id, String page_title,
			String page_description,String page_created,String page_updated,int page_views) {
		
		try {
			
			String q = "update Page set page_title=?, page_description=?, page_created=?,page_updated=?,"
					+ "page_views=?,websiteId=?, page_id=" + page_id;
			
			PreparedStatement ps = connection.prepareStatement(q);
			
		
			ps.setString(1,page_title);
			ps.setString(2,page_description);
			ps.setString(3,page_created);
			ps.setString(4,page_updated);
			ps.setInt(5,page_views);
			ps.setInt(6,websiteId);
	
				
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
