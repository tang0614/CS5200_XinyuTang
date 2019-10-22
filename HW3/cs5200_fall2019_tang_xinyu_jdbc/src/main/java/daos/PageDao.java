package daos;

import java.util.Collection;

import models.Page;

import java.sql.SQLException;
import java.util.Collection;

public interface PageDao {
    void createPageForWebsite(int websiteId, Page page) throws SQLException, ClassNotFoundException;

    Collection<Page> findAllPages() throws SQLException, ClassNotFoundException;

    Page findPageById(int pageId) throws SQLException, ClassNotFoundException;

    Collection<Page> findPagesForWebsite(int websiteId) throws SQLException, ClassNotFoundException;

    int updatePage(int pageId, Page page) throws SQLException, ClassNotFoundException;

    int deletePage(int pageId) throws SQLException, ClassNotFoundException;
}