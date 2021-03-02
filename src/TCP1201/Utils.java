package TCP1201;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class Utils {
    public static Label styleContent(Label content){
        setMaxWidthHeight(content);
        content.setWrapText(true);
        content.setId("gridContent");
        return content;
    }

    public static Label styleColTitle(Label colTitle){
        setMaxWidthHeight(colTitle);
        colTitle.setId("colTitle");
        return colTitle;
    }

    public static HBox styleHRow(HBox hRow){
        setMaxWidthHeight(hRow);
        hRow.setId("hRow");
        return hRow;
    }

    private static void setMaxWidthHeight(Region r){
        r.setMaxWidth(Double.MAX_VALUE);
        r.setMaxHeight(Double.MAX_VALUE);
    }

}
