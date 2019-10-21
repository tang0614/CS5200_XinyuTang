package models;

import java.util.Collection;

import daos.DeveloperDaolmpl;

public class Developer{
	private int developer_id;
	private String key;
	private Address ad;
	private Phone ph;
	private DeveloperDaolmpl dao;
	protected enum Role {
		owner, admin, writer, editor,reviewer;
	}
	
	
	public Developer(DeveloperDaolmpl dao, int id, String first_name, String last_name, String user_name, String created, String password,
			String email, String date, int developer_id, String key) {
		super();
		this.dao =dao;
		this.developer_id=developer_id;
		this.key = key;
		
	
	
	}

	
	
	
public Developer(int id, String first_name, String last_name, String user_name, String created, String password,			
		String email, String date, int developer_id, String key, Address ad, Phone ph) {
		super();
		this.developer_id = developer_id;
		this.key = key;
		this.ad = new Address();
		this.ph =new Phone();
		

}
	
	
}