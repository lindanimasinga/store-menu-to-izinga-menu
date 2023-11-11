package co.za.izinga.menuupdater.kfc.model;

public class CategoryContent {
    private String entityID;
    private Object caloricValue;
    private Image image;

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
}
