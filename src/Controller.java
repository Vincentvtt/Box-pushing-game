import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * The Controller class ctonrols the graphics of the menu
 * @author Marie, Kevin, Vincent, Vince, Victor
 */
public class Controller {
        @FXML
        private AnchorPane main_pane;
        Canvas game;
        GraphicsContext gc;
        Scene scene;
        /**
         * Class constructor
         * Creates a new Controller object
         * @return Controller
         * Post: creates Controller object
         */
        public Controller (){
            main_pane = new AnchorPane();
            main_pane.getStylesheets().add("main.css");
            main_pane.getStyleClass().add("anchorpane");
            game = new Canvas(448, 704);
            gc = game.getGraphicsContext2D();
        }
       /**
        * Method returns parent AnchorPane
        * @return main_pane
        * Post: returns parent AnchorPane
        */
        public AnchorPane returnParent() {
            return main_pane;
        }
       /**
        * Method creates a menu 
        * @return game The game menu
        * Post: returns game menu
        */
        public Canvas drawCanvas() {

            Menu menu = new Menu(gc, main_pane, scene);
            menu.drawMenu();

            return game;
        }
       /**
        * Sets the scene given
        * Pre s must be a valid stage
        * Post: sets Stage s as scene
        */
        public void setScene(Stage s) {
            this.scene = s.getScene();
        }


}

