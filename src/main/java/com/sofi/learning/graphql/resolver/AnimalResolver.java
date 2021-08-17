package com.sofi.learning.graphql.resolver;

import com.sofi.learning.graphql.model.Animal;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class AnimalResolver implements DataFetcher<List<Animal>> {

    @Override
    public List<Animal> get(DataFetchingEnvironment environment) {  // the environment variable contains information/objects containing data about parameters which may have been passed into the graphQL query
        Map<String, Object> arguments = environment.getArguments();
        for(String s: arguments.keySet()) {
            System.out.println("Key: " + s + ", Value: " + arguments.get(s));
        }
        //this is hard-coded... IRL, we would get this data from some datastore
        return Arrays.asList(new Animal(4, "Luna"), new Animal(6, "Oscar"));
    }
}
