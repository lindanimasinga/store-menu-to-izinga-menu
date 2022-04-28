package co.za.izinga.menuupdater.kfc.model;
import com.fasterxml.jackson.annotation.JsonProperty; 
public class MenuData{
    @JsonProperty("CatalogImagePath") 
    public String catalogImagePath;
    @JsonProperty("SelectedCategory") 
    public SelectedCategory selectedCategory;
    @JsonProperty("FavItem") 
    public Object favItem;
    @JsonProperty("IsGenericCatalog") 
    public boolean isGenericCatalog;
}
