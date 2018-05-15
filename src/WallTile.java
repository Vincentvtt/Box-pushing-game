import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class WallTile extends GroundTile implements Tile {
    private static Image tile;

    public WallTile() {
        super();
        tile = new Image("/assets/Blocks/block_03.png");
    }

    @Override
    public void drawTile(GraphicsContext gc, double dx, double dy) {
        super.drawTile(gc, dx, dy);
        gc.drawImage(tile, dx, dy, 64, 64);
    }
    @Override
    public char getTypeCode(){
        return '1';
    }
}