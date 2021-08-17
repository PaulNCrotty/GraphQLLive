package com.sofi.learning.graphql.resolver;

import com.sofi.learning.graphql.model.Cat;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CatResolver implements DataFetcher<List<Cat>> {

    @Override
    public List<Cat> get(DataFetchingEnvironment environment) {
        //this is hard-coded... IRL, we would get this data from some datastore
        return Arrays.asList(new Cat(4, "Spreckles", "Charlie"), new Cat(6, "Charlie", "Spreckles"));
    }
}
