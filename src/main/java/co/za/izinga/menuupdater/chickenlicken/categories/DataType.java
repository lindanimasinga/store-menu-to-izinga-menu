package co.za.izinga.menuupdater.chickenlicken.categories;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;

public enum DataType {
    @JsonProperty("image-sets")
    IMAGE_SETS,
    @JsonProperty("media")
    MEDIA,
    @JsonProperty("products")
    PRODUCTS,
    @JsonProperty("side-items")
    SIDE_ITEMS;

    public String toValue() {
        switch (this) {
            case IMAGE_SETS:
                return "image-sets";
            case MEDIA:
                return "media";
            case PRODUCTS:
                return "products";
            case SIDE_ITEMS:
                return "side-items";
        }
        return null;
    }

    public static DataType forValue(String value) throws IOException {
        if (value.equals("image-sets")) return IMAGE_SETS;
        if (value.equals("media")) return MEDIA;
        if (value.equals("products")) return PRODUCTS;
        if (value.equals("side-items")) return SIDE_ITEMS;
        throw new IOException("Cannot deserialize DataType");
    }
}
