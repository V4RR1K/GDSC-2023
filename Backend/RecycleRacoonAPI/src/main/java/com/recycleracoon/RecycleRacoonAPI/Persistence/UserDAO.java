package com.recycleracoon.RecycleRacoonAPI.Persistence;

import java.io.IOException;
import com.recycleracoon.RecycleRacoonAPI.Model.User;


public interface UserDAO {
    /**
     * getUsers gets all users
     * @return all users in an array
     * @throws IOException if issue with internal storage
     */
    User[] getUsers() throws IOException;

    /**
     * getUser gets a user by ID
     * @param id userID
     * @return User
     * @throws IOException if issue with internal storage
     */
    User getUser(int id) throws IOException;

    /**
     * createUser creates a new user
     * @param newUser given user to create
     * @return created user
     * @throws IOException if issue with internal storage
     */
    User createUser(User newUser) throws IOException;

    /**
     * updateUser updates user with new information
     * this will be how a new location will be added to user list
     * @param updatedUser user with updated information
     * @return the updated user
     * @throws IOException if issue with internal storage
     */
    User updateUser(User updatedUser) throws IOException;

    /**
     * deleteUser deletes user with given id
     * @param id user id
     * @return true if user was deleted, false if not
     * @throws IOException if issue with internal storage
     */
    boolean deleteUser(int id) throws IOException;
}
