package co.za.izinga.menuupdater.chickenlicken.categories;

public class Datum {
    private PurpleType type;
    private String id;
    private DatumAttributes attributes;
    private DatumRelationships relationships;
    private DatumLinks links;

    public PurpleType getType() {
        return type;
    }

    public void setType(PurpleType value) {
        this.type = value;
    }

    public String getID() {
        return id;
    }

    public void setID(String value) {
        this.id = value;
    }

    public DatumAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(DatumAttributes value) {
        this.attributes = value;
    }

    public DatumRelationships getRelationships() {
        return relationships;
    }

    public void setRelationships(DatumRelationships value) {
        this.relationships = value;
    }

    public DatumLinks getLinks() {
        return links;
    }

    public void setLinks(DatumLinks value) {
        this.links = value;
    }
}
