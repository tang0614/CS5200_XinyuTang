package daos;

import java.util.Collection;
import java.sql.SQLException;
import java.util.Collection;

import models.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import models.Website;

import models.Website;




public interface WebsiteDao {
    void createWebsiteForDeveloper(int developerId, Website website) throws SQLException, ClassNotFoundException;

    Collection<Website> findAllWebsites() throws SQLException, ClassNotFoundException;

    Collection<Website> findWebsitesForDeveloper(int developerId) throws SQLException, ClassNotFoundException;

    Website findWebsiteById(int websiteId) throws SQLException, ClassNotFoundException;

    int updateWebsite(int websiteId, Website website) throws SQLException, ClassNotFoundException;

    int deleteWebsite(int websiteId) throws SQLException, ClassNotFoundException;
}