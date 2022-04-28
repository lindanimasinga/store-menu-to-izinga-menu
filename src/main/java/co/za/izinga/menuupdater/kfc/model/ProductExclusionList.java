package co.za.izinga.menuupdater.kfc.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
public class ProductExclusionList{
    @JsonProperty("ProductId") 
    public String productId;
    @JsonProperty("ParentProductId") 
    public String parentProductId;
    @JsonProperty("TypeofItem") 
    public int typeofItem;
    @JsonProperty("RestaurantIdList") 
    public ArrayList<String> restaurantIdList;
    @JsonProperty("StartDate") 
    public String startDate;
    @JsonProperty("EndDate") 
    public String endDate;
    @JsonProperty("OrderMode") 
    public String orderMode;
}
