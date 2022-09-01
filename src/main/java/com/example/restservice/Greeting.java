package com.example.restservice;

// plain java object with fields
public class Greeting {
    private final long id;
    private final String content;

    // constructor
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    // id accessor
    public long getId() {
        return id;
    }

    // content accessor
    public String getContent() {
        return content;
    }
}