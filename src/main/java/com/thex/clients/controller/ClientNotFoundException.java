package com.thex.clients.controller;

public class ClientNotFoundException extends RuntimeException {

    ClientNotFoundException(Long ID) {
        super("Could not find client " + ID);
    }
}