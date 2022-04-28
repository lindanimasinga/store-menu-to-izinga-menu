package co.za.izinga.menuupdater.kfc.model;
import com.fasterxml.jackson.annotation.JsonProperty; 
public class Address{
    @JsonProperty("Street") 
    public String street;
    @JsonProperty("City") 
    public String city;
    @JsonProperty("ZipCode") 
    public String zipCode;
    @JsonProperty("Country") 
    public String country;
    @JsonProperty("Latitude") 
    public double latitude;
    @JsonProperty("Longitude") 
    public double longitude;
    @JsonProperty("Distance") 
    public int distance;
    @JsonProperty("HouseNumber") 
    public String houseNumber;
    @JsonProperty("District") 
    public String district;
    @JsonProperty("SubDistrict") 
    public String subDistrict;
    @JsonProperty("Comments") 
    public String comments;
}
