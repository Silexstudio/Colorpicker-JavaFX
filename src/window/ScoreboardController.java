package window;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import scoreboard.Score;
import scoreboard.Scoreboard;

public class ScoreboardController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private ScrollPane scroll;
    
    
    @FXML
    private void clickBack(ActionEvent event) {
        WindowController wc = WindowController.getInstance();
        wc.changeWindow("Menu");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Scoreboard scoreboard = new Scoreboard();
        ArrayList<Score> arr = scoreboard.getScores();
        VBox vBox = new VBox();
        vBox.getStyleClass().add("vbox");
        
        for(Score s : arr){
            Text name = new Text(s.getName());
            name.setWrappingWidth(270);
            Text score = new Text("" + s.getScore());
            score.setWrappingWidth(270);
            score.setTextAlignment(TextAlignment.RIGHT);
            
            HBox hBox = new HBox();
            hBox.getStyleClass().add("hbox");
            
            hBox.getChildren().add(name);
            hBox.getChildren().add(score);
            
            vBox.getChildren().add(hBox);
            
        }
        scroll.setBackground(Background.EMPTY);
        scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
        scroll.setVbarPolicy(ScrollBarPolicy.NEVER);
        scroll.setContent(vBox);
        
    }    
    
}
