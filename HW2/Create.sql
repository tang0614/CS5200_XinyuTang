
	CREATE TABLE person (
		id INT(8) NOT NULL  PRIMARY KEY AUTO_INCREMENT,   
		first_name VARCHAR(250) NOT NULL, 
		last_name VARCHAR(250) NOT NULL,
		username VARCHAR(250) NOT NULL,
		password VARCHAR(250) NOT NULL,
		email VARCHAR(250),
		dob DATE
	);
	


	CREATE TABLE user (
		id INT(8) NOT NULL  PRIMARY KEY AUTO_INCREMENT,   
		person INT(8),
		user_agreement BOOL
	);
	

	ALTER TABLE user ADD CONSTRAINT user_person_generalization 
	    FOREIGN KEY (person) REFERENCES person(id);
			
	

	
	CREATE TABLE developer (
		id INT(8) NOT NULL  PRIMARY KEY AUTO_INCREMENT,   
		person INT(8),
		developer_key VARCHAR(250)
	);
	

	ALTER TABLE developer ADD CONSTRAINT developer_person_generalization 
	    FOREIGN KEY (person) REFERENCES person(id);
			
	


	CREATE TABLE website (
		id INT(8) NOT NULL  PRIMARY KEY AUTO_INCREMENT,   
		developer INT(8),
		name VARCHAR(250) NOT NULL,
		description VARCHAR(250),
		created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
		updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
		visits INT(8) DEFAULT 0
	);
	

	ALTER TABLE website ADD CONSTRAINT website_developer_aggregation
	    FOREIGN KEY (developer) REFERENCES developer(id);
			

	CREATE TABLE page (
		id INT(8) NOT NULL  PRIMARY KEY AUTO_INCREMENT,   
		website INT(8),
		title VARCHAR(250) NOT NULL,
		description VARCHAR(250),
		created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
		updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
		views INT(8) DEFAULT 0
	);
	

	ALTER TABLE page ADD CONSTRAINT page_website_composition
	    FOREIGN KEY (website) REFERENCES website(id)
			ON DELETE CASCADE;
			
	
	CREATE TABLE widget (
		id INT(8) NOT NULL  PRIMARY KEY AUTO_INCREMENT,   
		page INT(8),
		name VARCHAR(250) NOT NULL,
		width INT(8),
		height INT(8),
		css_class VARCHAR(250),
		css_style VARCHAR(250),
		text VARCHAR(250),
		widget_order INT(8),
		dtype VARCHAR(250) NOT NULL,
		youtube_url VARCHAR(250),
		youtube_shareble BOOL,
		youtube_expandable BOOL,
		image_src VARCHAR(25),
		heading_size INT(8) DEFAULT 2,
		html_html VARCHAR(25)
	);
	

	ALTER TABLE widget
	ADD CONSTRAINT widget_page_composition
	FOREIGN KEY (`page`) REFERENCES page (id)
	ON DELETE CASCADE;
			

	CREATE TABLE phone (
		id INT(8) NOT NULL  PRIMARY KEY AUTO_INCREMENT,   
		person INT(8),
		phone VARCHAR(25) NOT NULL,
		phone_primary BOOL
	);
	

	ALTER TABLE phone ADD CONSTRAINT phone_person_composition
	    FOREIGN KEY (person) REFERENCES person(id);
			
	 
	CREATE TABLE address (
		id INT(8) NOT NULL  PRIMARY KEY AUTO_INCREMENT,   
		person INT(8),
		street1 VARCHAR(250),
		street2 VARCHAR(250),
		city VARCHAR(250),
		state VARCHAR(250),
		zip VARCHAR(250),
		address_primary BOOL
	);
	

	ALTER TABLE address ADD CONSTRAINT address_person_composition
	    FOREIGN KEY (person) REFERENCES person(id);
			
	
	CREATE TABLE role (
		name VARCHAR(250) NOT NULL DEFAULT '',
	 PRIMARY KEY (name)	
	);
	

	
	CREATE TABLE priviledge (
		name VARCHAR(250) NOT NULL DEFAULT '',
		PRIMARY KEY(name)
	);
	

			
	CREATE TABLE website_role (
		id INT(8) NOT NULL  PRIMARY KEY AUTO_INCREMENT,   
		role VARCHAR(250) DEFAULT NULL,
		developer INT(8),
		website INT(8),
		FOREIGN KEY (role) REFERENCES role (name),
		FOREIGN KEY (developer) REFERENCES developer (id),
		FOREIGN KEY (website) REFERENCES website (id) ON DELETE CASCADE;
	);
			
	CREATE TABLE website_priviledge (
		id INT(8) NOT NULL  PRIMARY KEY AUTO_INCREMENT,   
		priviledge VARCHAR(250) DEFAULT NULL,
		developer INT(8),
		website INT(8),
		FOREIGN KEY (priviledge) REFERENCES priviledge (name),
		FOREIGN KEY (developer) REFERENCES developer (id),
		FOREIGN KEY (website) REFERENCES website (id) ON DELETE CASCADE
	);
	

	
	CREATE TABLE page_role (
		id INT(8) NOT NULL  PRIMARY KEY AUTO_INCREMENT,   
		role VARCHAR(250) DEFAULT NULL,
		developer INT(8),
		page INT(8),
		FOREIGN KEY (role) REFERENCES role (name),
		FOREIGN KEY (developer) REFERENCES developer (id),
		FOREIGN KEY (page) REFERENCES page (id) ON DELETE CASCADE
	);
	

	CREATE TABLE page_priviledge (
		id INT(8) NOT NULL  PRIMARY KEY AUTO_INCREMENT,   
		priviledge VARCHAR(250) DEFAULT NULL,
		developer INT(8),
		page INT(8),
		FOREIGN KEY (priviledge) REFERENCES priviledge (name),
		FOREIGN KEY (developer) REFERENCES developer (id),
		FOREIGN KEY (page) REFERENCES page (id)
	);


	insert into priviledge(name) values ('create');
	insert into priviledge(name) values ('read');
	insert into priviledge(name) values ('update');
	insert into priviledge(name) values ('delete');


	insert into role(name) values ('owner');
	insert into role(name) values ('admin');
	insert into role(name) values ('writer');
	insert into role(name) values ('editor');
	insert into role(name) values ('reviewer');
	
