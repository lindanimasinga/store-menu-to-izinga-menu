package co.za.izinga.menuupdater.chickenlicken.categories;

import java.util.List;

public class CategoryDetails {
    String id;
    List<Product> products;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
