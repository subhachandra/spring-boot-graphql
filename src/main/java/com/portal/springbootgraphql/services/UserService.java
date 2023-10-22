package com.portal.springbootgraphql.services;

import org.bson.types.ObjectId;
import com.portal.springbootgraphql.models.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();
    User findOneById(ObjectId id);
    List<User> findByIdIn(List<String>ids);
}
