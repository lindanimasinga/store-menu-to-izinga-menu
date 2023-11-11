package co.za.izinga.menuupdater.kfc.model;

public class ProductContent {
    private String entityID;
    private Object caloricValue;
    private Image image;
    private Object flagText;
    private String[] tagArray;
    private String shortDescription;
    private long serves;

    public String getEntityID() {
        return entityID;
    }

    public void setEntityID(String value) {
        this.entityID = value;
    }

    public Object getCaloricValue() {
        return caloricValue;
    }

    public void setCaloricValue(Object value) {
        this.caloricValue = value;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image value) {
        this.image = value;
    }

    public Object getFlagText() {
        return flagText;
    }

    public void setFlagText(Object value) {
        this.flagText = value;
    }

    public String[] getTagArray() {
        return tagArray;
    }

    public void setTagArray(String[] value) {
        this.tagArray = value;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String value) {
        this.shortDescription = value;
    }

    public long getServes() {
        return serves;
    }

    public void setServes(long value) {
        this.serves = value;
    }
}
