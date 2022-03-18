package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFromController {
    public AnchorPane DashBoardContext;

    public void btnSaveOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SaveCustomerFrom");
    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SearchCustomerFrom");
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws IOException {
        setUi("UpdateCustomerFrom");
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DeleteCustomerFrom");
    }

    public void btnLoadAllOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoadAllCustomerFrom");
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) throws IOException {
        setUi("PlaceOrderFrom");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) DashBoardContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/" + location + ".fxml"))));
        stage.show();
    }
}
