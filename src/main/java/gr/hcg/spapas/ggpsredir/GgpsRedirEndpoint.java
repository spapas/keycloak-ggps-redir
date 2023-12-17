package gr.hcg.spapas.ggpsredir;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.keycloak.services.resource.RealmResourceProvider;

import java.net.URI;
import java.net.URISyntaxException;

public class GgpsRedirEndpoint implements RealmResourceProvider {

    public final static String ID = "ggps-redir";

    @Override
    public Object getResource() {
        return this;
    }


    @GET
    @Path("redir")
    @Produces(MediaType.TEXT_PLAIN)
    public Response get2(@QueryParam("url") String url) {
        URI uri;
        if(url == null || url.isBlank()) {
            url = "https://www.gov.gr/";
        }
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            try {
                uri = new URI("https://www.gov.gr/");
            } catch (URISyntaxException ex) {
                throw new RuntimeException(ex);
            }
        }
        return Response.temporaryRedirect(uri).build();
    }

    @Override
    public void close() {
        // Nothing to do, no resources to close
    }
}
