package ${{ values.groupId }}.${{ values.artifactId }};

import org.apache.camel.builder.RouteBuilder;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.model.rest.RestBindingMode;

@ApplicationScoped
public class Routes extends RouteBuilder {
  
  @Override
  public void configure() throws Exception {
    restConfiguration()
      .dataFormatProperty("prettyPrint", "true")
      .apiProperty("api.title", "${{ values.artifactId }}")
      .apiProperty("api.version", "1.0.0")
      .apiContextPath("api-docs")
      .bindingMode(RestBindingMode.json);
    
    rest("/api/v1")
      .get("/")
        .description("${{ values.description }}")
        .setBody(constant("Hello World: ${{ values.artifactId }}"))
        .produces("text/plain");
  }
}
