
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
    "MenuId",
    "MenuVersion",
    "Categories",
    "FavouriteMenuItemCodes"
})
public class SteersMenu {

    @JsonProperty("MenuId")
    private int menuId;
    @JsonProperty("MenuVersion")
    private int menuVersion;
    @JsonProperty("Categories")
    private List<Category> categories = null;
    @JsonProperty("FavouriteMenuItemCodes")
    private List<Object> favouriteMenuItemCodes = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("MenuId")
    public int getMenuId() {
        return menuId;
    }

    @JsonProperty("MenuId")
    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @JsonProperty("MenuVersion")
    public int getMenuVersion() {
        return menuVersion;
    }

    @JsonProperty("MenuVersion")
    public void setMenuVersion(int menuVersion) {
        this.menuVersion = menuVersion;
    }

    @JsonProperty("Categories")
    public List<Category> getCategories() {
        return categories;
    }

    @JsonProperty("Categories")
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @JsonProperty("FavouriteMenuItemCodes")
    public List<Object> getFavouriteMenuItemCodes() {
        return favouriteMenuItemCodes;
    }

    @JsonProperty("FavouriteMenuItemCodes")
    public void setFavouriteMenuItemCodes(List<Object> favouriteMenuItemCodes) {
        this.favouriteMenuItemCodes = favouriteMenuItemCodes;
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
