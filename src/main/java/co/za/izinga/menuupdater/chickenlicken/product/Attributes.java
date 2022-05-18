
package co.za.izinga.menuupdater.chickenlicken.product;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "created-at",
    "updated-at",
    "title",
    "slug",
    "position",
    "subtitle",
    "specialfont",
    "description",
    "price",
    "botswana",
    "southafrica",
    "botswana-price",
    "sideitem-included",
    "published"
})

public class Attributes {

    @JsonProperty("created-at")
    private String createdAt;
    @JsonProperty("updated-at")
    private String updatedAt;
    @JsonProperty("title")
    private String title;
    @JsonProperty("slug")
    private Object slug;
    @JsonProperty("position")
    private Integer position;
    @JsonProperty("subtitle")
    private String subtitle;
    @JsonProperty("specialfont")
    private Integer specialfont;
    @JsonProperty("description")
    private String description;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("botswana")
    private Integer botswana;
    @JsonProperty("southafrica")
    private Integer southafrica;
    @JsonProperty("botswana-price")
    private Object botswanaPrice;
    @JsonProperty("sideitem-included")
    private Integer sideitemIncluded;
    @JsonProperty("published")
    private Object published;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("created-at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created-at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updated-at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated-at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("slug")
    public Object getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(Object slug) {
        this.slug = slug;
    }

    @JsonProperty("position")
    public Integer getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Integer position) {
        this.position = position;
    }

    @JsonProperty("subtitle")
    public String getSubtitle() {
        return subtitle;
    }

    @JsonProperty("subtitle")
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @JsonProperty("specialfont")
    public Integer getSpecialfont() {
        return specialfont;
    }

    @JsonProperty("specialfont")
    public void setSpecialfont(Integer specialfont) {
        this.specialfont = specialfont;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("price")
    public Integer getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonProperty("botswana")
    public Integer getBotswana() {
        return botswana;
    }

    @JsonProperty("botswana")
    public void setBotswana(Integer botswana) {
        this.botswana = botswana;
    }

    @JsonProperty("southafrica")
    public Integer getSouthafrica() {
        return southafrica;
    }

    @JsonProperty("southafrica")
    public void setSouthafrica(Integer southafrica) {
        this.southafrica = southafrica;
    }

    @JsonProperty("botswana-price")
    public Object getBotswanaPrice() {
        return botswanaPrice;
    }

    @JsonProperty("botswana-price")
    public void setBotswanaPrice(Object botswanaPrice) {
        this.botswanaPrice = botswanaPrice;
    }

    @JsonProperty("sideitem-included")
    public Integer getSideitemIncluded() {
        return sideitemIncluded;
    }

    @JsonProperty("sideitem-included")
    public void setSideitemIncluded(Integer sideitemIncluded) {
        this.sideitemIncluded = sideitemIncluded;
    }

    @JsonProperty("published")
    public Object getPublished() {
        return published;
    }

    @JsonProperty("published")
    public void setPublished(Object published) {
        this.published = published;
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
