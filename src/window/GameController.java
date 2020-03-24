package window;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import java.text.DecimalFormat;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import scoreboard.Scoreboard;

public class GameController implements Initializable {
    
    @FXML
    private ProgressBar timerBar;
    @FXML
    private Text color;
    @FXML
    private AnchorPane byColor;
    @FXML
    private AnchorPane byText;
    @FXML
    private Text scoreText;
    @FXML
    private AnchorPane heart1;
    @FXML
    private AnchorPane heart2;
    @FXML
    private AnchorPane heart3;
    @FXML
    private AnchorPane submitPane;
    @FXML
    private TextField submitText;
    
    private static String[] colorNames = new String[]{"Red", "Blue", "Green", "Yellow"};
    private static Color[] colors = new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
    private static int difficulty = 0;
    private int timer = -1;
    private int actColor = 0;
    private int actText = 0;
    private int by = 0;
    private int score = 0;
    private int life = 3;
    private Boolean isOver = false;
    private AnchorPane[] hearts;
    
    private void loseHeart(){
        life--;
        hearts[life].setOpacity(0);
        if(life == 0){
            isOver = true;
            submitPane.setOpacity(1);
        }
    }
    
    private void pushedColor(int col){
        if(!isOver){
            timer = -1;

            int byWhat;
            if(by == 0){
                byWhat = actText;
            }
            else{
                byWhat = actColor;
            }

            if(col == byWhat){
                score += 100 * difficulty;
                scoreText.setText("" + score);
            }
            else{
                loseHeart();
            }
        }
    }
    
    private Thread t = new Thread(new Runnable(){
        @Override
        public void run(){
            while(!isOver){
                if(timer <= 0){
                    if(timer == 0){
                        loseHeart();
                    }
                    
                    timer = (4 - difficulty) * 1000 + 50;
                    
                    actColor = (int) (Math.random() * 4);
                    actText = (int) (Math.random() * 4);

                    by = (int) (Math.random() * 2);
                    if(by == 0){
                        byText.setOpacity(1);
                        byColor.setOpacity(0);
                    }
                    else{
                        byText.setOpacity(0);
                        byColor.setOpacity(1);
                    }
                    color.setText(colorNames[actText]);
                    color.setFill(colors[actColor]);
                }
                timer -= 50;
                timerBar.setProgress((double) timer/((4 - difficulty) * 1000));
                
                
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    
                }
            }
        }
    });
    
    @FXML
    private void btn1Click(ActionEvent event){
        pushedColor(0);
    }
    
    @FXML
    private void btn2Click(ActionEvent event){
        pushedColor(2);
    }
    
    @FXML
    private void btn3Click(ActionEvent event){
        pushedColor(1);
    }
    
    @FXML
    private void btn4Click(ActionEvent event){
        pushedColor(3);
    }
    
    @FXML
    private void submit(ActionEvent event){
        Scoreboard scoreboard = new Scoreboard();
        if(!"".equals(submitText.getText())){
            scoreboard.addScore(submitText.getText().trim(), score);
            WindowController wc = WindowController.getInstance();
            wc.changeWindow("Menu");
        }
    }
    
    public static void setDifficulty(int diff){
        difficulty = diff;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hearts = new AnchorPane[]{heart1, heart2, heart3};
        t.start();
    }    
    
}
