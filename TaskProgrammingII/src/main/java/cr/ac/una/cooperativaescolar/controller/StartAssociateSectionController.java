package cr.ac.una.cooperativaescolar.controller;

import cr.ac.una.cooperativaescolar.util.FlowController;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Sofia Bejarano Mora
 */
public class StartAssociateSectionController extends Controller implements Initializable {
    @FXML
    private AnchorPane root;
    @FXML
    private MFXButton btnNext;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @Override
    public void initialize() {
    }

    @FXML
    private void onActionBtnNext(ActionEvent event) {
        FlowController.getInstance().goMain();
        ((Stage) btnNext.getScene().getWindow()).close();
    }
}

