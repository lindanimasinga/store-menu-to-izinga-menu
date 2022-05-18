
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
    "categories",
    "side-item",
    "image-set",
    "related"
})
public class Relationships {

    @JsonProperty("categories")
    private Categories categories;
    @JsonProperty("side-item")
    private SideItem sideItem;
    @JsonProperty("image-set")
    private ImageSet imageSet;
    @JsonProperty("related")
    private Related related;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("categories")
    public Categories getCategories() {
        return categories;
    }

    @JsonProperty("categories")
    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    @JsonProperty("side-item")
    public SideItem getSideItem() {
        return sideItem;
    }

    @JsonProperty("side-item")
    public void setSideItem(SideItem sideItem) {
        this.sideItem = sideItem;
    }

    @JsonProperty("image-set")
    public ImageSet getImageSet() {
        return imageSet;
    }

    @JsonProperty("image-set")
    public void setImageSet(ImageSet imageSet) {
        this.imageSet = imageSet;
    }

    @JsonProperty("related")
    public Related getRelated() {
        return related;
    }

    @JsonProperty("related")
    public void setRelated(Related related) {
        this.related = related;
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
