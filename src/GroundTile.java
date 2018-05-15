import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * The GroundTile class defines a "ground" tile
 * @author Marie, Kevin, Vincent, Vince, Victor
 */
public class GroundTile implements Tile {
    private static Image tile;
    /**
     * GroundTile Class constructor
     * @return GroundTile
     */
    public GroundTile() {
        tile = new Image("/assets/Ground/ground_01.png");
    }
    /**
     * Draws a tile given coordinates x and y
     * @param gc
     * @param dx		x coordinate
     * @param dy		y coordinate
     */
    @Override
    public void drawTile(GraphicsContext gc, double dx, double dy) {
        gc.drawImage(tile, dx, dy, 64, 64);
    }
    /**
     * Method returns '0' when called
     * @return '0' character which defines tile as "ground" tile
     */
    @Override
    public char getTypeCode() {
        return '0';
    }
}