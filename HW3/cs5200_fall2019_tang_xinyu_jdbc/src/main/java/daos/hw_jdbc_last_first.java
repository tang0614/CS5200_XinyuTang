package daos;

import java.sql.SQLException;
import java.util.List;

import models.*;


public class hw_jdbc_last_first {
	private DeveloperDao developerDao = new DeveloperDaolmpl();
    private WebsiteDao websiteDao = new WebsiteDaolmpl();
    private PageDao pageDao = new PageDaolmpl();
    private WidgetDao widgetDao = new WidgetDaolmpl();
    private RoleDao roleDao = new Rolelmpl();
    
    public void insertDevelopers() throws SQLException, ClassNotFoundException {
        Developer developer = new Developer(12,"4321rewq","Alice","Wonder","alice","alice", "alice@wonder.com");
        developerDao.createDeveloper(developer);
        developer = new Developer(23,"5432trew","Bob","Marley","bob","bob","bon@marley.com");
        developerDao.createDeveloper(developer);
        developer = new Developer(34,"6543ytre","Charlie","Garcia","charlie","charlie","chuch@garcia.com");
        developerDao.createDeveloper(developer);
    }

    public void insertWebsites() throws SQLException, ClassNotFoundException {
        Website web = new Website(123,"Facebook", "an online social media and social networking service",null,null,1234234);
        websiteDao.createWebsiteForDeveloper(12, web);

        web = new Website(234,"Twitter","an online news and social networking service",null,null,4321543);
        websiteDao.createWebsiteForDeveloper(23, web);
        web = new Website(345,"Wikipedia","a free online encyclopedia",null,null,3456654);
        websiteDao.createWebsiteForDeveloper(34, web);
        web = new Website(456,"CNN","an American basic cable and satellite television news channel",null,null,6543345);
        websiteDao.createWebsiteForDeveloper(12, web);
        web = new Website(567,"CNET", "an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics",null,null,5433455);
        websiteDao.createWebsiteForDeveloper(23, web);
        web = new Website(678,"Gizmodo","a design, technology, science and science fiction website that also writes articles on politics",null,null,4322345);
        websiteDao.createWebsiteForDeveloper(34, web);
    }

    public void insertPages() throws SQLException, ClassNotFoundException {
        Page page = new Page(123,"Home","Landing page",null,null,123434);
        pageDao.createPageForWebsite(567, page);
        page = new Page(234,"About","Website description",null,null,234545);
        pageDao.createPageForWebsite(678, page);
        page = new Page(345,"Contact","Addresses, phones, and contact info",null,null,345656);
        pageDao.createPageForWebsite(345, page);
        page = new Page(456,"Preferences","Where users can configure their preferences",null,null,456776);
        pageDao.createPageForWebsite(456, page);
        page = new Page(567,"Profile","Users can configure their personal information",null,null,567878);
        pageDao.createPageForWebsite(567, page);
    }

    public void insertWidgets() throws SQLException, ClassNotFoundException {
        Widget widget = new Widget(1,"head123",-1,-1,"","","Welcome",0);
        widgetDao.createWidgetForPage(123, widget);

        widget = new Widget(2,"post234",-1,-1,"","","<p>Lorem</p>",0);
        widgetDao.createWidgetForPage(234, widget);

        widget = new Widget(3,"head345",-1,-1,"","","Hi",1);
        widgetDao.createWidgetForPage(345, widget);

        widget = new Widget(4,"intro456",-1,-1,"","","<h1>Hi</h1>",2);
        widgetDao.createWidgetForPage(345, widget);

        widget = new Widget(5,"image345",50,100,"","","",3);
        widgetDao.createWidgetForPage(345, widget);

        widget = new Widget(6,"video456",400,300,"","","",0);
        widgetDao.createWidgetForPage(456, widget);
    }

