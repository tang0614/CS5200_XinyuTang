# create website role

CREATE TRIGGER website_after
    AFTER INSERT ON website_role
    FOR EACH ROW 
BEGIN
    DECLARE developer INT;
    DECLARE website INT;
	DECLARE role VARCHAR(250);
		
		SET role = NEW.role;
		SET developer = NEW.developer;
		SET website = NEW.website;
		
		CASE role
			WHEN 'admin' THEN
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('create', developer, website);
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('read', developer, website);
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('update', developer, website);
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('delete', developer, website);
			WHEN 'owner' THEN
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('create', developer, website);
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('read', developer, website);
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('update', developer, website);
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('delete', developer, website);
		  	WHEN 'writer' THEN
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('create', developer, website);
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('read', developer, website);
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('update', developer, website);
		   WHEN 'editor' THEN
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('read', developer, website);			
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('update', developer, website);
		   WHEN 'reviewer' THEN
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('read', developer, website);	
			END CASE;



CREATE TRIGGER website_update
    AFTER UPDATE ON website_role
    FOR EACH ROW 
BEGIN
		DECLARE developer INT;
		DECLARE website INT;
		DECLARE role VARCHAR(250);
		
		SET developer = NEW.developer;
		SET website = NEW.website;
		SET role = NEW.role;
		
		CASE role
			WHEN 'admin' THEN
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('create', developer, website);
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('read', developer, website);
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('update', developer, website);
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('delete', developer, website);
		
			WHEN 'owner' THEN
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('create', developer, website);
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('read', developer, website);
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('update', developer, website);
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('delete', developer, website);
		    WHEN 'writer' THEN
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('create', developer, website);
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('read', developer, website);
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('update', developer, website);
		  	WHEN 'editor' THEN
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('read', developer, website);
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('update', developer, website);
		  	WHEN 'reviewer' THEN
				INSERT INTO website_priviledge(priviledge, developer, website) VALUES ('read', developer, website);	
			END CASE;




CREATE TRIGGER website_delete
    AFTER UPDATE ON website_role
    FOR EACH ROW 
BEGIN
    DECLARE developer INT;
    DECLARE website INT;
		DECLARE role VARCHAR(250);
		
		SET developer = NEW.developer;
		SET website = NEW.website;
		SET role = NEW.role;
		
		# delete previous priviledges of this developer and website
		DELETE from website_priviledge  
		WHERE developer = developer 
		AND website = website;	





CREATE TRIGGER page_create
    AFTER INSERT ON page_role
    FOR EACH ROW 
BEGIN
		DECLARE developer INT;
		DECLARE page INT;
		DECLARE role VARCHAR(250);
		
		SET developer = NEW.developer;
		SET page = NEW.page;
		SET role = NEW.role;
		
		CASE role
			WHEN 'admin' THEN
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('create', developer, page);
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('read', developer, page);
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('update', developer, page);
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('delete', developer, page);
		
			WHEN 'owner' THEN
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('create', developer, page);
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('read', developer, page);
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('update', developer, page);
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('delete', developer, page);
		  WHEN 'writer' THEN
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('create', developer, page);
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('read', developer, page);
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('update', developer, page);
		  	WHEN 'editor' THEN
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('read', developer, page);
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('update', developer, page);
		 
			END CASE;



CREATE TRIGGER after_page_role_update
    AFTER UPDATE ON page_role
    FOR EACH ROW 
BEGIN
		DECLARE developer INT;
		DECLARE page INT;
		DECLARE role VARCHAR(250);
		
		SET page = NEW.page;
		SET role = NEW.role;
		SET developer = NEW.developer;

		
		# delete previous priviledges of this developer and page
		DELETE from page_priviledge  WHERE developer = developer AND page = page;	
		
		# add new priviledges based on the new role
		CASE role
			WHEN 'admin' THEN
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('create', developer, page);
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('read', developer, page);
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('update', developer, page);
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('delete', developer, page);
		  
			WHEN 'owner' THEN
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('create', developer, page);
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('read', developer, page);
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('update', developer, page);
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('delete', developer, page);
		  	WHEN 'writer' THEN
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('create', developer, page);
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('read', developer, page);
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('update', developer, page);
		  	WHEN 'editor' THEN
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('read', developer, page);
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('update', developer, page);
		  	WHEN 'reviewer' THEN
				INSERT INTO page_priviledge(priviledge, developer, page) VALUES ('read', developer, page);	
			END CASE;



#