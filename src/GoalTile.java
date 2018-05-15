import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
/**
 * The GoalTile class defines a "goal" tile
 * @author Marie, Kevin, Vincent, Vince, Victor
 */
public class GoalTile extends GroundTile implements Tile {

    private static Image tile;
    /**
     * GoalTile Class constructor
     * @return GoalTile
     */
    public GoalTile() {
        super();
        tile = new Image("assets/Environment/environment_05.png");
    }
    /**
     * Draws a tile given coordinates x and y
     * @param gc
     * @param dx		x coordinate
     * @param dy		y coordinate
     */
    @Override
    public void drawTile(GraphicsContext gc, double dx, double dy) {
        super.drawTile(gc, dx, dy);
        gc.drawImage(tile, dx, dy, 64, 64);
    }
    /**
     * Method returns 'x' when called
     * @return 'x' character which defines tile as "goal" tile
     */
    @Override
    public char getTypeCode(){
        return 'x';
    }

}