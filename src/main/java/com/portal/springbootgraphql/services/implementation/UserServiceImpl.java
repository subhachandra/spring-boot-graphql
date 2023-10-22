package com.portal.springbootgraphql.services.implementation;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portal.springbootgraphql.models.User;
import com.portal.springbootgraphql.repositories.UserRepository;
import com.portal.springbootgraphql.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return (ArrayList) userRepository.findAll();
    }

//    @Override
//    public User findOneById(ObjectId id) {
//        return userRepository.findOne(id);
//    }

    @Override
    public List<User> findByIdIn(List<String> ids) {
        return userRepository.findByIdIn(ids);
    }

	@Override
	public User findOneById(ObjectId id) {
		return null;
		
	}
}
