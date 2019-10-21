package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.DB_connection;
import models.Website;
import models.Widget;

public class WidgetDaolmpl {

	DB_connection obj_DB_connection = new DB_connection();
	Connection connection = obj_DB_connection.get_connection(); 
	
	public void createWidgetForPage(int id, String name, int width, int height,String cssClass, String cssStyle,
			String text, int order, int page_id) {
		
		try {
			
			String q = "insert into Website(id,name,width,height,visits,cssClass,cssStyle,"
					+ "text,order,page_id"
					+"values(?,?,?,?,?,?,?,?,?,?)";	
			
			PreparedStatement ps = connection.prepareStatement(q);
		

			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setInt(3,width);
			ps.setInt(4,height);
			ps.setString(5,cssClass);
			ps.setString(6,cssStyle);
			ps.setString(7,text);
			ps.setInt(8,order);
			ps.setInt(9,page_id);
	
		
			ps.execute();
			ps.close();

			
			}
			catch(SQLException e) {
				System.out.println(e);
			}
			
		
	}
	
	public Widget findWidgetById(int widgetId) {
		
		try {
			
			String q = "select * from Widget where id =" + widgetId;	
			PreparedStatement ps = connection.prepareStatement(q);
            ResultSet rs = ps.executeQuery(q);
          	rs.next();
        
    
			String name = rs.getString("name");
			int width = rs.getInt("width");
			int height =rs.getInt("height");
			String cssClass= rs.getString("cssClass");
			String cssStyle= rs.getString("cssStyle");
			String text = rs.getString("text");
			int order  = rs.getInt("order");
			int page_id = rs.getInt("page_id");

			ps.execute();
			ps.close();
			
			return new Widget(this, widgetId, name, width, height, cssClass, cssStyle,text,order, page_id);
			}catch(SQLException e) {
				
				System.out.println(e);
			}
		return null;
		
	}
	
	public Widget findAllWidget(int id) {
		try {
			
			String q = "select * from Widget where id =" +id;	
			PreparedStatement ps = connection.prepareStatement(q);
            ResultSet rs = ps.executeQuery(q);
          	rs.next();
          	
          	String name = rs.getString("name");
			int width = rs.getInt("width");
			int height =rs.getInt("height");
			String cssClass= rs.getString("cssClass");
			String cssStyle= rs.getString("cssStyle");
			String text = rs.getString("text");
			int order  = rs.getInt("order");
			int page_id = rs.getInt("page_id");
			
			
			ps.execute();
			ps.close();
			
			return new Widget(this,id, name, width, height, cssClass, cssStyle,text,order, page_id);
			
			}catch(SQLException e) {
				System.out.println(e);
			}
		return null;
		
	}
	
	public Collection<Widget> findAllWigets(){
		try {
		String q = "select * from Widgets";
		PreparedStatement ps = connection.prepareStatement(q);
        ResultSet rs = ps.executeQuery(q);
        Collection<Widget> es = new ArrayList<Widget>();
        
        while(rs.next()) {
        	int id = rs.getInt("id");
        	es.add(findAllWidget(id));
        	ps.execute();
			ps.close();
        }
		return es;
		}catch(SQLException e) {
			System.out.println(e);
		}return null;
   	
	}
	
	public Collection<Widget> findWidgetsForPage(int page_id){
		try {
		String q = "select * from Widget where page_id =" + page_id;
		PreparedStatement ps = connection.prepareStatement(q);
        ResultSet rs = ps.executeQuery(q);
        Collection<Widget> es = new ArrayList<Widget>();
        
        while(rs.next()) {
        	int id = rs.getInt("id");
        	es.add(findAllWidget(id));
        	ps.execute();
			ps.close();
        }
		return es;
		}catch(SQLException e) {
			System.out.println(e);
		}return null;
   	
	}
	
	public int updateWidget(int id, String name, int width, int height,String cssClass, String cssStyle,
			String text, int order, int page_id) {
		try {
			
			String q = "update Widget set name=?, width=?, height=?,cssClass=?,cssStyle=?,text=?,order=?,page_id=?"
					+ "id=" + id;
			
			PreparedStatement ps = connection.prepareStatement(q);
			

			ps.setString(1,name);
			ps.setInt(2,width);
			ps.setInt(3,height);
			ps.setString(4,cssClass);
			ps.setString(5,cssStyle);
			ps.setString(6,text);
			ps.setInt(7,order);
			ps.setInt(8,page_id);
			

			return ps.executeUpdate();
			}
			catch(SQLException e) {
				System.out.println(e);
			}
			return 0;	
	}
	
	public int deleteWidget(int Id) {
		
		try {
			String q = "delete from Widget where id = ?";
			PreparedStatement ps = connection.prepareStatement(q);
			ps.setInt(1,Id);
	        ps.executeUpdate();
	        System.out.println("delete row with the websiteId");
	        return ps.executeUpdate();
			}
		
			catch(SQLException e) {
				System.out.println(e);
			}return 0;
		
	}

	
	
	
	
	


}
