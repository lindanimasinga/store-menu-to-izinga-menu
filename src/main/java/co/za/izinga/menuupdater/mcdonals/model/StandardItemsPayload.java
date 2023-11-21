package co.za.izinga.menuupdater.mcdonals.model; 
import java.util.List; 
public class StandardItemsPayload{
    public Title title;
    public int spanCount;
    public List<CatalogItem> catalogItems;
    public String sectionUUID;
    public double numOfItemsOnScreen;
    public ItemStyleMetadata itemStyleMetadata;
    public CatalogSectionAnalyticsData catalogSectionAnalyticsData;
}