    public void insetRoles() throws SQLException, ClassNotFoundException {

        RoleDao RoleDao = new Rolelmpl();
        roleDao.assignWebsiteRole(12, 123, Role.owner.name());
        roleDao.assignWebsiteRole(23, 123, Role.editor.name());
        roleDao.assignWebsiteRole(34, 123, Role.admin.name());
        roleDao.assignWebsiteRole(23, 234, Role.owner.name());
        roleDao.assignWebsiteRole(34, 234, Role.editor.name());
        roleDao.assignWebsiteRole(12, 234, Role.admin.name());
        roleDao.assignWebsiteRole(34, 345, Role.owner.name());
        roleDao.assignWebsiteRole(12, 345, Role.editor.name());
        roleDao.assignWebsiteRole(23, 345, Role.admin.name());
        roleDao.assignWebsiteRole(12, 456, Role.owner.name());
        roleDao.assignWebsiteRole(23, 456, Role.editor.name());
        roleDao.assignWebsiteRole(34, 456, Role.admin.name());
        roleDao.assignWebsiteRole(23, 567, Role.owner.name());
        roleDao.assignWebsiteRole(34, 567, Role.editor.name());
        roleDao.assignWebsiteRole(12, 567, Role.admin.name());
        roleDao.assignWebsiteRole(34, 678, Role.owner.name());
        roleDao.assignWebsiteRole(12, 678, Role.editor.name());
        roleDao.assignWebsiteRole(23, 678, Role.admin.name());

        // insert page roles
        roleDao.assignPageRole(12, 123, Role.editor.name());
        roleDao.assignPageRole(23, 123, Role.reviewer.name());
        roleDao.assignPageRole(34, 123, Role.writer.name());
        roleDao.assignPageRole(23, 234, Role.editor.name());
        roleDao.assignPageRole(34, 234, Role.reviewer.name());
        roleDao.assignPageRole(12, 234, Role.writer.name());
        roleDao.assignPageRole(34, 345, Role.editor.name());
        roleDao.assignPageRole(12, 345, Role.reviewer.name());
        roleDao.assignPageRole(23, 345, Role.writer.name());
        roleDao.assignPageRole(12, 456, Role.editor.name());
        roleDao.assignPageRole(23, 456, Role.reviewer.name());
        roleDao.assignPageRole(34, 456, Role.writer.name());
        roleDao.assignPageRole(23, 567, Role.editor.name());
        roleDao.assignPageRole(34, 567, Role.reviewer.name());
        roleDao.assignPageRole(12, 567, Role.writer.name());
    }

   
    public void updateDeleloper() throws ClassNotFoundException, SQLException {
        Developer developer = developerDao.findDeveloperByUsername("Charlie");
        for (Phone phone : developer.getPerson().getPhones()) {
            if (phone.isPrimary()) {
                phone.setPhone("333-444-5555");
               
            }
        }

        developerDao.updateDeveloper(developer.getId(), developer);
    }
    
    public void updateWidget() throws SQLException, ClassNotFoundException {
        Widget head345 = widgetDao.findWidgetById(3);
        head345.setOrder(3);
        widgetDao.updateWidget(3, head345);

        Widget intro456 = widgetDao.findWidgetById(4);
        intro456.setOrder(4);
        widgetDao.updateWidget(4, intro456);

        Widget image345 = widgetDao.findWidgetById(5);
        image345.setOrder(5);
        widgetDao.updateWidget(5, image345);
    }
    
    public void updatePage() throws SQLException, ClassNotFoundException {
        for (Page page : pageDao.findPagesForWebsite(567)) {
            String title = page.getTitle();
            page.setTitle("CNET - " + title);
            page.setWebsiteId(567);
            pageDao.updatePage(page.getId(), page);
        }
    }

    // Swap Charlie's and Bob's role in CNET's Home page
    public void updateRole() throws SQLException, ClassNotFoundException {
        roleDao.deletePageRole(34, 123, Role.writer.name());
        roleDao.deletePageRole(23, 123, Role.reviewer.name());
        roleDao.assignPageRole(34, 123, Role.reviewer.name());
        roleDao.assignPageRole(23, 123, Role.writer.name());
    }

    // Delete Alice's primary address
    public void deleteDeveloper() throws SQLException, ClassNotFoundException {
        Developer developer = developerDao.findDeveloperByUsername("Alice");
        Person person = developer.getPerson();
        List<Address> addresses = person.getAddresses();
        int deleteIndex = -1;
        for(int i = 0; i < addresses.size(); i++) {
            if (addresses.get(i).isPrimary()) {
                deleteIndex = i;
                break;
            }
        }

        addresses.remove(deleteIndex);

        developerDao.updateDeveloper(developer.getId(), developer);
    }

	
	
}
