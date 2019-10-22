package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.northeastern.cs5200.DB_connection;

import java.sql.SQLException;

public interface RoleDao {
    void assignWebsiteRole(int developerId, int websiteId, String role) throws SQLException, ClassNotFoundException;

    void assignPageRole(int developerId, int pageId, String role) throws SQLException, ClassNotFoundException;

    void deleteWebsiteRole(int developerId, int websiteId, String role) throws SQLException, ClassNotFoundException;

    void deletePageRole(int developerId, int pageId, String role) throws SQLException, ClassNotFoundException;
}