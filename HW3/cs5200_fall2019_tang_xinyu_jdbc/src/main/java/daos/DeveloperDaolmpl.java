package daos;

import java.sql.Connection;
import models.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import models.Developer;


import edu.northeastern.cs5200.DB_connection;


public class DeveloperDaolmpl implements DeveloperDao{

	
	DB_connection obj_DB_connection = new DB_connection();
	Connection connection = obj_DB_connection.get_connection(); 
	
	
	
	public void createDeveloper(Developer developer){
		try {
		Person person = developer.getPerson();
		String q_person = "insert into person (first_name, last_name, username, password, email, dob) values (?,?,?,?,?,?)";;	
		PreparedStatement ps = connection.prepareStatement(q_person);
	
		
		ps.setString(1, person.getFirstName());
        ps.setString(2, person.getLastName());
        ps.setString(3, person.getUsername());
        ps.setString(4, person.getPassword());
        ps.setString(5, person.getEmail());
        ps.setDate(6, person.getDob());

	
		ps.execute();
		ps.close();

		
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
	
		
	}
	
	public Collection<Developer> findAllDevelopers() {
		
		List<Developer> developers = new ArrayList<Developer>();
		
		try {
			
			String q = "select * from Developer ";	
			PreparedStatement ps = connection.prepareStatement(q);
			
            ResultSet rs = ps.executeQuery(q);
          	
            
 
            while (rs.next()) {
            	
            }
                int id = rs.getInt("id");
                int personId = rs.getInt("person");
                String developer_Key = rs.getString("developer_key");

                
                Person person = new Person();
                
                String sql = "select * from person where id =" + personId;
                
                
                PreparedStatement psPerson = connection.prepareStatement(sql);
                ResultSet ResultSet2 = psPerson.executeQuery();

                if (ResultSet2.next()) {
                	person.setFirstName(ResultSet2.getString("first_name"));
                	person.setLastName(ResultSet2.getString("last_name"));
                	person.setUsername(ResultSet2.getString("username"));
                	person.setPassword(ResultSet2.getString("password"));
                	person.setEmail(ResultSet2.getString("email"));
                	person.setDob(ResultSet2.getDate("dob"));
                }
                
            Developer developer = new Developer(id, developer_Key, person);
            developers.add(developer);
			ps.close();
			
			return developers;
			}catch(SQLException e) {
				System.out.println(e);
			}
		return null;
		
	}
	
	
	public Developer findAllDeveloperByUserName(String user_name) {
		try {
			
			String q = "select * from Developer where user_name =" +user_name;	
			PreparedStatement ps = connection.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
          
            int personId = rs.getInt("id");
            
            Person person = new Person();
            person.setFirstName(rs.getString("first_name"));
            person.setLastName(rs.getString("last_name"));
            person.setUsername(rs.getString("email"));
            person.setDob(rs.getDate("dob"));
            
            
            String q2 = "select * from Developer where person =" +personId;	
            PreparedStatement ps2 = connection.prepareStatement(q);
            ResultSet rs2 = ps2.executeQuery();
            
            int id = rs.getInt("id");
            String developer_Key = rs.getString("developer_key");
            Developer developer = new Developer(id, developer_Key, person);
            
            return developer;
		
			
			}catch(SQLException e) {
				System.out.println(e);
			}
		return null;
		
	}
	
	public Developer findAllDeveloperByCredential(String user_name,String password) {
		try {
			
			String q = "select * from Developer where user_name =" +user_name+
					"and password =" +password;	
			PreparedStatement ps = connection.prepareStatement(q);
            ResultSet rs = ps.executeQuery(q);
            
            int personId = rs.getInt("id");

            Person person = new Person();
            person.setFirstName(rs.getString("first_name"));
            person.setLastName(rs.getString("last_name"));
            person.setUsername(rs.getString("username"));
            person.setEmail(rs.getString("email"));
            person.setPassword(password);
            person.setDob(rs.getDate("dob"));

            String q2 = "select * from Developer where person =" +personId;
            PreparedStatement ps2 = connection.prepareStatement(q);
            ResultSet rs2 = ps2.executeQuery();
            
            int id = rs.getInt("id");
            String developer_Key = rs.getString("developer_key");
            Developer developer = new Developer(id, developer_Key, person);
            
            return developer;
		
			
			}catch(SQLException e) {
				System.out.println(e);
			}
		return null;
		
	}
	
	
	
	public int updateDeveloper(int developer_id, Developer developer){
		try {
			
		String q = "update Developer set k=?, id=?, first_name=?,last_name=?,"
				+ "user_name=?, password=?,email=? where developer_id =" + developer_id;
		
		PreparedStatement ps = connection.prepareStatement(q);
		Person person = developer.getPerson();
		ps.setInt(1, person.getId());
        ps.setString(2, person.getFirstName());
        ps.setString(3, person.getLastName());
        ps.setString(4, person.getUsername());
        ps.setString(5, person.getPassword());
        ps.setString(6, person.getEmail());
        ps.setDate(7, person.getDob());
        ps.setInt(8, person.getId());

        ps.executeUpdate();
        
        
        String SQL_UPDATE_DEVELOPER = "UPDATE developer SET id=?, person=?, developer_key=? WHERE id=?";
        PreparedStatement psUpdateDeveloper = connection.prepareStatement(SQL_UPDATE_DEVELOPER);
        psUpdateDeveloper.setInt(1, developer.getId());
        psUpdateDeveloper.setInt(2, developer.getPerson().getId());
        psUpdateDeveloper.setString(3, developer.getDeveloperKey());
        psUpdateDeveloper.setInt(4, developer_id);

        psUpdateDeveloper.executeUpdate();

		return developer_id;
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return 0;	
	}
	
	
	
	public int deleteDeveloper(int developer_id) {
		try {
			String q = "delete from Developer where developer_id = ?";
			PreparedStatement ps = connection.prepareStatement(q);
			ps.setInt(1,developer_id);
	        ps.executeUpdate();
	        System.out.println("delete row with the developer_id");
	        return ps.executeUpdate();
			}
		
			catch(SQLException e) {
				System.out.println(e);
			}return 0;
		
	}

	@Override
	public Developer findDeveloperById(int developerId) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Developer findDeveloperByUsername(String username) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Developer findDeveloperByCredentials(String username, String password)
			throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
