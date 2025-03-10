package com.mritunjay.tutorial;

// Implements the DB interface for production environment.
public class ProdDB implements DB {
    @Override
    public String getData() {
        return "Prod Data"; // Returns production-specific data.
    }
}
