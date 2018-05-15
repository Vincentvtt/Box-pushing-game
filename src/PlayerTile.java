import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PlayerTile implements Tile{

    private static Image playerImage;

    public PlayerTile(){
        playerImage = new Image("assets/Player/player_01.png");
    }

    @Override
    public void drawTile(GraphicsContext gc, double dx, double dy) {
        gc.drawImage(playerImage, dx, dy,64,64);
    }

    @Override
    public char getTypeCode() {
        return 'p';
    }
}
