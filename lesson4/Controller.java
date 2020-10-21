package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextArea textOut;

    @FXML
    TextField textIn;
    public void sendMsg() {
        textOut.appendText(textIn.getText() + "\n");
        textIn.clear();
        textIn.requestFocus();
    }
}
