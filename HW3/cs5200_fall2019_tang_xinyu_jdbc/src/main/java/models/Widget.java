package models;
import daos.WidgetDaolmpl;


public class Widget {

    private int id;
    private int pageId;
    private String name;
    private int width;
    private int height;
    private String cssClass;
    private String cssStyle;
    private String text;
    private int order;
    private WidgetType type;
  

    public Widget(int id,
           String name,
           int width,
           int height,
           String cssStyle,
           String cssClass,
           String text,
           int order) {

        this.id = id;
        this.name = name;
        this.width = width;
        this.height = height;
        this.cssStyle = cssStyle;
        this.cssClass = cssClass;
        this.text = text;
        this.order = order;
    }

    public Widget(int id,
           int width,
           int height,
           int order,
           int size,
           boolean shareble,
           boolean expandable,
           String name,
           String cssStyle,
           String cssClass,
           String text,
           String html,
           String src,
           String url,
           WidgetType type) {

        this.id = id;
        this.name = name;
        this.width = width;
        this.height = height;
        this.cssStyle = cssStyle;
        this.cssClass = cssClass;
        this.text = text;
        this.order = order;
        this.type = type;

       
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getCssStyle() {
        return cssStyle;
    }

    public void setCssStyle(String cssStyle) {
        this.cssStyle = cssStyle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public WidgetType getType() {
        return type;
    }

    public void setType(WidgetType type) {
        this.type = type;
    }

         return htmlWidget;
    }

    public void setHtmlWidget(HtmlWidget htmlWidget) {
        this.htmlWidget = htmlWidget;
    }
}