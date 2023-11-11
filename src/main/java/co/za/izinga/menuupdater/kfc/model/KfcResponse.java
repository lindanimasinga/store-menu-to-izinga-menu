package co.za.izinga.menuupdater.kfc.model;

import java.util.ArrayList;

public class KfcResponse {
    private String id;
    private ArrayList<Category> categories;

    public KfcResponse() {
    }

    public KfcResponse(String id, ArrayList<Category> categories) {
        this.id = id;
        this.categories = categories;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> value) {
        this.categories = value;
    }
}

