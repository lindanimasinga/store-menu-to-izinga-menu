
package co.za.izinga.menuupdater.steers.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "UnavailableTag",
    "UnavailableReason",
    "IsUnavailable",
    "Id",
    "Name",
    "ImageUrl",
    "Description",
    "Price",
    "CheapestPrice",
    "Code",
    "CSSClasses",
    "ShowPlusSymbol"
})
public class MenuItem {

    @JsonProperty("UnavailableTag")
    private Object unavailableTag;
    @JsonProperty("UnavailableReason")
    private Object unavailableReason;
    @JsonProperty("IsUnavailable")
    private boolean isUnavailable;
    @JsonProperty("Id")
    private int id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ImageUrl")
    private String imageUrl;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Price")
    private double price;
    @JsonProperty("CheapestPrice")
    private double cheapestPrice;
    @JsonProperty("Code")
    private String code;
    @JsonProperty("CSSClasses")
    private Object cSSClasses;
    @JsonProperty("ShowPlusSymbol")
    private boolean showPlusSymbol;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("OptionLists")
    private List<OptionList> optionLists;

    @JsonProperty("UnavailableTag")
    public Object getUnavailableTag() {
        return unavailableTag;
    }

    @JsonProperty("UnavailableTag")
    public void setUnavailableTag(Object unavailableTag) {
        this.unavailableTag = unavailableTag;
    }

    @JsonProperty("UnavailableReason")
    public Object getUnavailableReason() {
        return unavailableReason;
    }

    @JsonProperty("UnavailableReason")
    public void setUnavailableReason(Object unavailableReason) {
        this.unavailableReason = unavailableReason;
    }

    @JsonProperty("IsUnavailable")
    public boolean isIsUnavailable() {
        return isUnavailable;
    }

    @JsonProperty("IsUnavailable")
    public void setIsUnavailable(boolean isUnavailable) {
        this.isUnavailable = isUnavailable;
    }

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

    @JsonProperty("ImageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("ImageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("Price")
    public double getPrice() {
        return price;
    }

    @JsonProperty("Price")
    public void setPrice(double price) {
        this.price = price;
    }

    @JsonProperty("CheapestPrice")
    public double getCheapestPrice() {
        return cheapestPrice;
    }

    @JsonProperty("CheapestPrice")
    public void setCheapestPrice(double cheapestPrice) {
        this.cheapestPrice = cheapestPrice;
    }

    @JsonProperty("Code")
    public String getCode() {
        return code;
    }

    @JsonProperty("Code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("CSSClasses")
    public Object getCSSClasses() {
        return cSSClasses;
    }

    @JsonProperty("CSSClasses")
    public void setCSSClasses(Object cSSClasses) {
        this.cSSClasses = cSSClasses;
    }

    @JsonProperty("ShowPlusSymbol")
    public boolean isShowPlusSymbol() {
        return showPlusSymbol;
    }

    @JsonProperty("ShowPlusSymbol")
    public void setShowPlusSymbol(boolean showPlusSymbol) {
        this.showPlusSymbol = showPlusSymbol;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public List<OptionList> getOptionLists() {
        return optionLists;
    }

    public void setOptionLists(List<OptionList> optionLists) {
        this.optionLists = optionLists;
    }
}
