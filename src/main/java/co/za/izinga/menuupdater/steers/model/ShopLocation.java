package co.za.izinga.menuupdater.steers.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ShopLocation {

    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Address")
    private String address;
    @JsonProperty("TelephoneNumber")
    private String telephoneNumber;
    @JsonProperty("Latitude")
    private Double latitude;
    @JsonProperty("Longitude")
    private Double longitude;
    @JsonProperty("DoesDelivery")
    private Boolean doesDelivery;
    @JsonProperty("DoesCollect")
    private Boolean doesCollect;
    @JsonProperty("DoesKerbside")
    private Boolean doesKerbside;
    @JsonProperty("DoesDineIn")
    private Boolean doesDineIn;
    @JsonProperty("DoesToGo")
    private Boolean doesToGo;
    @JsonProperty("DeliveryTimeInMinutes")
    private Double deliveryTimeInMinutes;
    @JsonProperty("CollectTimeInMinutes")
    private Double collectTimeInMinutes;
    @JsonProperty("IsTemporarilyClosed")
    private Boolean isTemporarilyClosed;
    @JsonProperty("DeliveryFreeAmount")
    private Double deliveryFreeAmount;
    @JsonProperty("IsEligibleForFreeDelivery")
    private Boolean isEligibleForFreeDelivery;
    @JsonProperty("Distance")
    private Double distance;
    @JsonProperty("IsOnline")
    private Boolean isOnline;
    @JsonProperty("IsOnlineOrderingSupported")
    private Boolean isOnlineOrderingSupported;
    @JsonProperty("IsOnlinePaymentAllowed")
    private Boolean isOnlinePaymentAllowed;
    @JsonProperty("BrandId")
    private Integer brandId;
    @JsonProperty("EstimatedDeliveryFee")
    private Object estimatedDeliveryFee;
    @JsonProperty("MenuId")
    private Integer menuId;
    @JsonProperty("StoreState")
    private String storeState;
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("TimeZoneOffset")
    private String timeZoneOffset;
    @JsonProperty("ImageURL")
    private String imageURL;
    @JsonProperty("DeliveryTradingHours")
    private Object deliveryTradingHours;
    @JsonProperty("Categories")
    private List<Object> categories;

    @JsonProperty("Id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("Address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("TelephoneNumber")
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    @JsonProperty("TelephoneNumber")
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @JsonProperty("Latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("Latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("Longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("Longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("DoesDelivery")
    public Boolean getDoesDelivery() {
        return doesDelivery;
    }

    @JsonProperty("DoesDelivery")
    public void setDoesDelivery(Boolean doesDelivery) {
        this.doesDelivery = doesDelivery;
    }

    @JsonProperty("DoesCollect")
    public Boolean getDoesCollect() {
        return doesCollect;
    }

    @JsonProperty("DoesCollect")
    public void setDoesCollect(Boolean doesCollect) {
        this.doesCollect = doesCollect;
    }

    @JsonProperty("DoesKerbside")
    public Boolean getDoesKerbside() {
        return doesKerbside;
    }

    @JsonProperty("DoesKerbside")
    public void setDoesKerbside(Boolean doesKerbside) {
        this.doesKerbside = doesKerbside;
    }

    @JsonProperty("DoesDineIn")
    public Boolean getDoesDineIn() {
        return doesDineIn;
    }

    @JsonProperty("DoesDineIn")
    public void setDoesDineIn(Boolean doesDineIn) {
        this.doesDineIn = doesDineIn;
    }

    @JsonProperty("DoesToGo")
    public Boolean getDoesToGo() {
        return doesToGo;
    }

    @JsonProperty("DoesToGo")
    public void setDoesToGo(Boolean doesToGo) {
        this.doesToGo = doesToGo;
    }

    @JsonProperty("DeliveryTimeInMinutes")
    public Double getDeliveryTimeInMinutes() {
        return deliveryTimeInMinutes;
    }

    @JsonProperty("DeliveryTimeInMinutes")
    public void setDeliveryTimeInMinutes(Double deliveryTimeInMinutes) {
        this.deliveryTimeInMinutes = deliveryTimeInMinutes;
    }

    @JsonProperty("CollectTimeInMinutes")
    public Double getCollectTimeInMinutes() {
        return collectTimeInMinutes;
    }

    @JsonProperty("CollectTimeInMinutes")
    public void setCollectTimeInMinutes(Double collectTimeInMinutes) {
        this.collectTimeInMinutes = collectTimeInMinutes;
    }

    @JsonProperty("IsTemporarilyClosed")
    public Boolean getIsTemporarilyClosed() {
        return isTemporarilyClosed;
    }

    @JsonProperty("IsTemporarilyClosed")
    public void setIsTemporarilyClosed(Boolean isTemporarilyClosed) {
        this.isTemporarilyClosed = isTemporarilyClosed;
    }

    @JsonProperty("DeliveryFreeAmount")
    public Double getDeliveryFreeAmount() {
        return deliveryFreeAmount;
    }

    @JsonProperty("DeliveryFreeAmount")
    public void setDeliveryFreeAmount(Double deliveryFreeAmount) {
        this.deliveryFreeAmount = deliveryFreeAmount;
    }

    @JsonProperty("IsEligibleForFreeDelivery")
    public Boolean getIsEligibleForFreeDelivery() {
        return isEligibleForFreeDelivery;
    }

    @JsonProperty("IsEligibleForFreeDelivery")
    public void setIsEligibleForFreeDelivery(Boolean isEligibleForFreeDelivery) {
        this.isEligibleForFreeDelivery = isEligibleForFreeDelivery;
    }

    @JsonProperty("Distance")
    public Double getDistance() {
        return distance;
    }

    @JsonProperty("Distance")
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @JsonProperty("IsOnline")
    public Boolean getIsOnline() {
        return isOnline;
    }

    @JsonProperty("IsOnline")
    public void setIsOnline(Boolean isOnline) {
        this.isOnline = isOnline;
    }

    @JsonProperty("IsOnlineOrderingSupported")
    public Boolean getIsOnlineOrderingSupported() {
        return isOnlineOrderingSupported;
    }

    @JsonProperty("IsOnlineOrderingSupported")
    public void setIsOnlineOrderingSupported(Boolean isOnlineOrderingSupported) {
        this.isOnlineOrderingSupported = isOnlineOrderingSupported;
    }

    @JsonProperty("IsOnlinePaymentAllowed")
    public Boolean getIsOnlinePaymentAllowed() {
        return isOnlinePaymentAllowed;
    }

    @JsonProperty("IsOnlinePaymentAllowed")
    public void setIsOnlinePaymentAllowed(Boolean isOnlinePaymentAllowed) {
        this.isOnlinePaymentAllowed = isOnlinePaymentAllowed;
    }

    @JsonProperty("BrandId")
    public Integer getBrandId() {
        return brandId;
    }

    @JsonProperty("BrandId")
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @JsonProperty("EstimatedDeliveryFee")
    public Object getEstimatedDeliveryFee() {
        return estimatedDeliveryFee;
    }

    @JsonProperty("EstimatedDeliveryFee")
    public void setEstimatedDeliveryFee(Object estimatedDeliveryFee) {
        this.estimatedDeliveryFee = estimatedDeliveryFee;
    }

    @JsonProperty("MenuId")
    public Integer getMenuId() {
        return menuId;
    }

    @JsonProperty("MenuId")
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @JsonProperty("StoreState")
    public String getStoreState() {
        return storeState;
    }

    @JsonProperty("StoreState")
    public void setStoreState(String storeState) {
        this.storeState = storeState;
    }

    @JsonProperty("IsActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("IsActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("TimeZoneOffset")
    public String getTimeZoneOffset() {
        return timeZoneOffset;
    }

    @JsonProperty("TimeZoneOffset")
    public void setTimeZoneOffset(String timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
    }

    @JsonProperty("ImageURL")
    public String getImageURL() {
        return imageURL;
    }

    @JsonProperty("ImageURL")
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @JsonProperty("DeliveryTradingHours")
    public Object getDeliveryTradingHours() {
        return deliveryTradingHours;
    }

    @JsonProperty("DeliveryTradingHours")
    public void setDeliveryTradingHours(Object deliveryTradingHours) {
        this.deliveryTradingHours = deliveryTradingHours;
    }

    @JsonProperty("Categories")
    public List<Object> getCategories() {
        return categories;
    }

    @JsonProperty("Categories")
    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }
}
