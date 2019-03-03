/**
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppControllerTest {
    private AuthServer auth = new AuthServer();
    private HRDatabase hrdb = new HRDatabase();
    private AppController app = new AppController(auth, hrdb);

    @BeforeEach
    public void setUp() {
        auth.addDetails("director", "dir000", "pa55word");
        auth.addDetails("director", "hre000", "pa33word");
        auth.addDetails("director", "emp000", "password");
    }

    @AfterEach
    public void tearDown() {
        auth = new AuthServer();
        hrdb = new HRDatabase();
        app = new AppController(auth, hrdb);
    }

    @Test
    void incorrectPassword() {
        assertFalse(app.login("emp000", "wrong"));
    }

    @Test
    void invalidLogin() {
        assertFalse(app.login("emp001", "password"));
    }

    @Test
    void validEmployeeLogin() {
        assertTrue(app.login("emp000", "password"));
    }

    @Test
    void logoutWhileLoggedIn() {
        app.login("emp000", "password");
        assertTrue(app.logout());
        assertFalse(app.getLoggedIn());
    }

    @Test
    void logoutWhileLoggedOut() {
        assertFalse(app.logout());
        assertFalse(app.getLoggedIn());
    }
}**/
