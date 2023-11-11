package co.za.izinga.menuupdater.kfc.model;

import java.io.IOException;

public enum Day {
    EVERYDAY;

    public String toValue() {
        switch (this) {
            case EVERYDAY:
                return "EVERYDAY";
        }
        return null;
    }

    public static Day forValue(String value) throws IOException {
        if (value.equals("EVERYDAY")) return EVERYDAY;
        throw new IOException("Cannot deserialize Day");
    }
}