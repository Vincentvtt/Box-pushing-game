import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.LinkedList;
/**
 * The Level class contains a level of the game
 * @author Marie, Kevin, Vincent, Vince, Victor
 */
public class Level {

    private StaticGrid baseLevel;
    private DynamicGrid dynamicLevel;
    private DynamicGrid oldState;
    private CollisionHandler colDetector;
    private TileFactory levelCreator;
    private LinkedList<Vector2D> goalTiles;
    private String levelFile;
    private Scene gameScene;
    private AnchorPane main_pane;

    /**
     * Class constructor
     * Pre: given valid levelFile, gameS
     * @param levelFile level.txt file for creating this Level.
     * @param gameS Scene for game
     * @return Level object
     * Post: creates Level object
     */
    public Level(String levelFile,Scene gameS){
        levelCreator = new TileFactory();
        this.levelFile = levelFile;
        initLevel();
        gameScene = gameS;
        enableInput(gameScene);
    }

    /**
     * Method shows the graphics for this level 
     * Pre: shows graphics for this level
     * @param gc graphics context
     * @param root AnchorPane
     * Post: shows graphics for this level
     */
    public void show(GraphicsContext gc,AnchorPane root){
        new AnimationTimer(){ //basic game loop to handle for updates in the event
            public void handle(long time){
                main_pane = root;
                baseLevel.draw(gc);
                dynamicLevel.draw(gc);
                if(colDetector.checkCompletion(dynamicLevel, goalTiles)){
                    stop();
                    gc.clearRect(0,0,448,706);
                    Menu m = new Menu(gc,root, gameScene);
                    m.drawMenu();
                }
            }
        }.start();
    }
    /**
     * Initialises the level
     * Pre: levelFile path is valid
     * Post: creates the static and dynamic grids for this level.
     */
    public void initLevel(){
        baseLevel = levelCreator.createStaticGrid(this.levelFile);
        dynamicLevel= levelCreator.createDynamicGrid(levelFile);
        colDetector = new CollisionHandler();
        goalTiles = baseLevel.getTilePositions('x');
    }
    /**
     * Resets the game level.
     * Pre: event is valid
     * Post: Resets the level by initialising again
     */
    private void resetButtonPress(ActionEvent event){
        initLevel();
    }
    /**
     * Enables Input for user keyboard inputs and updates player position
     * Pre: gamescene is valid
     * Post: Updates the players position depending on what key is pressed
     */
    private void enableInput(Scene gameScene){
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                oldState = levelCreator.CloneDynamicGrid(dynamicLevel);

                switch (event.getCode()) {
                    case UP:
                        dynamicLevel.updatePlayerPos(Direction.UP);
                        break;
                    case W:
                        dynamicLevel.updatePlayerPos(Direction.UP);
                        break;
                    case DOWN:
                        dynamicLevel.updatePlayerPos(Direction.DOWN);
                        break;
                    case S:
                        dynamicLevel.updatePlayerPos(Direction.DOWN);
                        break;
                    case LEFT:
                        dynamicLevel.updatePlayerPos(Direction.LEFT);
                        break;
                    case A:
                        dynamicLevel.updatePlayerPos(Direction.LEFT);
                        break;
                    case RIGHT:
                        dynamicLevel.updatePlayerPos(Direction.RIGHT);
                        break;
                    case D:
                        dynamicLevel.updatePlayerPos(Direction.RIGHT);
                        break;
                    case R:
                        initLevel();
                    default:
                        dynamicLevel.updatePlayerPos(Direction.NOTHING);
                        break;
                }
                colDetector.HandleCollision(baseLevel, dynamicLevel, oldState);
            }

        });
    }
    /**
     * Returns the width of level
     * @return width
     * Post: Returns the width of Level.
     */
    public int getWidth(){
        return this.baseLevel.getWidth();
    }
    /**
     * Returns the height of level
     * @return height
     * Post: Returns the height of Level.
     */
    public int getHeight(){
        return this.baseLevel.getHeight();
    }
}
