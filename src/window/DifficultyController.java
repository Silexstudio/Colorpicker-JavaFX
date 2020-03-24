package window;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class DifficultyController implements Initializable {
    
    @FXML
    private Label label;
    
    
    @FXML
    private void clickBack(ActionEvent event) {
        WindowController wc = WindowController.getInstance();
        wc.changeWindow("Menu");
    }
    
    @FXML
    private void clickEasy(ActionEvent event){
        WindowController wc = WindowController.getInstance();
        GameController.setDifficulty(1);
        wc.changeWindow("Game");
    }
    
    @FXML
    private void clickMedium(ActionEvent event){
        WindowController wc = WindowController.getInstance();
        GameController.setDifficulty(2);
        wc.changeWindow("Game");
    }
    
    @FXML
    private void clickHard(ActionEvent event){
        WindowController wc = WindowController.getInstance();
        GameController.setDifficulty(3);
        wc.changeWindow("Game");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
    }    
    
}
