package com.cronus.app.Notification;

import com.cronus.app.Notification.Base.BaseNotification;

public class TelegramNotification  extends BaseNotification{

    private static String host = "api.telegram.org";
    private static String path = "";
    public TelegramNotification(){
        super();
    }
    @Override
    public void SendNotification(String Message) {
       
        
    }
    private static void CheckAndAddNewUsers(){

    }

    private static void AnalyseCommands(){

    }
    private static void GetUpdates()
    {

    }

    private String GenerateWelcomeMessage(){
        return "Hey! Thanks for pinging me!\nI\'m Cronus, as in the Greek God of Time. I\'ll make sure that you'll get your notifications for your reminders on time.\n Be seeing you! \\m/'";
    }
    
    private void ExecuteMyReminders()
    {
        
    }
}
