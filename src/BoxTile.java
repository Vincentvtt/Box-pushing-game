import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
/**
 * @author Marie, Kevin, Vincent, Vince, Victor
 */
public class BoxTile extends GroundTile implements Tile {
    private static Image boxImage;
    /**
     * Class constructor
     * @return BoxTile
     */
    public BoxTile(){
        super();
        boxImage = new Image("assets/Crates/crate_03.png");
    }
    /**
     * Draws a tile given coordinates
     * @param gc
     * @param dx		x coordinate
     * @param dy 	y coordinate
     */
    @Override
    public void drawTile(GraphicsContext gc, double dx, double dy) {
        super.drawTile(gc, dx, dy);
        gc.drawImage(boxImage, dx, dy,64,64);

    }
    /**
     * Method returns 'b' when called
     * @return 'b' character which defines tile as "box" tile
     */
    @Override
    public char getTypeCode() {
        return 'b';
    }

}
