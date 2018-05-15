import javafx.scene.canvas.GraphicsContext;

/**
 * The DynamicGrid class contains moving tiles (box tiles and player tiles)
 * @author Marie, Kevin, Vincent, Vince, Victor
 */
public class DynamicGrid extends StaticGrid{	//MIGHT WANT TO CONSIDER INHERITING FROM STATIC GRID AND DELETING GRID

    private int playerCol;
    private int playerRow;
    private Direction playerDirection;
    /**
     * Class constructor
     * Pre: given valid tileset
     * @param tileSet
     * @return DynamicGrid object
     * Post: creates DynamicGrid object
     */
    public DynamicGrid(Tile[][] tileSet){
        super(tileSet);
        initPlayerPos();
        playerDirection = Direction.NOTHING;
    }
    /**
     * Pre: playerCol is initialised
     * @return x position of player
     * Post: returns playerCol value
     */
    public int getPlayerXpos(){
        return this.playerCol;
    }
    /**
     * Pre: playerRow is initialised
     * @return y position of player
     * Post: returns playerRow value
     */
    public int getPlayerYpos(){
        return this.playerRow;
    }

    /**
     * Pre: valid graphics context
     * Method draws all the tiles for the grid
     * @param gc
     * Post: draws the grid of boxes and players
     */
    @Override
    public void draw(GraphicsContext gc) {
        for(int yPos = 0;yPos< super.getRowCount();yPos+=1){
            for(int xPos=0;xPos<super.getColumnCount();xPos += 1){
                if(super.getTile(xPos, yPos)!=null){
                    super.getTile(xPos, yPos).drawTile(gc, xPos*Tile.LENGTH, yPos*Tile.LENGTH); //render top to bottom from left to rig
                }
            }
        }
    }
    /**
     * Pre: direction valid
     * Updates the players positioning on grid
     * @param d Direction of travel
     * Post: Updates players position on grid
     */
    public void updatePlayerPos(Direction d){
        int newX =this.playerCol;
        int newY =this.playerRow;
        this.playerDirection = d;
        switch(d){
            case UP:
                newY--;
                break;
            case DOWN:
                newY++;
                break;
            case LEFT:
                newX--;
                break;
            case RIGHT:
                newX++;
                break;
            default:
                break;
        }
        if(!(newX<0||newX==super.getColumnCount())&&!(newY<0||newY==super.getRowCount())){ //not out of array bounds.
            PlayerTile Temp = (PlayerTile)super.getTile(this.playerCol, this.playerRow);
            super.setTile(this.playerCol,this.playerRow,  null);
            super.setTile(newX, newY, Temp);
            this.playerCol = newX;
            this.playerRow = newY;
        }
    }
    /**
     * Pre: playerDirection initialised
     * Method returns player's facing direction
     * @return Direction that player is facing
     * Post: returns playerDirection value
     */
    public Direction getPlayerDirection(){
        return this.playerDirection;
    }
    /**
     * Gets players position on grid
     * Post: initialises players position.
     */
    private void initPlayerPos(){
        for(int r =0;r<super.getRowCount();r++){
            for(int c=0;c<super.getColumnCount();c++){
                if(super.getTile(c, r)!=null && super.getTile(c, r).getTypeCode()=='p'){
                    this.playerRow = r;
                    this.playerCol = c;
                    return;
                }
            }
        }
    }


}
