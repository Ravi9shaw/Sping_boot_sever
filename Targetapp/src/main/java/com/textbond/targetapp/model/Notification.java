package com.textbond.targetapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "notifications")
/*
Well Document is used here to say MangoDB to Map it out
and the collection = "notifications" u see this is used when u app is connect to the mangoDB server or anything it will create a new table for u to store u data
 */
public class Notification {

    @Id
    /*
    well MangoDB creates(by default) a default ID for each quary or content u create,insert even for the object creation
    So we are asking mangoDb to send its value so that we can store it use it and manupilate it to
     */
    private String id;

    private String userId;
    private String message;
    private boolean read;
    private LocalDateTime createdAt;

    /*
    we are creating this default constructor bcz by default spring use the default constuctor of every POJO and we have create
    a parameterised constroctor so that spring,MangoDB can also use it
    Also to create a Bean to
     */
    public Notification() {
    }

    // We are using it to define the objects
    public Notification(String userId, String message) {
        this.userId = userId;
        this.message = message;
        this.read = false;
        this.createdAt = LocalDateTime.now();
    }

    // we are creating this methords so that other System can interact with it and set values that is also some of the reason we have default one
    //EX Json,MAngoDB
    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }

    public boolean isRead() {
        return read;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
