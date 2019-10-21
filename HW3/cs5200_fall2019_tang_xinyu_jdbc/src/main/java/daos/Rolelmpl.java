package daos;

public interface Rolelmpl {
	public void assignWebsiteRole(int developerId, int websiteId, int roleId);
	public void assignPageRole(int developerId, int pageId, int roleId);
	public void deleteWebsiteRole(int developerId, int websiteId, int roleId);
	public void deletePageRole(int developerId, int pageId, int roleId);


}
