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
import java.sql.ResultSet;
import java.sql.SQLException;

public class AUpdateCustomerFromController {
    public AnchorPane UpdateContext;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;

    public void UpdateOnAction(ActionEvent actionEvent) {
        Customer c = new Customer(
                txtId.getText(), txtName.getText(), txtAddress.getText(),
                Double.parseDouble(txtSalary.getText())
        );

        try {
            boolean isUpdated = CrudUtil.execute("UPDATE Customer SET name= ? , address=? , salary=? WHERE id=?", c.getName(), c.getAddress(), c.getSalary(), c.getId());
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, txtId.getText() + " is Updated!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
        }
    }

    public void HomeOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) UpdateContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/DashBoardFrom.fxml"))));
    }

    public void CustomerUpdateSearchOnAction(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            ResultSet result = CrudUtil.execute("SELECT * FROM Customer WHERE id=?", txtId.getText());
            if (result.next()) {
                txtName.setText(result.getString(2));
                txtAddress.setText(result.getString(3));
                txtSalary.setText(String.valueOf(result.getDouble(4)));
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
