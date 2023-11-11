package co.za.izinga.menuupdater.chickenlicken.categories;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    @JsonProperty("southafrica")
    private int southAfrica;
    private int price;
    private String id;
    private String title;
    @JsonProperty("image-set")
    private ImageSet imageSet;

    public int getSouthAfrica() {
        return southAfrica;
    }

    public void setSouthAfrica(int southAfrica) {
        this.southAfrica = southAfrica;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ImageSet getImageSet() {
        return imageSet;
    }

    public void setImageSet(ImageSet imageSet) {
        this.imageSet = imageSet;
    }
}
