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

        try {
            return Response.temporaryRedirect(new URI(url)).build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        // Nothing to do, no resources to close
    }
}
