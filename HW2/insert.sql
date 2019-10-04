INSERT INTO person(username, password, first_name, last_name, email) 
	VALUES('alice', 'alice', 'Alice', 'Wonder', 'alice@wonder.com')


INSERT INTO developer(id, developer_key, person)
  VALUES(12, '4321rewq', (
  	SELECT id FROM person WHERE username = 'alice'));
	
INSERT INTO person(username, password, first_name, last_name, email) 
	VALUES('bob', 'bob', 'Bob', 'Marley', 'bob@marley.com')


INSERT INTO developer(id, developer_key, person)
  VALUES(23, '5432trew', 
  	(SELECT id FROM person WHERE username = 'bob'));
	
INSERT INTO person(username, password, first_name, last_name, email) 
	VALUES('charlie', 'charlie', 'Charles', 'Garcia', 'chuch@garcia.com')


INSERT INTO developer(id, developer_key, person)
  VALUES(34, '6543ytre', 
  	(SELECT id FROM person WHERE username = 'charlie'));
	
INSERT INTO person(username, password, first_name, last_name, email) 
	VALUES('dan', 'dan', 'Dan', 'Martin', 'dan@martin.com')


INSERT INTO user(id, person)
  VALUES(45, 
  	(SELECT id FROM person WHERE username = 'dan'));
	
INSERT INTO person(username, password, first_name, last_name, email) 
	VALUES('ed', 'ed', 'Ed', 'Karaz', 'ed@kar.com')


INSERT INTO user(id, person)
  VALUES(56, 
  	(SELECT id FROM person WHERE username = 'ed'));








	

ALTER TABLE address ADD CONSTRAINT address_person_composition
    FOREIGN KEY (person) REFERENCES person(id);
		
INSERT INTO phone(person, phone, phone_primary)
	VALUES(
		(SELECT id FROM person WHERE username = 'alice'),
		 '123-234-3456', true);	

INSERT INTO phone(person, phone, phone_primary)
	VALUES(
		(SELECT id FROM person WHERE username = 'bob'),
		 '345-456-5677', true);	
	
INSERT INTO phone(person, phone, phone_primary)
	VALUES(
		(SELECT id FROM person WHERE username = 'charlie'), 
		'321-432-5435', true);	
	
INSERT INTO phone(person, phone, phone_primary)
	VALUES(
		(SELECT id FROM person WHERE username = 'charlie'), 
		'432-432-5433', false);

INSERT INTO phone(person, phone, phone_primary)
	VALUES(
		(SELECT id FROM person WHERE username = 'alice'), 
		'234-34-4566', false);

INSERT INTO phone(person, phone, phone_primary)
	VALUES(
		(SELECT id FROM person WHERE username = 'charlie'), 
		'543-543-6544', false);	
	



INSERT INTO website(id, developer, name, description, visits)
  VALUES(123, 12, 'Facebook', 'an online social media and social networking service', 1234234)


INSERT INTO website_role(role, developer, website)
	VALUES('owner', 12, 123);
	
INSERT INTO website_role(role, developer, website)
	VALUES('editor', 23, 123);
	
INSERT INTO website_role(role, developer, website)
	VALUES('admin', 34, 123);
	
	
INSERT INTO website(id, developer, name, description, visits)
  VALUES(234, 23, 'Twitter', 'an online news and social', 4321543)


INSERT INTO website_role(role, developer, website)
	VALUES('owner', 23, 234);


INSERT INTO website_role(role, developer, website)
	VALUES('editor', 34, 234);
	
INSERT INTO website_role(role, developer, website)
	VALUES('admin', 12, 234);
	
INSERT INTO website(id, developer, name, description, visits)
  VALUES(345, 34, 'Wikipedia', 'a free online encyclopedia', 3456654)


INSERT INTO website_role(role, developer, website)
	VALUES('owner', 34, 345);


INSERT INTO website_role(role, developer, website)
	VALUES('editor', 12, 345);
	
INSERT INTO website_role(role, developer, website)
	VALUES('admin', 23, 345);	
	
INSERT INTO website(id, developer, name, description, visits)
  VALUES(456, 12, 'CNN', 'an American basic cable and satellite television news channel', 6543345)


INSERT INTO website_role(role, developer, website)
	VALUES('owner', 12, 456);


INSERT INTO website_role(role, developer, website)
	VALUES('editor', 23, 456);
	
INSERT INTO website_role(role, developer, website)
	VALUES('admin', 34, 456);		
	
INSERT INTO website(id, developer, name, description, visits)
  VALUES(567, 23, 'CNNET', 'an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics', 5433455)


INSERT INTO website_role(role, developer, website)
	VALUES('owner', 23, 567);


INSERT INTO website_role(role, developer, website)
	VALUES('editor', 34, 567);
	
INSERT INTO website_role(role, developer, website)
	VALUES('admin', 12, 567);
	
INSERT INTO website(id, developer, name, description, visits)
  VALUES(678, 34, 'Gizmodo', 'a design, technology, science and science fiction website that also writes articles on politics', 4322345)


INSERT INTO website_role(role, developer, website)
	VALUES('owner', 34, 678);


