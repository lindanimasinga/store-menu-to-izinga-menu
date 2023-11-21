package co.za.izinga.menuupdater.mcdonals.model; 
public class CatalogItem{
    public String uuid;
    public String imageUrl;
    public String title;
    public String itemDescription;
    public int price;
    public PriceTagline priceTagline;
    public int spanCount;
    public String displayType;
    public boolean isSoldOut;
    public boolean hasCustomizations;
    public int numAlcoholicItems;
    public String subsectionUuid;
    public boolean isAvailable;
    public PurchaseInfo purchaseInfo;
    public String sectionUuid;
    public QuickAddConfig quickAddConfig;
    public LabelPrimary labelPrimary;
    public String itemAvailabilityState;
    public CatalogItemAnalyticsData catalogItemAnalyticsData;
    public ItemDescriptionBadge itemDescriptionBadge;
}
