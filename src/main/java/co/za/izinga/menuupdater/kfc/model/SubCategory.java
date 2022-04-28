package co.za.izinga.menuupdater.kfc.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class SubCategory{
    @JsonProperty("SubCategories") 
    public ArrayList<Object> subCategories;
    @JsonProperty("Products") 
    public ArrayList<Product> products;
    @JsonProperty("CategoryImageVersion") 
    public String categoryImageVersion;
    @JsonProperty("Id") 
    public String id;
    @JsonProperty("Name") 
    public String name;
    @JsonProperty("Description") 
    public String description;
    @JsonProperty("ImageName") 
    public String imageName;
    @JsonProperty("TemplateName") 
    public String templateName;
    @JsonProperty("CategoryUIName") 
    public String categoryUIName;
    @JsonProperty("Items") 
    public ArrayList<Item> items;
    @JsonProperty("IsGenericCatalog") 
    public boolean isGenericCatalog;
}
