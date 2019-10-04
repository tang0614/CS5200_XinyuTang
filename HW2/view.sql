
create view developeras
select d.id, p.firstname, p.lastname, p.username, p.email
from person p, developer d
where d.person=p.id;

create view developer_website as
select d.*, w.name, w.visits, w.updated, wr.role, wp.priviledge
from developer_view d, website w, website_role wr, website_priviledge wp
where w.developer=d.id and wr.website=w.id and wp.developer=d.id and wp.website=w.id and (
	case wr.role
		when 'editor' then 
			wp.priviledge='read' or wp.priviledge='update'
		when 'reviewer' then 
			wp.priviledge='read'
		when 'owner' then 
			wp.priviledge='create' or wp.priviledge='read' or wp.priviledge='update' or wp.priviledge='delete'
		when 'admin' then 
			wp.priviledge='create' or wp.priviledge='read' or wp.priviledge='update' or wp.priviledge='delete'
		when 'writer' then 
			wp.priviledge='create' or wp.priviledge='read' or wp.priviledge='update'
					
	end
);

# join developer and page (page role and priviledge) information

create view developer_page as
select d.*, p.title, p.views, p.updated, r.role, pp.priviledge
from page_role r, developer_view d, page p, page_priviledge pp
where r.developer=d.id and r.page=p.id and pp.developer=d.id and pp.page=p.id and(
		case r.role
		when 'editor' then 
			pp.priviledge='read' or pp.priviledge='update'
		when 'reviewer' then 
			pp.priviledge='read'
		when 'owner' then 
			pp.priviledge='create' or pp.priviledge='read' or pp.priviledge='update' or pp.priviledge='delete'
		when 'admin' then 
			pp.priviledge='create' or pp.priviledge='read' or pp.priviledge='update' or pp.priviledge='delete'
		when 'writer' then 
			pp.priviledge='create' or pp.priviledge='read' or pp.priviledge='update'
					
	end
);