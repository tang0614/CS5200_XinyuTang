
	update widget
	set widget_order=3
	where name='head345';
	

	update widget
	set widget_order=widget_order + 2
	where page=(select id from page where title='Contact') 
	and name != 'head345';
	


	update page
	set title=CONCAT('CNET-', title)
	where page.website=(select id from website where name='CNET');
	
	update phone 
	set phone='333-444-5555'
	where person=(select id from person where username='charlie') 
	and phone_primary=true;
	




	CREATE PROCEDURE update_role()
	BEGIN
			DECLARE role_c VARCHAR(250);
			DECLARE role_b VARCHAR(250);
			
			# select original roles
			SET role_c = (select pr.role from page p, page_role pr, website w where p.website=w.id 
				and pr.page=p.id 
				and pr.developer=34 
				and w.name='CNET' 
				and p.title='CNET-Home');
			
			SET role_b = (select pr.role from page p, page_role pr, website w where p.website=w.id and 			
			pr.page=p.id 
			and pr.developer=23 
			and w.name='CNET'  
			and p.title='CNET-Home');
			
			# switch role
			update page_role
			set role=role_b
			where page=(select id from page where title='CNET-Home') 
			and developer=34;
			
			update page_role
			set role=role_c
			where page=(select id from page where title='CNET-Home') 
			and developer=23;
	END $$
	
	

	







