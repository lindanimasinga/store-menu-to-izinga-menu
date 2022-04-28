package co.za.izinga.menuupdater.kfc.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Product{
    @JsonProperty("AvailableVariants") 
    public Object availableVariants;
    @JsonProperty("VariantDescriptions") 
    public Object variantDescriptions;
    @JsonProperty("SizeDescriptions") 
    public Object sizeDescriptions;
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
