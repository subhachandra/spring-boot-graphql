package com.portal.springbootgraphql.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.portal.springbootgraphql.models.User;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, ObjectId>{

    List<User> findByIdIn(List<String> ids);
  
}
