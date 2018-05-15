import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
/**
 * The levelTest class creates/draws the level graphics
 * @author Marie, Kevin, Vincent, Vince, Victor
 */
public class levelTest {
    GraphicsContext gc;
    AnchorPane main_pane;
    Scene scene;
    /**
     * initialises variables
     * Pre: given valid s, ggc, mp
     * @param s Scene for level
     * @param ggc GraphicsContext for level
     * @param mp AnchorPane for level
     * Post: initialises values
     */
    public levelTest (Scene s, GraphicsContext ggc, AnchorPane mp) {
        scene = s;
        gc = ggc;
        main_pane = mp;
    }
    /**
     * draws the graphics for the level
     * Post: Draws in graphics for the level
     */
    public void drawLevel() {
        LevelGenerator lg = new LevelGenerator();
        lg.randomLevel();
        Level myLevel1 = new Level("leveltest.txt", scene);
        gc.setStroke(Color.GREY);
        gc.setLineWidth(2);
        gc.strokeRect(0, 0, 320, 320);
        myLevel1.show(gc, main_pane);

    }

}


