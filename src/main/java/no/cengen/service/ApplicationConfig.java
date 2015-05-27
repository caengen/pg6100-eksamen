package no.cengen.service;

import com.wordnik.swagger.jaxrs.config.BeanConfig;
import com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider;
import com.wordnik.swagger.jaxrs.listing.ApiListingResource;
import com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON;
import com.wordnik.swagger.jaxrs.listing.ResourceListingProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api/")
public class ApplicationConfig extends Application {
    public ApplicationConfig() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setBasePath("http://localhost:8080/pg6100-eksamen-1.0-SNAPSHOT/api");
        beanConfig.setResourcePackage("no.cengen.service");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        addServiceClassesTo(resources);
        addDocumentationClassesTo(resources);

        return resources;
    }

    private void addDocumentationClassesTo(Set<Class<?>> resources) {
        resources.add(ApiListingResource.class);
        resources.add(ApiDeclarationProvider.class);
        resources.add(ApiListingResourceJSON.class);
        resources.add(ResourceListingProvider.class);
    }

    private void addServiceClassesTo(Set<Class<?>> resources) {
        resources.add(TeamService.class);
        resources.add(GameService.class);
        resources.add(ResultService.class);
    }
}
