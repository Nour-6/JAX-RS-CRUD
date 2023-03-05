package activator;



import io.swagger.jaxrs.config.BeanConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class RestActivator extends Application {
    public RestActivator(){
        super();
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("JAX_RS_CRUD_war_exploded/api");
        beanConfig.setResourcePackage("restressources");
        beanConfig.setScan(true);
    }

}
