package cr.ac.una.taskprogrammingii.controller;

import cr.ac.una.taskprogrammingii.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}