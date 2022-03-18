package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Customer;
import util.CrudUtil;

import java.io.IOException;
import java.sql.SQLException;

public class ASaveCustomerFromController {
    public AnchorPane SaveContext;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;

    public void SaveOnAction(ActionEvent actionEvent) {
        Customer c = new Customer(
                txtId.getText(), txtName.getText(), txtAddress.getText(),
                Double.parseDouble(txtSalary.getText())
        );

        try {
            if (CrudUtil.execute("INSERT INTO Customer VALUES (?,?,?,?)", c.getId(), c.getName(), c.getAddress(), c.getSalary())) {
                new Alert(Alert.AlertType.CONFIRMATION, txtId.getText() + " is Saved.").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void HomeOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) SaveContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/DashBoardFrom.fxml"))));
    }
}
