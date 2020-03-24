package colorpicker;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import window.WindowController;

public class Colorpicker extends Application {
    private MediaPlayer mp;
    
    @Override
    public void start(Stage stage) throws Exception {
        mp = new MediaPlayer(new Media(getClass().getResource("muzsika.mp3").toExternalForm()));
        mp.setStartTime(Duration.ZERO);
        mp.setStopTime(Duration.seconds(180));
        mp.play();
        
        Parent root = new AnchorPane();
        Scene scene = new Scene(root, 600, 800);
        
        WindowController wc = WindowController.getInstance();
        
        Font.loadFont(wc.getClass().getResource("font1.ttf").toExternalForm(), 90);
        Font.loadFont(wc.getClass().getResource("font2.ttf").toExternalForm(), 60);
        scene.getStylesheets().add(wc.getClass().getResource("style.css").toExternalForm());
        
        wc.init(scene, stage);
        wc.changeWindow("Menu");
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
