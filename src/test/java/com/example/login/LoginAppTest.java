package com.example.login;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginAppTest {

    @Test
    public void testValidLogin() {
        assertTrue(LoginApp.login("admin", "admin"));
    }

    @Test
    public void testInvalidLogin() {
        assertFalse(LoginApp.login("admin", "wrongpass"));
    }
}
