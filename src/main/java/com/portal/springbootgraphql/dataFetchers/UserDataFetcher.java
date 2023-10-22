package com.portal.springbootgraphql.dataFetchers;

import graphql.schema.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.portal.springbootgraphql.models.User;
import com.portal.springbootgraphql.services.UserService;

import java.util.Map;

@Component
public class UserDataFetcher implements DataFetcher<User> {

    private final UserService userService;

    @Autowired
    UserDataFetcher(UserService userService){
        this.userService = userService;
    }

    @Override
    public User get(DataFetchingEnvironment env) {
        Map args = env.getArguments();
        User user = userService.findOneById(new ObjectId(String.valueOf(args.get("id"))));
        return null;
    }
}