package page.todoistcom;
import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class MenuSection {
    public Button inboxButton = new Button(By.xpath("//a/span[text()='Inbox']"));
    public Button settingButton = new Button(By.xpath("//div[contains(@class, 'settings_avatar')]"));
    public Button logoutButton = new Button(By.xpath("//button/span[text()='Log out']"));


}
