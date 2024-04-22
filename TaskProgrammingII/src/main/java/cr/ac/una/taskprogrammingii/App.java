package cr.ac.una.taskprogrammingii;

import cr.ac.una.taskprogrammingii.util.AppContext;
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
    }

    public static void main(String[] args) {
        if(args.length==1){
            AppContext.getInstance().set("typeIncome", args[0]);
            if (args[0].equals("P")){
                FlowController.getInstance().goViewInWindow("startTeacherSetctionView");
            }
            else if(args[0].equals("A")){
                FlowController.getInstance().goViewInWindow("startAssociateSectionView");
            }
            else if(args[0].equals("S")){
                FlowController.getInstance().goViewInWindow("startStudentfView");
            }
        }
        else{
            AppContext.getInstance().set("typeIncome", "L");
        }
        
        launch();
    }

}