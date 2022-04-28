package co.za.izinga.menuupdater.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class BaseModel {

    private String id;
    @JsonProperty(value = "date")
    private Date createdDate = new Date();
    private Date modifiedDate;

    public BaseModel() {
    }

    public BaseModel(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
