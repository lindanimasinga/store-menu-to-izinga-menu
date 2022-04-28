package co.za.izinga.menuupdater.kfc.model;
import com.fasterxml.jackson.annotation.JsonProperty; 
public class OrderingContext{
    @JsonProperty("RestaurantId") 
    public String restaurantId;
    @JsonProperty("CartQuantity") 
    public int cartQuantity;
    @JsonProperty("CartTotalAmount") 
    public double cartTotalAmount;
    @JsonProperty("OrderId") 
    public String orderId;
    @JsonProperty("IsDuplicateOrderCheck") 
    public boolean isDuplicateOrderCheck;
    @JsonProperty("CartId") 
    public String cartId;
    @JsonProperty("OrderReadyDate") 
    public OrderReadyDate orderReadyDate;
    @JsonProperty("RestaurantGroupId") 
    public String restaurantGroupId;
    @JsonProperty("OrderMode") 
    public int orderMode;
    @JsonProperty("PrefferedAddress") 
    public PrefferedAddress prefferedAddress;
    @JsonProperty("OrderType") 
    public int orderType;
    @JsonProperty("LastItemAdded") 
    public String lastItemAdded;
    @JsonProperty("LastItemAddedPrice") 
    public Object lastItemAddedPrice;
    @JsonProperty("LastItemAddedImageName") 
    public Object lastItemAddedImageName;
    @JsonProperty("IsDisplayBubble") 
    public boolean isDisplayBubble;
    @JsonProperty("CustomerInput") 
    public Object customerInput;
    @JsonProperty("CustomerRegistrationInput") 
    public Object customerRegistrationInput;
    @JsonProperty("RestaurantLocationSearchText") 
    public String restaurantLocationSearchText;
    @JsonProperty("LastItemPrice") 
    public Object lastItemPrice;
    @JsonProperty("IsCarryoutUseMyLocation") 
    public boolean isCarryoutUseMyLocation;
    @JsonProperty("RestaurantPOSItemId") 
    public String restaurantPOSItemId;
    @JsonProperty("CollectionPoint") 
    public int collectionPoint;
    @JsonProperty("CollectNowURLAndUserName") 
    public Object collectNowURLAndUserName;
    @JsonProperty("RestaurantCity") 
    public Object restaurantCity;
    @JsonProperty("AddressSavedByDefault") 
    public boolean addressSavedByDefault;
    @JsonProperty("IsPreviouslyOrdered") 
    public boolean isPreviouslyOrdered;
    @JsonProperty("RestaurantFranchiseName") 
    public Object restaurantFranchiseName;
    @JsonProperty("TenderType") 
    public Object tenderType;
    @JsonProperty("SelectedRestaurantDetails") 
    public SelectedRestaurantDetails selectedRestaurantDetails;
    @JsonProperty("PromiseTimePOS") 
    public Object promiseTimePOS;
    @JsonProperty("VIPOSVersion") 
    public Object vIPOSVersion;
    @JsonProperty("CurrentChannel") 
    public int currentChannel;
    @JsonProperty("IsAddHopeChecked") 
    public boolean isAddHopeChecked;
    @JsonProperty("CheckedAddHopeId") 
    public String checkedAddHopeId;
    @JsonProperty("ItemQtyInformation") 
    public String itemQtyInformation;
    @JsonProperty("ItemTotalAmount") 
    public double itemTotalAmount;
    @JsonProperty("AlohaOrderId") 
    public Object alohaOrderId;
    @JsonProperty("MicrosOrderId") 
    public Object microsOrderId;
    @JsonProperty("IsDriverTipAmountChecked") 
    public boolean isDriverTipAmountChecked;
    @JsonProperty("DriverTipAmount") 
    public Object driverTipAmount;
    @JsonProperty("IsDefaultDriverTipChanged") 
    public boolean isDefaultDriverTipChanged;
    @JsonProperty("DeliveryETA") 
    public Object deliveryETA;
    @JsonProperty("IsOrderInQueue") 
    public boolean isOrderInQueue;
}
