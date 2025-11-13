package com.example.login;

import java.util.HashMap;
import java.util.Map;

public class LoginApp {
    private static Map<String, String> users = new HashMap<>();

    static {
        users.put("admin", "admin");
        users.put("apurva", "apurva");
    }

    public static boolean login(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public static void main(String[] args) {
        System.out.println("Login successful: " + login("admin", "admin"));
    }
}
