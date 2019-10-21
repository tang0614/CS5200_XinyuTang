package daos;

import java.util.Collection;

import models.Page;

public interface PageDao {
	public void createPageForWebsite(int websiteId, int page_id, String page_title,
			String page_description,String page_created,String page_updated,int page_views);
	public Page findPageById(int pageId);
	public Page findAllPage(int id);
	public Collection<Page> findAllPages();
	public Collection<Page> findPagesForWebsite(int websiteId);
	public int updatePage(int websiteId, int page_id, String page_title,
			String page_description,String page_created,String page_updated,int page_views);
	public int deletePage(int page_id);

}
