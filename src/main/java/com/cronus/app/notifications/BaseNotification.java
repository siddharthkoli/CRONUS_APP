package com.cronus.app.notifications;

public abstract class BaseNotification {
    private String id;

    public BaseNotification(String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
    
    protected abstract void sendNotification(String msg);
}
