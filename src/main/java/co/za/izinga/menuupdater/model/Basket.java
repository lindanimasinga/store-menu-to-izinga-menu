package co.za.izinga.menuupdater.model;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class Basket {

    private String id;
    @NotEmpty(message = "order basket is empty")
    private List<BasketItem> items = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public void setItems(List<BasketItem> items) {
        this.items = items;
    }

    public Double getTotalPrice() {
        return getItems().stream().mapToDouble(BasketItem::getTotalPrice).sum();
    }
}
