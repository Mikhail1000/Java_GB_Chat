package client.controllers;

import client.models.Network;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

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

    private Network network;

    public void setNetwork(Network network) {
        this.network = network;
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
        textField.requestFocus();

        try {
            network.getOut().writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка при отправке сообщения");
        }
    }

    public void addMessageToList(String message) {
        var items = messageField.getItems();
        int index = items.size();
        messageField.getItems().add(message);

        //messageField.scrollTo(index);

    }
}

