
select * 
from developer;



select * 
from developer 
where id = 34;



select d.id 
from developer d, website_role  w
where d.id = w.developer 
and w.website = 234 
and w.role != 'owner';



select d.id
from developer d, page p, page_role r
where d.id = r.developer 
and p.id = r.page 
and p.views <= 300000 
and pr.role = 'reviewer';



select distinct r.developer
from page_role r, website wb, page p, widget w
where r.page = p.id 
and r.role='writer' 
and w.name='CNN' 
and p.title='home' 
and w.dtype='heading';




select *
from website
order by visits asc limit 1



select *
from website
where id=678



select distinct w.*
from website wb, page p, widget w, page_role r
where p.website = w.id 
and w.page = w.id 
and r.developer=23 
and r.role='reviewer' 
and w.dtype='youtube';



select w.*
from website wb, website_role r
where wb.id=r.website 
and r.developer=12 
and r.role='owner';


select w.*
from website w, website_role r
where wb.id=r.website and r.developer=34 and r.role='admin' and wb.visits > 6000000;




select *
from page
order by views desc
limit 1


select title
from page
where id=234;


select p.*
from page p, page_role r
where p.id=pr.page 
and r.developer=12 
and r.role='editor';



select sum(p.views)
from page p, website w
where p.website=w.id 
and w.name='CNET';



select avg(p.views)
from page p, website w
where p.website=w.id 
and w.name='Wikipedia';




select w.*
from page p, widget w, website wb
where w.page=p.id 
and p.website=wb.id 
and wb.name='CNET' 
and p.title='Home';



select w.*
from page p, widget w, website wb
where wd.page=p.id 
and p.website=wb.id 
and wb.name='CNN' 
and w.dtype='youtube';



select w.*
from page p, widget w, page_role pr
where w.page=p.id 
and p.id=pr.page 
and w.dtype='image' 
and pr.developer=12 
and pr.role='reviewer';



select count(*)
from page p, widget wd, website w
where wd.page=p.id 
and p.website=w.id 
and w.name='Wikipedia';



select w.name
from website w, website_priviledge wp
where w.website=w.id 
and w.developer=23 
and w.priviledge='delete';



select p.title
from page p, page_priviledge p
where pp.page=p.id 
and p.developer=34 
and p.priviledge='create';
