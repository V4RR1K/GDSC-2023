package com.recycleracoon.RecycleRacoonAPI.Persistence;

import java.io.IOException;
import com.recycleracoon.RecycleRacoonAPI.Model.User;


public interface UserDAO {
    User[] getUsers() throws IOException;

    User getUser(int id) throws IOException;

    User createUser(User newUser) throws IOException;

    User updateUser(User updatedUser) throws IOException;

    boolean deleteUser(int id) throws IOException;
}
