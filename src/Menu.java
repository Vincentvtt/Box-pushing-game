import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
/**
 * The Menu class contains the menu of the game
 * @author Marie, Kevin, Vincent, Vince, Victor
 */
public class Menu {
    GraphicsContext gc;
    Boolean state;
    AnchorPane main_pane;
    DropShadow drop_shadow = new DropShadow(3, Color.DARKRED);
    Scene scene;
    /**
     * Class constructor
     * Pre: given valid ggc, main, s
     * @param ggc graphics context
     * @param main AnchorPane
     * @param s Scene 
     * @return Menu object
     * Post: creates the Menu object
     */
    public Menu (GraphicsContext ggc, AnchorPane main, Scene s) {
        gc = ggc;
        state = false;
        main_pane = main;
        drop_shadow = new DropShadow(3, Color.DARKRED);
        scene = s;
    }
    /**
     * draws the title on the menu
     * Pre: image path file valid
     * Post: draws the title for the menu
     */
    public void drawTitle () {
        Image crate = new Image("assets/Crates/crate_03.png");
        int i;
        for (i = 0; i < 576; i+=64) {
            gc.drawImage(crate, i/1, 0);
            gc.drawImage(crate, i/1, 40);
            gc.drawImage(crate, i/1, 80);
        }

        gc.setEffect(drop_shadow);
        Font title = new Font("Avenir Next Bold", 40);
        gc.setFont(title);
        gc.setFill(Color.WHITESMOKE);
        gc.fillText("SUPER WAREHOUSE", 10, 60);
        gc.fillText("BROS.", 150, 110);
    }

    public void drawButtons () {
        Font other = new Font("Avenir Next Regular", 40);
        gc.setFont(other);
        gc.setFill(Color.WHITESMOKE);
        gc.beginPath();
        gc.fillText("play",200, 200);
        gc.fillText("quit",200, 264);
    }
    /**
     * Triggers events depending on where mouse is clicked
     * Post: Event occurs corresponding to area clicked
     */
    public void triggerMouseEvents() {
        main_pane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Double x = event.getSceneX();
                Double y = event.getSceneY();
                if ((x >= 200 && x <= 260) && (y >= 170 && y <= 210)) {
                    state = true;
                    gc.clearRect(0, 0, 576, 386);
                    levelTest lvl_tst = new levelTest(scene, gc, main_pane);
                    lvl_tst.drawLevel();
                } else if (x >= 200 && x <= 260 && (y >= 240 && y <= 320)) {
                    Platform.exit();
                }
            }
        });
        Font other = new Font("Avenir Next Regular", 40);
        gc.setFont(other);
        main_pane.setOnMouseMoved (new EventHandler<javafx.scene.input.MouseEvent>() {

            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                if (!state) {
                    Double x = event.getSceneX();
                    Double y = event.getSceneY();
                    if ((x >= 200 && x <= 260) && (y >= 170 && y <= 210)) {
                        gc.setFill(Color.ORANGERED);
                        gc.fillText("play", 200, 200);
                    } else if (x >= 200 && x <= 260 && (y >= 240 && y <= 320)) {
                        gc.setFill(Color.ORANGERED);
                        gc.fillText("quit",200, 264);
                    } else {
                        gc.setFill(Color.WHITESMOKE);
                        gc.fillText("play", 200, 200);
                        gc.fillText("quit",200, 264);
                    }

                }
            }
        });
    }
    /**
     * draws in the menu decorations
     * Image files are valid paths
     * Post: Creates Menu decorations
     */
    public void drawMenuDecoration () {
        Image crate_2 = new Image("assets/Crates/crate_02.png");
        Image place = new Image("assets/Environment/environment_05.png");
        Image player_back = new Image("assets/Player/player_23.png");
        Image instructions = new Image("instructions.png");
        gc. setEffect(null);
        for (int i = 155; i <= 232; i += 64) {
            gc.drawImage(place, 130, i/1);
        }

        gc.drawImage(crate_2, 310, 460);
        gc.drawImage(player_back, 310, 400);
        gc.drawImage(instructions, 60, 360);

    }

    public void drawMenu () {
        drawTitle();
        drawButtons();
        triggerMouseEvents();
        drawMenuDecoration();
    }

}
