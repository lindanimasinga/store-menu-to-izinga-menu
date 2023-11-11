package co.za.izinga.menuupdater.kfc.model;

public class Item {
    private String mdmID;
    private String id;
    private String name;
    private String size;
    private Object linkID;
    private String url;
    private boolean isPromo;
    private String posID;
    private long displayOrder;
    private boolean customizable;
    private Dname[] dname;
    private Dname[] shortDescription;
    private Dname[] longDescription;
    private Dname[] imageName;
    private Object modgrps;
    private boolean isHidden;
    private Availability[] availability;
    private long effectiveStartDateTime;
    private long effectiveEndDateTime;
    private Object recommendationRules;
    private String[] categoryURL;
    private String categoryID;

    public String getMdmID() {
        return mdmID;
    }

    public void setMdmID(String value) {
        this.mdmID = value;
    }

    public String getID() {
        return id;
    }

    public void setID(String value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String value) {
        this.size = value;
    }

    public Object getLinkID() {
        return linkID;
    }

    public void setLinkID(Object value) {
        this.linkID = value;
    }

    public String getURL() {
        return url;
    }

    public void setURL(String value) {
        this.url = value;
    }

    public boolean getIsPromo() {
        return isPromo;
    }

    public void setIsPromo(boolean value) {
        this.isPromo = value;
    }

    public String getPosID() {
        return posID;
    }

    public void setPosID(String value) {
        this.posID = value;
    }

    public long getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(long value) {
        this.displayOrder = value;
    }

    public boolean getCustomizable() {
        return customizable;
    }

    public void setCustomizable(boolean value) {
        this.customizable = value;
    }

    public Dname[] getDname() {
        return dname;
    }

    public void setDname(Dname[] value) {
        this.dname = value;
    }

    public Dname[] getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(Dname[] value) {
        this.shortDescription = value;
    }

    public Dname[] getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(Dname[] value) {
        this.longDescription = value;
    }

    public Dname[] getImageName() {
        return imageName;
    }

    public void setImageName(Dname[] value) {
        this.imageName = value;
    }

    public Object getModgrps() {
        return modgrps;
    }

    public void setModgrps(Object value) {
        this.modgrps = value;
    }

    public boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(boolean value) {
        this.isHidden = value;
    }

    public long getEffectiveStartDateTime() {
        return effectiveStartDateTime;
    }

    public void setEffectiveStartDateTime(long value) {
        this.effectiveStartDateTime = value;
    }

    public long getEffectiveEndDateTime() {
        return effectiveEndDateTime;
    }

    public void setEffectiveEndDateTime(long value) {
        this.effectiveEndDateTime = value;
    }

    public Object getRecommendationRules() {
        return recommendationRules;
    }

    public void setRecommendationRules(Object value) {
        this.recommendationRules = value;
    }

    public String[] getCategoryURL() {
        return categoryURL;
    }

    public void setCategoryURL(String[] value) {
        this.categoryURL = value;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String value) {
        this.categoryID = value;
    }

    public Availability[] getAvailability() {
        return availability;
    }

    public void setAvailability(Availability[] availability) {
        this.availability = availability;
    }
}
