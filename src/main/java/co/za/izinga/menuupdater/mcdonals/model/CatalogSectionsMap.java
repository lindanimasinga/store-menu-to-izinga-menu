package co.za.izinga.menuupdater.mcdonals.model; 
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CatalogSectionsMap{
    //mcd
    @JsonProperty("2ec697b9-6a0d-5c46-83e8-2593f124b852") 
    public List<SelectionMap> mcdCatalog;
    @JsonProperty("d9d8ada9-f07b-5d43-a023-f5d674b83dc8")
    public List<SelectionMap> selectionMap2;

    //spur
    @JsonProperty("fb398ce1-7c05-51cd-81d6-356642ea2435")
    public List<SelectionMap> spurCatalog;

    //bp garage
    @JsonProperty("c4bb2df2-5a63-48a9-90ab-4b5895d174fa")
    public List<SelectionMap> bpCatalog;

    //woolworths garage
    @JsonProperty("e5f6d7ff-95e1-5e0b-85dd-121dae634541")
    public List<SelectionMap> woolworthsCatalog;
}
