package com.example.departmentcrud;




import com.example.departmentcrud.Util.CORSFilter;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
// Note that the class extends ResourceConfig and not Application because we want to make use of register()
public class HelloApplication extends ResourceConfig {
    public HelloApplication() {
        // Registering the CORSFilter class with the Jersey ResourceConfig
        register(CORSFilter.class);

        // Telling Jersey the CLASSPATH where the specified classes (in our case, CORSFilter) can be found
        packages("com.example.departmentcrud");
    }
}