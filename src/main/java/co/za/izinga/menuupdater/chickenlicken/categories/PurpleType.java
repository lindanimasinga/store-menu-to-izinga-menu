package co.za.izinga.menuupdater.chickenlicken.categories;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;

public enum PurpleType {

    @JsonProperty("categories")
    CATEGORIES;

    public String toValue() {
        switch (this) {
            case CATEGORIES:
                return "categories";
        }
        return null;
    }

    public static PurpleType forValue(String value) throws IOException {
        if (value.equals("categories")) return CATEGORIES;
        throw new IOException("Cannot deserialize PurpleType");
    }
}
