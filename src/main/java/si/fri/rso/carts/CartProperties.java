package si.fri.rso.carts;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;

import javax.enterprise.context.ApplicationScoped;

@ConfigBundle("carts")
@ApplicationScoped
public class CartProperties {

    private String catalogueUrl = "http://localhost:3000";

    public String getCatalogueUrl() {
        return catalogueUrl;
    }

    public void setCatalogueUrl(String catalogueUrl) {
        this.catalogueUrl = catalogueUrl;
    }
}
