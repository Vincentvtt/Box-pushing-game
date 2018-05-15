import javafx.scene.canvas.GraphicsContext;

public interface Tile {
    int LENGTH = 64;
    void drawTile(GraphicsContext gc, double dx, double dy);
    char getTypeCode();
}
