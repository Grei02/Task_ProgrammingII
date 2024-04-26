package cr.ac.una.cooperativaescolar;

import cr.ac.una.cooperativaescolar.util.AppContext;
import cr.ac.una.cooperativaescolar.util.FlowController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        
        FlowController.getInstance().InitializeFlow(stage, null);
        FlowController.getInstance().goMain();
    }

    public static void main(String[] args) {
        
        if(args.length > 0){
            AppContext.getInstance().set("typeIncome", args[0]);
            switch (args[0]) {
                case " P" -> FlowController.getInstance().goViewInWindow("startTeacherSetctionView");
                case " A" -> FlowController.getInstance().goViewInWindow("startAssociateSectionView");
                case " S" -> FlowController.getInstance().goViewInWindow("startStudentfView");
            }
        }
        else{
            AppContext.getInstance().set("typeIncome", "L");
        }
        launch();
    }

}