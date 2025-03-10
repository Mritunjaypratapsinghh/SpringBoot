package com.mritunjay.tutorial;

// Implements the DB interface for development environment.
public class DevDB implements DB {
    @Override
    public String getData() {
        return "Dev Data"; // Returns development-specific data.
    }
}
