package co.za.izinga.menuupdater.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

public class SelectionOption {

    @NotEmpty(message = "selectionOption name not valid")
    private String name;
    @NotEmpty(message = "selectionOption values not valid")
    private List<String> values;
    private String selected;
    @Min(value = 0)
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getValues() {
        return values;
    }

    public List<String> titleValuesPair() {
        return values.stream().map(i -> name + " " + i).collect(Collectors.toList());
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }
}
