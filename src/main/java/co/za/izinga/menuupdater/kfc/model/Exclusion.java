package co.za.izinga.menuupdater.kfc.model;

public class Exclusion {

    private String activityId;
    private String itemId;
    private String reason;
    private String itemName;
    private String service;
    private String entityType;
    private String channel;
    private Integer startDateInEpoch;
    private String storeId;
    private Object nonAvailabilityCode;
    private Boolean isExcludedDueToTime;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Integer getStartDateInEpoch() {
        return startDateInEpoch;
    }

    public void setStartDateInEpoch(Integer startDateInEpoch) {
        this.startDateInEpoch = startDateInEpoch;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Object getNonAvailabilityCode() {
        return nonAvailabilityCode;
    }

    public void setNonAvailabilityCode(Object nonAvailabilityCode) {
        this.nonAvailabilityCode = nonAvailabilityCode;
    }

    public Boolean getExcludedDueToTime() {
        return isExcludedDueToTime;
    }

    public void setExcludedDueToTime(Boolean excludedDueToTime) {
        isExcludedDueToTime = excludedDueToTime;
    }
}
