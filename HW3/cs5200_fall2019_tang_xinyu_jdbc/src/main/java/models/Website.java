package models;

import daos.WebsiteDaolmpl;

public class Website {
	private int id;
	private String name;
	private String description;
	private String created;
	private String updated;
	private int visits;
	private int developer_id;
	private Page pages;
	private WebsiteDaolmpl dao;
	
	
	//constructor
	public Website(WebsiteDaolmpl dao,int id,String name,String description,String created,String updated,int visits, Page pages,
			int developer_id)
	{
		this.dao =dao;
		this.id = id;
		this.description = description;
		this.name=name;
		this.created=created;
		this.updated = updated;
		this.visits = visits;
		this.pages = pages;
		this.developer_id=developer_id;
		
	}
	
	
	

}
