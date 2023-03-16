package com.recycleracoon.RecycleRacoonAPI.Controller;

import com.recycleracoon.RecycleRacoonAPI.Model.User;
import com.recycleracoon.RecycleRacoonAPI.Persistence.UserDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("users")
public class UserController {
    private static final Logger LOG = Logger.getLogger(UserController.class.getName());
    private UserDAO userDao;

    public UserController(UserDAO userDao){
        this.userDao = userDao;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        LOG.info("GET /users/" + id);
        try{
            User user = userDao.getUser(id);
            if (user != null) {
                return new ResponseEntity<User>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<User[]> getUsers(){
        LOG.info("GET /users/");
        try{
            User[] users = userDao.getUsers();
            if (users != null) {
                return new ResponseEntity<User[]>(users, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user){
        LOG.info("POST /users/" + user);
        try {
            User newUser = userDao.createUser(user);
            if (newUser != null){
                return new ResponseEntity<User>(user, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        } catch (IOException e){
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        LOG.info("PUT /users/" + user);
        try {
            User newUser = userDao.updateUser(user);
            if (newUser != null){
                return new ResponseEntity<User>(user, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e){
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("")
    public ResponseEntity<User> deleteUser (@RequestBody User user) {
        LOG.info("PUT /users/" + user);
        try {
            boolean deleted = userDao.deleteUser(user.getId());
            if (deleted) {
                return new ResponseEntity<User>(user, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
