	delete from widget
	where page=(select id from page where title='Contact') 
	order by widget_order desc limit 1;
	
	delete from address
	where person=(select id from person where username='alice') and address_primary=true;
	


	delete from page
	where website=(select id from website where name='Wikipedia') 
	order by  updated desc limit 1;
	
	delete from website where name='CNET';
