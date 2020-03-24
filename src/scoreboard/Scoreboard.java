package scoreboard;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.SplitPane;

public class Scoreboard {
    public Scoreboard(){
    
    }
    
    public void addScore(String name, int score){
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("scores.txt", true));
            printWriter.println(name);
            printWriter.println(score);
            printWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Scoreboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public ArrayList<Score> getScores(){
            ArrayList<Score> arr = new ArrayList<Score>();
            try {
                FileReader fileReader = new FileReader("scores.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = bufferedReader.readLine();
                while(line != null) {
                    SplitPane sp = new SplitPane();
                    
                    String s = line;
                    line = bufferedReader.readLine();
                    
                    Score score = new Score(s, Integer.parseInt(line));
                    
                    arr.add(score);
                    
                    line = bufferedReader.readLine();
                }

                fileReader.close();
                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Scoreboard.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Scoreboard.class.getName()).log(Level.SEVERE, null, ex);
            }

            Collections.sort(arr, new Comparator<Score>() {
                @Override
                public int compare(Score s1, Score s2)
                {
                    return s2.getScore() - s1.getScore();
                }
            });
            
            return arr;
        }
}
