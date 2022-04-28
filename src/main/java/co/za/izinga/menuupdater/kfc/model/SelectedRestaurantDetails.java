package co.za.izinga.menuupdater.kfc.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class SelectedRestaurantDetails{
    @JsonProperty("RestaurantGroupId") 
    public Object restaurantGroupId;
    @JsonProperty("OpenTime") 
    public Date openTime;
    @JsonProperty("CloseTime") 
    public Date closeTime;
    @JsonProperty("PrevOpenTime") 
    public Date prevOpenTime;
    @JsonProperty("PrevCloseTime") 
    public Date prevCloseTime;
    @JsonProperty("CurbsideService") 
    public boolean curbsideService;
    @JsonProperty("TimeZone") 
    public String timeZone;
    @JsonProperty("OpenDate") 
    public Date openDate;
    @JsonProperty("CloseDate") 
    public Date closeDate;
    @JsonProperty("OpenCloseTimes") 
    public OpenCloseTimes openCloseTimes;
    @JsonProperty("RestaurantStatus") 
    public Object restaurantStatus;
    @JsonProperty("FranchiseRedirectionUrl") 
    public Object franchiseRedirectionUrl;
    @JsonProperty("RestaurantRedirectionUrl") 
    public Object restaurantRedirectionUrl;
    @JsonProperty("CommunicationMethod") 
    public int communicationMethod;
    @JsonProperty("PrimaryAddress") 
    public String primaryAddress;
    @JsonProperty("SecondaryAddress") 
    public Object secondaryAddress;
    @JsonProperty("TaxSourceType") 
    public int taxSourceType;
    @JsonProperty("POSType") 
    public int pOSType;
    @JsonProperty("AlohaStoreKey") 
    public int alohaStoreKey;
    @JsonProperty("RestaurantTimings") 
    public RestaurantTimings restaurantTimings;
    @JsonProperty("ScheduledCloseDates") 
    public Object scheduledCloseDates;
    @JsonProperty("IsRestaurantOpen") 
    public boolean isRestaurantOpen;
    @JsonProperty("IsSamedayButRestNotOpen") 
    public boolean isSamedayButRestNotOpen;
    @JsonProperty("IsRestShutdownForNextDay") 
    public boolean isRestShutdownForNextDay;
    @JsonProperty("IsTechnicalShutDown") 
    public boolean isTechnicalShutDown;
    @JsonProperty("IsRestaurantshutdown") 
    public boolean isRestaurantshutdown;
    @JsonProperty("MinCarryoutOrderingLimit") 
    public int minCarryoutOrderingLimit;
    @JsonProperty("MinDeliveryOrderingLimit") 
    public int minDeliveryOrderingLimit;
    @JsonProperty("MaxCarryOutOrderingLimit") 
    public double maxCarryOutOrderingLimit;
    @JsonProperty("MaxcateringOrderingLimit") 
    public int maxcateringOrderingLimit;
    @JsonProperty("MaxDeliveryOrderingLimit") 
    public double maxDeliveryOrderingLimit;
    @JsonProperty("MinCateringOrderingLimit") 
    public int minCateringOrderingLimit;
    @JsonProperty("ImageName") 
    public Object imageName;
    @JsonProperty("RestaurantNumber") 
    public int restaurantNumber;
    @JsonProperty("IsCarryoutSupported") 
    public boolean isCarryoutSupported;
    @JsonProperty("IsDeliverySupported") 
    public boolean isDeliverySupported;
    @JsonProperty("IsDineInSupported") 
    public boolean isDineInSupported;
    @JsonProperty("IsCateringSupported") 
    public boolean isCateringSupported;
    @JsonProperty("RestaurantServices") 
    public Object restaurantServices;
    @JsonProperty("HolidayStartEndDateTimes") 
    public ArrayList<Object> holidayStartEndDateTimes;
    @JsonProperty("POSItemId") 
    public String pOSItemId;
    @JsonProperty("StoreLocatorId") 
    public Object storeLocatorId;
    @JsonProperty("RestaurantCity") 
    public Object restaurantCity;
    @JsonProperty("FranchiseName") 
    public Object franchiseName;
    @JsonProperty("IsOnlinePaymentSupported") 
    public boolean isOnlinePaymentSupported;
    @JsonProperty("IsDealConversionSupported") 
    public boolean isDealConversionSupported;
    @JsonProperty("IsSuggestiveUpsellSupported") 
    public boolean isSuggestiveUpsellSupported;
    @JsonProperty("IsDealSupported") 
    public boolean isDealSupported;
    @JsonProperty("PaymentType") 
    public int paymentType;
    @JsonProperty("DeliveryCharge") 
    public double deliveryCharge;
    @JsonProperty("DeliveryAmount") 
    public int deliveryAmount;
    public boolean isRestaurantOffline;
    public boolean isFavRestaurant;
    @JsonProperty("RestaurantOrderModeOpenCloseTimes") 
    public ArrayList<RestaurantOrderModeOpenCloseTime> restaurantOrderModeOpenCloseTimes;
    @JsonProperty("IsRestaurantOpenPreviousDay") 
    public boolean isRestaurantOpenPreviousDay;
    @JsonProperty("PaymentMerchantId") 
    public String paymentMerchantId;
    @JsonProperty("PaymentAccountId") 
    public String paymentAccountId;
    @JsonProperty("PaymentSecret") 
    public String paymentSecret;
    @JsonProperty("PassWord") 
    public String passWord;
    @JsonProperty("Non3DMerchantID") 
    public String non3DMerchantID;
    @JsonProperty("Non3DPassword") 
    public String non3DPassword;
    public boolean isOneClickSupported;
    @JsonProperty("IsautoSettlementOn") 
    public boolean isautoSettlementOn;
    @JsonProperty("ProductExclusionList") 
    public ArrayList<ProductExclusionList> productExclusionList;
    @JsonProperty("EmergencyShutdowns") 
    public Object emergencyShutdowns;
    @JsonProperty("Tips") 
    public Object tips;
    @JsonProperty("TaxDetails") 
    public ArrayList<Object> taxDetails;
    @JsonProperty("BottleDepositDetails") 
    public ArrayList<Object> bottleDepositDetails;
    @JsonProperty("FutureOrderDayLimit") 
    public int futureOrderDayLimit;
    @JsonProperty("FutureCateringOrderDayLimit") 
    public int futureCateringOrderDayLimit;
    @JsonProperty("FutureDeliveryOrderDayLimit") 
    public int futureDeliveryOrderDayLimit;
    @JsonProperty("RestClosedFirstOrderTimeDifferenceCarryout") 
    public String restClosedFirstOrderTimeDifferenceCarryout;
    @JsonProperty("RestClosedLastOrderTimeDifferenceCarryout") 
    public String restClosedLastOrderTimeDifferenceCarryout;
    @JsonProperty("RestClosedFirstOrderTimeDifferenceDelivery") 
    public String restClosedFirstOrderTimeDifferenceDelivery;
    @JsonProperty("RestClosedLastOrderTimeDifferenceDelivery") 
    public String restClosedLastOrderTimeDifferenceDelivery;
    @JsonProperty("RestClosedFirstOrderTimeDifferenceCatering") 
    public String restClosedFirstOrderTimeDifferenceCatering;
    @JsonProperty("RestClosedLastOrderTimeDifferenceCatering") 
    public String restClosedLastOrderTimeDifferenceCatering;
    @JsonProperty("ShowCalorie") 
    public boolean showCalorie;
    @JsonProperty("PromiseTime") 
    public Object promiseTime;
    @JsonProperty("OrderMode") 
    public int orderMode;
    public ArrayList<TenderWithService> tenderWithService;
    @JsonProperty("PrefferedLanguage") 
    public String prefferedLanguage;
    @JsonProperty("IPAddress") 
    public String iPAddress;
    @JsonProperty("UnAvailibilityReason") 
    public int unAvailibilityReason;
    public int deliveryPartnerType;
    @JsonProperty("IsTipEnabled") 
    public boolean isTipEnabled;
    @JsonProperty("RestaurantId") 
    public String restaurantId;
    @JsonProperty("Name") 
    public String name;
    @JsonProperty("Description") 
    public String description;
    @JsonProperty("Address") 
    public Address address;
    @JsonProperty("Phone") 
    public String phone;
    @JsonProperty("SupportPhone") 
    public String supportPhone;
    @JsonProperty("Email") 
    public Object email;
    @JsonProperty("OnlineOrderingEnabled") 
    public boolean onlineOrderingEnabled;
    @JsonProperty("IsCollectionPointEnabled") 
    public boolean isCollectionPointEnabled;
    @JsonProperty("CollectionPoints") 
    public ArrayList<Integer> collectionPoints;
    @JsonProperty("BayNumbers") 
    public ArrayList<Object> bayNumbers;
    @JsonProperty("IsFranchise") 
    public boolean isFranchise;
    @JsonProperty("CarryoutQuoteTime") 
    public String carryoutQuoteTime;
    @JsonProperty("DeliveryQuoteTime") 
    public String deliveryQuoteTime;
    @JsonProperty("QuadrantId") 
    public Object quadrantId;
    @JsonProperty("QuadrantName") 
    public Object quadrantName;
    @JsonProperty("OrderAmount") 
    public int orderAmount;
    @JsonProperty("DisplayName") 
    public Object displayName;
    @JsonProperty("DetailUrlPart1") 
    public Object detailUrlPart1;
    @JsonProperty("DetailUrlPart2") 
    public Object detailUrlPart2;
    @JsonProperty("Latitude") 
    public int latitude;
    @JsonProperty("Longitude") 
    public int longitude;
    @JsonProperty("IsOpenNow") 
    public boolean isOpenNow;
    @JsonProperty("POSID") 
    public Object pOSID;
    @JsonProperty("Distance") 
    public Object distance;
    @JsonProperty("DistanceinDecimal") 
    public int distanceinDecimal;
    @JsonProperty("DayHours") 
    public ArrayList<Object> dayHours;
    @JsonProperty("EmergencyDownModes") 
    public ArrayList<Object> emergencyDownModes;
    @JsonProperty("TechnicalDownModes") 
    public ArrayList<Object> technicalDownModes;
    @JsonProperty("ServiceModes") 
    public ArrayList<Object> serviceModes;
}
