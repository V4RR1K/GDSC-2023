package com.recycleracoon.RecycleRacoonAPI.Persistence;

import com.recycleracoon.RecycleRacoonAPI.Model.User;

import java.io.IOException;

public class UserFileDAO implements UserDAO {

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
