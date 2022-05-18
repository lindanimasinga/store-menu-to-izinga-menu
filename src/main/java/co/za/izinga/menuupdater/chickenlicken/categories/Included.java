package co.za.izinga.menuupdater.chickenlicken.categories;

public class Included {
    private DataType type;
    private String id;
    private IncludedAttributes attributes;
    private IncludedRelationships relationships;

    public DataType getType() {
        return type;
    }

    public void setType(DataType value) {
        this.type = value;
    }

    public String getID() {
        return id;
    }

    public void setID(String value) {
        this.id = value;
    }

    public IncludedAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(IncludedAttributes value) {
        this.attributes = value;
    }

    public IncludedRelationships getRelationships() {
        return relationships;
    }

    public void setRelationships(IncludedRelationships value) {
        this.relationships = value;
    }
}
