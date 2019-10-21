package daos;

import edu.northeastern.cs5200.DAO;
import models.Developer;
import models.Widget;

public class hw_jdbc_last_first {
	public static void main(String[] args) {
		DeveloperDaolmpl dao = new DeveloperDaolmpl();
		WebsiteDaolmpl web = new WebsiteDaolmpl();
		WidgetDaolmpl wid = new WidgetDaolmpl();
		PageDaolmpl pag = new PageDaolmpl();
		
		//insert into developer
		dao.createDeveloper(12,"4321rewq",1, "Alice", "Wonder", "alice","alice","alice@wonder.com");
		dao.createDeveloper(23,"5432trew",2, "Bob", "Merley","bob","bob","bob@marley.com");
		dao.createDeveloper(34,"6543ytre",3, "Charles", "Garcia","charles","charles","chuch@garcia.com");
		dao.createDeveloper(45,"7654fda",4, "Dan", "Martin","dan","dan","dan@martin.com");
		dao.createDeveloper(56,"7654fda",5, "Dan", "Martin","dan","dan","dan@martin.com");
		
		
		//insert into Website
		web.createWebsiteForDeveloper(123,"Facebook",
				"an online social media and social networking service","","",1234234,0);
		
		web.createWebsiteForDeveloper(234,"Twitter",
				"an online news and social networking service" + 
				"","","",4321543,1);
		web.createWebsiteForDeveloper(345,"Wikipedia",
				"a free online encyclopedia","","",3456654,2);
		web.createWebsiteForDeveloper(456,"CNN",
				"an American basic cable and satellite elevision news channel","","",6543345,3);
		web.createWebsiteForDeveloper(567,"CNET",
				"an American meida website that publishes reveiws, news, artilces, blog on consumer electronincs"
				,"","",5433455,4);
		web.createWebsiteForDeveloper(678,"Gizmodo",
				"a design, technology, science and fiction website that also writes articles on politics","","",4322345,5);
		
		//insert into pages
		pag.createPageForWebsite(1,123, "Home",
				"Landing page","","",123434);
		pag.createPageForWebsite(2,234, "About",
				"Website description","","",234545);
		pag.createPageForWebsite(3,345, "Contact",
				"Addresses, phones, and contact info","","",345656);
		pag.createPageForWebsite(4,456, "Preference",
				"Where users can confiture their preference","","",456776);
		pag.createPageForWebsite(5,567, "Profile",
				"User can configure theri personal information","","",457878);
		
		//insert widget
		wid.createWidgetForPage(1, "head123", 0, 0,"", "",
				"Welcome", 0, 1);
		wid.createWidgetForPage(1, "post234", 0, 0,"", "",
				"<p>Lorem</p>" + 
				"", 0, 1);
		wid.createWidgetForPage(1, "head345", 0, 0,"", "",
				"Hi", 0, 1);
		wid.createWidgetForPage(1, "intro456", 0, 0,"", "",
				"<h1>HI<Hi>", 0, 1);
		wid.createWidgetForPage(1, "image345", 50, 100,"", "",
				"", 0, 1);
		wid.createWidgetForPage(1, "video456", 400, 300,"", "",
				"", 0, 1);

		
		//delete
		dao.deleteDeveloper(12);
		wid.deleteWidget(12);
		pag.deletePage(345);
		web.deleteWebsite(123);
		web.deleteWebsite(567);
	}
	
}
