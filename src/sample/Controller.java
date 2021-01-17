package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    @FXML
    private MenuItem buttonExit;

    @FXML
    private TextField textField;

    @FXML
    private ListView<String> messageField;

    @FXML
    private Label headerName;

    private final ObservableList<String> messageList = FXCollections.observableArrayList();

    @FXML
    void onExit() {
        System.exit(0);
    }

    @FXML
    void sendMessage() {
        String message = textField.getText().trim();
        if (!message.isBlank()) {
            addMessageToList(message);
        }
        else {
            System.out.println("Пустая строка!");
        }
        textField.clear();
    }

    private void addMessageToList(String message) {
        var items = messageField.getItems();
        int index = items.size();
        messageField.getItems().add(message);
        messageField.scrollTo(index);
    }
}

