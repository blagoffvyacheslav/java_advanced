package com.dmdev.common.repository;

import com.dmdev.common.models.User;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserRepository {

    public static User getUser(Long id) {
        String url = "http://userrepository.com/api/id/";

        String response = performGetRequest(url, id);
        User user = processResponse(response);

        System.out.println("Имя: " + user.getFirstName());
        System.out.println("Фамилия: " + user.getLastName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Никнейм: " + user.getNickname());
        return user;
    }

    public static String performGetRequest(String url, Long id) {
        StringBuilder responseBuilder = new StringBuilder();
        try {
            URL apiUrl = new URL(url + id);

            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            reader.close();

            connection.disconnect();
        } catch (IOException e) {
            System.out.println("Request error: " + e);
        }

        return responseBuilder.toString();
    }

    private static User processResponse(String response) {
        try {
            JSONObject json = new JSONObject(response);

            String firstName = json.optString("firstName", "Default");
            String lastName = json.optString("lastName", "Default");
            String email = json.optString("email", "default@example.com");
            String nickname = json.optString("nickname", "");

            return new User(firstName, lastName, email, nickname);
        } catch (JSONException e) {
            e.printStackTrace();
            return new User("Default", "Default", "default@example.com", "");
        }
    }
}