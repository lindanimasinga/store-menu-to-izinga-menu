package co.za.izinga.menuupdater.kfc.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class CartInfo{
    @JsonProperty("UpsaleInfo") 
    public Object upsaleInfo;
    @JsonProperty("IsUpsaleSectionPresent") 
    public boolean isUpsaleSectionPresent;
    @JsonProperty("SoonestPossibleOrderReadyText") 
    public Object soonestPossibleOrderReadyText;
    @JsonProperty("CouponDetails") 
    public ArrayList<Object> couponDetails;
    @JsonProperty("DiscountDetails") 
    public ArrayList<Object> discountDetails;
    @JsonProperty("CustomDiscountDetails") 
    public ArrayList<Object> customDiscountDetails;
    @JsonProperty("ShowDealConversionPopUp") 
    public boolean showDealConversionPopUp;
    @JsonProperty("DeliveryCharge") 
    public double deliveryCharge;
    @JsonProperty("CouponErrorMessage") 
    public Object couponErrorMessage;
    @JsonProperty("IsSameDayOrdering") 
    public boolean isSameDayOrdering;
    @JsonProperty("OrderReadyDateText") 
    public String orderReadyDateText;
    @JsonProperty("AddHopePrice") 
    public int addHopePrice;
    @JsonProperty("AddHopeId") 
    public Object addHopeId;
    @JsonProperty("IsAddHopeChecked") 
    public boolean isAddHopeChecked;
    @JsonProperty("IsDriverTipAmountChecked") 
    public boolean isDriverTipAmountChecked;
    @JsonProperty("IsTipSectionshown") 
    public boolean isTipSectionshown;
    @JsonProperty("DriverTipAmount") 
    public int driverTipAmount;
    public ArrayList<AddHopeModel> addHopeModels;
    @JsonProperty("DriverTipAmountModels") 
    public Object driverTipAmountModels;
    @JsonProperty("IsCouponavailable") 
    public boolean isCouponavailable;
    @JsonProperty("CouponCode") 
    public String couponCode;
    @JsonProperty("OneClickDeniedMsg") 
    public Object oneClickDeniedMsg;
    @JsonProperty("OrderingContext") 
    public OrderingContext orderingContext;
    @JsonProperty("RestaurantInfo") 
    public RestaurantInfo restaurantInfo;
    @JsonProperty("Items") 
    public ArrayList<Item> items;
    @JsonProperty("Subtotal") 
    public double subtotal;
    @JsonProperty("TaxInformation") 
    public ArrayList<Object> taxInformation;
    @JsonProperty("BottleDepositInformation") 
    public ArrayList<Object> bottleDepositInformation;
    @JsonProperty("Tax") 
    public int tax;
    @JsonProperty("BottleDepositAmount") 
    public int bottleDepositAmount;
    @JsonProperty("OrderTotal") 
    public double orderTotal;
    @JsonProperty("CartOrderSummary") 
    public String cartOrderSummary;
    @JsonProperty("IsQuantityUpdated") 
    public boolean isQuantityUpdated;
    @JsonProperty("LastItemAdded") 
    public Object lastItemAdded;
    @JsonProperty("LastItemAddedImageName") 
    public Object lastItemAddedImageName;
    @JsonProperty("IsDisplayBubble") 
    public boolean isDisplayBubble;
    @JsonProperty("IsSaveCartLinkDisplayed") 
    public boolean isSaveCartLinkDisplayed;
    @JsonProperty("IsChangeDateTimeLinkDisplayed") 
    public boolean isChangeDateTimeLinkDisplayed;
    @JsonProperty("CartMessage") 
    public String cartMessage;
    @JsonProperty("OrderReadyDateTime") 
    public String orderReadyDateTime;
    @JsonProperty("ShowOnlyCartBubble") 
    public boolean showOnlyCartBubble;
    @JsonProperty("ItemQuantityInformation") 
    public String itemQuantityInformation;
    @JsonProperty("IsGenericCatalog") 
    public boolean isGenericCatalog;
}
