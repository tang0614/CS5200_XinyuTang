package models;
import daos.WidgetDaolmpl;

public class Widget {
	private int id;
	private String name;
	private int width;
	private int height;
	private String cssClass;
	private String cssStyle;
	private String text;
	private int order;
	private int page_id;
	private HeadingWidget hw;
	private HtmlWidget ht;
	private YouTubeWidget yout;
	private WidgetDaolmpl dao;
	
	
	protected enum Category {
		Youtube, Image, Html, Heading;
	}

	
	public Widget(WidgetDaolmpl dao,int id, String name, int width, int height,String cssClass, String cssStyle,
			String text, int order, int page_id) {
		this.dao = dao;
		this.id = id;
		this.width = width;
		this.height = height;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text= text;
		this.order = order;
		this.page_id = page_id;
	}
	
	public Widget(int id, String name, int width, int height,String cssClass, String cssStyle,
			String text, int order, int size, String html, String url, boolean shareable,
			boolean expandable, Category types) {
		
		this.id = id;
		this.width = width;
		this.height = height;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text= text;
		this.order = order;
		
		hw = new HeadingWidget(id,size);
		this.hw = hw;
		
		ht = new HtmlWidget(id,html);
		this.ht = ht;
		
	    yout = new YouTubeWidget(id,url,shareable,expandable);
	    this.yout = yout;

		
	}
	
	

}
