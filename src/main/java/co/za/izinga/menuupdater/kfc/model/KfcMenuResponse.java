package co.za.izinga.menuupdater.kfc.model;
import com.fasterxml.jackson.annotation.JsonProperty;

public class KfcMenuResponse {
    @JsonProperty("Status") 
    public int status;
    @JsonProperty("AjaxResponseMessage") 
    public Object ajaxResponseMessage;
    @JsonProperty("ExceptionDetails") 
    public Object exceptionDetails;
    @JsonProperty("DataObject") 
    public DataObject dataObject;
    @JsonProperty("DialogObject") 
    public Object dialogObject;
    @JsonProperty("ReturnURL") 
    public Object returnURL;
    @JsonProperty("Resources") 
    public String resources;
    @JsonProperty("UrlObject") 
    public UrlObject urlObject;
    @JsonProperty("Code") 
    public Object code;
    @JsonProperty("PolygonData") 
    public Object polygonData;
}
