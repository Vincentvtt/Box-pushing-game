import java.util.LinkedList;
/**
 * The CollisionHandler class checks for goal completion and handles collisions with walls and boxes
 * @author Marie, Kevin, Vincent, Vince, Victor
 */
public class CollisionHandler {

    /**
     * Checks for completion of all the goals
     * Pre: valid dynamicLevel, goalTiles inputs 
     * @return true if completed, false if not
     * Post: returns completion status
     */
    public boolean checkCompletion(DynamicGrid dynamicLevel,LinkedList<Vector2D> goalTiles){
        for(Vector2D tile : goalTiles){
            if(dynamicLevel.getTile(tile.getX(), tile.getY())==null){
                return false;
            }
            if(dynamicLevel.getTile(tile.getX(), tile.getY()).getTypeCode() !='b'){
                return false;

            }
        }
        return true;
    }
    /**
     * Handles collision of tile (player, box) to another tile (wall, box) by checking change in grid state
     * Pre: valid baselevel, dynamicLevel, oldState inputs
     * Post: handles collision
     */
    //NEED TO TIDY THIS UP!!!!!!!!
    public void HandleCollision(StaticGrid baseLevel, DynamicGrid dynamicLevel,DynamicGrid oldState){

        if( baseLevel.getTile(dynamicLevel.getPlayerXpos(), dynamicLevel.getPlayerYpos()).getTypeCode()=='1')
        {
            //dynamicLevel.updatePlayerPos(Direction.DOWN);
            switch(dynamicLevel.getPlayerDirection()){
                case DOWN:
                    dynamicLevel.updatePlayerPos(Direction.UP);
                    break;
                case UP:
                    dynamicLevel.updatePlayerPos(Direction.DOWN);
                    break;
                case LEFT:
                    dynamicLevel.updatePlayerPos(Direction.RIGHT);
                    break;
                case RIGHT:
                    dynamicLevel.updatePlayerPos(Direction.LEFT);
                    break;
                default:
                    break;
            }
        }

        if( oldState.getTile(dynamicLevel.getPlayerXpos(), dynamicLevel.getPlayerYpos()) ==null){
            return; //player moved to air
        }

        if( oldState.getTile(dynamicLevel.getPlayerXpos(), dynamicLevel.getPlayerYpos()).getTypeCode()
                == 'b'){

            int boxX = dynamicLevel.getPlayerXpos();
            int boxY = dynamicLevel.getPlayerYpos();

            switch(dynamicLevel.getPlayerDirection()){
                case DOWN:
                    dynamicLevel.setTile(dynamicLevel.getPlayerXpos(), dynamicLevel.getPlayerYpos()+1,new BoxTile());
                    boxY +=1;
                    break;
                case UP:
                    dynamicLevel.setTile(dynamicLevel.getPlayerXpos(), dynamicLevel.getPlayerYpos()-1,new BoxTile());
                    boxY -=1;
                    break;
                case LEFT:
                    dynamicLevel.setTile(dynamicLevel.getPlayerXpos()-1, dynamicLevel.getPlayerYpos(),new BoxTile());
                    boxX -=1;
                    break;
                case RIGHT:
                    dynamicLevel.setTile(dynamicLevel.getPlayerXpos()+1, dynamicLevel.getPlayerYpos(),new BoxTile());
                    boxX +=1;
                    break;
                default:
                    break;
            }

            if(baseLevel.getTile(boxX, boxY).getTypeCode()=='1'||
                    (oldState.getTile(boxX, boxY) !=null &&oldState.getTile(boxX, boxY).getTypeCode()=='b')){


                int oldPlayerPosX = dynamicLevel.getPlayerXpos();
                int oldPlayerPosY = dynamicLevel.getPlayerYpos();


                switch(dynamicLevel.getPlayerDirection()){
                    case DOWN:
                        dynamicLevel.updatePlayerPos(Direction.UP);
                        break;
                    case UP:
                        dynamicLevel.updatePlayerPos(Direction.DOWN);
                        break;
                    case LEFT:
                        dynamicLevel.updatePlayerPos(Direction.RIGHT);
                        break;
                    case RIGHT:
                        dynamicLevel.updatePlayerPos(Direction.LEFT);
                        break;
                    default:
                        break;
                }

                if(oldState.getTile(boxX, boxY) !=null &&oldState.getTile(boxX, boxY).getTypeCode()=='b'){
                    dynamicLevel.setTile(boxX, boxY,new BoxTile());
                }else{
                    dynamicLevel.setTile(boxX, boxY,null);
                }

                dynamicLevel.setTile(oldPlayerPosX, oldPlayerPosY,new BoxTile());

            }
        }

    }

}
