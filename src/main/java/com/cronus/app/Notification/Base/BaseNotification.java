package com.cronus.app.Notification.Base;

public abstract class BaseNotification {
    private Integer Id;

    public Integer getId() {
        return this.Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public BaseNotification(){
        this.Id = Id;
    }
    
    public abstract void SendNotification(String Message);
}
