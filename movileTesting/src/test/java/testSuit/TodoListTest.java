package testSuit;

import activities.AddTaskScreen;
import activities.MainScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sesion.Session;

import java.util.Date;

public class TodoListTest {
    MainScreen mainScreen = new MainScreen();
    AddTaskScreen addTaskScreen = new AddTaskScreen();

    @Test
    public void createNewTaskTest(){
        String title="Hora maxima de entrega de Proyeto"+new Date().getTime();
        mainScreen.addButton.click();
        addTaskScreen.titleTxtBox.setText(title);
        addTaskScreen.dateTxtBox.click();
        addTaskScreen.dayButton.click();
        addTaskScreen.okButton.click();
        addTaskScreen.clocButton.click();
        addTaskScreen.hourButton.click();
        addTaskScreen.minuteButton.click();
        addTaskScreen.ok2Button.click();
        addTaskScreen.saveButton.click();

        Assertions.assertTrue(mainScreen.getTaskName(title).isControlDisplayed(),
                "ERROR la tarea no fue creada");
    }

    @AfterEach
    public void closeApp(){
        Session.getSession().closeSession();
    }


}

