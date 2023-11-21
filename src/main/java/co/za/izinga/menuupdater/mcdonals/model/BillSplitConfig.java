package co.za.izinga.menuupdater.mcdonals.model; 
import com.fasterxml.jackson.annotation.JsonProperty; 
public class BillSplitConfig{
    @JsonProperty("SplitBySubtotalInfo") 
    public SplitBySubtotalInfo splitBySubtotalInfo;
}
