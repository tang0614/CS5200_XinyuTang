package daos;
import java.util.Collection;

import models.Developer;

import java.sql.SQLException;
import java.util.Collection;


public interface DeveloperDao {
    void createDeveloper(Developer developer) throws SQLException, ClassNotFoundException;

    Collection<Developer> findAllDevelopers() throws SQLException, ClassNotFoundException;

    Developer findDeveloperById(int developerId) throws SQLException, ClassNotFoundException;

    Developer findDeveloperByUsername(String username) throws SQLException, ClassNotFoundException;

    Developer findDeveloperByCredentials(String username, String password) throws SQLException, ClassNotFoundException;

    int updateDeveloper(int developerId, Developer developer) throws SQLException, ClassNotFoundException;

    int deleteDeveloper(int developerId) throws SQLException, ClassNotFoundException;
}
