package com.recycleracoon.RecycleRacoonAPI.Persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recycleracoon.RecycleRacoonAPI.Model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

@Component
public class UserFileDAO implements UserDAO {
    Map<Integer, User> users;

    private final ObjectMapper objectMapper;
    private static int nextId;
    private final String filename;

    public UserFileDAO(@Value("${users.file}") String filename,
                              ObjectMapper objectMapper) throws IOException {
        this.objectMapper = objectMapper;
        this.filename = filename;
        load();
    }

    private synchronized static int nextId() {
        int id = nextId;
        ++nextId;
        return id;
    }

    private User[] getUserArray(){
        ArrayList<User> userArrayList = new ArrayList<>();

        for (User user: users.values()) {
            userArrayList.add(user);
        }

        User[] userList = new User[userArrayList.size()];
        userArrayList.toArray(userList);
        return userList;
    }

    private boolean save() throws IOException{
        User[] userList = getUserArray();
        objectMapper.writeValue(new File(filename), userList);
        return true;
    }

    private boolean load() throws IOException {
        users = new TreeMap<>();
        nextId = 0;

        User[] userList = objectMapper.readValue(new File(filename), User[].class);

        for (User user : userList){
            users.put(user.getId(), user);
            if (user.getId() > nextId){
                nextId = user.getId() + 1;
            }
        }
        return true;
    }

    // --------------------------------- Overrides ---------------------------------

    /**
     * getUsers gets all users
     *
     * @return all users in an array
     * @throws IOException if issue with internal storage
     */
    @Override
    public User[] getUsers() throws IOException {
        return new User[0];
    }

    /**
     * getUser gets a user by ID
     *
     * @param id userID
     * @return User
     * @throws IOException if issue with internal storage
     */
    @Override
    public User getUser(int id) throws IOException {
        return null;
    }

    /**
     * createUser creates a new user
     *
     * @param newUser given user to create
     * @return created user
     * @throws IOException if issue with internal storage
     */
    @Override
    public User createUser(User newUser) throws IOException {
        return null;
    }

    /**
     * updateUser updates user with new information
     * this will be how a new location will be added to user list
     *
     * @param updatedUser user with updated information
     * @return the updated user
     * @throws IOException if issue with internal storage
     */
    @Override
    public User updateUser(User updatedUser) throws IOException {
        return null;
    }

    /**
     * deleteUser deletes user with given id
     *
     * @param id user id
     * @return true if user was deleted, false if not
     * @throws IOException if issue with internal storage
     */
    @Override
    public boolean deleteUser(int id) throws IOException {
        return false;
    }
}
