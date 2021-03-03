package TCP1201;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Snapshot {

    private static ArrayList<File> filenameList = new ArrayList<>();
    private static int count = 1;

    public static ArrayList<File> getFilenameList() {
        return filenameList;
    }

    public static void saveAsPng(Scene scene) {
        WritableImage image = scene.snapshot(null);
        String p1 = Paths.get(System.getProperty("user.dir")).toString();
        File file = new File(p1 + "\\history\\history" + count++ + ".png");


        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            filenameList.add(file);
        } catch (IOException e) {
            Logger.getLogger(ModuleLayer.Controller.class.getName()).log(Level.SEVERE,null,e);
        }
    }

    public static void clearList(){
        filenameList.clear();
    }

    public static void setCount(int num){
        count = num;
    }

}
