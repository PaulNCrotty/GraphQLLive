package com.sofi.learning.graphql.resolver;

import com.sofi.learning.graphql.model.Dog;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DogResolver implements DataFetcher<List<Dog>> {

    @Override
    public List<Dog> get(DataFetchingEnvironment environment) {
        //this is hard-coded... IRL, we would get this data from some datastore
        return Arrays.asList(new Dog(4, "Luna", "Chua-zu"), new Dog(6, "Oscar", "Malt-pom-zu"));
    }
}
