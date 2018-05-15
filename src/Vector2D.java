/**
 * The Vector2D class contains coordinate locations for grid
 * @author Marie, Kevin, Vincent, Vince, Victor
 */
public class Vector2D {
    private int x;
    private int y;
    /**
     * Class constructor
     * @return Vector2D object
     * Post: creates Vector2D object
     */
    public Vector2D(int x, int y){
        this.x = x;
        this.y = y;
    }
    /**
     * Returns the x coordinate
     * @return x coordinate
     * Post: x coordinate returned
     */
    public int getX(){
        return this.x;
    }
    /**
     * Returns the y coordinate
     * @return y coordinate
     * Post: y coordinate returned
     */
    public int getY(){
        return this.y;
    }
}
