package com.morteza.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user = userDao.findOne(id);
        if(user == null)
            throw new UserNotFoundException("id-"+id);
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody  User user){
        User savedUser = userDao.save(user);
        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(savedUser.getId()).
                toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id){
        User user = userDao.deleteById(id);

        if(user == null){
            throw new UserNotFoundException("id-"+id);
//            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
