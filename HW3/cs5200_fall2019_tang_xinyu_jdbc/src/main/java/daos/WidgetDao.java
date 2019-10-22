package daos;

import java.util.Collection;
import java.sql.SQLException;
import java.util.Collection;

import models.Widget;

public interface WidgetDao {
    void createWidgetForPage(int pageId, Widget widget) throws SQLException, ClassNotFoundException;

    Collection<Widget> findAllWidgets() throws SQLException, ClassNotFoundException;

    Widget findWidgetById(int widgetId) throws SQLException, ClassNotFoundException;

    Collection<Widget> findWidgetsForPage(int pageId) throws SQLException, ClassNotFoundException;

    int updateWidget(int widgetId, Widget widget) throws SQLException, ClassNotFoundException;

    int deleteWidget(int widgetId) throws SQLException, ClassNotFoundException;
}