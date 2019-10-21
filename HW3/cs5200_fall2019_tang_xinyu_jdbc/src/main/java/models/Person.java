package models;

public class Person {
	private int id;
	private String first_name;
	private String last_name;
	private String user_name;
	private String created;
	private String password;
	private String email;
	private String date;

	
	public Person(int id,String first_name,String last_name,String user_name,
			String created,String password,String email,String date) {
		
		this.id =id;
		this.first_name= first_name;
		this.last_name =last_name;
		this.user_name=user_name;
		this.created = created;
		this.password =password;
		this.email = email;
		this.date = date;
	}
	
	public void setFirstName(String first_name) {
		this.first_name= first_name;
	}
	public void setLastName(String last_name) {
		this.last_name =last_name;
		
	}
	public void setUserName(String user_name) {
		this.user_name=user_name;	
	}
	public void setPassword(String password) {
		this.password =password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDate(String date) {
		this.date=date;	
	}

	public int getID() {
		return id;
	}
	
}
