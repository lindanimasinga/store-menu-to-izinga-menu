package co.za.izinga.menuupdater.chickenlicken.categories;

import java.time.OffsetDateTime;

public class DatumAttributes {
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private String title;
    private long position;
    private String subtitle;
    private String socialMeta;
    private long specialfont;
    private Long onmenu;
    private Object slug;
    private String description;

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime value) {
        this.createdAt = value;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime value) {
        this.updatedAt = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long value) {
        this.position = value;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String value) {
        this.subtitle = value;
    }

    public String getSocialMeta() {
        return socialMeta;
    }

    public void setSocialMeta(String value) {
        this.socialMeta = value;
    }

    public long getSpecialfont() {
        return specialfont;
    }

    public void setSpecialfont(long value) {
        this.specialfont = value;
    }

    public Long getOnmenu() {
        return onmenu;
    }

    public void setOnmenu(Long value) {
        this.onmenu = value;
    }

    public Object getSlug() {
        return slug;
    }

    public void setSlug(Object value) {
        this.slug = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }
}
