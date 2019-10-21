package models;

import daos.PageDaolmpl;

public class Page{
	private int page_id;
	private String page_title;
	private String page_description;
	private String page_created;
	private String page_updated;
	private int page_views;
	private int web_id;

	public Page(PageDaolmpl dao, int page_id, String page_title,String page_description,String page_created,String page_updated
			,int page_views, int web_id) {
		
		this.page_id =page_id;
		this.page_description = page_description;
		this.page_created = page_created;
		this.page_updated = page_updated;
		this.page_views=page_views;
		this.web_id = web_id;
		
	}
}


