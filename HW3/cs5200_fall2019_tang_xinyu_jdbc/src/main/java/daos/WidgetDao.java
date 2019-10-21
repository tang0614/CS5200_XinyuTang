package daos;

import java.util.Collection;

import models.Widget;

public interface WidgetDao {
	public void createWidgetForPage(int id, String name, int width, int height,String cssClass, String cssStyle,
			String text, int order, int page_id);
	public Widget findWidgetById(int widgetId);
	public Widget findAllWidget(int id);
	public Collection<Widget> findAllWigets();
	public Collection<Widget> findWidgetsForPage(int page_id);
	public int updateWidget(int id, String name, int width, int height,String cssClass, String cssStyle,
			String text, int order, int page_id);
	public int deleteWidget(int Id);
}
