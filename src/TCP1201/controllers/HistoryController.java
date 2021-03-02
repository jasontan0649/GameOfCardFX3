package TCP1201.controllers;

import TCP1201.Snapshot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class HistoryController {

    @FXML private ImageView imageView;
    @FXML private Button backButton;
    @FXML private Button nextButton;
    @FXML private int imagePointer;
    @FXML private ArrayList<File> filenameList = Snapshot.getFilenameList();

    @FXML
    private void initialize() throws MalformedURLException {
        imagePointer = filenameList.size() - 1;
        showImage(filenameList.get(imagePointer));
        nextButton.setDisable(true);
    }

    private void showImage(File file) throws MalformedURLException {
        double width = imageView.getFitWidth();
        double height = imageView.getFitHeight();

        imageView.setImage(new Image(file.toURI().toURL().toExternalForm(), width, height, true, true));
    }

    @FXML
    private void prevHistory(MouseEvent actionEvent) throws MalformedURLException {
        imagePointer--;
        showImage(filenameList.get(imagePointer));

        if (imagePointer == 0) {
            backButton.setDisable(true);
        } else {
            nextButton.setDisable(false);
        }
    }

    @FXML
    private void nextHistory(MouseEvent actionEvent) throws MalformedURLException {
        imagePointer++;
        showImage(filenameList.get(imagePointer));

        if (imagePointer == filenameList.size() - 1) {
            nextButton.setDisable(true);
        } else {
            backButton.setDisable(false);
        }
    }
}
