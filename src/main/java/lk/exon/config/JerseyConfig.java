package lk.exon.config;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api") // Base path for API
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("lk.exon.controllers"); // Register controller package
    }
}
