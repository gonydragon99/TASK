package testSuite.todoistcom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import page.todoistcom.*;
import session.Session;
import util.GetProperties;

public class TestBase {
    public MainPage mainPage = new MainPage();
    public LoginSection loginSection = new LoginSection();
    public MenuSection menuSection = new MenuSection();
    public ProjectSection projectSection = new ProjectSection();
    public TaskSection taskSection = new TaskSection();
    public static String user;
    public static String password;


    @BeforeAll
    public static void beforeAll() {
        System.setProperty("configuration.name", "todoistcom.properties");
        user = GetProperties.getInstance().getUser();
        password = GetProperties.getInstance().getPwd();
    }
    @BeforeEach
    public void openBrowser() {
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }

    @AfterEach
    public void closeBrowser() {
        Session.getInstance().closeSession();
    }





}
