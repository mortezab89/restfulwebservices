package com.morteza.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDao;
    //GET /users
    //retrieve all users
    @GetMapping("/users")
    public List<User> retrieveUsers(){
        return userDao.findAll();
    }

    //retirieve user(int id)
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable  int id){
        return userDao.findOne(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody  User user){
        User savedUser = userDao.save(user);
    }
}
