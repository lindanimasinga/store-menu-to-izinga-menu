
package co.za.izinga.menuupdater.chickenlicken.categories;

import java.util.HashMap;
import java.util.Map;

import co.za.izinga.menuupdater.nandos.model.NandosMenu;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "links"
})

public class ImageSet {

    private Image productImage;

    public Image getProductImage() {
        return productImage;
    }

    public void setProductImage(Image productImage) {
        this.productImage = productImage;
    }

    public static class Image {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
