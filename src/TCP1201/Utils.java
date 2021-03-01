package TCP1201;

import javafx.scene.control.Label;

public class Utils {
    public static Label stylePName(Label pName){
        pName.setMaxWidth(Double.MAX_VALUE);
        pName.setMaxHeight(Double.MAX_VALUE);
        pName.setWrapText(true);
        pName.setId("pName");
        return pName;
    }
}
