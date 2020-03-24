package window;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class MenuController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void clickStart(ActionEvent event) {
        WindowController wc = WindowController.getInstance();
        wc.changeWindow("Difficulty");
    }
    
    @FXML
    private void clickScoreboard(ActionEvent event) {
        WindowController wc = WindowController.getInstance();
        wc.changeWindow("Scoreboard");
    }
    
    @FXML
    private void clickExit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
