package com.cronus.app.notifications;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

import com.cronus.app.PropertiesReader;

import org.json.JSONArray;
import org.json.JSONObject;

public class TelegramNotification extends BaseNotification {
    static final String host = PropertiesReader.getProperty("API_HOST");
    static final String path = String.format("bot%s/", PropertiesReader.getProperty("BOT_KEY"));

    public TelegramNotification(String id) {
        super(id);
    }

    protected static HttpURLConnection createConnection(String requestMethod, String requestEndpoint) {
        try {
            URL url = new URL(String.format("%s%s%s", host, path, requestEndpoint));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(requestMethod);
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            return connection;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    protected void attachJSON(String jsonInputString, HttpURLConnection connection) {
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    protected static JSONObject getJSONOutput(HttpURLConnection connection) {
        try {
            StringBuilder response = new StringBuilder();
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }

            return new JSONObject(response.toString());
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    protected static void printJSON(JSONObject jo) {
        Iterator<String> keys = jo.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            if (jo.get(key) instanceof JSONObject) {
                System.out.println(key + " " + jo.get(key));
            }
        }
    }

    @Override
    public void sendNotification(String msg) {
        try {
            // get connection object
            HttpURLConnection connection = TelegramNotification.createConnection("POST", "sendMessage");
            // make json for post request
            String jsonInputString = String.format("{\"chat_id\": %s, \"text\": \"%s\"}", this.getId(), msg);
            // attach json to connectin object
            this.attachJSON(jsonInputString, connection);
            TelegramNotification.printJSON(TelegramNotification.getJSONOutput(connection));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    static void checkAndAddNewUsers(JSONArray userArray) {
        for (int i = 0; i < userArray.length(); i++) {
            JSONObject message = userArray.getJSONObject(i);
            message = (JSONObject) message.get("message");
            JSONObject chat = message.getJSONObject("chat");
            String firstName = (String) chat.get("first_name");
            if (PropertiesReader.getChatId(firstName.toUpperCase()) == null) {
                try {
                    Files.write(Paths.get(ClassLoader.getSystemResource("chatIds.properties").toURI()), String.format("%s = %s", firstName.toUpperCase(), chat.get("id").toString()).getBytes(), StandardOpenOption.APPEND);
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }
    }

    public static void getUpdates() {
        try {
            HttpURLConnection connection = createConnection("GET", "getUpdates");
            JSONObject json = getJSONOutput(connection);
            printJSON(json);
            JSONArray userArray = (JSONArray) json.get("result");
            if (userArray.length() != 0)
                checkAndAddNewUsers(userArray);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    static String generateWelcomeMessage() {
        return "Hey! Thanks for pinging me!\nI'm Cronus, like Cronos, the Greek God of Time. I'll make sure that you'll get your notifications for your reminders on time.\n Be seeing you! \\m/";
    }
}
