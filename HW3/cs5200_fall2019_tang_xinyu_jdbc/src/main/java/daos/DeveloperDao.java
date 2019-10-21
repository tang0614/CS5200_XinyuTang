package daos;
import java.util.Collection;

import models.Developer;

public interface DeveloperDao {
	
	public void createDeveloper(int developer_id,String k,int id, String first_name, String last_name,
			String user_name,String password,String email);
	public Developer findAllDevelopers(int developer_id);
	public Developer findAllDeveloperByUserName(String user_name);
	public Developer findAllDeveloperByCredential(String user_name,String password);
	public Collection<Developer> findAllDevelopers();
	public int updateDeveloper(int developer_id,String k,int id, String first_name, String last_name,
			String user_name,String password,String email);
	public int deleteDeveloper(int developer_id);
		
}

