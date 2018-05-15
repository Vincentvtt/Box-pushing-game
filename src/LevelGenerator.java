import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * The LevelGenerator class creates a level.txt file for Level layout
 * @author Marie, Kevin, Vincent, Vince, Victor
 */
public class LevelGenerator {
    /**
     * randomLevel generates a random Level layout
     * Post: Creates a level.txt file showing level layout
     */
    public void randomLevel(){

        ArrayList<String> topList = new ArrayList<String>();
        ArrayList<String> middleList = new ArrayList<String>();
        ArrayList<String> bottomList = new ArrayList<String>();

        File topFolder = new File("topLevel");
        File[] topFiles = topFolder.listFiles();

        for (int i = 0; i < topFiles.length; i++) {
            if (topFiles[i].isFile()) {
                topList.add(topFiles[i].getPath());
            }
        }

        File middleFolder = new File("middleLevel");
        File[] middleFiles = middleFolder.listFiles();

        for (int i = 0; i < middleFiles.length; i++) {
            if (middleFiles[i].isFile()) {
                middleList.add(middleFiles[i].getPath());
            }
        }

        File bottomFolder = new File("bottomLevel");
        File[] bottomFiles = bottomFolder.listFiles();

        for (int i = 0; i < bottomFiles.length; i++) {
            if (bottomFiles[i].isFile()) {
                bottomList.add(bottomFiles[i].getPath());
            }
        }

        int top = (int)(Math.random() * topList.size());
        int middle = (int)(Math.random() * middleList.size());
        int bottom = (int)(Math.random() * bottomList.size());

        try{
            PrintWriter writer = new PrintWriter("leveltest.txt", "UTF-8");

            try (BufferedReader br = new BufferedReader(new FileReader(topList.get(top)))) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    writer.println(line);
                }
            }

            try (BufferedReader br = new BufferedReader(new FileReader(middleList.get(middle)))) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    writer.println(line);
                }
            }

            try (BufferedReader br = new BufferedReader(new FileReader(bottomList.get(bottom)))) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    writer.println(line);
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to create level");
        }
    }
    /**
     * Main method for this generator program
     * Pre: args must be valid
     * Post: runs randomLevel(), which generates a random level layout
     */
    public static void main(String[] args){
        LevelGenerator lg = new LevelGenerator();
        lg.randomLevel();
    }
}
