import javafx.scene.canvas.GraphicsContext;

import java.util.LinkedList;
/**
 * The StaticGrid class contains static tiles (wall, ground, goal)
 * @author Marie, Kevin, Vincent, Vince, Victor
 */
public class StaticGrid{

    private Tile[][] tileGrid;//essentially a matrix of tiles.
    private int Nrows;
    private int Ncolumns;
    /**
     * Class constructor
     * Pre: given valid tileset
     * @param tileSet
     * @return StaticGrid object
     * Post: creates StaticGrid object
     */
    public StaticGrid(Tile[][] tileSet){
        this.tileGrid = tileSet;
        this.Nrows =tileSet.length ;
        this.Ncolumns = tileSet[0].length;
    }
    /**
     * Pre: valid graphics context
     * Method draws all the tiles for the grid
     * @param gc
     * Post: draws the grid of boxes and players
     */
    public void draw(GraphicsContext gc) {
        for(int yPos = 0;yPos< this.Nrows;yPos+=1){
            for(int xPos=0;xPos<this.Ncolumns;xPos += 1){
                this.tileGrid[yPos][xPos].drawTile(gc, xPos*Tile.LENGTH, yPos*Tile.LENGTH); //render top to bottom from left to rig
            }
        }
    }
    /**
     * Pre: valid xIndex and yIndex values
     * Method returns tile given x and y coordinates
     * @param xIndex x coordinate on grid
     * @param yIndex y coordinate on grid
     * @return Tile Tile at coordinates
     * Post: returns tile given x and y coordinates
     */
    public Tile getTile(int xIndex,int yIndex){
        return this.tileGrid[yIndex][xIndex];
    }
    /**
     * Pre: valid xIndex and yIndex values, tile
     * Method sets a tile given its coordinates
     * @param xIndex x coordinate on grid
     * @param yIndex y coordinate on grid
     * @param newTile tile to be set
     * Post: sets a tile into given coordinates
     */
    public void setTile(int xIndex,int yIndex,Tile newTile){
        this.tileGrid[yIndex][xIndex] = newTile;
    }
     /**
     * Pre: Ncolumns is set.
     * Returns the column count
     * @return Ncolumns value
     * Post: returns Ncolumns value
     */
    public int getColumnCount(){
        return this.Ncolumns;
    }
    /**
     * Pre: Nrows is set.
     * Returns the row count
     * @return Nrows value
     * Post: returns Nrows value
     */
    public int getRowCount(){
        return this.Nrows;
    }
    /**
     * Pre: Ncolumns is set.
     * Returns width of grid
     * @return width of grid
     * Post: returns Ncolumns * Tile.LENGTH
     */
    public int getWidth(){
        return this.Ncolumns *Tile.LENGTH;
    }
     /**
     * Pre: Nrows is set.
     * Returns the height of grid
     * @return height of grid
     * Post: returns Nrows value * Tile.LENGTH
     */
    public int getHeight(){
        return this.Nrows *Tile.LENGTH;
    }
      /**
     * Pre: TileCode valid symbol
     * Returns the positions of where that specified tile is located
     * @return LinkedList<Vector2D> of positions of given tile type
     * Post: the positions of where that specified tile is located
     */
    public LinkedList<Vector2D> getTilePositions(char TileCode){
        LinkedList<Vector2D> positions = new LinkedList<Vector2D>();

        for(int r =0; r<this.Nrows;r++){
            for(int c= 0;c<this.Ncolumns;c++){
                if(this.tileGrid[r][c]!=null &&this.tileGrid[r][c].getTypeCode() == TileCode){
                    // System.out.println("added intopoision "+ c + r );
                    positions.add(new Vector2D(c,r));
                }
            }
        }
        return positions;

    }
}