INSERT INTO website_role(role, developer, website)
	VALUES('editor', 12, 678);
	
INSERT INTO website_role(role, developer, website)
	VALUES('admin', 23, 678);	
	
	
	

INSERT INTO page(id, website, title, description, views)
  VALUES(123, 567, 'Home', 'Landing page', 123434)


INSERT INTO page_role(role, developer, page)
	VALUES('editor', 12, 123);
	
INSERT INTO page_role(role, developer, page)
	VALUES('reviewer', 23, 123);


INSERT INTO page_role(role, developer, page)
	VALUES('writer', 34, 123);


INSERT INTO page(id, website, title, description, views)
  VALUES(234, 678, 'About', 'Website descriptio', 234545)


INSERT INTO page_role(role, developer, page)
	VALUES('editor', 23, 234);
	
INSERT INTO page_role(role, developer, page)
	VALUES('reviewer', 34, 234);


INSERT INTO page_role(role, developer, page)
	VALUES('writer', 12, 234);


INSERT INTO page(id, website, title, description, views)
  VALUES(345, 345, 'Contact', 'Addresses, phones, and contact info', 345656)


INSERT INTO page_role(role, developer, page)
	VALUES('editor', 34, 345);
	
INSERT INTO page_role(role, developer, page)
	VALUES('reviewer', 12, 345);


INSERT INTO page_role(role, developer, page)
	VALUES('writer', 23, 345);
	
INSERT INTO page(id, website, title, description, views)
  VALUES(456, 456, 'Preferences', 'Where users can configure their preferences', 456776)


INSERT INTO page_role(role, developer, page)
	VALUES('editor', 12, 456);
	
INSERT INTO page_role(role, developer, page)
	VALUES('reviewer', 23, 456);


INSERT INTO page_role(role, developer, page)
	VALUES('writer', 34, 456);	
	
INSERT INTO page(id, website, title, description, views)
  VALUES(567, 567, 'Profile', 'Users can configure their personal informatio', 567878)


INSERT INTO page_role(role, developer, page)
	VALUES('editor', 23, 567);
	
INSERT INTO page_role(role, developer, page)
	VALUES('reviewer', 34, 567);


INSERT INTO page_role(role, developer, page)
	VALUES('writer', 12, 567);	
	


ALTER TABLE widget ADD CONSTRAINT widget_page_composition
    FOREIGN KEY (page) REFERENCES page(id);


INSERT INTO widget(id, page, name, dtype, text, widget_order, width, height, youtube_url)
	VALUES(678, 456, 'video456', 'youtube', null, 0, 400, 300, 'https://youtu.be/h67VX51QXiQ');	
INSERT INTO widget(id, page, name, dtype, text, widget_order, width, height, image_src)
	VALUES(567, 345, 'image345', 'image', null, 3, 50, 100, '/img/567.png');	
	
INSERT INTO widget(id, page, name, dtype, text, widget_order)
	VALUES(456, 345, 'intr456', 'html', '<h1>Hi</h1>', 2);	

INSERT INTO widget(id, page, name, dtype, text, widget_order)
	VALUES(345, 345, 'head345', 'heading', 'Hi', 1);	


INSERT INTO widget(id, page, name, dtype, text, widget_order)
	VALUES(234, 234, 'post234', 'html', '<p>Lorem</p>', 0);	



INSERT INTO widget(id, page, name, dtype, text, widget_order)
	VALUES(123, 123, 'head123', 'heading', 'Welcome', 0);	
	


		
CREATE TABLE address (
	id INT(8) NOT NULL  PRIMARY KEY AUTO_INCREMENT,   
	person INT(8),
	street1 VARCHAR(250),
	street2 VARCHAR(250),
	city VARCHAR(250),
	state VARCHAR(20),
	zip VARCHAR(250),
	address_primary BOOL
);


INSERT INTO address(person, street1, street2, city, zip, address_primary)
	VALUES((SELECT id FROM person WHERE username = 'alice'), 
		'123 Adam St.', null, 'Alton', '01234', true);	
		
INSERT INTO address(person, street1, street2, city, zip, address_primary)
	VALUES((SELECT id FROM person WHERE username = 'alice'), 
		'234 Birch St.', null, 'Boston', '02345', false);
	
INSERT INTO address(person, street1, street2, city, zip, address_primary)
	VALUES((SELECT id FROM person WHERE username = 'bob'), 
		'345 Charles St.', null, 'Chelms', '03455', true);	
	
INSERT INTO address(person, street1, street2, city, zip, address_primary)
	VALUES((SELECT id FROM person WHERE username = 'bob'), 
		'456 Down St.', null, 'Dalton', '04566', false);	


INSERT INTO address(person, street1, street2, city, zip, address_primary)
	VALUES((SELECT id FROM person WHERE username = 'bob'), 
		'543 East St.', null, 'Everett', '01112', false);


INSERT INTO address(person, street1, street2, city, zip, address_primary)
	VALUES((SELECT id FROM person WHERE username = 'charlie'), 
		'654 Frank St.', null, 'Foulton', '04322', true);
