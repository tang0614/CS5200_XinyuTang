
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
import models.Widget;
import models.WidgetType;



public class WidgetDaolmpl implements WidgetDao{

	DB_connection obj_DB_connection = new DB_connection();
	Connection connection = obj_DB_connection.get_connection(); 
	
	public void createWidgetForPage(int pageId, Widget widget) {
		
		try {
			
			String q = "insert into widget (id, page, name, width, height, css_class, css_style, text, widget_order," +
	                " dtype) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			
			PreparedStatement ps = connection.prepareStatement(q);
		

			ps.setInt(1, widget.getId());
	        ps.setInt(2, pageId);
	        ps.setString(3, widget.getName());
	        ps.setInt(4, widget.getWidth());
	        ps.setInt(5, widget.getHeight());
	        ps.setString(6, widget.getCssClass());
	        ps.setString(7, widget.getCssStyle());
	        ps.setString(8, widget.getText());
	        ps.setInt(9, widget.getOrder());
	        ps.setString(10, widget.getType().name());
	        

	        ps.executeUpdate();

			
			}
			catch(SQLException e) {
				System.out.println(e);
			}
			
		
	}
	
	public Widget findWidgetById(int widgetId) {
		String q = "select * from widget where id=" + widgetId;
		
		
		try {
			PreparedStatement ps = connection.prepareStatement(q);
	        ResultSet rs = ps.executeQuery();
			int id = rs.getInt("id");
	        int pageId = rs.getInt("page");
	        int width = rs.getInt("width");
	        int height = rs.getInt("height");
	        int order = rs.getInt("widget_order");
	        String name = rs.getString("name");
	   
	        String cssClass = rs.getString("css_class");
	        String cssStyle = rs.getString("css_style");
	        String text = rs.getString("text");
	        WidgetType type = WidgetType.valueOf(rs.getString("dtype"));
	       

	        Widget widget = new Widget(id, name, width, height, cssStyle, cssClass,text,order);
	        widget.setPageId(pageId);
			
			return widget;
			}catch(SQLException e) {
				
				System.out.println(e);
			}
		return null;
		
	}
	
	public Collection<Widget> findAllWidgets() {
		List<Widget> widgets = new ArrayList<Widget>();
		String q = "select * from widget";
		

		try {
			PreparedStatement ps = connection.prepareStatement(q);
	        ResultSet rs = ps.executeQuery();
			while (rs.next()) {
	            int id = rs.getInt("id");
	            int pageId = rs.getInt("page");
	            int width = rs.getInt("width");
	            int height = rs.getInt("height");
	            int order = rs.getInt("widget_order");
	            
	            String name = rs.getString("name");
	            String cssClass = rs.getString("css_class");
	            String cssStyle = rs.getString("css_style");
	            String text = rs.getString("text");
	         
	            WidgetType type = WidgetType.valueOf(rs.getString("dtype"));
	           

	            Widget widget = new Widget(id, name, width, height, cssStyle, cssClass,
	                    text, order);
	            widget.setPageId(pageId);
	            widgets.add(widget);

	           
	        }
			
			return widgets;
			
			}catch(SQLException e) {
				System.out.println(e);
			}
		return null;
		
	}
	
	
	public Collection<Widget> findWidgetsForPage(int page_id){
		try {
		String q = "select * from Widget where page_id =" + page_id;
		PreparedStatement ps = connection.prepareStatement(q);
        ResultSet rs = ps.executeQuery(q);
        Collection<Widget> widgets = new ArrayList<Widget>();
        
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int width = rs.getInt("width");
            int height = rs.getInt("height");
            String cssClass = rs.getString("css_class");
            String cssStyle = rs.getString("css_style");
            String text = rs.getString("text");
            int order = rs.getInt("widget_order");
            WidgetType type = WidgetType.valueOf(rs.getString("dtype"));
            

            Widget widget = new Widget(id, name, width, height, cssStyle, cssClass,
                    text, order);
            widget.setPageId(page_id);
            widgets.add(widget);
		
        }
		return  widgets;
		}catch(SQLException e) {
			System.out.println(e);
		}return null;
   	
	}
	
	public int updateWidget(int widgetId, Widget widget) {
		try {
			
			String q = "UPDATE widget SET id=?, page=?, name=?, width=?, height=?, css_class=?, css_style=?, text=?, widget_order=?," +
                    "dtype=? WHERE id=" + widgetId;
			
			PreparedStatement ps = connection.prepareStatement(q);
			

			ps.setInt(1, widget.getId());
	        ps.setInt(2, widget.getPageId());
	        ps.setString(3, widget.getName());
	        ps.setInt(4, widget.getWidth());
	        ps.setInt(5, widget.getHeight());
	        ps.setString(6, widget.getCssClass());
	        ps.setString(7, widget.getCssStyle());
	        ps.setString(8, widget.getText());
	        ps.setInt(9, widget.getOrder());
	        ps.setString(10, widget.getType().name());


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
