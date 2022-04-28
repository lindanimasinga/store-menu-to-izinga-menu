package co.za.izinga.menuupdater.steers.model;

        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;
        import com.fasterxml.jackson.annotation.JsonAnyGetter;
        import com.fasterxml.jackson.annotation.JsonAnySetter;
        import com.fasterxml.jackson.annotation.JsonIgnore;
        import com.fasterxml.jackson.annotation.JsonProperty;

public class OptionList {

    @JsonProperty("Id")
    private int id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Heading")
    private String heading;
    @JsonProperty("OptionListType")
    private int optionListType;
    @JsonProperty("Options")
    private List<Option> options = null;
    @JsonProperty("QuantityMultiplier")
    private double quantityMultiplier;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Id")
    public int getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Heading")
    public String getHeading() {
        return heading;
    }

    @JsonProperty("Heading")
    public void setHeading(String heading) {
        this.heading = heading;
    }

    @JsonProperty("OptionListType")
    public int getOptionListType() {
        return optionListType;
    }

    @JsonProperty("OptionListType")
    public void setOptionListType(int optionListType) {
        this.optionListType = optionListType;
    }

    @JsonProperty("Options")
    public List<Option> getOptions() {
        return options;
    }

    @JsonProperty("Options")
    public void setOptions(List<Option> options) {
        this.options = options;
    }

    @JsonProperty("QuantityMultiplier")
    public double getQuantityMultiplier() {
        return quantityMultiplier;
    }

    @JsonProperty("QuantityMultiplier")
    public void setQuantityMultiplier(double quantityMultiplier) {
        this.quantityMultiplier = quantityMultiplier;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}

