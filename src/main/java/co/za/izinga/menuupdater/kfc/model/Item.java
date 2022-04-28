package co.za.izinga.menuupdater.kfc.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Item{
    @JsonProperty("ItemID") 
    public String itemID;
    @JsonProperty("ImgName") 
    public Object imgName;
    @JsonProperty("ItemName") 
    public String itemName;
    @JsonProperty("Description") 
    public String description;
    @JsonProperty("Quantity") 
    public int quantity;
    @JsonProperty("UnitPrice") 
    public double unitPrice;
    @JsonProperty("Price") 
    public String price;
    @JsonProperty("ImageName") 
    public String imageName;
    @JsonProperty("Size") 
    public String size;
    @JsonProperty("ViewName") 
    public Object viewName;
    @JsonProperty("POSItemID") 
    public String pOSItemID;
    @JsonProperty("ItemType") 
    public int itemType;
    @JsonProperty("LineItemId") 
    public Object lineItemId;
    @JsonProperty("IsCart") 
    public boolean isCart;
    @JsonProperty("ShowCustomize") 
    public boolean showCustomize;
    @JsonProperty("ShowOrderNow") 
    public boolean showOrderNow;
    @JsonProperty("Allergens") 
    public String allergens;
    @JsonProperty("Additives") 
    public String additives;
    @JsonProperty("HasModifiers") 
    public boolean hasModifiers;
    @JsonProperty("CategoryID") 
    public String categoryID;
    @JsonProperty("ParentCategoryId") 
    public String parentCategoryId;
    @JsonProperty("ParentCategoryName") 
    public Object parentCategoryName;
    @JsonProperty("ModifierGroups") 
    public ArrayList<Object> modifierGroups;
    @JsonProperty("IsDisplayItemImage") 
    public boolean isDisplayItemImage;
    @JsonProperty("IsExcluded") 
    public boolean isExcluded;
    @JsonProperty("UIName") 
    public String uIName;
    @JsonProperty("Crust") 
    public Object crust;
    @JsonProperty("ItemInformation") 
    public Object itemInformation;
    @JsonProperty("IsAvailableOnPickupTime") 
    public boolean isAvailableOnPickupTime;
    @JsonProperty("MaxFreeToppingCount") 
    public int maxFreeToppingCount;
    @JsonProperty("IsHalfNHalf") 
    public boolean isHalfNHalf;
    @JsonProperty("IsHalfNHalfPizza") 
    public boolean isHalfNHalfPizza;
    @JsonProperty("ImageVersion") 
    public Object imageVersion;
    @JsonProperty("AlaCartePrice") 
    public String alaCartePrice;
    @JsonProperty("ItemUIName") 
    public Object itemUIName;
    @JsonProperty("PriceInDecimal") 
    public double priceInDecimal;
    @JsonProperty("ModifierCode") 
    public int modifierCode;
    @JsonProperty("IsDefault") 
    public boolean isDefault;
    @JsonProperty("IsExtraDefault") 
    public boolean isExtraDefault;
    @JsonProperty("ExtraModifierCode") 
    public int extraModifierCode;
    @JsonProperty("IsDoubleRemoved") 
    public boolean isDoubleRemoved;
    @JsonProperty("IsDoubleDefault") 
    public boolean isDoubleDefault;
    @JsonProperty("PromoId") 
    public Object promoId;
    @JsonProperty("IsUpsellItem") 
    public boolean isUpsellItem;
    @JsonProperty("IsLoyaltyItem") 
    public boolean isLoyaltyItem;
    @JsonProperty("Points") 
    public String points;
    @JsonProperty("IsUpsellItemAdded") 
    public boolean isUpsellItemAdded;
    @JsonProperty("ProductUrl") 
    public String productUrl;
    @JsonProperty("IsTradeUpItem") 
    public boolean isTradeUpItem;
    @JsonProperty("OfferedWithItems") 
    public Object offeredWithItems;
    @JsonProperty("UpsalePT") 
    public Object upsalePT;
    @JsonProperty("IsStaticUpsellItem") 
    public boolean isStaticUpsellItem;
    @JsonProperty("UpsaleOrderLimit") 
    public Object upsaleOrderLimit;
    @JsonProperty("CategoryName") 
    public Object categoryName;
    @JsonProperty("IsPromoItem") 
    public boolean isPromoItem;
    @JsonProperty("ShowCalorie") 
    public boolean showCalorie;
    @JsonProperty("ModifierGroupName") 
    public Object modifierGroupName;
    @JsonProperty("ModifierType") 
    public int modifierType;
    @JsonProperty("ServingSize") 
    public int servingSize;
    @JsonProperty("IsAddToOrder") 
    public boolean isAddToOrder;
    @JsonProperty("EditUrl") 
    public Object editUrl;
    public ArrayList<Nutrition> nutritions;
    @JsonProperty("MRPPrice") 
    public int mRPPrice;
    @JsonProperty("IsGenericCatalog") 
    public boolean isGenericCatalog;
}
