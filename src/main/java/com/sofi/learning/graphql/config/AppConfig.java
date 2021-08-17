package com.sofi.learning.graphql.config;

import com.sofi.learning.graphql.resolver.AnimalResolver;
import com.sofi.learning.graphql.resolver.CatResolver;
import com.sofi.learning.graphql.resolver.DogResolver;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@Configuration
public class AppConfig {

    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    final ResourceLoader resourceLoader;
    final AnimalResolver animalResolver;
    final DogResolver dogResolver;
    final CatResolver catResolver;

    @ConstructorBinding
    public AppConfig(ResourceLoader resourceLoader,
                     AnimalResolver animalResolver,
                     DogResolver dogResolver,
                     CatResolver catResolver) {
        this.resourceLoader = resourceLoader;
        this.animalResolver =  animalResolver;
        this.dogResolver =  dogResolver;
        this.catResolver =  catResolver;
    }

    /**
     * This is ONE method... it works, but it is a little complex.
     * Using the GraphQL Tools library makes things even easier
     *
     * @return - a GraphQLSchema for simple queries against "someField"
     */
    @Bean
    public GraphQLSchema graphQLSchema() {
        SchemaParser parser = new SchemaParser();
        SchemaGenerator generator = new SchemaGenerator();

        TypeDefinitionRegistry registry = null;
        RuntimeWiring wiring = null;
        try {
            Resource resource = resourceLoader.getResource("classpath:models.graphqls");  //points to  resource directory on class path and laods file called "models.graphqls"
            registry = parser.parse(resource.getFile());    // preparing to register the types defined in models.graphqls
            wiring = RuntimeWiring.newRuntimeWiring()
                    .type("Queries", builder -> builder
                            //dataFetcher is the Java/JVM parlance for "Resolvers" (in the JS world); this method associates "animal" to the AnimalResolver object
                            .dataFetcher("animal", animalResolver)
                            .dataFetcher("dog", dogResolver)
                            .dataFetcher("cat", catResolver)
                    ).build();

        } catch(Exception e) {
            logger.warn("ERROR trying to get registry {}", e.getMessage());
        }

        return generator.makeExecutableSchema(registry, wiring);
    }

}
