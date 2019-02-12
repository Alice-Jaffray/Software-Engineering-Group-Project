import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppControllerTest extends TestCase {
    private AuthServer auth = new AuthServer();
    private AppController app = new AppController(auth);

    @BeforeEach
    public void setUp() {
        auth.addDetails("dir000", "pa55word");
        auth.addDetails("hre000", "pa33word");
        auth.addDetails("emp000", "password");
    }

    @AfterEach
    public void tearDown() {
        auth = new AuthServer();
        app = new AppController(auth);
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
        assertTrue(app.getLoggedIn());
    }

    @Test
    void logoutWhileLoggedOut() {
        assertFalse(app.logout());
        assertFalse(app.getLoggedIn());
    }
}