import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * The Main class contains main menu for game
 * @author Marie, Kevin, Vincent, Vince, Victor
 */
public class Main extends Application {
    /**
     * Pre: primaryStage valid
     * @param args 
     * @throws Exception 
     * Post: starts and creates main menu
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Controller controller = new Controller();
        AnchorPane root = controller.returnParent();


        primaryStage.setTitle("Warehouse Bros.");
        Scene scene = new Scene(root,448,704);
        primaryStage.setScene(scene);
        controller.setScene(primaryStage);
        root.getChildren().add(controller.drawCanvas());

        primaryStage.show();
    }

    /**
     * Pre: given valid args
     * @param args 
     * Post: launches start() function
     */
    public static void main(String[] args) {
        launch(args);
    }
}
