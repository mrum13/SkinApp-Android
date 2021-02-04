package com.example.projskinapp.models;

import java.util.List;

public class UserResponse {
    private boolean error;
    private List<User> user;

    public UserResponse(boolean error, List<User> user) {
        this.error = error;
        this.user = user;
    }

    public boolean isError() {
        return error;
    }

    public List<User> getUser() {
        return user;
    }
}
