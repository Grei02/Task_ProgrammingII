package cr.ac.una.taskprogrammingii;

import cr.ac.una.taskprogrammingii.util.FlowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FlowController.getInstance().InitializeFlow(stage, null);
       //AddDavilitarAccountsView
     // FlowController.getInstance().goViewInWindow("AccountMaintenanceView");
    //FlowController.getInstance().goViewInWindow("startTeacherSetctionView");
    //FlowController.getInstance().goViewInWindow("startTeacherSetctionView");
     //FlowController.getInstance().goViewInWindow("startAssociateSectionView");
     FlowController.getInstance().goViewInWindow("AddDavilitarAccountsView");
    // FlowController.getInstance().goViewInWindow("startAssociateSectionView");
    //  FlowController.getInstance().goViewInWindow("AddDavilitarAccountsView");
 //Stashed changes
    }

    public static void main(String[] args) {
        launch();
    }

}