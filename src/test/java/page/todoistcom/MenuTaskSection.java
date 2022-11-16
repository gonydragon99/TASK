package page.todoistcom;
import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class MenuTaskSection {
    public Button moreActionsButton = new Button(By.xpath("//button[@aria-label='More actions']"));
    public Button deleteTaskButton = new Button(By.xpath("//button[@aria-label='Delete task…']"));
    public Button deleteButton = new Button(By.xpath("//button/span[text()='Delete']"));

}
