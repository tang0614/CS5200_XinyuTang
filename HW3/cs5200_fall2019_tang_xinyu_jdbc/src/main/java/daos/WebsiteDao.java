package daos;

import java.util.Collection;

import models.Website;

public interface WebsiteDao {

	public void createWebsiteForDeveloper(int id,String description,String created,String updated,
			int visits, int developer_id);
	public Website findWebsiteById(int websiteId);
	public Website findAllWebsites(int id);
	public Collection<Website> findAllWebsites();
	public Collection<Website> findWebsitesForDeveloper(int developer_id);
	public int updateWebsite(int id,String description,String created,String updated,
			int visits, int developer_id);
	public int deleteWebsite(int websiteId);
}
