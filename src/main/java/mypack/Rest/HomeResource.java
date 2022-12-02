package mypack.Rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import mypack.Faces.GreetingService;

@ApplicationPath("/api")
@Path("/greet")
public class HomeResource extends Application {

  @Inject
  GreetingService greetingService;

  @GET
  public String getHello() {
    return "Hello, world!";
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Animal postHello(Animal animal) {
    return animal;
  }

  @GET
  @Path("/{name}")
  @Produces(MediaType.TEXT_PLAIN)
  public String doGreeting(@PathParam("name") String name, @QueryParam("lang") String lang) {
    return String.format(greetingService.greetingTemplate(lang), name);
  }

  @GET
  @Path("/json")
  @Produces(MediaType.APPLICATION_JSON)
  public Animal getJson() {
    return new Animal("Fido", "Dog");
  }
}
