package window;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowController {
    private static WindowController instance = null;
    private Scene scene;
    private Stage stage;
    
    private WindowController(){}
    
    public void changeWindow(String fxml){
        try {
            scene.setRoot(FXMLLoader.load(getClass().getResource(fxml + ".fxml")));
            stage.setTitle(fxml);
        } catch (IOException ex) {
            Logger.getLogger(WindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void init(Scene scene, Stage stage){
        this.scene = scene;
        this.stage = stage;
    }
    
    public static WindowController getInstance(){
        if(instance == null){
            instance = new WindowController();
        }
        return instance;
    }
}
