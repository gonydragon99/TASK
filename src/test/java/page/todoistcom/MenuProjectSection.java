package page.todoistcom;
import control.Button;
import org.openqa.selenium.By;


public class MenuProjectSection {

    public Button menuIconButton = new Button(By.xpath("//button[@aria-label='More project actions']"));
    public Button editButton = new Button(By.xpath("//div[text()='Edit project']"));
    public Button deleteButton = new Button(By.xpath("//div[text()='Delete project']"));

}
