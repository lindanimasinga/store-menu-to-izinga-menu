package co.za.izinga.menuupdater.chickenlicken.categories;

import java.time.OffsetDateTime;

public class IncludedAttributes {
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private String fileName;
    private String url;
    private String title;
    private String slug;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String value) {
        this.fileName = value;
    }

    public String getURL() {
        return url;
    }

    public void setURL(String value) {
        this.url = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String value) {
        this.slug = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }
}
