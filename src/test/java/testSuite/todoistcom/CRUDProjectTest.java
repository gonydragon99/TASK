package testSuite.todoistcom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;
import org.junit.jupiter.api.Assertions;

public class CRUDProjectTest extends TestBase {

    @Test
    public void verifyCRUDProject() throws InterruptedException {
        String createdProject = String.format("NEW_PROJECT_%d", System.currentTimeMillis());
        String updatedProject = String.format("UPDATED_PROJECT_VERSION_%d", System.currentTimeMillis());
        // Login.
        mainPage.loginLabel.click();
        loginSection.emailTxtBox.setText(user);
        loginSection.passwordTxtBox.setText(password);
        loginSection.loginButton.click();
        Assertions.assertTrue(menuSection.inboxButton.isControlDisplayed(), "ERROR!");

        // Create project.
        projectSection.addNewProjectButton.click();
        projectSection.nameProjectTxtBox.setText(createdProject);
        projectSection.colorButton.click();
        projectSection.skyBlueLabel.click();
        projectSection.addButton.click();
        projectSection.addButton.waitControlIsNotInThePage();
        Assertions.assertTrue(projectSection.isProjectDisplayedInList(createdProject), "ERROR!");

        String createdTask = String.format("NEW_TASK_%d", System.currentTimeMillis());
        String updatedTask = String.format("UPDATED_TASK_VERSION_%d", System.currentTimeMillis());

        // Create Task.
        taskSection.addNewTaskButton.click();
        taskSection.descriptionTxtBox.setText(createdTask);
        taskSection.addTaskButton.click();
        taskSection.addNewTaskButton.waitControlIsNotInThePage();
        Assertions.assertTrue(taskSection.isTaskDisplayedInList(createdTask), "ERROR!");


        // Delete Task.
        taskSection.clickOnTask(createdTask);
        taskSection.menuTaskSection.moreActionsButton.click();
        taskSection.menuTaskSection.deleteTaskButton.click();
        taskSection.menuTaskSection.deleteButton.click();
        taskSection.getTask(createdTask).waitControlIsNotInThePage();
        Assertions.assertFalse(taskSection.isTaskDisplayedInList(createdTask), "ERROR!");

        // Update the project name.
        projectSection.clickOnProject(createdProject);
        projectSection.menuProjectSection.menuIconButton.click();
        projectSection.menuProjectSection.editButton.click();
        projectSection.editProjectTxtBox.cleanSetText(updatedProject);
        projectSection.saveButton.click();
        projectSection.saveButton.waitControlIsNotInThePage();
        Assertions.assertTrue(projectSection.isProjectDisplayedInList(updatedProject), "ERROR!");

        // Delete the project
        projectSection.clickOnProject(updatedProject);
        projectSection.menuProjectSection.menuIconButton.click();
        projectSection.menuProjectSection.deleteButton.click();
        projectSection.deleteButton.click();
        projectSection.getProject(updatedProject).waitControlIsNotInThePage();
        Assertions.assertFalse(projectSection.isProjectDisplayedInList(updatedProject), "ERROR!");
    }

}
