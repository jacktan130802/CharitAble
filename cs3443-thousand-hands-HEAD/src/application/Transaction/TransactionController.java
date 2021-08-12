package application.Transaction;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import model.User2;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

public class TransactionController implements Initializable {
    @FXML
    private AnchorPane transactionMainpane;
    @FXML
    private ListView<String> myListView ;
    @FXML
    void transactiontoMain(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("../Main/Main.fxml"));
        transactionMainpane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] usersproperties = {",",","};
        String data;
        ArrayList<String> test = new ArrayList<>();
        for (Map.Entry<String, String> entry:  User2.users.entrySet()) {

            //sets data string by concatenating strings from HashMap key and value
            data = entry.getKey() + " who is a " + entry.getValue() ;
            System.out.println(data);
            test.add(data);	//adds string to test list
        }
        myListView.getItems().addAll(test);
    }

}
