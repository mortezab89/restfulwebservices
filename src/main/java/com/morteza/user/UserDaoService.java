package com.morteza.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<User>();

    private Integer usersCount = 3;

    static {
        users.add(new User(1, "Morteza", new Date()));
        users.add(new User(2, "John", new Date()));
        users.add(new User(3, "Joe", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User  save(User user){
        if(user.getId() == null){
            user.setId(++usersCount);
        }
        users.add(user);

        return user;
    }

    public User findOne(int id){
        for (User user : users) {
            if(user.getId().equals(id))
                return user;
        }
        return null;
    }

    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if(user.getId().equals(id)) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }



}
