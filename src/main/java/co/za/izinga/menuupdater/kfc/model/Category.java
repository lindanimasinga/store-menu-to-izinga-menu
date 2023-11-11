package co.za.izinga.menuupdater.kfc.model;

public class Category {
    private String id;
    private String name;
    private Dname[] dname;
    private Object[] longDescription;
    private Object[] shortDescription;
    private Dname[] imageName;
    private Category[] categories;
    private Product[] products;
    private boolean isHidden;
    private String url;
    private Object[] additionalProperties;
    private long displayOrder;
    private CategoryContent content;
    private Availability[] availability;
    private boolean isTimeSpecific;

    public String getID() {
        return id;
    }

    public void setID(String value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Dname[] getDname() {
        return dname;
    }

    public void setDname(Dname[] value) {
        this.dname = value;
    }

    public Object[] getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(Object[] value) {
        this.longDescription = value;
    }

    public Object[] getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(Object[] value) {
        this.shortDescription = value;
    }

    public Dname[] getImageName() {
        return imageName;
    }

    public void setImageName(Dname[] value) {
        this.imageName = value;
    }

    public Category[] getCategories() {
        return categories;
    }

    public void setCategories(Category[] value) {
        this.categories = value;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] value) {
        this.products = value;
    }

    public boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(boolean value) {
        this.isHidden = value;
    }

    public String getURL() {
        return url;
    }

    public void setURL(String value) {
        this.url = value;
    }

    public Object[] getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Object[] value) {
        this.additionalProperties = value;
    }

    public long getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(long value) {
        this.displayOrder = value;
    }

    public CategoryContent getContent() {
        return content;
    }

    public void setContent(CategoryContent value) {
        this.content = value;
    }

    public Availability[] getAvailability() {
        return availability;
    }

    public void setAvailability(Availability[] value) {
        this.availability = value;
    }

    public boolean getIsTimeSpecific() {
        return isTimeSpecific;
    }

    public void setIsTimeSpecific(boolean value) {
        this.isTimeSpecific = value;
    }
}