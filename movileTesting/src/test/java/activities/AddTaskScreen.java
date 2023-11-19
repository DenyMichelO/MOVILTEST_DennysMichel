package activities;


import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class AddTaskScreen {

    public TextBox titleTxtBox = new TextBox(By.id("com.splendapps.splendo:id/edtTaskName"));
    public TextBox dateTxtBox = new TextBox(By.id("com.splendapps.splendo:id/edtDueD"));
    public Button dayButton = new Button(By.xpath("//android.view.View[@content-desc='20 November 2023']"));
    public Button okButton = new Button(By.id("android:id/button1"));
    public Button clocButton = new Button(By.id("com.splendapps.splendo:id/btnSetT"));
    public Button hourButton = new Button(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='11']"));
    public Button minuteButton = new Button(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='50']"));

    public Button ok2Button = new Button(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));

    public Button saveButton = new Button(By.id("com.splendapps.splendo:id/fabSaveTask"));
}