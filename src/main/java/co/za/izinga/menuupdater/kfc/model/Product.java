package co.za.izinga.menuupdater.kfc.model;

public class Product {
    private String mdmID;
    private String name;
    private String id;
    private boolean customizable;
    private Dname[] dname;
    private Dname[] shortDescription;
    private Dname[] longDescription;
    private String imageName;
    private Item[] items;
    private Object[] additionalProperties;
    private long displayOrder;
    private boolean isHidden;
    private ProductContent content;
    private String url;

    public String getMdmID() {
        return mdmID;
    }

    public void setMdmID(String value) {
        this.mdmID = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public boolean getCustomizable() {
        return customizable;
    }

    public void setCustomizable(boolean value) {
        this.customizable = value;
    }

    public Dname[] getDname() {
        return dname;
    }

    public void setDname(Dname[] value) {
        this.dname = value;
    }

    public Dname[] getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(Dname[] value) {
        this.shortDescription = value;
    }

    public Dname[] getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(Dname[] value) {
        this.longDescription = value;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String value) {
        this.imageName = value;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] value) {
        this.items = value;
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

    public boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(boolean value) {
        this.isHidden = value;
    }

    public ProductContent getContent() {
        return content;
    }

    public void setContent(ProductContent value) {
        this.content = value;
    }

    public String getURL() {
        return url;
    }

    public void setURL(String value) {
        this.url = value;
    }
}
