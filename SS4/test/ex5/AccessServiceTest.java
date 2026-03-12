package ex5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccessServiceTest {

    AccessService service;
    User admin;
    User moderator;
    User user;

    @BeforeEach
    void setUp() {
        service = new AccessService();
        admin = new User(Role.ADMIN);
        moderator = new User(Role.MODERATOR);
        user = new User(Role.USER);
    }

    @AfterEach
    void tearDown() {
        admin = null;
        moderator = null;
        user = null;
    }

    @Test
    void testAdminPermissions() {

        assertTrue(service.canPerformAction(admin, Action.DELETE_USER));
        assertTrue(service.canPerformAction(admin, Action.LOCK_USER));
        assertTrue(service.canPerformAction(admin, Action.VIEW_PROFILE));
    }

    @Test
    void testModeratorPermissions() {

        assertFalse(service.canPerformAction(moderator, Action.DELETE_USER));
        assertTrue(service.canPerformAction(moderator, Action.LOCK_USER));
        assertTrue(service.canPerformAction(moderator, Action.VIEW_PROFILE));
    }

    @Test
    void testUserPermissions() {

        assertFalse(service.canPerformAction(user, Action.DELETE_USER));
        assertFalse(service.canPerformAction(user, Action.LOCK_USER));
        assertTrue(service.canPerformAction(user, Action.VIEW_PROFILE));
    }
}
