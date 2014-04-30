import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by dkazakov on 29.04.2014.
 */
public class Main {

    public static void main(String... args) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080")
                .path("Rest")
                .path("rest")
                .path("hotels");
        Response response = target.request(MediaType.APPLICATION_JSON_TYPE).get();
        System.out.println(response.getStatus());
        System.out.println();
    }

}
