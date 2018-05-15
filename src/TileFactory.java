import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TileFactory {

    public StaticGrid createStaticGrid(String file){
        Scanner levelReader = null;
        LinkedList<Queue<Tile>> tileList = new LinkedList<Queue<Tile>>();

        try{
            levelReader = new Scanner(new FileReader(file));
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }

        int yIndex =0;
        while(levelReader.hasNext()){
            tileList.add(new LinkedList<Tile>());
            char[] tileSymbols = levelReader.nextLine().toCharArray();
            for(char symbol :tileSymbols){
                tileList.get(yIndex).add(createStaticTile(symbol));
            }
            yIndex++;
        }
        levelReader.close();

        Tile[][] tileSet = new Tile[tileList.size()][tileList.peek().size()];
        int x=0,y =0;
        while(tileList.isEmpty() == false){
            x=0;
            for(Tile t:tileList.poll()){
                tileSet[y][x] = t;
                x++;
            }
            y++;
        }

        return new StaticGrid(tileSet);//staticGrid = new StaticGrid(2d array of tiles)
    }
    public DynamicGrid CloneDynamicGrid(DynamicGrid copy){
        Tile[][] newTiles = new Tile[copy.getRowCount()][copy.getColumnCount()];
        for(int r =0;r<copy.getRowCount();r++){
            for(int c =0;c<copy.getColumnCount();c++){
                if(copy.getTile(c, r)!= null){
                    newTiles[r][c]= createDynamicTile(copy.getTile(c, r).getTypeCode());
                }
            }
        }
        return new DynamicGrid(newTiles);

    }
    public DynamicGrid createDynamicGrid(String file){
        Scanner levelReader = null;
        LinkedList<Queue<Tile>> tileList = new LinkedList<Queue<Tile>>();

        try{
            levelReader = new Scanner(new FileReader(file));
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }

        int yIndex =0;
        while(levelReader.hasNext()){
            tileList.add(new LinkedList<Tile>());
            char[] tileSymbols = levelReader.nextLine().toCharArray();
            for(char symbol :tileSymbols){
                tileList.get(yIndex).add(createDynamicTile(symbol));
            }
            yIndex++;
        }
        levelReader.close();

        Tile[][] tileSet = new Tile[tileList.size()][tileList.peek().size()];
        int x=0,y =0;
        while(tileList.isEmpty() == false){
            x=0;
            for(Tile t:tileList.poll()){
                tileSet[y][x] = t;
                x++;
            }
            y++;
        }
        return new DynamicGrid(tileSet);
    }
    private Tile createDynamicTile(char symbol){
        Tile newTile = null;
        switch (symbol){
            case 'p': newTile = new PlayerTile(); //player spawn tile
                break;
            case 'b': newTile = new BoxTile();
                break;
            default:
                return null;
        }
        return newTile;
    }
    private Tile createStaticTile(char symbol){
        Tile newTile = null;
        switch (symbol){
            case '1': newTile = new WallTile();
                break;
            case '0': newTile = new GroundTile();
                break;
            case 'x': newTile = new GoalTile();
                break;
            default:
                return newTile = new GroundTile();
        }
        return newTile;
    }

}
